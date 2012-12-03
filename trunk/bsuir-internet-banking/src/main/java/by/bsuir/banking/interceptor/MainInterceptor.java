package by.bsuir.banking.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.domain.User;

public class MainInterceptor extends HandlerInterceptorAdapter{

private static Logger logger = Logger.getLogger(MainInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		HttpSession session = request.getSession();
		if(session == null){
			AdminUtils.logDebug(logger, MessageConstants.SESSION_IS_NULL);
			response.sendRedirect(request.getContextPath() + MessageConstants.LOGIN_VIEW);
			return false;
		}
		Object userObj = session.getAttribute(MessageConstants.USER_ATTR);
		if(userObj == null){
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR, MessageConstants.NOT_AUTHENTICATED_REASON);
			response.sendRedirect(request.getContextPath() + MessageConstants.LOGIN_VIEW);
			return false;
		}
		if(((User)userObj).getRole() != MessageConstants.CLIENT_ROLE){
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR, MessageConstants.WRONG_ROLE_REASON);
			response.sendRedirect(request.getContextPath() + MessageConstants.AUTH_FAILED_VIEW);
			return false;
		}
		return true;
	}
}
