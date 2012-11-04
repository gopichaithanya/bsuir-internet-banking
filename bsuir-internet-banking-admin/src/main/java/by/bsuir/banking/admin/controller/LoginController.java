package by.bsuir.banking.admin.controller;

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

import by.bsuir.banking.admin.domain.User;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.dotnetclient.IAuthenticationService;
import by.bsuir.banking.dotnetclient.IAuthenticationServiceAuthenticateAuthenticationFaultFaultFaultMessage;

/**
 * Controller for authentication, handles user input and calls web-service
 * method to obtain security token
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/login")
@SessionAttributes({ "user" })
public class LoginController extends EntityController{
	private static Logger logger = Logger.getLogger(LoginController.class);
	private static final String VIEW_NAME = "login";
	
	/**
	 * Invoked initially to create the "user" attribute Once created the "form"
	 * attribute comes from the HTTP session (see @SessionAttributes)
	 */
	@ModelAttribute("user")
	public User createUser() {
		AdminUtils.logInfo(logger, MessageConstants.MODEL_BEAN_CREATED, "user");
		return new User();
	}

	/**
	 * Method just returns the view
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return VIEW_NAME;
	}

	/**
	 * Method for obtaining security token from web-service. Usually called with
	 * Ajax request. Security token is stored in session with username (user
	 * object)
	 * 
	 * @param user
	 * @param result
	 * @param ajaxRequest
	 * @param model
	 * @param redirectAttrs
	 * @param session
	 * @return
	 * @throws IAuthenticationServiceAuthenticateAuthenticationFaultFaultFaultMessage
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs, HttpSession session) {
		if (result.hasErrors()) {
			AdminUtils
					.logDebug(logger, MessageConstants.USER_AUTH_FAILED_CLIENT);
			return VIEW_NAME;
		}

		// Web-service calling
		try {
			IAuthenticationService service = ServiceProvider.getAuthenticationService();
			String securityToken;
			securityToken = service.authenticate(user.getUsername(),
					user.getPassword());
			user.setSecurityToken(securityToken);
			user.setRole("admin"); // test value
			session.setAttribute(MessageConstants.USER_ATTR, user);

			AdminUtils.logInfo(logger,
					MessageConstants.SECURITY_TOKEN_OBTAINED,
					user.getUsername());
			return "redirect:/";
		} catch (IAuthenticationServiceAuthenticateAuthenticationFaultFaultFaultMessage e) {
			result.reject(e.getMessage());
			AdminUtils.logInfo(logger, MessageConstants.USER_AUTH_FAILED_SERVER);
			return null;
		}

	}

}
