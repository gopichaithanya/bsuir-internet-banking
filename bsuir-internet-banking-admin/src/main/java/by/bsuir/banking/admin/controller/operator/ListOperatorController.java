package by.bsuir.banking.admin.controller.operator;

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
import by.bsuir.banking.admin.domain.OperatorWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.administration.ArrayOfOperator;
import by.bsuir.banking.proxy.administration.IAdministrationService;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetAllOperatorsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetAllOperatorsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetOperatorsCountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.IAdministrationServiceGetOperatorsCountDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.administration.Operator;

/**
 * Controller for listing operators
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/operator/list")

public class ListOperatorController extends EntityController{
	private static Logger logger = Logger.getLogger(ListOperatorController.class);
	private static IAdministrationService service;
	private Integer itemsonpage = 5;
	private static final String VIEW_NAME = "operator-list";
	
	
	public ListOperatorController(){
		service = ServiceProvider.getAdministrationService();
	}
	
	/**
	 * 
	 * @param model
	 * @param session
	 * @param response
	 * @throws IOException
	 */
	@ModelAttribute
	public void pagingAttributes(Model model, HttpSession session, HttpServletResponse response) throws IOException{
		String securityToken = getSecurityToken(session);
		Integer adminsCount = 0;
		try {
			adminsCount = service.getOperatorsCount(securityToken);
			System.out.println("Operators count from service: " + adminsCount);
		} catch (IAdministrationServiceGetOperatorsCountAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			response.sendRedirect(MessageConstants.AUTH_FAILED_VIEW);
		} catch (IAdministrationServiceGetOperatorsCountDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.SERVICE_ERROR);
			response.sendRedirect(MessageConstants.ERROR_VIEW);
		}
		Double pagecount = Math.ceil(((double)adminsCount) / (double)itemsonpage);
		model.addAttribute("pagecount", pagecount.intValue());
		model.addAttribute("itemsonpage", itemsonpage);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String defaultList(Model model, HttpSession session){
		String securityToken = getSecurityToken(session);
			ArrayOfOperator operators;
			try {
				operators = service.getAllOperators(1, itemsonpage, securityToken);
				System.out.println("Operators count form list: " + operators.getOperator().size());
				List<OperatorWrapper> wrappedList = new ArrayList<OperatorWrapper>();
				for (Operator operator:operators.getOperator()){
					wrappedList.add(new OperatorWrapper(operator));
				}
				model.addAttribute("operatorlist", wrappedList);
				model.addAttribute("page", 1);

			} catch (IAdministrationServiceGetAllOperatorsAuthorizationFaultFaultFaultMessage e) {
				AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
				return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
			} catch (IAdministrationServiceGetAllOperatorsDomainFaultFaultFaultMessage e) {
				AdminUtils.logDebug(logger, MessageConstants.SERVICE_ERROR);
				return "redirect:" + MessageConstants.ERROR_VIEW;
			}
					
		return VIEW_NAME;
	}
	
	@RequestMapping(value={"/{page}"}, method = RequestMethod.GET)
	public String getPage(@PathVariable("page")Integer page, Model model, HttpSession session){
		String securityToken = getSecurityToken(session);
		ArrayOfOperator operators;
		try {
			operators = service.getAllOperators(page, itemsonpage, securityToken);
			System.out.println("Operators count form list: " + operators.getOperator().size());
			List<OperatorWrapper> wrappedList = new ArrayList<OperatorWrapper>();
			for (Operator operator:operators.getOperator()){
				wrappedList.add(new OperatorWrapper(operator));
			}
			model.addAttribute("operatorlist", wrappedList);
			model.addAttribute("page", page);

		} catch (IAdministrationServiceGetAllOperatorsAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IAdministrationServiceGetAllOperatorsDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.SERVICE_ERROR);
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
				
	return VIEW_NAME;
	}
	
}
