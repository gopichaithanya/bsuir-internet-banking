 package by.bsuir.banking.controller.transfer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.CardUtil;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.CardSelectInfo;
import by.bsuir.banking.domain.CardTypeWrapper;
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.CurrencyTypeWrapper;
import by.bsuir.banking.domain.MoneyWrapper;
import by.bsuir.banking.domain.TransferInfo;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceExecuteTransferAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceExecuteTransferDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage;
import by.bsuir.banking.validator.TransferValidator;

/**
 * Controller for transfer between client's cards
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/transfer")
@SessionAttributes({ "transfer", "cardSelect", "curSelect", "sender", "receiver" })
public class TransferMoneyController extends EntityController {

	private static Logger logger = Logger
			.getLogger(TransferMoneyController.class);
	private static IInternetBankingService service;
	private final static String VIEW_NAME_STEP_1 = "transfer-step-1";
	private final static String VIEW_NAME_STEP_2 = "transfer-step-2";
	@Autowired
	private TransferValidator transferValidator;


	public TransferMoneyController() {
		service = ServiceProvider.getInternetBankingService(); 
	}

	@RequestMapping(value = { "", "/", "/step1" }, method = RequestMethod.GET)
	public String createForm(Model model, HttpSession session,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// creating list of cards
		String securityToken = getSecurityToken(session); 
		List<CardWrapper> cards = new ArrayList<CardWrapper>();
		List<MoneyWrapper> ballance = new ArrayList<MoneyWrapper>();
		List<CardSelectInfo> cardSelect = new ArrayList<CardSelectInfo>();
		try {
			for (Card card : service.getCards(securityToken).getCard()) {
				CardWrapper cardWrapper = new CardWrapper(card);
				cards.add(cardWrapper);
				MoneyWrapper cardsBallance = new MoneyWrapper(
						service.getBallance(cardWrapper.getCardId(),
								securityToken));
				ballance.add(cardsBallance);
				cardSelect.add(new CardSelectInfo(cardWrapper, cardsBallance));
			}
			model.addAttribute("cardList", cards);
			model.addAttribute("cardSelect", cardSelect);
		} catch (IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			response.sendRedirect(request.getContextPath()
					+ MessageConstants.AUTH_FAILED_VIEW);
		} catch (IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			response.sendRedirect(request.getContextPath()
					+ MessageConstants.AUTH_FAILED_VIEW);
		} catch (IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.SERVICE_ERROR);
			response.sendRedirect(request.getContextPath()
					+ MessageConstants.ERROR_VIEW);
		} catch (IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.SERVICE_ERROR);
			response.sendRedirect(request.getContextPath()
					+ MessageConstants.ERROR_VIEW);
		}
		model.addAttribute("transfer", new TransferInfo());

		return VIEW_NAME_STEP_1;
	}
 
	@RequestMapping(value={"","/","/step1"}, method=RequestMethod.POST)
	public String submitStep1(
			@Valid @ModelAttribute("transfer") TransferInfo transfer,
			BindingResult result, 
			@ModelAttribute("cardSelect") List<CardSelectInfo> cardSelect, Model model, HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes attrs) throws IOException { 
		
		if(result.hasErrors()){
			model.addAttribute("form-error", "На форме есть ошибки");
	 		return VIEW_NAME_STEP_1;
		}
		if(transfer.getReceiverCardNumber().equals(transfer.getSenderCardNumber())){
			result.reject("TranferError","Вы выбрали одинаковые карты. Выберите вторую карту.");
			return VIEW_NAME_STEP_1;
		}
		
		List<CardTypeWrapper> cardTypes = new ArrayList<CardTypeWrapper>();
		//we take only those types that we have in our selected cards
		String securityToken = getSecurityToken(session);
		if(session.getAttribute("cardSelect") == null){
			attrs.addFlashAttribute("error", "Невозможно найти список карт");
			response.sendRedirect(request.getContextPath() + MessageConstants.ERROR_VIEW);
		}
		String curTypeFrom = "";
		String curTypeTo = "";
		for(CardSelectInfo card:cardSelect){
			if(card.getCardNumber().equals(transfer.getSenderCardNumber())){
				if(card.isExpired()){
					result.reject("TransferError", "Карта-отправитель недействительна. Выберите другую карту или обратитесь к оператору.");
					return VIEW_NAME_STEP_1;
				}
				if(card.isLocked()){
					result.reject("TransferError",
							"Карта-отправитель заблокированна. Разблокируйте карту, выберите другую или обратитесь к оператору");
	 				return VIEW_NAME_STEP_1;
				}
				attrs.addFlashAttribute("sender", card.getDisplayValue());
				curTypeFrom = card.getCurrencyType();
			}
			if(card.getCardNumber().equals(transfer.getReceiverCardNumber())){
				if(card.isExpired()){
					result.reject("TransferError", "Карта-получатель недействительна. Выберите другую карту или обратитесь к оператору.");
					return VIEW_NAME_STEP_1;
				}
				if(card.isLocked()){
					result.reject("TransferError",
							"Карта-получатель заблокированна. Разблокируйте карту, выберите другую или обратитесь к оператору");
	 				return VIEW_NAME_STEP_1;
				}
				curTypeTo = card.getCurrencyType();
				attrs.addFlashAttribute("receiver", card.getDisplayValue());
			}
		}
		//form list of available currency types
		List<String> curTypes = new ArrayList<String>();
		curTypes.add(curTypeFrom);
		if(!curTypeFrom.equals(curTypeTo)){
			curTypes.add(curTypeTo);
		}
		attrs.addFlashAttribute("cardSelect", cardSelect);
		attrs.addFlashAttribute("curSelect",curTypes);
		attrs.addFlashAttribute("transfer", transfer);
		
		return "redirect:/transfer/step2";
	}
	
	@RequestMapping(value={"/step2"}, method=RequestMethod.GET)
	public String createStep2(Model model, RedirectAttributes attrs){
		if(!model.containsAttribute("curSelect") || !model.containsAttribute("transfer")){
			attrs.addFlashAttribute("error", "Вы еще не выбрали карты");
			return "redirect:/transfer/step1";
		}
		return VIEW_NAME_STEP_2;
	}
	
	@RequestMapping(value={"/step2"}, method=RequestMethod.POST)
	public String submitStep2(@Valid @ModelAttribute("transfer") TransferInfo transfer,
			BindingResult result, 
			@ModelAttribute("cardSelect") List<CardSelectInfo> cardSelect, Model model, HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes attrs) throws IOException{
		transferValidator.validate(transfer, result);
		if(result.hasErrors()){
			return VIEW_NAME_STEP_2;
		}
		transfer.getAmount().setAmount(BigDecimal.valueOf(Double.valueOf(transfer.getAmount().getEnteredAmount().trim().replace(',', '.'))));
		try {
			//lets name currencyTypeIds
			List<CurrencyTypeWrapper> currrencies = CardUtil.getCurrencyTypes();
			for(CurrencyTypeWrapper cur:currrencies){
				if(cur.getShortName().equalsIgnoreCase(transfer.getAmount().getCurrencyType())){
					transfer.getAmount().setCurrencyTypeId(cur.getCurrencyType().getId());
				}
			}
			String resp = service.executeTransfer(transfer.getSenderCardNumber(), transfer.getReceiverCardNumber(), transfer.getAmount().getMoney(), getSecurityToken(session));
			if (resp.equals("Failure")) {
				result.reject("paymentError",
						"Перевод не может быть проведен. Проверьте правильность введенных данных");

				return VIEW_NAME_STEP_2;
			}
			if (resp.equals("OperationsLimit")) {
				result.reject("paymentError",
						"Перевод не может быть проведен. Вы превисили лимит по расходным операциям");
				return VIEW_NAME_STEP_2;
			}
			if (resp.equals("MoneyLimit")) {
				result.reject(
						"paymentError",
						"Перевод не может быть проведен. Вы превисили лимит по сумме на расходные операции");
				return VIEW_NAME_STEP_2;
			}
			if (resp.equals("Balance")) {
				result.reject("paymentError",
						"Перевод не может быть проведен. На карте недостаточно средств");
				return VIEW_NAME_STEP_2;
			}
		} catch (IInternetBankingServiceExecuteTransferAuthorizationFaultFaultFaultMessage e) {
			response.sendRedirect(request.getContextPath() + MessageConstants.AUTH_FAILED_VIEW);
		} catch (IInternetBankingServiceExecuteTransferDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error", e.getMessage());
			return "redirect:/transfer/step1";
			/*response.sendRedirect(request.getContextPath() + MessageConstants.ERROR_VIEW);*/
		} catch (IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage e) {
			response.sendRedirect(request.getContextPath() + MessageConstants.ERROR_VIEW);
		}
		attrs.addFlashAttribute("success", "Операция перевода прошла успешно");
		return "redirect:/cards/view";
		
	}
}
