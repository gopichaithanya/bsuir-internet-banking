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
import by.bsuir.banking.domain.ChangePasswordWrapper;
import by.bsuir.banking.domain.UserInfo;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;

/**
 * Controller for changing password
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/personal/change/password")
@SessionAttributes("changepassword")
public class ChangePasswordController extends EntityController{
	private static Logger logger = Logger
			.getLogger(ChangePasswordController.class);
	private static final String VIEW_NAME = "password-change";
	private IInternetBankingService service;

	public ChangePasswordController() {
		service = ServiceProvider.getInternetBankingService();
	}

	@ModelAttribute("changepassword")
	public ChangePasswordWrapper createModel() {
		return new ChangePasswordWrapper();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String createForm(Model model, HttpSession session) {

		return VIEW_NAME;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(
			@Valid @ModelAttribute("changepassword") ChangePasswordWrapper wrapper,
			BindingResult result, HttpSession session, RedirectAttributes attrs) {
		if (result.hasErrors()) {
			return VIEW_NAME;
		}
		// checking original username
		UserInfo user = getSessionUser(session);
		if (!user.getPassword().equals(wrapper.getOriginalPassword())) {
			result.reject("Original password is wrong");
			return VIEW_NAME;
		}
		if (!wrapper.getPassword().equals(wrapper.getConfirmPassword())) {
			result.reject("Password and confirmed password do not match");
			return VIEW_NAME;
		}
		// TODO set new username
		attrs.addFlashAttribute("success", "Password was suceessfully changed");
		return "redirect:/main";
	}
}
