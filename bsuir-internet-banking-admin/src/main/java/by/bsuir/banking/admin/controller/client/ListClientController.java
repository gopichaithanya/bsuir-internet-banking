package by.bsuir.banking.admin.controller.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.ClientWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.operator.ArrayOfClient;
import by.bsuir.banking.proxy.operator.Client;
import by.bsuir.banking.proxy.operator.IOperatorService;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetClientsCountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetClientsCountDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetPageofClientsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetPageofClientsDomainFaultFaultFaultMessage;

/**
 * Controller for listing clients
 * 
 * @author Katherine
 * 
 */
@Controller
@RequestMapping("/client/list")
@SessionAttributes({ "pagecount", "itemsonpage" })
public class ListClientController extends EntityController {
	private static Logger logger = Logger.getLogger(ListClientController.class);
	private static IOperatorService service;
	private Integer itemsonpage = 5;
	private static final String VIEW_NAME = "client-list";

	public ListClientController() {
		service = ServiceProvider.getOperatorService();
	}

	/**
	 * 
	 * @param model
	 * @param session
	 * @param response
	 * @throws IOException
	 */
	@ModelAttribute
	public void pagingAttributes(Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		String securityToken = getSecurityToken(session);
		Integer adminsCount = 0;
		try {
			adminsCount = service.getClientsCount(securityToken);
		} catch (IOperatorServiceGetClientsCountAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			response.sendRedirect(request.getContextPath() + MessageConstants.AUTH_FAILED_VIEW);
		} catch (IOperatorServiceGetClientsCountDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CLIENT_ENTITY);
			return;
		}
		Double pagecount = Math.ceil(((double) adminsCount)
				/ (double) itemsonpage);
		model.addAttribute("pagecount", pagecount.intValue());
		model.addAttribute("itemsonpage", itemsonpage);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String defaultList(Model model, HttpSession session) {
		String securityToken = getSecurityToken(session);
		ArrayOfClient clients = new ArrayOfClient();
		try {
			clients = service.getPageofClients(1, itemsonpage, securityToken);
		} catch (IOperatorServiceGetPageofClientsAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IOperatorServiceGetPageofClientsDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CLIENT_ENTITY);
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		List<ClientWrapper> wrappedList = new ArrayList<ClientWrapper>();
		for (Client client : clients.getClient()) {
			wrappedList.add(new ClientWrapper(client));
		}
		model.addAttribute("clientlist", wrappedList);
		model.addAttribute("page", 1);

		return VIEW_NAME;
	}
	
	@RequestMapping(value={"/{page}"}, method = RequestMethod.GET)
	public String getPage(@PathVariable("page")Integer page, Model model, HttpSession session){
		String securityToken = getSecurityToken(session);
		ArrayOfClient clients;
		try {
			clients = service.getPageofClients(page, itemsonpage, securityToken);
		} catch (IOperatorServiceGetPageofClientsAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IOperatorServiceGetPageofClientsDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CLIENT_ENTITY);
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		List<ClientWrapper> wrappedList = new ArrayList<ClientWrapper>();
		for (Client client:clients.getClient()){
			wrappedList.add(new ClientWrapper(client));
		}
		model.addAttribute("clientlist", wrappedList);
		model.addAttribute("page", page);
				
	return VIEW_NAME;
	}

}
