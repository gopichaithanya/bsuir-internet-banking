package by.bsuir.banking.admin.controller.account;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceCloseAccountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceCloseAccountDomainFaultFaultFaultMessage;


@Controller
@RequestMapping("/account/{clientId}/close/{accountId}")
public class CloseAccountController extends EntityController {
	private static IInternetBankingService service;
	
	public CloseAccountController(){
		service = ServiceProvider.getInternetBankingInstance();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String deleteAccount(@PathVariable("clientId") Integer clientId, @PathVariable("accountId") Integer accountId,
			HttpSession session, RedirectAttributes attrs){
		String securityToken=getSecurityToken(session);
		try {
			service.closeAccount(accountId, securityToken);
			
		} catch (IInternetBankingServiceCloseAccountAuthorizationFaultFaultFaultMessage e) {
			return "redirect:"+MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceCloseAccountDomainFaultFaultFaultMessage e) {
			return "redirect:"+MessageConstants.ERROR_VIEW;
		}
		attrs.addFlashAttribute("success", "Account was successfully closed");
		return "redirect:/client/view/" + clientId;
	}
}
