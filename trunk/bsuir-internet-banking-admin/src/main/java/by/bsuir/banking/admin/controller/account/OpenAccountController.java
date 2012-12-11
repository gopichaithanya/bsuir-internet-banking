package by.bsuir.banking.admin.controller.account;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;

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

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.AccountCardWrapper;
import by.bsuir.banking.admin.domain.CardTypeWrapper;
import by.bsuir.banking.admin.domain.ClientWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.CardUtil;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.NumberGenerator;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceCreateCardAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceCreateCardDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllCardTypesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceOpenAccountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceOpenAccountDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.Client;
import by.bsuir.banking.proxy.operator.IOperatorService;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.OperatorService;

/**
 * Controller for opening account. Account can be opened only for particular
 * client, so the url always contains client's id
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/account/{id}/open")
@SessionAttributes({ "account_card", "currencyTypes", "cardTypes", "client" })
public class OpenAccountController extends EntityController {

	private static Logger logger = Logger
			.getLogger(OpenAccountController.class);
	private static IInternetBankingService service;
	private static final String VIEW_NAME = "account-open";

	public OpenAccountController() {
		service = ServiceProvider.getInternetBankingInstance();
		AdminUtils.logInfo(logger, MessageConstants.CARD_SERVICE_CREATED);
	}

	@ModelAttribute("account_card")
	public AccountCardWrapper createModel() {
		return new AccountCardWrapper();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String createForm(@PathVariable("id") Integer id, Model model,
			HttpSession session) {
		try {
			model.addAttribute("currencyTypes", CardUtil.getCurrencyTypes());
			String securityToken = getSecurityToken(session);
			model.addAttribute("cardTypes",
					CardUtil.getCardTypes(securityToken));
			IOperatorService operatorService = new OperatorService()
					.getBasicHttpBindingIOperatorService();
			Client client = operatorService.getClient(id, securityToken);
			model.addAttribute("client", new ClientWrapper(client));
		} catch (IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllCardTypesDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOperatorServiceGetClientAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOperatorServiceGetClientDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return VIEW_NAME;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(
			@PathVariable("id") Integer id,
			@Valid @ModelAttribute("account_card") AccountCardWrapper accountCard,
			BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest,
			HttpSession session, RedirectAttributes redirectAttrs)
			throws DatatypeConfigurationException {
		if (result.hasErrors()) {
			AdminUtils.logDebug(logger, MessageConstants.FORM_VALIDATION_ERROR,
					MessageConstants.ACCOUNT_ENTITY);
			return VIEW_NAME;
		}
		String securityToken = getSecurityToken(session);
		Integer accountId = 0;
		Integer cardId = 0;
		try {
			// generate account number
			String accNumber = NumberGenerator.generateAccountNumber();
			accountCard.setAccountNumber(accNumber);
			accountCard.setClientId(id);
			accountId = service.openAccount(accountCard.getAccount(),
					securityToken);
		} catch (IInternetBankingServiceOpenAccountAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			result.reject(e.getMessage());
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceOpenAccountDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger,
					MessageConstants.OBJECT_SAVING_FAILED_ON_SERVER,
					MessageConstants.ACCOUNT_ENTITY);
			result.reject(e.getMessage());
			return VIEW_NAME;
		}
		try {
			accountCard.setCardsAccountId(accountId);
			CardTypeWrapper cardType = CardUtil.getCardType(
					accountCard.getCardTypeId(), securityToken);
			if (cardType != null) {
				String cardNumber = NumberGenerator.generateCardNumber(cardType.getName());
				accountCard.setCardNumber(cardNumber);
			}
			// TODO set expiration date
			accountCard.setExpirationDate(CardUtil.getExpirationDate());
			// TODO set money and operation limits based on card type
			accountCard.setOperationsLimit(CardUtil
					.getOperationsLimit(accountCard.getCardType()));
			accountCard.setMoneyLimit(CardUtil.getMoneyLimit(accountCard
					.getCardType()));
			accountCard.setCVV2(NumberGenerator.generateCVV2());
			cardId = service.createCard(accountCard.getCard(), securityToken);
		} catch (IInternetBankingServiceCreateCardAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			result.reject(e.getMessage());
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceCreateCardDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger,
					MessageConstants.OBJECT_SAVING_FAILED_ON_SERVER,
					MessageConstants.CARD_ENTITY);
			redirectAttrs
					.addFlashAttribute("error",
							"Account was successfully created but withowt a card. Try creating card again");
			return "redirect:/account/" + id + "/view/" + accountId;
		} catch (IInternetBankingServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllCardTypesDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/account/" + id + "/view/" + accountId;
	}

}
