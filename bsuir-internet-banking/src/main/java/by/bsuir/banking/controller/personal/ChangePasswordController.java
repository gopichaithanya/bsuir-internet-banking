package by.bsuir.banking.controller.personal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.ChangePasswordWrapper;
import by.bsuir.banking.domain.UserInfo;
import by.bsuir.banking.proxy.authentication.AuthenticationCredential;
import by.bsuir.banking.proxy.authentication.IAuthenticationService;
import by.bsuir.banking.proxy.authentication.IAuthenticationServiceAuthenticateAuthenticationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.authentication.IAuthenticationServiceAuthenticateDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceSetNewPasswordAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceSetNewPasswordDomainFaultFaultFaultMessage;
import by.bsuir.banking.validator.ChangePasswordValidator;

/**
 * Controller for changing password
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/personal/change/password")
@SessionAttributes("changepassword")
public class ChangePasswordController extends EntityController {
	private static Logger logger = Logger
			.getLogger(ChangePasswordController.class);
	private IInternetBankingService service;
	private static final String VIEW_NAME = "password-change";
	@Autowired
	private ChangePasswordValidator changePasswordValidator;

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
		// checking original username
		UserInfo user = getSessionUser(session);
		if (!user.getPassword().equals(wrapper.getOriginalPassword())) {
			result.reject("ChangePasswordError", "Текущий пароль неправильный");
			return VIEW_NAME;
		}
		changePasswordValidator.validate(wrapper, result);
		if (result.hasErrors()) {
			return VIEW_NAME;
		}
		try {
			service.setNewPassword(wrapper.getPassword(),
					getSecurityToken(session));
			// reauthenticate with new password
			String username = user.getUsername();
			IAuthenticationService authService = ServiceProvider
					.getAuthenticationService();
			AuthenticationCredential credential = authService.authenticate(username, wrapper.getPassword());
			user.setPassword(wrapper.getPassword()); 
			user.setRole(credential.getRole().getValue());
			if (!user.getRole().equals(MessageConstants.CLIENT_ROLE)) {
				result.reject("logonError",
						"Имя пользователя и/или пароль неверны");
				AdminUtils.logInfo(logger,
						MessageConstants.USER_AUTH_FAILED_CLIENT);
				return VIEW_NAME;
			}
			user.setSecurityToken(credential.getSecurityToken().getValue());

			session.setAttribute(MessageConstants.USER_ATTR, user);

		} catch (IInternetBankingServiceSetNewPasswordAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceSetNewPasswordDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error",
					"Произошла ошибка. Пароль не был изменен");
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IAuthenticationServiceAuthenticateAuthenticationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IAuthenticationServiceAuthenticateDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error",
					"Произошла ошибка. Не могу авторизоваться под новым паролем");
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		attrs.addFlashAttribute("success", "Пароль был успешно изменен");
		return "redirect:/main";
	}
}
