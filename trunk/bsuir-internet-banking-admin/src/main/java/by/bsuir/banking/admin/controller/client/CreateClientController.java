package by.bsuir.banking.admin.controller.client;

import java.math.BigInteger;
import java.security.SecureRandom;
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
import by.bsuir.banking.proxy.operator.IOperatorService;

/**
 * Controller for client creation. Model - decorator of proxy class from .Net
 * web-service client.
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/client/create")
@SessionAttributes({"client", "passport"})
public class CreateClientController extends EntityController {
	private static Logger logger = Logger.getLogger(CreateClientController.class);
	private static IOperatorService service;
	private static final String VIEW_NAME_COMMON = "client-create";
	private static final String VIEW_NAME_PASSPORT = "passport-create";
	private static SecureRandom random = new SecureRandom();
    
	
	/**
	 * Constructor which gets service for this controller
	 */
	public CreateClientController(){
		service = ServiceProvider.getOperatorService();
		AdminUtils.logInfo(logger, MessageConstants.OPERATOR_SERVICE_CREATED);
	}
	
	/**
	 * Invoked initially to create the "client" attribute Once created the "form"
	 * attribute comes from the HTTP session (see @SessionAttributes)
	 */
	@ModelAttribute("client")
	public ClientWrapper createForm() {
		AdminUtils.logInfo(logger, MessageConstants.MODEL_BEAN_CREATED, MessageConstants.CLIENT_ENTITY);
		return new ClientWrapper();
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		String format = "MM/dd/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value={"","/common"}, method=RequestMethod.GET)
	public String clientCreate(){
		return VIEW_NAME_COMMON;
	}
	
	@RequestMapping(value={"","/common"}, method=RequestMethod.POST)
	public String clientSubmit(@Valid @ModelAttribute("client") ClientWrapper client, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs, HttpSession session){
		if(result.hasErrors()){
			AdminUtils.logDebug(logger, MessageConstants.FORM_VALIDATION_ERROR, MessageConstants.CLIENT_ENTITY);
			return VIEW_NAME_COMMON;
		}
		AdminUtils.logInfo(logger, MessageConstants.MODEL_BEAN_CREATED, MessageConstants.PASSPORT_ENTITY);
		PassportWrapper passport = new PassportWrapper();
		model.addAttribute("passport", passport);
		redirectAttrs.addFlashAttribute("client", client);
		redirectAttrs.addFlashAttribute("passport", passport);
		return "redirect:/client/create/passport";
	}
	
	@RequestMapping(value={"/passport"}, method=RequestMethod.GET)
	public String passportCreate(Model model){
		if(!model.containsAttribute("passport")){
			return "redirect:/client/create/common";
		}
		return VIEW_NAME_PASSPORT;
	}
	
	@RequestMapping(value={"/passport"}, method=RequestMethod.POST)
	public String passportSubmit(@ModelAttribute("client") ClientWrapper client, @Valid @ModelAttribute("passport") PassportWrapper passport, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs, HttpSession session){
		if(result.hasErrors()){
			AdminUtils.logDebug(logger, MessageConstants.FORM_VALIDATION_ERROR, MessageConstants.PASSPORT_ENTITY);
			return VIEW_NAME_PASSPORT;
		}
		String securityToken = getSecurityToken(session);
		client.setPassport(passport);
		//generating login and password
		String login = new BigInteger(50, random).toString(32);
	    String password = new BigInteger(50, random).toString(32);
		client.setLogin(login);
		client.setPassword(password);
		service.createClient(client.getClient(), securityToken);
		//getting id for newly created entity
		Integer id = service.getClientByPassportData(passport.getSeria(), passport.getNumber(), securityToken).getId();
		redirectAttrs.addFlashAttribute("message", "Client was created successfully");
		return "redirect:/client/view/" + id;
	}
	
	
	
}
