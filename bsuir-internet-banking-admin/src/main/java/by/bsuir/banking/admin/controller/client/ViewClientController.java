package by.bsuir.banking.admin.controller.client;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.admin.controller.DatePropertyEditor;
import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.ClientWrapper;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.operator.Client;
import by.bsuir.banking.proxy.operator.IOperatorService;

/**
 * Controller for viewing client
 * with operations like "open account, view accounts" etc
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/client/view/{id}")
public class ViewClientController extends EntityController {

	private static Logger logger = Logger.getLogger(ViewClientController.class);
	private static IOperatorService service;
	private static final String VIEW_NAME = "client-view";
	
    public ViewClientController(){
    	service = ServiceProvider.getOperatorService();
    }
    
    @InitBinder
	public void initBinder(HttpServletRequest req, ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class, new DatePropertyEditor());
	}
    
    @RequestMapping(method=RequestMethod.GET)
    public String viewClient(@PathVariable("id") Integer id, HttpSession session, Model model){
    	String securityToken = getSecurityToken(session);
    	Client client = service.getClient(id, securityToken);
    	ClientWrapper wrapper = new ClientWrapper(client);
    	model.addAttribute("client", wrapper);
    	
    	return VIEW_NAME;
    }
}
