package by.bsuir.banking.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import by.bsuir.banking.admin.domain.UserInfo;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = Logger.getLogger(AdminInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		HttpSession session = request.getSession();
		if(session == null){
			AdminUtils.logDebug(logger, MessageConstants.SESSION_IS_NULL);
			return false;
		}
		Object userObj = session.getAttribute(MessageConstants.USER_ATTR);
		if(userObj == null){
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR, MessageConstants.NOT_AUTHENTICATED_REASON);
			response.sendRedirect(request.getContextPath() + MessageConstants.LOGIN_VIEW);
			return false;
		}
		if(!((UserInfo)userObj).getRole().equalsIgnoreCase(MessageConstants.ADMIN_ROLE)){
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR, MessageConstants.WRONG_ROLE_REASON);
			response.sendRedirect(request.getContextPath() + MessageConstants.AUTH_FAILED_VIEW);
			return false;
		}
		return true;
	}

}
