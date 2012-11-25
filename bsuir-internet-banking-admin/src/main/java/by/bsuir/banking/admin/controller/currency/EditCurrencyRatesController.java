package by.bsuir.banking.admin.controller.currency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.CurrencyRatesWrapper;
import by.bsuir.banking.admin.domain.PurchaseRateWrapper;
import by.bsuir.banking.admin.domain.SellRateWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.currency.ArrayOfPurchaseCurrencyRate;
import by.bsuir.banking.proxy.currency.ArrayOfSellCurrencyRate;
import by.bsuir.banking.proxy.currency.ICurrencyService;
import by.bsuir.banking.proxy.currency.ICurrencyServiceGetPurchaseCurrencyRatesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.currency.ICurrencyServiceGetSellCurrencyRatesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.currency.ICurrencyServiceUpdatePurchaseCurrencyRatesAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.currency.ICurrencyServiceUpdatePurchaseCurrencyRatesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.currency.ICurrencyServiceUpdateSellCurrencyRatesAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.currency.ICurrencyServiceUpdateSellCurrencyRatesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.currency.ObjectFactory;
import by.bsuir.banking.proxy.currency.PurchaseCurrencyRate;
import by.bsuir.banking.proxy.currency.SellCurrencyRate;

/**
 * Controller for setting currency exchange rates
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/currency/rates/set")
@SessionAttributes({"rates"})
public class EditCurrencyRatesController extends EntityController{

	private static Logger logger = Logger.getLogger(EditCurrencyRatesController.class);
	private static ICurrencyService service;
	private static final String VIEW_NAME = "rates-edit";
	
	public EditCurrencyRatesController() {
		service = ServiceProvider.getCurrencyService();
	}
	
	@ModelAttribute("rates")
	public CurrencyRatesWrapper createPurchaseRates(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<PurchaseRateWrapper> purchaseRates = new ArrayList<PurchaseRateWrapper>();
		try {
			for(PurchaseCurrencyRate rate: service.getPurchaseCurrencyRates().getPurchaseCurrencyRate()){
				purchaseRates.add(new PurchaseRateWrapper(rate));
			}
		} catch (ICurrencyServiceGetPurchaseCurrencyRatesDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CURRENCY_ENTITY);
			response.sendRedirect(request.getContextPath() + MessageConstants.ERROR_VIEW);
		}
		
		List<SellRateWrapper> sellRates = new ArrayList<SellRateWrapper>();
		try {
			for(SellCurrencyRate rate: service.getSellCurrencyRates().getSellCurrencyRate()){
				sellRates.add(new SellRateWrapper(rate));
			}
		} catch (ICurrencyServiceGetSellCurrencyRatesDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CURRENCY_ENTITY);
			response.sendRedirect(request.getContextPath() + MessageConstants.ERROR_VIEW);
		}
		CurrencyRatesWrapper wrapper = new CurrencyRatesWrapper(purchaseRates, sellRates);
		return wrapper;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String editRatesForm(){
		return VIEW_NAME;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("rates") CurrencyRatesWrapper wrapper, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs, HttpSession session){
		if (result.hasErrors()) {
			AdminUtils.logInfo(logger,
					MessageConstants.FORM_VALIDATION_ERROR, MessageConstants.CURRENCY_ENTITY);
			return VIEW_NAME;
		}
		ObjectFactory factory = new ObjectFactory();
		String securityToken = getSecurityToken(session);
		ArrayOfPurchaseCurrencyRate purchaseList = factory.createArrayOfPurchaseCurrencyRate();
		for(PurchaseRateWrapper purchaseWrapper:wrapper.getPurchaseRates()){
			purchaseList.getPurchaseCurrencyRate().add(purchaseWrapper.getPurchaseCurrencyRate());
		}
		try {
			service.updatePurchaseCurrencyRates(purchaseList, securityToken);
		} catch (ICurrencyServiceUpdatePurchaseCurrencyRatesAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			result.reject(e.getMessage());
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (ICurrencyServiceUpdatePurchaseCurrencyRatesDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.OBJECT_SAVING_FAILED_ON_SERVER, MessageConstants.CURRENCY_ENTITY);
			result.reject(e.getMessage());
			return VIEW_NAME;
		}
		ArrayOfSellCurrencyRate sellList = factory.createArrayOfSellCurrencyRate();
		for(SellRateWrapper sellWrapper:wrapper.getSellRates()){
			sellList.getSellCurrencyRate().add(sellWrapper.getSellCurrencyrate());
		}
		try {
			service.updateSellCurrencyRates(sellList, securityToken);
		} catch (ICurrencyServiceUpdateSellCurrencyRatesAuthorizationFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.AUTHORIZATION_ERROR);
			result.reject(e.getMessage());
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (ICurrencyServiceUpdateSellCurrencyRatesDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.OBJECT_SAVING_FAILED_ON_SERVER, MessageConstants.CURRENCY_ENTITY);
			result.reject(e.getMessage());
			return VIEW_NAME;
		}
		return "redirect:/currency/rates/view";
	}
}
