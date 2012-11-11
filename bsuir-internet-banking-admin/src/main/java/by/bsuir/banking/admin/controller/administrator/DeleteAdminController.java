package by.bsuir.banking.admin.controller.administrator;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.administration.IAdministrationService;
import by.bsuir.banking.proxy.administration.IAdministrationServiceRemoveAdministratorAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceRemoveAdministratorDomainFaultFaultFaultMessage;

/**
 * Controller for deleting admin entities
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/admin/delete/{id}")
public class DeleteAdminController extends EntityController {

	private static Logger logger = Logger.getLogger(DeleteAdminController.class);
	private static IAdministrationService service;
	
	/**
	 * Constructor which gets service for this controller
	 */
	public DeleteAdminController(){
		service = ServiceProvider.getAdministrationService();
		AdminUtils.logInfo(logger, MessageConstants.ADMIN_SERVICE_CREATED);
		
	}
	
	/**
	 * Action that removes the admin entity
	 * @return
	 */
	@RequestMapping()
	public String deleteAdmin(@PathVariable("id") Integer id, @RequestHeader(value = "referer", required = false) String referrer, final RedirectAttributes redirectAttrs, HttpSession session){
		String securityToken = getSecurityToken(session);
		try {
			if(referrer == null || referrer == ""){
				referrer = "/admin/list";
			}
			service.removeAdministrator(id, securityToken);
		} catch (IAdministrationServiceRemoveAdministratorAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IAdministrationServiceRemoveAdministratorDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.DELETING_OBJECT_FAILED_ON_SERVER, MessageConstants.ADMIN_ENTITY);
			redirectAttrs.addFlashAttribute("message", "Administrator cannot be removed");
			return "redirect:" + referrer;
		}
		redirectAttrs.addFlashAttribute("message", "Administrator was successfully deleted");
		return "redirect:/admin/list";
	}
}
