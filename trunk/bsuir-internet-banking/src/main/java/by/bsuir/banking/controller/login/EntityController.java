package by.bsuir.banking.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;

import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.domain.UserInfo;

@Controller
public class EntityController {

	/**
	 * Method for retrieving security token. Necessary for all we-service calls.
	 * 
	 * @param session
	 * @return
	 */
	protected String getSecurityToken(HttpSession session) {
		// when we call this methods we are sure that user is in the session
		// see Interceptor
		return ((UserInfo) session.getAttribute(MessageConstants.USER_ATTR))
				.getsSecurityToken();
	}

	/**
	 * Method for retrieving currently authenticated user. May be useful if we
	 * want to get user attribute (e.g. user-role).
	 * 
	 * @param session
	 * @return
	 */
	protected UserInfo getSessionUser(HttpSession session) {
		// when we call this methods we are sure that user is in the session
		// see Interceptor
		if(session.getAttribute(MessageConstants.USER_ATTR) == null){
			return null;
		}
		return (UserInfo) session.getAttribute(MessageConstants.USER_ATTR);
	}

	/**
	 * Invoked on every request
	 * 
	 * @param request
	 * @param model
	 */
	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

}
