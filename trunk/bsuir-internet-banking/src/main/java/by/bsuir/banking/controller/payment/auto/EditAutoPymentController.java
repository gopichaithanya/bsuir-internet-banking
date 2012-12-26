package by.bsuir.banking.controller.payment.auto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.utils.CardUtil;
import by.bsuir.banking.admin.utils.InformationParser;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.PaymentUtil;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.AutoPaymentInfo;
import by.bsuir.banking.domain.AutoPaymentWrapper;
import by.bsuir.banking.domain.CardSelectInfo;
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.ClientWrapper;
import by.bsuir.banking.domain.EripWrapper;
import by.bsuir.banking.domain.LegalPersonWrapper;
import by.bsuir.banking.domain.MoneyWrapper;
import by.bsuir.banking.proxy.internetbanking.AutoPayment;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAutoPaymentAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAutoPaymentDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCitiesForRegionAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCitiesForRegionDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetServicesForCityAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetServicesForCityDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceUpdateAutoPaymentAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceUpdateAutoPaymentDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;
import by.bsuir.banking.validator.AutoPaymentValidator;

@Controller
@RequestMapping("/autopayment/edit/{id}")
@SessionAttributes({ "payment", "cardList", "cardSelect", "days" })
public class EditAutoPymentController extends EntityController {
	private static String VIEW_NAME = "autopayment-edit";
	private static String VIEW_NAME_CHECK = "autopayment-check";
	private static IInternetBankingService service;
	@Autowired
	private AutoPaymentValidator autoPaymentValidator;

	
	public EditAutoPymentController(){
		service = ServiceProvider.getInternetBankingService();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String createForm(@PathVariable("id") Integer id, HttpSession session, Model model){
		
		String securityToken = getSecurityToken(session);
		try {
			AutoPaymentWrapper autopayment = new AutoPaymentWrapper(service.getAutoPayment(id, securityToken));
			ClientWrapper client = new ClientWrapper(service.getClient(securityToken));
			List<CardWrapper> cards = new ArrayList<CardWrapper>();
			List<MoneyWrapper> ballance = new ArrayList<MoneyWrapper>();
			List<CardSelectInfo> cardSelect = new ArrayList<CardSelectInfo>();
			for (Card card : service.getCards(securityToken).getCard()) {
				CardWrapper cardWrapper = new CardWrapper(card);
				cards.add(cardWrapper);
				MoneyWrapper cardsBallance = new MoneyWrapper(
						service.getBallance(cardWrapper.getCardId(),
								securityToken));
				ballance.add(cardsBallance);
				cardSelect.add(new CardSelectInfo(cardWrapper, cardsBallance));
			}
			List<Integer> daysOfMonth = new ArrayList<Integer>();
			for (int i = 1; i < 29; i++) {
				daysOfMonth.add(i);
			}
			CardWrapper card = CardUtil.getCardByAccountId(
					autopayment.getAccountId(), securityToken);
			AutoPaymentInfo info = null;
			if(autopayment.getLegalAccountId() == 1){
				//erip
				//finding id
				Integer eripId = InformationParser.getEripIdFromInformation(autopayment.getInformation());
				EripWrapper erip = PaymentUtil.getServiceById(eripId, securityToken);
				info = new AutoPaymentInfo(client, erip);
				
			}else{
				//regular
				LegalPersonWrapper legal = PaymentUtil.getLegalPersonByAccountId(autopayment.getLegalAccountId(), securityToken);
				info = new AutoPaymentInfo(client, legal);
			}
			info.setSaved(true);
			info.setAmount(autopayment.getAmount());
			info.setCardNumber(card.getHiddenNumber());
			info.setClient(client);
			info.setDayOfMonth(autopayment.getDayOfMonth());
			info.setInfoString(InformationParser.getInfoString(autopayment.getInformation()));
			
			model.addAttribute("payment", info);
			model.addAttribute("cardList", cards);
			model.addAttribute("cardSelect", cardSelect);
			model.addAttribute("days", daysOfMonth);
		} catch (IInternetBankingServiceGetAutoPaymentAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAutoPaymentDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCitiesForRegionAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCitiesForRegionDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetServicesForCityAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetServicesForCityDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetClientDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return VIEW_NAME;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitForm(HttpSession session,
			@Valid @ModelAttribute("payment") AutoPaymentInfo payment,
			BindingResult result, RedirectAttributes attrs,
			@ModelAttribute("cardSelect") List<CardSelectInfo> cardSelect,
			Model model, @PathVariable("id") Integer id){
		autoPaymentValidator.validate(payment, result);
		if (result.hasErrors()) {
			return VIEW_NAME;
		} else {
			payment.getAmount().setAmount(
					BigDecimal.valueOf(Double.valueOf(payment.getAmount()
							.getEnteredAmount().replace(',', '.'))));
		}

		if (session.getAttribute("cardSelect") == null) {
			attrs.addFlashAttribute("error", "Невозможно найти список карт");
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}

		for (CardSelectInfo card : cardSelect) {
			if (card.getCardNumber().equals(payment.getCardNumber())) {
				payment.setDisplayCard(card.getDisplayValue());
				if (card.isExpired()) {
					result.reject("paymentError",
							"Карта недействительна. Выберите другую карту или обратитесь к оператору");
					return VIEW_NAME;
				}
				if (card.isLocked()) {
					result.reject(
							"paymentError",
							"Карта заблокированна. Разблокируйте карту, выберите другую или обратитесь к оператору");
					return VIEW_NAME;
				}
			}
		}

		attrs.addFlashAttribute("cardSelect", cardSelect);
		attrs.addFlashAttribute("payment", payment);

		
		return "redirect:/autopayment/edit/" + id + "/check";
	}
	
	@RequestMapping(value="/check", method=RequestMethod.GET)
	public String createCheck(HttpSession session, Model model,
			RedirectAttributes attrs, @PathVariable("id") Integer id){
		if (!model.containsAttribute("payment") || !model.containsAttribute("cardSelect")) {
			attrs.addFlashAttribute("error", "Вы еще не заполнили форму");
			return "redirect:/autopayment/edit/" + id;
		}
		return VIEW_NAME_CHECK;
	}
	
	
	@RequestMapping(value="/check", method=RequestMethod.POST)
	public String submitCheck(@PathVariable("id") Integer id, @Valid @ModelAttribute("payment") AutoPaymentInfo payment,
			BindingResult result, HttpSession session,
			RedirectAttributes attrs,
			@ModelAttribute("cardSelect") List<CardSelectInfo> cardSelect){
	
		String securityToken = getSecurityToken(session);
		AutoPayment autoPayment = new AutoPayment();
		ObjectFactory factory = new ObjectFactory();
		Integer accountId = 0;
		for (CardSelectInfo card : cardSelect) {
			if (card.getCardNumber().equals(payment.getCardNumber())) {
				accountId = card.getCardWrapper().getCardsAccountId();
				// set currency type for amount
				payment.getAmount().setCurrencyTypeId(1);
			}
		}
		// setting autopayment fields
		autoPayment.setId(id);
		autoPayment.setAccountId(accountId);
		autoPayment.setDayOfMonth(payment.getDayOfMonth());
		autoPayment.setMoney(factory.createAutoPaymentMoney(payment.getAmount().getMoney()));
		if (payment.getLegalPerson() != null) {
			autoPayment.setInformation(factory.createAutoPaymentInformation(PaymentUtil.formInformation(payment)));
			autoPayment.setLegalAccountId(payment.getLegalPerson().getAccount().getId());
			
		}else if(payment.getErip() != null){
			autoPayment.setInformation(factory.createAutoPaymentInformation(PaymentUtil.formInformationErip(payment)));
			autoPayment.setLegalAccountId(payment.getErip().getAccountId());
		}
		try {
			service.updateAutoPayment(autoPayment, securityToken);
		} catch (IInternetBankingServiceUpdateAutoPaymentAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceUpdateAutoPaymentDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		attrs.addFlashAttribute("success", "Автоплатеж был успешно изменен");
		return "redirect:/autopayment/list";
	}
	
}
