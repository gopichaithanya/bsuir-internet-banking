package by.bsuir.banking.admin.controller.client;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
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
import by.bsuir.banking.admin.domain.PassportWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.operator.Client;
import by.bsuir.banking.proxy.operator.IOperatorService;

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
	
	public EditClientController(){
		service = ServiceProvider.getOperatorService();
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		String format = "MM/dd/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@ModelAttribute("client")
	public ClientWrapper getClient(@PathVariable("id") Integer id, HttpSession session, Model model){
		String securityToken = getSecurityToken(session);
		Client client = service.getClient(id, securityToken);
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
		if(result.hasErrors()){
			AdminUtils.logDebug(logger, MessageConstants.FORM_VALIDATION_ERROR, MessageConstants.PASSPORT_ENTITY);
			return VIEW_NAME;
		}
		String securityToken = getSecurityToken(session);
		service.updateClient(client.getClient(), securityToken);
		//getting id for newly created entity
		redirectAttrs.addFlashAttribute("message", "Client was saved successfully");
		return "redirect:/client/view/" + client.getId();
	}
	
}
