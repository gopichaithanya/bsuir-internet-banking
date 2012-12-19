package by.bsuir.banking.controller.history;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.controller.personal.ChangePasswordController;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;

/**
 * Controller for viewing operations history
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/history/payment")
@SessionAttributes("cardSelect")
public class ViewPaymentHistoryController  extends EntityController{

	private static final String VIEW_NAME = "history-payment";
	private IInternetBankingService service;
	
	public ViewPaymentHistoryController(){
		service = ServiceProvider.getInternetBankingService();
	}
	
	@RequestMapping
	public String paymentsHistory(HttpSession session){
		
		return VIEW_NAME;
	}
	

}
