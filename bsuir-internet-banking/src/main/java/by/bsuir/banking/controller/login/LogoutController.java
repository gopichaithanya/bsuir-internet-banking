package by.bsuir.banking.controller.login;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;

/**
 * Controller for logging out, invalidates session
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/logout")
public class LogoutController extends EntityController{
	
	private static Logger logger = Logger.getLogger(LogoutController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		AdminUtils.logInfo(logger, MessageConstants.USER_LOGGED_OUT);
		return "redirect:/";
	}
}
