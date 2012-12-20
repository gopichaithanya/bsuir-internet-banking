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
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceLockCardByIdAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceLockCardByIdDomainFaultFaultFaultMessage;

@Controller
@RequestMapping("/card/{cardId}/lock")
public class LockCardController extends EntityController {
	 private static IInternetBankingService service;
	 
	 public LockCardController(){
		 service = ServiceProvider.getInternetBankingService();
	 }
	 
	 @RequestMapping(method=RequestMethod.POST)
	 public String lockCard(@PathVariable("cardId") Integer id, HttpSession session, RedirectAttributes attrs){
		 try {
			service.lockCardById(id, getSecurityToken(session));
		} catch (IInternetBankingServiceLockCardByIdAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceLockCardByIdDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error", "ќпераци€ блокировани€ карты не может быть выполнена. ќбратитесь к оператору");
			return "redirect:" + MessageConstants.ERROR_VIEW;  
		}
		 attrs.addFlashAttribute("success", " арта была успешно заблокирована");
		 return "redirect:/card/"+ id +"/view";
	 }
}
