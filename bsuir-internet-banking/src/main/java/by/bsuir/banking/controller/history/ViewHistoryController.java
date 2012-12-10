package by.bsuir.banking.controller.history;

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
@RequestMapping("/history")
@SessionAttributes()
public class ViewHistoryController  extends EntityController{

	private static Logger logger = Logger
			.getLogger(ChangePasswordController.class);
	private static final String VIEW_NAME = "history-view";
	private IInternetBankingService service;
	
	public ViewHistoryController(){
		service = ServiceProvider.getInternetBankingService();
	}
	
	

}
