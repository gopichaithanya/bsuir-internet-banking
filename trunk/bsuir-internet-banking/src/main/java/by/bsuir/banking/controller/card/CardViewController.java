package by.bsuir.banking.controller.card;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.MoneyWrapper;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForClientDomainFaultFaultFaultMessage;


@Controller
@RequestMapping("/card/{cardId}/view")
@SessionAttributes()
public class CardViewController extends EntityController {
	private static Logger logger = Logger.getLogger(CardViewController.class);
	private static IInternetBankingService service;
	private final static String VIEW_NAME = "card-view-detail";

	public CardViewController() {
		service = ServiceProvider.getInternetBankingService();
	}
	   
	@RequestMapping(method=RequestMethod.GET)
	public String createView(@PathVariable("cardId") Integer id, HttpSession session, Model model){
		String securityToken = getSecurityToken(session);
		try {
			CardWrapper wrapper = new CardWrapper(service.getCardForClient(id, securityToken));
			MoneyWrapper ballance = new MoneyWrapper(service.getBallance(id, securityToken));
			model.addAttribute("card", wrapper);
			model.addAttribute("ballance", ballance);
			 
		} catch (IInternetBankingServiceGetCardForClientAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetCardForClientDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		return VIEW_NAME;
	}
}
