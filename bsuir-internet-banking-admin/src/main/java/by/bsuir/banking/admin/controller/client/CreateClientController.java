package by.bsuir.banking.admin.controller.client;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.ClientWrapper;
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
@SessionAttributes("client")
public class CreateClientController extends EntityController {
	private static Logger logger = Logger.getLogger(CreateClientController.class);
	private static IOperatorService service;
	private static final String VIEW_NAME = "client-create";
	
	/**
	 * Constructor which gets service for this controller
	 */
	public CreateClientController(){
		service = ServiceProvider.getOperatorService();
		AdminUtils.logInfo(logger, MessageConstants.OPERATOR_SERVICE_CREATED);
	}
	
	/**
	 * Invoked initially to create the "admin" attribute Once created the "form"
	 * attribute comes from the HTTP session (see @SessionAttributes)
	 */
	@ModelAttribute("client")
	public ClientWrapper createForm() {
		AdminUtils.logInfo(logger, MessageConstants.MODEL_BEAN_CREATED, "client");
		return new ClientWrapper();
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public String formCreate(){
		return VIEW_NAME;
	}
	
	
}
