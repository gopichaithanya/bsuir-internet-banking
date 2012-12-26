 package by.bsuir.banking.controller.login;

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

import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.domain.UserInfo;
import by.bsuir.banking.proxy.authentication.AuthenticationCredential;
import by.bsuir.banking.proxy.authentication.IAuthenticationService;
import by.bsuir.banking.proxy.authentication.IAuthenticationServiceAuthenticateAuthenticationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.authentication.IAuthenticationServiceAuthenticateDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.Client;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetClientDomainFaultFaultFaultMessage;

/**
 * Controller for authentication, handles user input and calls web-service
 * method to obtain security token
 * 
 * @author Katherine
 *  
 */
@Controller
@RequestMapping("/login")
@SessionAttributes({ "userInfo" })
public class LoginController extends EntityController{
	private static Logger logger = Logger.getLogger(LoginController.class);
	private static final String VIEW_NAME = "login";
	
	/**
	 * Invoked initially to create the "user" attribute Once created the "form"
	 * attribute comes from the HTTP session (see @SessionAttributes)
	 */
	@ModelAttribute("userInfo")
	public UserInfo createUser() {
		AdminUtils.logInfo(logger, MessageConstants.MODEL_BEAN_CREATED, "user");
		return new UserInfo();
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
	public String login(@Valid @ModelAttribute("userInfo") UserInfo user, BindingResult result,
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
			AuthenticationCredential credential = service.authenticate(user.getUsername(),
					user.getPassword());
			
			
			user.setRole(credential.getRole().getValue());
			if(!user.getRole().equals(MessageConstants.CLIENT_ROLE)){
				result.reject("logonError", "Имя пользователя и/или пароль неверны");
				AdminUtils.logInfo(logger, MessageConstants.USER_AUTH_FAILED_CLIENT);
				return VIEW_NAME;
			}
			 Client client = ServiceProvider.getInternetBankingService().getClient(credential.getSecurityToken().getValue());
			
			user.setLasDate(credential.getLastDateTime().toGregorianCalendar().getTime()); 
			user.setName(client.getFirstName().getValue() + " " + client.getLastName().getValue());
			user.setSecurityToken(credential.getSecurityToken().getValue());
			
			
			session.setAttribute(MessageConstants.USER_ATTR, user);

			AdminUtils.logInfo(logger,
					MessageConstants.SECURITY_TOKEN_OBTAINED,
					user.getUsername());
			return "redirect:/main";
		} catch (IAuthenticationServiceAuthenticateAuthenticationFaultFaultFaultMessage e) {
			result.reject("loginError","Имя пользователя и/или пароль неверны. После трех неудачных попыток ваша учетная запись будет заблокирована");
			AdminUtils.logInfo(logger, MessageConstants.USER_AUTH_FAILED_SERVER);
			return VIEW_NAME;
		} catch (IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage e) {
			result.reject("authError", "Вы не авторизованны для этой операции");
			AdminUtils.logInfo(logger, MessageConstants.USER_AUTH_FAILED_SERVER);
			return VIEW_NAME;
		} catch (IInternetBankingServiceGetClientDomainFaultFaultFaultMessage e) {
			result.reject("domainError", "Невозможно получить информацию о клиенте");
			AdminUtils.logInfo(logger, MessageConstants.USER_AUTH_FAILED_SERVER);
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IAuthenticationServiceAuthenticateDomainFaultFaultFaultMessage e) {
			result.reject("authError", "Вы 3 раза ввели неверный пароль. Ваша учетная запись заблокирована. Обратитесь к оператору банка.");
			return VIEW_NAME;
		}

	}

}
