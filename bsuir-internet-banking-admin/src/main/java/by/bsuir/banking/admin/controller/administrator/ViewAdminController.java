package by.bsuir.banking.admin.controller.administrator;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.AdministratorWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.administration.Administrator;
import by.bsuir.banking.proxy.administration.IAdministrationService;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetAdministratorByIdAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetAdministratorByIdDomainFaultFaultFaultMessage;

/**
 * Controller for admin viewing. Model - decorator of proxy class from .Net
 * web-service client.
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/admin/view/{id}")
@SessionAttributes("admin")
public class ViewAdminController extends EntityController{

	private static Logger logger = Logger.getLogger(ViewAdminController.class);
	private static IAdministrationService service;
	private static final String VIEW_NAME = "admin-view";
	
	/**
	 * Constructor which gets service for this controller
	 */
	public ViewAdminController(){
		service = ServiceProvider.getAdministrationService();
		AdminUtils.logInfo(logger, MessageConstants.ADMIN_SERVICE_CREATED);
		
	}
	
	
	/**
	 * Action for viewing admin
	 */
	@RequestMapping(value="", method= RequestMethod.GET)
	public String viewAdmin(@PathVariable("id") Integer id, HttpSession session, Model model){
		String securityToken = getSecurityToken(session);
		try {
			Administrator admin = service.getAdministratorById(id, securityToken);
			AdministratorWrapper wrapper = new AdministratorWrapper(admin);
			model.addAttribute("admin", wrapper);
		} catch (IAdministrationServiceGetAdministratorByIdAuthorizationFaultFaultFaultMessage e) {
			model.addAttribute("error", "You are not authorized to see this content");
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			return VIEW_NAME;
		} catch (IAdministrationServiceGetAdministratorByIdDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER);
			model.addAttribute("error", "Administrator with requested id does not exist");
			return VIEW_NAME;
		}
		
		return VIEW_NAME;
	}
}
