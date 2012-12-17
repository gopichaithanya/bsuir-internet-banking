package by.bsuir.banking.controller.card.limits;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;

@Controller
@RequestMapping("card/{cardId}/limit")
@SessionAttributes("card")
public class EditLimitsController extends EntityController {
	private static Logger logger = Logger.getLogger(EditLimitsController.class);
	private static IInternetBankingService service;
	private final static String VIEW_NAME = "limits-set";
	
	public EditLimitsController(){
		service = ServiceProvider.getInternetBankingService();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String createForm(HttpSession session){
		
		return VIEW_NAME;
	}
}
