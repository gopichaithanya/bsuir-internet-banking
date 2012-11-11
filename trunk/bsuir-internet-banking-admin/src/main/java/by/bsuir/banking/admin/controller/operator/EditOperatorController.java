package by.bsuir.banking.admin.controller.operator;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.OperatorWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.administration.IAdministrationService;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetOperatorByIdAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetOperatorByIdDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceUpdateOperatorAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceUpdateOperatorDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.Operator;


/**
 * Controller for operator's editing, handles admin's input and calls web-service
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/operator/edit/{id}")
@SessionAttributes("operator")
public class EditOperatorController extends EntityController{
	private static Logger logger = Logger.getLogger(EditOperatorController.class);
	private static IAdministrationService service;
	private static final String VIEW_NAME="operator-edit";
	
	public EditOperatorController(){
		service = ServiceProvider.getAdministrationService();
		AdminUtils.logInfo(logger, MessageConstants.ADMIN_SERVICE_CREATED);
		
	}
	
	/**
	 * Invoked initially to create the "operator" attribute Once created the
	 * "form" attribute comes from the HTTP session (see @SessionAttributes)
	 * @throws IOException 
	 */
	@ModelAttribute("operator")
	public OperatorWrapper createOperator(@PathVariable("id") Integer id, Model model, HttpSession session, HttpServletResponse response) throws IOException {
		String securityToken = getSecurityToken(session);
		Operator operator = null;
		try {
			operator = service.getOperatorById(id, securityToken);
		} catch (IAdministrationServiceGetOperatorByIdAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			response.sendRedirect(MessageConstants.AUTH_FAILED_VIEW);
		} catch (IAdministrationServiceGetOperatorByIdDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.OPERATOR_ENTITY);
			model.addAttribute("error", "Operator with requested id does not exist");
			return null;
		}
		AdminUtils.logInfo(logger, MessageConstants.MODEL_BEAN_CREATED,
				MessageConstants.OPERATOR_ENTITY);
		return new OperatorWrapper(operator);
	}

	/**
	 * 
	 */
	@RequestMapping( method = RequestMethod.GET)
	public String formCreate() {
		return VIEW_NAME;
	}

	@RequestMapping( method = RequestMethod.POST)
	public String submitCreate(@Valid @ModelAttribute("operator") OperatorWrapper operator, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs, HttpSession session) {
		if (result.hasErrors()) {
			AdminUtils.logInfo(logger,
					MessageConstants.FORM_VALIDATION_ERROR, MessageConstants.OPERATOR_ENTITY);
			return VIEW_NAME;
		}

		String securityToken = getSecurityToken(session);
		try {
			service.updateOperator(operator.getOperator(), securityToken);
			AdminUtils.logInfo(logger, MessageConstants.OBJECT_INSTANCE_SAVED, MessageConstants.OPERATOR_ENTITY);
			// Success response handling
			return "redirect:/operator/list";
		} catch (IAdministrationServiceUpdateOperatorAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			result.reject(e.getMessage());
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IAdministrationServiceUpdateOperatorDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.OBJECT_SAVING_FAILED_ON_SERVER, MessageConstants.OPERATOR_ENTITY);
			result.reject(e.getMessage());
			return VIEW_NAME;
		}

	}

}
