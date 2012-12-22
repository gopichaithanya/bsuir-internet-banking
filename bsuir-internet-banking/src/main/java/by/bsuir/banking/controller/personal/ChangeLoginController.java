package by.bsuir.banking.controller.personal;

import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.ChangeUsernameWrapper;
import by.bsuir.banking.domain.UserInfo;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceSetNewLoginAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceSetNewLoginDomainFaultFaultFaultMessage;
import by.bsuir.banking.validator.ChangeLoginValidator;

/**
 * Controller for changing login
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/personal/change/login")
@SessionAttributes("changeusername")
public class ChangeLoginController extends EntityController { 

	private static Logger logger = Logger.getLogger(ChangeLoginController.class);
	private static final String VIEW_NAME = "username-change";
	@Autowired
	private ChangeLoginValidator changeLoginValidator;
	
	private IInternetBankingService service;

	public ChangeLoginController() {
		service = ServiceProvider.getInternetBankingService();
	}

	@ModelAttribute("changeusername")
	public ChangeUsernameWrapper createModel() { 
		return new ChangeUsernameWrapper();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String createForm(Model model, HttpSession session) {

		return VIEW_NAME;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(
			@Valid @ModelAttribute("changeusername") ChangeUsernameWrapper wrapper,
			BindingResult result, HttpSession session, RedirectAttributes attrs) {
		
		//checking original username
		UserInfo user = getSessionUser(session);
		if(!user.getUsername().equals(wrapper.getOriginalUsername())){
			result.reject("ChangeUsernameError","Неверное текущее имя пользователя");
			return VIEW_NAME;
		}
		changeLoginValidator.validate(wrapper, result);
		if(result.hasErrors()){
			return VIEW_NAME;
		}
		//TODO set new username
		try {
			service.setNewLogin(wrapper.getUsername(), getSecurityToken(session));
		} catch (IInternetBankingServiceSetNewLoginAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceSetNewLoginDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error", "Произошла ошибка. Имя пользователя не было изменено"); 
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		attrs.addFlashAttribute("success", "Имя пользователя успешно изменено"); 
		return "redirect:/main";
	}
}
