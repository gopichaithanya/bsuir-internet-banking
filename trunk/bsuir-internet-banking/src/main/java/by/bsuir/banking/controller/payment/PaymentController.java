package by.bsuir.banking.controller.payment;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;

/**
 * Controller for payments
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/payment/pay/{id}")
public class PaymentController extends EntityController{
	private static Logger logger = Logger.getLogger(PaymentController.class);
	private static final String VIEW_NAME = "payment-pay";
	private static IInternetBankingService service;
	
	public PaymentController(){
		service = ServiceProvider.getInternetBankingService();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String createForm(){
		
		return VIEW_NAME;
	}
	
}
