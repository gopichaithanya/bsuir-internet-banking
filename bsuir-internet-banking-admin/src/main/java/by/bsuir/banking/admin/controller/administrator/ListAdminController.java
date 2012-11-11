package by.bsuir.banking.admin.controller.administrator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.AdministratorWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.administration.Administrator;
import by.bsuir.banking.proxy.administration.ArrayOfAdministrator;
import by.bsuir.banking.proxy.administration.IAdministrationService;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetAdministratorsCountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetAdministratorsCountDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetAllAdministratorsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetAllAdministratorsDomainFaultFaultFaultMessage;


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
	private Integer itemsonpage = 5;
	private static final String VIEW_NAME = "admin-list";
	
	
	public ListAdminController(){
		service = ServiceProvider.getAdministrationService();
	}
	
	/**
	 * For now it's a fake method
	 * @param model
	 * @throws IOException 
	 */
	@ModelAttribute()
	public void pagingAttributes(Model model, HttpSession session, HttpServletResponse response) throws IOException{
		String securityToken = getSecurityToken(session);
		Integer adminsCount = 0;
		try {
			adminsCount = service.getAdministratorsCount(securityToken);
		} catch (IAdministrationServiceGetAdministratorsCountAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			response.sendRedirect(MessageConstants.AUTH_FAILED_VIEW);
		} catch (IAdministrationServiceGetAdministratorsCountDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.SERVICE_ERROR);
			response.sendRedirect(MessageConstants.ERROR_VIEW);
		}
		Double pagecount = Math.ceil(((double)adminsCount) / (double)itemsonpage);
		model.addAttribute("pagecount", pagecount.intValue());
		model.addAttribute("itemsonpage", itemsonpage);
	}
	
	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String defaultList(Model model, HttpSession session){
		String securityToken = getSecurityToken(session);
		try {
			ArrayOfAdministrator admins = service.getAllAdministrators(1, itemsonpage, securityToken);
			System.out.println("Admins count form list: " + admins.getAdministrator().size());
			List<AdministratorWrapper> wrappedList = new ArrayList<AdministratorWrapper>();
			for (Administrator admin:admins.getAdministrator()){
				wrappedList.add(new AdministratorWrapper(admin));
			}
			model.addAttribute("adminlist", wrappedList);
			model.addAttribute("page", 1);
		} catch (IAdministrationServiceGetAllAdministratorsAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IAdministrationServiceGetAllAdministratorsDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.SERVICE_ERROR);
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		return VIEW_NAME;
	}
	
	@RequestMapping(value={"/{page}"}, method = RequestMethod.GET)
	public String getPage(@PathVariable("page")Integer page, Model model, HttpSession session){
		String securityToken = getSecurityToken(session);
		try {
			ArrayOfAdministrator admins = service.getAllAdministrators(page, itemsonpage, securityToken);
			System.out.println("Admins count form list: " + admins.getAdministrator().size());
			List<AdministratorWrapper> wrappedList = new ArrayList<AdministratorWrapper>();
			for (Administrator admin:admins.getAdministrator()){
				wrappedList.add(new AdministratorWrapper(admin));
			}
			model.addAttribute("adminlist", wrappedList);
			model.addAttribute("page", page);
		} catch (IAdministrationServiceGetAllAdministratorsAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IAdministrationServiceGetAllAdministratorsDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.SERVICE_ERROR);
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		return VIEW_NAME;
	}
	
	
	
}
