  package by.bsuir.banking.controller.card.lock;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceUnlockCardByIdAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceUnlockCardByIdDomainFaultFaultFaultMessage;

@Controller
@RequestMapping("/card/{cardId}/unlock")
public class UnlockCardController extends EntityController {

	private static IInternetBankingService service;
	
	public UnlockCardController(){
		service=ServiceProvider.getInternetBankingService();
	} 
	
	@RequestMapping(method=RequestMethod.POST)
	public String unlockCard(@PathVariable("cardId") Integer id, HttpSession session, RedirectAttributes attrs){
		try {
			service.unlockCardById(id, getSecurityToken(session));
		} catch (IInternetBankingServiceUnlockCardByIdAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceUnlockCardByIdDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error", "ќпераци€ разблокировани€ карты не может быть выполнена. ќбратитесь к оператору");
			return "redirect:" + MessageConstants.ERROR_VIEW; 
		}
		
		attrs.addFlashAttribute("success", " арта была успешно разблокирована");
		return "redirect:/card/" + id + "/view";
	}
}
