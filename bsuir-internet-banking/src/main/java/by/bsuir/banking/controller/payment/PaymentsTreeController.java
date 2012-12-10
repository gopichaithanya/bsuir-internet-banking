package by.bsuir.banking.controller.payment;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;

/**
 * Controller that shows payments tree
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/payment/list")
public class PaymentsTreeController extends EntityController{
	private static Logger logger = Logger.getLogger(PaymentsTreeController.class);
	private static final String VIEW_NAME = "payment-list";
	private static IInternetBankingService service;
	
	public PaymentsTreeController(){
		service = ServiceProvider.getInternetBankingService();
	}
}
