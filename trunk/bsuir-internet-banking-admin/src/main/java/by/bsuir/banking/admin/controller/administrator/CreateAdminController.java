package by.bsuir.banking.admin.controller.administrator;

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

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.AdministratorWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.administration.IAdministrationService;
import by.bsuir.banking.proxy.administration.IAdministrationServiceCreateNewAdministratorAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceCreateNewAdministratorDomainFaultFaultFaultMessage;

/**
 * Controller for admin creation. Model - decorator of proxy class from .Net
 * web-service client.
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/admin/create")
@SessionAttributes("admin")
public class CreateAdminController extends EntityController{
	
	private static Logger logger = Logger.getLogger(CreateAdminController.class);
	private static IAdministrationService service;
	private static final String VIEW_NAME = "admin-create";
	
	
	/**
	 * Constructor which gets service for this controller
	 */
	public CreateAdminController(){
		service = ServiceProvider.getAdministrationService();
		AdminUtils.logInfo(logger, MessageConstants.ADMIN_SERVICE_CREATED);
		
	}
	
	/**
	 * Invoked initially to create the "admin" attribute Once created the "form"
	 * attribute comes from the HTTP session (see @SessionAttributes)
	 */
	@ModelAttribute("admin")
	public AdministratorWrapper createForm() {
		AdminUtils.logInfo(logger, MessageConstants.MODEL_BEAN_CREATED, "admin");
		return new AdministratorWrapper();
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public String formCreate(){
		return VIEW_NAME;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("admin") AdministratorWrapper admin, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs, HttpSession session){
		if(result.hasErrors()){
			AdminUtils.logDebug(logger, MessageConstants.FORM_VALIDATION_ERROR, MessageConstants.ADMIN_ENTITY);
			return VIEW_NAME;
		}
		String securityToken = getSecurityToken(session);
		try {
			service.createNewAdministrator(admin.getAdministrator(), securityToken);
			AdminUtils.logInfo(logger, MessageConstants.OBJECT_INSTANCE_SAVED, MessageConstants.ADMIN_ENTITY);
			return "redirect:/admin/list";
		} catch (IAdministrationServiceCreateNewAdministratorAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			result.reject(e.getMessage());
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IAdministrationServiceCreateNewAdministratorDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.OBJECT_SAVING_FAILED_ON_SERVER, MessageConstants.ADMIN_ENTITY);
			result.reject(e.getMessage());
			return VIEW_NAME;
		}
		
	}

}
