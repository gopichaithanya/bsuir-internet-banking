package by.bsuir.banking.controller.payment.saved;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceDeleteSavedPaymentAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceDeleteSavedPaymentDomainFaultFaultFaultMessage;

@Controller
@RequestMapping("/payment/saved/delete/{savedId}")
public class DeleteSavedPaymentController extends EntityController { 

	private static Logger logger = Logger
			.getLogger(DeleteSavedPaymentController.class);
	private static IInternetBankingService service;

	public DeleteSavedPaymentController() {
		service = ServiceProvider.getInternetBankingService();
	}
	 
	@RequestMapping(method=RequestMethod.POST)
	public String deletePayment(@PathVariable("savedId") Integer id, RedirectAttributes attrs,HttpSession session){
		try {
			service.deleteSavedPayment(id, getSecurityToken(session));
		} catch (IInternetBankingServiceDeleteSavedPaymentAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceDeleteSavedPaymentDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error", "Платеж не может быть удален");
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		attrs.addFlashAttribute("success", "Сохраненный платеж был успешно удален");
		return "redirect:/payment/saved/list"; 
	}
}
