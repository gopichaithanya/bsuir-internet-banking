package by.bsuir.banking.controller.payment.erip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.PaymentUtil;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.CardSelectInfo;
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.ClientWrapper;
import by.bsuir.banking.domain.EripWrapper;
import by.bsuir.banking.domain.MoneyWrapper;
import by.bsuir.banking.domain.PaymentInfo;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.Client;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage;
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
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServicePayERIPAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServicePayERIPDomainFaultFaultFaultMessage;

@Controller
@RequestMapping("/erip/pay/{paymentId}")
@SessionAttributes({ "payment", "cardList", "cardSelect", "curSelect" })
public class EripController extends EntityController {
	private static Logger logger = Logger.getLogger(EripController.class);
	private static final String VIEW_NAME = "payment-pay";
	private static final String VIEW_NAME_CHECK = "payment-check";
	private static IInternetBankingService service;

	public EripController() {
		service = ServiceProvider.getInternetBankingService();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String createForm(@PathVariable("paymentId") Integer id,
			HttpSession session, Model model) {

		String securityToken = getSecurityToken(session); 

		EripWrapper erip;
		try {
			erip = PaymentUtil.getServiceById(id, securityToken);
			erip.setCity(PaymentUtil.getCityById(erip.getCityId(),
					securityToken));
			erip.setRegion(PaymentUtil.getRegionById(erip.getCity()
					.getRegionId(), securityToken));
			Client client = service.getClient(securityToken);
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
			PaymentInfo wrapper = new PaymentInfo(erip, new ClientWrapper(
					client));
			model.addAttribute("payment", wrapper);
			model.addAttribute("cardList", cards);
			model.addAttribute("cardSelect", cardSelect);

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
		} catch (IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetClientDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return VIEW_NAME;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@PathVariable("paymentId") Integer paymentId,
			@Valid @ModelAttribute("payment") PaymentInfo payment,
			BindingResult result, HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes attrs,
			@ModelAttribute("cardSelect") List<CardSelectInfo> cardSelect,
			Model model) throws IOException {
		if (result.hasErrors()) {
			model.addAttribute("error", "На форме есть ошибки");
			return VIEW_NAME;
		}
		if (session.getAttribute("cardSelect") == null) {
			attrs.addFlashAttribute("error", "Невозможно найти список карт");
			response.sendRedirect(request.getContextPath()
					+ MessageConstants.ERROR_VIEW);
		}
		String curType = "";
		for (CardSelectInfo card : cardSelect) {
			if (card.getCardNumber().equals(payment.getCardNumber())) {
				if (card.isExpired()) {
					result.reject("paymentError",
							"Карта недействительна. Выберите другую карту или обратитесь к оператору");
					return VIEW_NAME;
				}
				if(card.isLocked()){
					result.reject("paymentError",
							"Карта заблокированна. Разблокируйте карту, выберите другую или обратитесь к оператору");
	 				return VIEW_NAME;
				}
				payment.setDisplayCard(card.getDisplayValue());
				curType = card.getCurrencyType();

			}
		}
		List<String> curTypes = new ArrayList<String>();
		if (!curType.equals("BYR")) {
			curTypes.add(curType);
		}
		curTypes.add("BYR");
		attrs.addFlashAttribute("cardSelect", cardSelect);
		attrs.addFlashAttribute("payment", payment);
		//attrs.addFlashAttribute("curSelect", curTypes);
		// model.addAttribute("curType", curType);
		// return createCheck(paymentId, model, attrs);
		return "redirect:/erip/pay/" + paymentId + "/check";

	}

	@RequestMapping(value = { "/check" }, method = RequestMethod.GET)
	public String createCheck(@PathVariable("paymentId") Integer paymentId,
			Model model, RedirectAttributes attrs) {
		if (!model.containsAttribute("payment")) {
			attrs.addFlashAttribute("error", "Вы еще не выбрали карту");
			return "redirect:/erip/pay/" + paymentId;
		}

		return VIEW_NAME_CHECK;
	}

	@RequestMapping(value = { "/check" }, method = RequestMethod.POST)
	public String submitCheck(
			@Valid @ModelAttribute("payment") PaymentInfo payment,
			BindingResult result,
			@ModelAttribute("cardSelect") List<CardSelectInfo> cardSelect,
			Model model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes attrs) {
		String securityToken = getSecurityToken(session);
		Integer accountId = 0;
		try {

			for (CardSelectInfo card : cardSelect) {
				if (card.getCardNumber().equals(payment.getCardNumber())) {
					accountId = card.getCardWrapper().getCardsAccountId();
					// set currency type for amount
					/*List<CurrencyTypeWrapper> currrencies;
					currrencies = CardUtil.getCurrencyTypes();

					for (CurrencyTypeWrapper cur : currrencies) {
						if (cur.getShortName().equalsIgnoreCase(
								payment.getAmount().getCurrencyType())) {
							payment.getAmount().setCurrencyTypeId(
									cur.getCurrencyType().getId());
						}
					}*/
					payment.getAmount().setCurrencyTypeId(1);
				}
			}
			String information = PaymentUtil.formInformationErip(payment);
			String paymentResult = service.payERIP(payment.getCardNumber(),
					payment.getAmount().getMoney(), information, securityToken);
			if (paymentResult.equals("Failure")) {
				result.reject("paymentError", 
						"Платеж не может быть проведен. Проверьте правильность введенных данных");
				
				return VIEW_NAME_CHECK;
			}
			if (paymentResult.equals("OperationsLimit")) {
				result.reject("paymentError",
						"Платеж не может быть проведен. Вы превисили лимит по расходным операциям");
				return VIEW_NAME_CHECK;
			}
			if(paymentResult.equals("MoneyLimit")){
				result.reject("paymentError", "Платеж не может быть проведен. Вы превисили лимит по сумме на расходные операции");
				return VIEW_NAME_CHECK;
			}
			if(paymentResult.equals("Balance")){
				result.reject("paymentError", "Платеж не может быть проведен. На карте недостаточно средств");
				return VIEW_NAME_CHECK;
			}
		} catch (IInternetBankingServicePayERIPAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServicePayERIPDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error",
					"Произошла ошибка. Платеж не был проведен");
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		attrs.addFlashAttribute("success", "Платеж прошел успешно");
		return "redirect:/main";
	}
}
