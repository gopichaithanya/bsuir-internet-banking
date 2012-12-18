package by.bsuir.banking.controller.card;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;


@Controller
@RequestMapping("/card/{cardId}/view")
@SessionAttributes()
public class CardViewController {
	private static Logger logger = Logger.getLogger(CardViewController.class);
	private static IInternetBankingService service;
	private final static String VIEW_NAME = "card-view-detail";

	public CardViewController() {
		service = ServiceProvider.getInternetBankingService();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String createView(HttpSession session){
		
		return VIEW_NAME;
	}
}
