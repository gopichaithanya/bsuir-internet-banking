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

import by.bsuir.banking.admin.domain.OperatorWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.dotnetclient.ArrayOfOperator;
import by.bsuir.banking.dotnetclient.IAdministrationService;
import by.bsuir.banking.dotnetclient.IAdministrationServiceGetAllOperatorsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.dotnetclient.IAdministrationServiceGetAllOperatorsDomainFaultFaultFaultMessage;
import by.bsuir.banking.dotnetclient.Operator;

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
	private static final String VIEW_NAME = "operator-list";
	
	
	public ListOperatorController(){
		service = ServiceProvider.getAdministrationService();
	}
	
	@ModelAttribute
	public void pagingAttributes(Model model){
		model.addAttribute("pagecount", 5);
		model.addAttribute("itemsonpage",10);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String defaultList(Model model, HttpSession session){
		String securityToken = getSecurityToken(session);
			ArrayOfOperator operators;
			try {
				operators = service.getAllOperators(1, 10, securityToken);
				List<OperatorWrapper> wrappedList = new ArrayList<OperatorWrapper>();
				for (Operator operator:operators.getOperator()){
					wrappedList.add(new OperatorWrapper(operator));
				}
				model.addAttribute("operatorlist", wrappedList);
				model.addAttribute("page", 1);

			} catch (IAdministrationServiceGetAllOperatorsAuthorizationFaultFaultFaultMessage e) {
				AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
				return "redirect:/auth/failed";
			} catch (IAdministrationServiceGetAllOperatorsDomainFaultFaultFaultMessage e) {
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
