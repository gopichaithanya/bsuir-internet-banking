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
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForClientDomainFaultFaultFaultMessage;
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
			 CardWrapper card = new CardWrapper(service.getCardForClient(id, getSecurityToken(session)));
			 if(card.isExpired()){
				 attrs.addFlashAttribute("error", "Срок годности карты истек. Все операции по карте запрещены. Обратитесь к оператору");
				 return "redirect:/card/"+id+"/view";
			 }
			service.lockCardById(id, getSecurityToken(session));
		} catch (IInternetBankingServiceLockCardByIdAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceLockCardByIdDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error", "Операция блокирования карты не может быть выполнена. Обратитесь к оператору");
			return "redirect:" + MessageConstants.ERROR_VIEW;  
		} catch (IInternetBankingServiceGetCardForClientAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetCardForClientDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error", "Операция блокирования карты не может быть выполнена. Обратитесь к оператору");
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		 attrs.addFlashAttribute("success", "Карта была успешно заблокирована");
		 return "redirect:/card/"+ id +"/view";
	 }
}
