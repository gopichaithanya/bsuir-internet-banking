package by.bsuir.banking.admin.controller;

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

import by.bsuir.banking.admin.domain.OperatorWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.dotnetclient.IAdministrationService;
import by.bsuir.banking.dotnetclient.IAdministrationServiceCreateNewOperatorAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.dotnetclient.IAdministrationServiceCreateNewOperatorDomainFaultFaultFaultMessage;

/**
 * Controller for operator's CRUD, handles admin's input and calls web-service
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/operator")
@SessionAttributes("operator")
public class CreateOperatorController extends EntityController{
	private static Logger logger = Logger.getLogger(CreateOperatorController.class);
	private static IAdministrationService service;
	private static final String VIEW_NAME="operator-form";
	
	public CreateOperatorController(){
		service = ServiceProvider.getAdministrationService();
		AdminUtils.logInfo(logger, MessageConstants.ADMIN_SERVICE_CREATED);
		
	}
	
	/**
	 * Invoked initially to create the "operator" attribute Once created the
	 * "form" attribute comes from the HTTP session (see @SessionAttributes)
	 */
	@ModelAttribute("operator")
	public OperatorWrapper createOperator() {
		AdminUtils.logInfo(logger, MessageConstants.MODEL_BEAN_CREATED,
				"operator");
		return new OperatorWrapper();
	}

	/**
	 * 
	 */
	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public String formCreate() {
		return VIEW_NAME;
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public String submitCreate(@Valid @ModelAttribute("operator") OperatorWrapper operator, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs, HttpSession session) {
		if (result.hasErrors()) {
			AdminUtils.logInfo(logger,
					MessageConstants.FORM_VALIDATION_ERROR, MessageConstants.OPERATOR_ENTITY);
			return "operator-form";
		}

		String securityToken = getSecurityToken(session);
		try {
			service.createNewOperator(operator.getOperator(), securityToken);
			AdminUtils.logInfo(logger, MessageConstants.OBJECT_INSTANCE_SAVED, MessageConstants.OPERATOR_ENTITY);
			// Success response handling
			return "redirect:/operator/list";
		} catch (IAdministrationServiceCreateNewOperatorAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			result.reject(e.getMessage());
			return VIEW_NAME;
		} catch (IAdministrationServiceCreateNewOperatorDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.OBJECT_SAVING_FAILED_ON_SERVER, MessageConstants.OPERATOR_ENTITY);
			result.reject(e.getMessage());
			return VIEW_NAME;
		}

		

		

	}
	
}
