package by.bsuir.banking.admin.login;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;

/**
 * Controller for authentication, handles user input and calls web-service method
 * to obtain security token
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/login")
@SessionAttributes({"user"})
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	/**
	 * Invoked on every request
	 * @param request
	 * @param model
	 */
	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	/**
	 * Invoked initially to create the "user" attribute
	 * Once created the "form" attribute comes from the HTTP session (see @SessionAttributes)
	 */
	@ModelAttribute("user")
	public User createUser() {
		AdminUtils.logInfo(logger, MessageConstants.MODEL_BEAN_CREATED, "user");
		return new User();
	}
	
	/**
	 * Method just returns the view
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "login";
	}

	/**
	 * Method for obtaining security token from web-service.
	 * Usually called with Ajax request.
	 * Security token is stored in session with username (user object)
	 * @param user
	 * @param result
	 * @param ajaxRequest
	 * @param model
	 * @param redirectAttrs
	 * @param session
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@Valid User user, BindingResult result, 
								@ModelAttribute("ajaxRequest") boolean ajaxRequest, 
								Model model, RedirectAttributes redirectAttrs, HttpSession session) {
		if (result.hasErrors()) {
			AdminUtils.logInfo(logger, MessageConstants.USER_AUTH_FAILED_CLIENT);
			return null;
		}
		
		//TODO insert web-service calling
		//String securityToken = ...
		user.setSecurityToken("testToken");
		session.setAttribute("user", user);
		
		AdminUtils.logInfo(logger, MessageConstants.SECURITY_TOKEN_OBTAINED, user.getUsername());
		
		// Success response handling
		if (ajaxRequest) {
			return null;
		} else {
			return "redirect:/";			
		}
	}
	

}
