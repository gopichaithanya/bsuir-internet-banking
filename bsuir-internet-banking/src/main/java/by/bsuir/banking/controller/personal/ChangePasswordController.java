package by.bsuir.banking.controller.personal;

import java.util.regex.Pattern;

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

import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.ChangePasswordWrapper;
import by.bsuir.banking.domain.UserInfo;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceSetNewPasswordAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceSetNewPasswordDomainFaultFaultFaultMessage;

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
	private IInternetBankingService service;
	private static final String VIEW_NAME = "password-change";
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";

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
			result.reject("ChangePasswordError","������� ������ ������������");
			return VIEW_NAME;
		}
		if (!wrapper.getPassword().equals(wrapper.getConfirmPassword())) {
			result.reject("ChangePasswordError","����� � �������������� ������ �� ���������");
			return VIEW_NAME;
		}
		if (!Pattern.compile(PASSWORD_PATTERN).matcher(wrapper.getPassword()).matches()) {
			result.reject("wrongNewPassword", "������ ������ ��������� ����� � ��������� �����");
			return VIEW_NAME;
		}
		// TODO set new username
		try {
			service.setNewPassword(wrapper.getPassword(), getSecurityToken(session));
		} catch (IInternetBankingServiceSetNewPasswordAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceSetNewPasswordDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error", "��������� ������. ������ �� ��� �������"); 
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		attrs.addFlashAttribute("success", "������ ��� ������� �������");
		return "redirect:/main";
	}
}
