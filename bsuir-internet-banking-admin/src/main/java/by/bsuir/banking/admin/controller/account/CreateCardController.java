package by.bsuir.banking.admin.controller.account;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.internetbanking.Account;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountByIdAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountByIdDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForAccountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForAccountDomainFaultFaultFaultMessage;

/**
 * Controller for creating card for account
 * (for example when the card is expired)
 * @author E.Krasnotschek
 *
 */
@Controller
@RequestMapping("/account/{clientId}/card/{accountId}/create")
public class CreateCardController extends EntityController {
	private static Logger logger = Logger.getLogger(ListAccountController.class);
	private static IInternetBankingService service;
	private static final String VIEW_NAME = "card-create"; 
	
	public CreateCardController(){
		service = ServiceProvider.getInternetBankingInstance();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String createForm(@PathVariable("accountId") Integer accountId, HttpSession session){
		//get account to see if it already has a card
		String securityToken = getSecurityToken(session);
		try {
			Account account = service.getAccountById(accountId, securityToken);
			Card card = service.getCardForAccount(accountId, securityToken);
			//if(card != null)
		} catch (IInternetBankingServiceGetAccountByIdAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAccountByIdDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardForAccountAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardForAccountDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return VIEW_NAME;
	}
}
