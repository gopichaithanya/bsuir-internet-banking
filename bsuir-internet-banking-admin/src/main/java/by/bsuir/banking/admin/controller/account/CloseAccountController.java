package by.bsuir.banking.admin.controller.account;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceCloseAccountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceCloseAccountDomainFaultFaultFaultMessage;

/**
 * Controller for deleting account along with the card
 * 
 * @author E.Krasnotschek
 * 
 */
@Controller
@RequestMapping("/account/{clientId}/close/{accountId}")
public class CloseAccountController extends EntityController {
	private static Logger logger = Logger
			.getLogger(CloseAccountController.class);
	private static IInternetBankingService service;

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@PathVariable("clientId") Integer clientId,
			@PathVariable("accountId") Integer accountId,
			RedirectAttributes attrs, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		try {
			service.closeAccount(accountId, getSecurityToken(session));
		} catch (IInternetBankingServiceCloseAccountAuthorizationFaultFaultFaultMessage e) {
			response.sendRedirect(request.getContextPath() + MessageConstants.AUTH_FAILED_VIEW);
		} catch (IInternetBankingServiceCloseAccountDomainFaultFaultFaultMessage e) {
			response.sendRedirect(request.getContextPath() + MessageConstants.ERROR_VIEW);
		}
		attrs.addFlashAttribute("success", "Account was successfully deleted");
		return "redirect:/client/view/" + clientId;
	}
}
