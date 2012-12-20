package by.bsuir.banking.controller.payment.auto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;

@Controller
@RequestMapping("/autopayment/create")
public class CreateAutoPaymentController extends EntityController {
	private static String VIEW_NAME = "autopayment-create";
	private static IInternetBankingService service;
	
	public CreateAutoPaymentController(){
		service = ServiceProvider.getInternetBankingService();
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String createForm(){
		
		
		return VIEW_NAME;
	}
}
