package by.bsuir.banking.admin.controller.client;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.ClientWrapper;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.operator.Client;
import by.bsuir.banking.proxy.operator.IOperatorService;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceUnlockClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceUnlockClientDomainFaultFaultFaultMessage;


@Controller
@RequestMapping("/client/unlock/{clientId}")
public class UnlockClientController extends EntityController {
	private static IOperatorService service;
	private static SecureRandom random = new SecureRandom();
	
	public UnlockClientController(){
		service = ServiceProvider.getOperatorService();
	}
	
	@RequestMapping()
	public String unlockClient(HttpSession session, @PathVariable("clientId") Integer clientId,
			RedirectAttributes attrs){
		String securityToken = getSecurityToken(session);
		try {
			Client client = service.getClient(clientId, securityToken);
			ClientWrapper wrapper = new ClientWrapper(client);
			if(!wrapper.isLocked()){
				attrs.addFlashAttribute("error", "This client is not locked.");
				return "redirect:/client/view/"+clientId;
			}
			String login = new BigInteger(50, random).toString(32);
		    String password = new BigInteger(50, random).toString(32);
			wrapper.setLogin(login);
			wrapper.setPassword(password);
			service.unlockClient(clientId, login, password, securityToken);
		} catch (IOperatorServiceGetClientAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IOperatorServiceGetClientDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IOperatorServiceUnlockClientAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IOperatorServiceUnlockClientDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		
		attrs.addFlashAttribute("success", "Client was successfully unlocked");
		return "redirect:/client/view/"+clientId;
	}
}
