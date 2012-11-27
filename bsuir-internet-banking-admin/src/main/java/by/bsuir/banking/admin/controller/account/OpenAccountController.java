package by.bsuir.banking.admin.controller.account;

import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.AccountCardWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.card.ICardService;
import by.bsuir.banking.proxy.card.ICardServiceCreateCardAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.card.ICardServiceCreateCardDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.card.ICardServiceOpenAccountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.card.ICardServiceOpenAccountDomainFaultFaultFaultMessage;

/**
 * Controller for opening account. Account can be opened only for particular
 * client, so the url always contains client's id
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/account/open/{id}")
@SessionAttributes("account_card")
public class OpenAccountController extends EntityController {

	private static Logger logger = Logger
			.getLogger(OpenAccountController.class);
	private static ICardService service;
	private static final String VIEW_NAME = "account-open";

	public OpenAccountController() {
		service = ServiceProvider.getCardService();
		AdminUtils.logInfo(logger, MessageConstants.CARD_SERVICE_CREATED);
	}

	@ModelAttribute("account_card")
	public AccountCardWrapper createModel() {
		return new AccountCardWrapper();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String createForm() {
		return VIEW_NAME;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(
			@PathVariable("id") Integer id,
			@Valid @ModelAttribute("account_card") AccountCardWrapper accountCard,
			BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest,
			HttpSession session, RedirectAttributes redirectAttrs) {
		Integer generatedId = 0;
		if (result.hasErrors()) {
			AdminUtils.logDebug(logger, MessageConstants.FORM_VALIDATION_ERROR, MessageConstants.ACCOUNT_ENTITY);
			return VIEW_NAME;
		}
		String securityToken = getSecurityToken(session);
		
		
		try {
			//generate account number
			String accNumber = generateAccountNumber();
			accountCard.setAccountNumber(accNumber);
			accountCard.setClientId(id);
			service.openAccount(accountCard.getAccount(), securityToken);
		} catch (ICardServiceOpenAccountAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			result.reject(e.getMessage());
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (ICardServiceOpenAccountDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.OBJECT_SAVING_FAILED_ON_SERVER, MessageConstants.ACCOUNT_ENTITY);
			result.reject(e.getMessage());
			return VIEW_NAME;
		}
		try {
			//TODO get newly created account's id to connect it to card
			//TODO generate number depending on card type
			//TODO set expiration date
			//TODO set money and operation limits based on card type
			service.createCard(accountCard.getCard(), securityToken);
		} catch (ICardServiceCreateCardAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			result.reject(e.getMessage());
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (ICardServiceCreateCardDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.OBJECT_SAVING_FAILED_ON_SERVER, MessageConstants.CARD_ENTITY);
			redirectAttrs.addFlashAttribute("message", "Account was successfully created but withowt a card. Try creating card again");
			return "redirect:/account/" + id + "/view/" + generatedId;
		}
		return "redirect:/account/" + id + "/view/" + generatedId;
	}
	
	private String generateAccountNumber(){
		Random rand = new Random();
		String characters = "0123456789";
		String firstDigits = generateString(rand, characters, 4);
		String seconDigits = generateString(rand, characters, 8);
		String controlKey = generateString(rand, characters, 1);
		return firstDigits + seconDigits + controlKey;
	}
	
	private static String generateString(Random rng, String characters, int length)
	{
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
}
