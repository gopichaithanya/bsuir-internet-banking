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
		service.deleteClient(id, securityToken);
		redirectAttrs.addFlashAttribute("message",
				"Client was successfully deleted");
		return "redirect:/client/list";
	}

}
