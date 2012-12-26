package by.bsuir.banking.controller.payment.auto;

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
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceDeleteAutoPaymentAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceDeleteAutoPaymentDomainFaultFaultFaultMessage;

@Controller
@RequestMapping("/autopayment/delete/{id}")
public class DeleteAutoPaymentController extends EntityController{
	private IInternetBankingService service;
	
	public DeleteAutoPaymentController(){
		service = ServiceProvider.getInternetBankingService();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String deletePayment(HttpSession session, @PathVariable("id") Integer id, RedirectAttributes attrs){
		try {
			service.deleteAutoPayment(id, getSecurityToken(session));
		} catch (IInternetBankingServiceDeleteAutoPaymentAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceDeleteAutoPaymentDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		attrs.addFlashAttribute("success", "Автоплатеж был успешно удален");
		return "redirect:/autopayment/list";
	}
}
