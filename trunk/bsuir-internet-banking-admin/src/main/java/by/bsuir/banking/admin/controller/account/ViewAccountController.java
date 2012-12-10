package by.bsuir.banking.admin.controller.account;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.AccountCardWrapper;
import by.bsuir.banking.admin.domain.ClientWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.internetbanking.Account;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountByIdAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountByIdDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForAccountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForAccountDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.Client;
import by.bsuir.banking.proxy.operator.IOperatorService;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.OperatorService;

/**
 * Controller for viewing account + Card
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/account/{clientId}/view/{accountId}")
@SessionAttributes({ "account_card", "client" })
public class ViewAccountController extends EntityController {

	private static Logger logger = Logger
			.getLogger(ViewAccountController.class);
	private static IInternetBankingService service;
	private static final String VIEW_NAME = "account-view";

	public ViewAccountController() {
		service = ServiceProvider.getInternetBankingInstance();
		AdminUtils.logInfo(logger, MessageConstants.CARD_SERVICE_CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String createForm(@PathVariable("clientId") Integer clientId, @PathVariable("accountId") Integer accountId, Model model,
			HttpSession session) {
		String securityToken = getSecurityToken(session);
		IOperatorService operatorService = new OperatorService()
				.getBasicHttpBindingIOperatorService();
		Client client = null;
		try {
			client = operatorService.getClient(clientId, securityToken);
		} catch (IOperatorServiceGetClientAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IOperatorServiceGetClientDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		model.addAttribute("client", new ClientWrapper(client));
		
		//getting account
		try {
			Account account = service.getAccountById(accountId, securityToken);
			Card card = service.getCardForAccount(accountId, securityToken);
			AccountCardWrapper accountCard = new AccountCardWrapper(account, card);
			model.addAttribute("account_card", accountCard);
		} catch (IInternetBankingServiceGetAccountByIdAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" +  MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAccountByIdDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetCardForAccountAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" +  MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetCardForAccountDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		

		return VIEW_NAME;
	}

}
