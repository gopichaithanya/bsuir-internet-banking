package by.bsuir.banking.admin.logout;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for logging out, invalidates session
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
