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
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceDeleteCardAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceDeleteCardDomainFaultFaultFaultMessage;

@Controller
@RequestMapping("/account/{clientId}/card/{accountId}/delete/{cardId}")
public class DeleteCardController extends EntityController {
	private static IInternetBankingService service;
	
	public DeleteCardController(){
		service = ServiceProvider.getInternetBankingInstance();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String deleteCard(@PathVariable("clientId") Integer clientId, @PathVariable("accountId") Integer accountId,
			@PathVariable("cardId") Integer cardId, HttpSession session, RedirectAttributes attrs){
		String securityToken = getSecurityToken(session);
		try {
			service.deleteCard(cardId, securityToken);
		} catch (IInternetBankingServiceDeleteCardAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceDeleteCardDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		return "redirect:/account/"+clientId+"/view/"+accountId;
	}
}
