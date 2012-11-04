package by.bsuir.banking.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.admin.domain.AdministratorWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.dotnetclient.Administrator;
import by.bsuir.banking.dotnetclient.ArrayOfAdministrator;
import by.bsuir.banking.dotnetclient.IAdministrationService;
import by.bsuir.banking.dotnetclient.IAdministrationServiceGetAllAdministratorsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.dotnetclient.IAdministrationServiceGetAllAdministratorsDomainFaultFaultFaultMessage;


/**
 * Controller for listing administrators
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/admin/list")
public class ListAdminController extends EntityController {
	private static Logger logger = Logger.getLogger(ListAdminController.class);
	private static IAdministrationService service;
	private static final String VIEW_NAME = "admin-list";
	
	
	public ListAdminController(){
		service = ServiceProvider.getAdministrationService();
	}
	
	/**
	 * For now it's a fake method
	 * @param model
	 */
	@ModelAttribute
	public void pagingAttributes(Model model){
		model.addAttribute("pagecount", 5);
		model.addAttribute("itemsonpage",10);
	}
	
	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String defaultList(Model model, HttpSession session){
		String securityToken = getSecurityToken(session);
		try {
			ArrayOfAdministrator admins = service.getAllAdministrators(1, 10, securityToken);
			List<AdministratorWrapper> wrappedList = new ArrayList<AdministratorWrapper>();
			for (Administrator admin:admins.getAdministrator()){
				wrappedList.add(new AdministratorWrapper(admin));
			}
			model.addAttribute("adminlist", wrappedList);
			model.addAttribute("page", 1);
		} catch (IAdministrationServiceGetAllAdministratorsAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			return "redirect:/auth/failed";
		} catch (IAdministrationServiceGetAllAdministratorsDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.SERVICE_ERROR);
			return "redirect:/error";
		}
		return VIEW_NAME;
	}
	
	@RequestMapping(value={"/{page}"}, method = RequestMethod.GET)
	public String getPage(@PathVariable("page")Integer page, HttpSession session){
		
		return VIEW_NAME;
	}
	
	
	
}
