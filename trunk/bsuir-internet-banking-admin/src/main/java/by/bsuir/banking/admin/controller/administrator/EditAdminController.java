package by.bsuir.banking.admin.controller.administrator;

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
import by.bsuir.banking.admin.domain.AdministratorWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.administration.Administrator;
import by.bsuir.banking.proxy.administration.IAdministrationService;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetAdministratorByIdAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetAdministratorByIdDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceUpdateAdministratorAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceUpdateAdministratorDomainFaultFaultFaultMessage;

/**
 * Controller for admin editing. Model - decorator of proxy class from .Net
 * web-service client.
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/admin/edit/{id}")
@SessionAttributes("admin")
public class EditAdminController extends EntityController {
	private static Logger logger = Logger.getLogger(EditAdminController.class);
	private static IAdministrationService service;
	private static final String VIEW_NAME = "admin-edit";
	
	
	/**
	 * Constructor which gets service for this controller
	 */
	public EditAdminController(){
		service = ServiceProvider.getAdministrationService();
		AdminUtils.logInfo(logger, MessageConstants.ADMIN_SERVICE_CREATED);
		
	}
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @param session
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String createForm(@PathVariable("id") Integer id, Model model, HttpSession session, HttpServletResponse response) throws IOException {
		String securityToken = getSecurityToken(session);
		Administrator admin = null;
		try {
			admin = service.getAdministratorById(id, securityToken);
			admin.setId(id);
			System.out.println("Admin id: " + admin.getId());
		} catch (IAdministrationServiceGetAdministratorByIdAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			response.sendRedirect(MessageConstants.AUTH_FAILED_VIEW);
		} catch (IAdministrationServiceGetAdministratorByIdDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.ADMIN_ENTITY);
			model.addAttribute("error", "Administrator with requested id does not exist");
			return null;
		}
		AdminUtils.logInfo(logger, MessageConstants.MODEL_BEAN_CREATED, "admin");
		model.addAttribute("admin", new AdministratorWrapper(admin));
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
			System.out.println("Admin id: " + admin.getAdministrator().getId());
			service.updateAdministrator(admin.getAdministrator(), securityToken);
			AdminUtils.logInfo(logger, MessageConstants.OBJECT_INSTANCE_SAVED, MessageConstants.OPERATOR_ENTITY);
			return "redirect:/admin/list";
		} catch (IAdministrationServiceUpdateAdministratorAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			result.reject(e.getMessage());
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IAdministrationServiceUpdateAdministratorDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.OBJECT_SAVING_FAILED_ON_SERVER, MessageConstants.ADMIN_ENTITY);
			result.reject(e.getMessage());
			return VIEW_NAME;
		}
		
	}

}
