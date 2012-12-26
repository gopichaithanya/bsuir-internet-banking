 package by.bsuir.banking.controller.currency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.CurrencyTypeWrapper;
import by.bsuir.banking.domain.PurchaseRateWrapper;
import by.bsuir.banking.domain.SellRateWrapper;
import by.bsuir.banking.proxy.internetbanking.CurrencyType;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetPurchaseCurrencyRatesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetSellCurrencyRatesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.PurchaseCurrencyRate;
import by.bsuir.banking.proxy.internetbanking.SellCurrencyRate;
import by.bsuir.banking.validator.PurchaseRateValidator;
import by.bsuir.banking.validator.SellRateValidator;

 
/**
 * Controller for viewing currency exchange rates
 * @author Katherine
 *
 */ 
@Controller
@RequestMapping("/currency/rates/view")
public class ViewCurrencyRatesController extends EntityController {

	private static Logger logger = Logger.getLogger(ViewCurrencyRatesController.class);
	private static IInternetBankingService service;
	private static final String VIEW_NAME = "rates-view";
	@Autowired
	private SellRateValidator sellRateValidator;
	@Autowired
	private PurchaseRateValidator purchaseRateValidator;
	public ViewCurrencyRatesController(){
		service = ServiceProvider.getInternetBankingService();
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String viewRates(Model model, @ModelAttribute @Valid SellRateWrapper sellWrapper, BindingResult sellResult, @ModelAttribute @Valid PurchaseRateWrapper purchaseWrapper, BindingResult purchaseResult, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		List<CurrencyTypeWrapper> typeList = new ArrayList<CurrencyTypeWrapper>();
		try {
			for(CurrencyType type: service.getCurrencyTypes().getCurrencyType()){
				CurrencyTypeWrapper wrapper = new CurrencyTypeWrapper(type);
				typeList.add(wrapper);
			}
		} catch (IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CURRENCY_ENTITY);
			response.sendRedirect(request.getContextPath() + MessageConstants.ERROR_VIEW);
		}
		model.addAttribute("types", typeList);
		
		List<PurchaseRateWrapper> purchaseList = new ArrayList<PurchaseRateWrapper>();
		try {
			for(PurchaseCurrencyRate rate: service.getPurchaseCurrencyRates().getPurchaseCurrencyRate()){
				PurchaseRateWrapper wrapper = new PurchaseRateWrapper(rate);
				purchaseRateValidator.validate(wrapper, purchaseResult);
				purchaseList.add(wrapper);
			}
		} catch (IInternetBankingServiceGetPurchaseCurrencyRatesDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CURRENCY_ENTITY);
			response.sendRedirect(request.getContextPath() + MessageConstants.ERROR_VIEW);
		}
		model.addAttribute("purchaseRates", purchaseList);
		
		List<SellRateWrapper> sellList = new ArrayList<SellRateWrapper>();
		try {
			for(SellCurrencyRate rate: service.getSellCurrencyRates().getSellCurrencyRate()){
				SellRateWrapper wrapper = new SellRateWrapper(rate);
				sellRateValidator.validate(wrapper, sellResult);
				sellList.add(wrapper);
			}
		} catch (IInternetBankingServiceGetSellCurrencyRatesDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CURRENCY_ENTITY);
			response.sendRedirect(request.getContextPath() + MessageConstants.ERROR_VIEW);
		}
		model.addAttribute("sellRates", sellList);
		if (purchaseResult.hasErrors()) {
			purchaseResult.reject("purchaseRateError");
		}
		if (sellResult.hasErrors()) {
			sellResult.reject("sellRateError");
		}
		return VIEW_NAME;
	}
}
