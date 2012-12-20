package by.bsuir.banking.admin.controller.account;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.AccountCardWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.internetbanking.Account;
import by.bsuir.banking.proxy.internetbanking.ArrayOfAccount;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountsForClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountsForClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForAccountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForAccountDomainFaultFaultFaultMessage;
/**
 * Controller for getting a list of accounts for particular client
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/account/{clientId}/list")
public class ListAccountController extends EntityController {
	private static Logger logger = Logger.getLogger(ListAccountController.class);
	private static IInternetBankingService service;
	private static final String VIEW_NAME = "account-list";
	
	public ListAccountController(){
		service = ServiceProvider.getInternetBankingInstance();
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String defaultList(@PathVariable("clientId") Integer clientId, Model model, HttpSession session){
		String securityToken = getSecurityToken(session);
		ArrayOfAccount accounts = new ArrayOfAccount();
		List<AccountCardWrapper> wrappedList = null;
		try {
			accounts = service.getAccountsForClient(clientId, securityToken);
			wrappedList = new ArrayList<AccountCardWrapper>(); 
			for (Account account : accounts.getAccount()) {
				Card card = service.getCardForAccount(account.getId(), securityToken);
				wrappedList.add(new AccountCardWrapper(account, card));
			}
		} catch (IInternetBankingServiceGetAccountsForClientAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAccountsForClientDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CLIENT_ENTITY);
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetCardForAccountAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetCardForAccountDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CLIENT_ENTITY);
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		model.addAttribute("clientId", clientId);
		model.addAttribute("accountlist", wrappedList);

		return VIEW_NAME;
	}
	
}
