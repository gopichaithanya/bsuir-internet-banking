package by.bsuir.banking.admin.controller.client;

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
import by.bsuir.banking.proxy.operator.IOperatorService;
import by.bsuir.banking.proxy.operator.IOperatorServiceDeleteClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceDeleteClientDomainFaultFaultFaultMessage;

/**
 * Controller for deleting clients
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/client/delete/{id}")
public class DeleteClientController extends EntityController {

	private static Logger logger = Logger
			.getLogger(DeleteClientController.class);
	private static IOperatorService service;

	public DeleteClientController() {
		service = ServiceProvider.getOperatorService();
		AdminUtils.logInfo(logger, MessageConstants.OPERATOR_SERVICE_CREATED);
	}

	@RequestMapping()
	public String deleteAdmin(
			@PathVariable("id") Integer id,
			@RequestHeader(value = "referer", required = false) String referrer,
			final RedirectAttributes redirectAttrs, HttpSession session) {
		String securityToken = getSecurityToken(session);
		if (referrer == null || referrer == "") {
			referrer = "/client/list";
		}
		try {
			service.deleteClient(id, securityToken);
		} catch (IOperatorServiceDeleteClientAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IOperatorServiceDeleteClientDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.DELETING_OBJECT_FAILED_ON_SERVER, MessageConstants.CLIENT_ENTITY);
			redirectAttrs.addFlashAttribute("message",
					"Client could not be deleted");
			return "redirect:" + referrer;
		}
		redirectAttrs.addFlashAttribute("message",
				"Client was successfully deleted");
		return "redirect:/client/list";
	}

}
