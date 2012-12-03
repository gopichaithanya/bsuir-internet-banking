package by.bsuir.banking.controller.personal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.controller.login.LoginController;
import by.bsuir.banking.domain.ChangeUsernameWrapper;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;

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

	private static Logger logger = Logger.getLogger(LoginController.class);
	private static final String VIEW_NAME = "username-change";
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
		if(result.hasErrors()){
			return VIEW_NAME;
		}
		if(!wrapper.getUsername().equals(wrapper.getConfirmUsername())){
			result.reject("Username and confirmed username do not match");
			return VIEW_NAME;
		}
		//TODO set new username
		attrs.addAttribute("message", "Username was suceessfully changed"); //??not working!!!!!!!!!!!!!!1
		return "redirect:/main";
	}
}
