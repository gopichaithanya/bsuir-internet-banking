package by.bsuir.banking.admin.controller.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.ClientWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.admin.validation.ClientValidator;
import by.bsuir.banking.proxy.operator.Client;
import by.bsuir.banking.proxy.operator.IOperatorService;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceUpdateClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceUpdateClientDomainFaultFaultFaultMessage;

/**
 * Controller for editing client entities
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/client/edit/{id}")
@SessionAttributes("client")
public class EditClientController extends EntityController {

	private static Logger logger = Logger.getLogger(EditClientController.class);
	private static IOperatorService service;
	private static final String VIEW_NAME = "client-edit";
	@Autowired
	ClientValidator clientValidator;
	
	public EditClientController(){
		service = ServiceProvider.getOperatorService();
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		String format = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@ModelAttribute("client")
	public ClientWrapper getClient(@PathVariable("id") Integer id, HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		String securityToken = getSecurityToken(session);
		Client client = null;
		try {
			client = service.getClient(id, securityToken);
		} catch (IOperatorServiceGetClientAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			response.sendRedirect(request.getContextPath() + MessageConstants.AUTH_FAILED_VIEW);
		} catch (IOperatorServiceGetClientDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CLIENT_ENTITY);
			return null;
		}
		ClientWrapper wrapper = new ClientWrapper(client);
		return wrapper;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getEditForm(){
		return VIEW_NAME;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitForm(@ModelAttribute("client") ClientWrapper client, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs, HttpSession session){
		clientValidator.validate(client, result);
		if(result.hasErrors()){
			AdminUtils.logDebug(logger, MessageConstants.FORM_VALIDATION_ERROR, MessageConstants.PASSPORT_ENTITY);
			return VIEW_NAME;
		}
		String securityToken = getSecurityToken(session);
		try {
			service.updateClient(client.getClient(), securityToken);
		} catch (IOperatorServiceUpdateClientAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			result.reject(e.getMessage());
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IOperatorServiceUpdateClientDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.OBJECT_SAVING_FAILED_ON_SERVER, MessageConstants.CLIENT_ENTITY);
			result.reject(e.getMessage());
			return VIEW_NAME;
		}
		//getting id for newly created entity
		redirectAttrs.addFlashAttribute("message", "Client was saved successfully");
		return "redirect:/client/view/" + client.getId();
	}
	
}
