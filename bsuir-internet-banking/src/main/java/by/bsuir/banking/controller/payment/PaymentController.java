package by.bsuir.banking.controller.payment;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.PaymentUtil;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.ClientWrapper;
import by.bsuir.banking.domain.PaymentWrapper;
import by.bsuir.banking.proxy.internetbanking.Client;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.LegalPerson;

/**
 * Controller for payments
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/payment/pay/{paymentId}")
@SessionAttributes("payment")
public class PaymentController extends EntityController{
	private static Logger logger = Logger.getLogger(PaymentController.class);
	private static final String VIEW_NAME = "payment-pay";
	private static IInternetBankingService service;
	
	public PaymentController(){
		service = ServiceProvider.getInternetBankingService();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String createForm(@PathVariable("paymentId") Integer id, HttpSession session, Model model){
		String securityToken = getSecurityToken(session);
		try {
			LegalPerson person = PaymentUtil.getLegalPersonById(id, securityToken);
			Client client = service.getClient(securityToken);
			PaymentWrapper wrapper = new PaymentWrapper(person, new ClientWrapper(client));
			model.addAttribute("payment", wrapper);
		} catch (IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetClientDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		return VIEW_NAME;
	}
	
}
