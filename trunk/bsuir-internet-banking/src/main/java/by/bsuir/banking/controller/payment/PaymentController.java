package by.bsuir.banking.controller.payment;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.utils.CardUtil;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.PaymentUtil;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.CardSelectInfo;
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.ClientWrapper;
import by.bsuir.banking.domain.CurrencyTypeWrapper;
import by.bsuir.banking.domain.LegalPersonWrapper;
import by.bsuir.banking.domain.MoneyWrapper;
import by.bsuir.banking.domain.PaymentInfo;
import by.bsuir.banking.domain.SavedPaymentWrapper;
import by.bsuir.banking.proxy.internetbanking.Account;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.Client;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceCreateSavedPaymentAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceCreateSavedPaymentDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountByIdAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountByIdDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServicePayAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServicePayDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.LegalPerson;
import by.bsuir.banking.validator.PaymentValidator;

/**
 * Controller for payments
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/payment/pay/{paymentId}")
@SessionAttributes({ "payment", "cardList", "cardSelect", "curType" })
public class PaymentController extends EntityController {
	private static Logger logger = Logger.getLogger(PaymentController.class);
	private static final String VIEW_NAME = "payment-pay";
	private static final String VIEW_NAME_CHECK = "payment-check";
	private static IInternetBankingService service;
	@Autowired
	private PaymentValidator paymentValidator;

	public PaymentController() {
		service = ServiceProvider.getInternetBankingService();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String createForm(@PathVariable("paymentId") Integer id,
			HttpSession session, Model model) {
		String securityToken = getSecurityToken(session);
		try {
			LegalPerson person = PaymentUtil.getLegalPersonById(id,
					securityToken);
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
			PaymentInfo wrapper = new PaymentInfo(
					new LegalPersonWrapper(person), new ClientWrapper(client),
					false);
			model.addAttribute("payment", wrapper);
			model.addAttribute("cardList", cards);
			model.addAttribute("cardSelect", cardSelect);
		} catch (IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetClientDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
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
		paymentValidator.validate(payment, result);
		if (result.hasErrors()) {
			model.addAttribute("form-error", "На форме есть ошибки");
			return VIEW_NAME;
		}
		if (session.getAttribute("cardSelect") == null) {
			attrs.addFlashAttribute("error", "Невозможно найти список карт");
			response.sendRedirect(request.getContextPath()
					+ MessageConstants.ERROR_VIEW);
		}
		String curType = "";
		for (CardSelectInfo card : cardSelect) {
			if (card.getCardNumber().equals(payment.getСardNumber())) {
				if (card.isExpired()) {
					result.reject("paymentError",
							"Карта недействительна. Выберите другую карту или обратитесь к оператору");
					return VIEW_NAME;
				}
				attrs.addFlashAttribute("card", card.getDisplayValue());
				curType = card.getCurrencyType();

			}
		}
		attrs.addFlashAttribute("cardSelect", cardSelect);
		attrs.addFlashAttribute("payment", payment);
		attrs.addFlashAttribute("curType", curType);
		//model.addAttribute("curType", curType);
		//return createCheck(paymentId, model, attrs);
		return "redirect:/payment/pay/" + paymentId + "/check";
	}

	@RequestMapping(value = { "/check" }, method = RequestMethod.GET)
	public String createCheck(@PathVariable("paymentId") Integer paymentId,
			Model model, RedirectAttributes attrs) {
		if (!model.containsAttribute("curType")
				|| !model.containsAttribute("payment")) {
			attrs.addFlashAttribute("error", "Вы еще не выбрали карту");
			return "redirect:/payment/pay/" + paymentId;
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
		if (result.hasErrors()) {
			return VIEW_NAME_CHECK;
		}
		Integer accountId = 0;
		try {
			for (CardSelectInfo card : cardSelect) {
				if (card.getCardNumber().equals(payment.getСardNumber())) {
					accountId = card.getCardWrapper().getCardsAccountId();
					// set currency type for amount
					List<CurrencyTypeWrapper> currrencies = CardUtil
							.getCurrencyTypes();
					for (CurrencyTypeWrapper cur : currrencies) {
						if (cur.getShortName().equalsIgnoreCase(
								card.getCurrencyType())) {
							payment.getAmount().setCurrencyTypeId(
									cur.getCurrencyType().getId());
						}
					}
				}
			}

			Account account = service.getAccountById(accountId, securityToken);
			if (account == null) {
				attrs.addFlashAttribute("error",
						"Ошибка. Счета не существует. Обратитесь к оператору");
				return VIEW_NAME_CHECK;
			}
			String accountNumber = account.getNumber().getValue();
			String receiverLegalAccountNumber = payment.getLegalPerson()
					.getAccount().getNumber().getValue();
			String information = PaymentUtil.formInformation(payment);

			if (payment.isToSave()) {
				// saving payment
				if (payment.isSaved()) {
					// take saved payment id
				} else {
					SavedPaymentWrapper savedPayment = new SavedPaymentWrapper(
							accountId, payment.getLegalPerson().getAccount()
									.getId(), information, payment.getAmount());
					service.createSavedPayment(savedPayment.getSavedPayment(),
							securityToken);
				}
			}

			service.pay(accountNumber, receiverLegalAccountNumber, payment
					.getAmount().getMoney(), information, securityToken);

		} catch (IInternetBankingServicePayAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServicePayDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error",
					"Произошла ошибка. Платеж не был проведен");
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetAccountByIdAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAccountByIdDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceCreateSavedPaymentAuthorizationFaultFaultFaultMessage e) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceCreateSavedPaymentDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error", "Платеж не был сохранен");
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		attrs.addFlashAttribute("success", "Платеж прошел успешно");
		return "redirect:/main";
	}
	
	

}
