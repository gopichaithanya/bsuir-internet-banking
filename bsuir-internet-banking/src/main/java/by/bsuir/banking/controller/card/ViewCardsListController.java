   package by.bsuir.banking.controller.card;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.MoneyWrapper;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage;

/**
 * 
 * @author Svetlana 
 * 
 */
@Controller
@RequestMapping("cards/view")
public class ViewCardsListController extends EntityController {

	private static Logger logger = Logger.getLogger(ViewCardsListController.class);
	private static IInternetBankingService service;
	private final static String VIEW_NAME = "card-view";

	public ViewCardsListController() {
		service = ServiceProvider.getInternetBankingService();
	}
  
	@RequestMapping(method = RequestMethod.GET)
	public String viewCards(HttpSession session, Model model,
			@ModelAttribute @Valid CardWrapper w, BindingResult result,
			HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		String securityToken = getSecurityToken(session);
		List<CardWrapper> cards = new ArrayList<CardWrapper>();
		List<MoneyWrapper> ballance = new ArrayList<MoneyWrapper>();
		try {
			for (Card card : service.getCards(securityToken).getCard()) {
				CardWrapper wrapper = new CardWrapper(card);
				cards.add(wrapper);
				ballance.add(new MoneyWrapper(service.getBallance(
						wrapper.getCardId(), securityToken)));
			}
		} catch (IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			response.sendRedirect(request.getContextPath()
					+ MessageConstants.AUTH_FAILED_VIEW);
		} catch (IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			response.sendRedirect(request.getContextPath()
					+ MessageConstants.AUTH_FAILED_VIEW);
		} catch (IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.SERVICE_ERROR);
			response.sendRedirect(request.getContextPath()
					+ MessageConstants.ERROR_VIEW);
		} catch (IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.SERVICE_ERROR);
			response.sendRedirect(request.getContextPath()
					+ MessageConstants.ERROR_VIEW);
		}
		model.addAttribute("cardList", cards);
		model.addAttribute("ballance", ballance);
		model.addAttribute("size", cards.size() - 1);
		return VIEW_NAME;
	}

}
