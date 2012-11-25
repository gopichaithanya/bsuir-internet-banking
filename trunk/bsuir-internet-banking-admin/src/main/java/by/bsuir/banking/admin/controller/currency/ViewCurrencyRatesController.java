package by.bsuir.banking.admin.controller.currency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.CurrencyTypeWrapper;
import by.bsuir.banking.admin.domain.PurchaseRateWrapper;
import by.bsuir.banking.admin.domain.SellRateWrapper;
import by.bsuir.banking.admin.utils.AdminUtils;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.currency.CurrencyType;
import by.bsuir.banking.proxy.currency.ICurrencyService;
import by.bsuir.banking.proxy.currency.ICurrencyServiceGetCurrencyTypesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.currency.ICurrencyServiceGetPurchaseCurrencyRatesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.currency.ICurrencyServiceGetSellCurrencyRatesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.currency.PurchaseCurrencyRate;
import by.bsuir.banking.proxy.currency.SellCurrencyRate;

/**
 * Controller for viewing currency exchange rates
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/currency/rates/view")
public class ViewCurrencyRatesController extends EntityController {

	private static Logger logger = Logger.getLogger(ViewCurrencyRatesController.class);
	private static ICurrencyService service;
	private static final String VIEW_NAME = "rates-view";
	
	public ViewCurrencyRatesController(){
		service = ServiceProvider.getCurrencyService();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String viewRates(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		List<CurrencyTypeWrapper> typeList = new ArrayList<CurrencyTypeWrapper>();
		try {
			for(CurrencyType type: service.getCurrencyTypes().getCurrencyType()){
				CurrencyTypeWrapper wrapper = new CurrencyTypeWrapper(type);
				typeList.add(wrapper);
			}
		} catch (ICurrencyServiceGetCurrencyTypesDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CURRENCY_ENTITY);
			response.sendRedirect(request.getContextPath() + MessageConstants.ERROR_VIEW);
		}
		model.addAttribute("types", typeList);
		
		List<PurchaseRateWrapper> purchaseList = new ArrayList<PurchaseRateWrapper>();
		try {
			for(PurchaseCurrencyRate rate: service.getPurchaseCurrencyRates().getPurchaseCurrencyRate()){
				PurchaseRateWrapper wrapper = new PurchaseRateWrapper(rate);
				purchaseList.add(wrapper);
			}
		} catch (ICurrencyServiceGetPurchaseCurrencyRatesDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CURRENCY_ENTITY);
			response.sendRedirect(request.getContextPath() + MessageConstants.ERROR_VIEW);
		}
		model.addAttribute("purchaseRates", purchaseList);
		
		List<SellRateWrapper> sellList = new ArrayList<SellRateWrapper>();
		try {
			for(SellCurrencyRate rate: service.getSellCurrencyRates().getSellCurrencyRate()){
				SellRateWrapper wrapper = new SellRateWrapper(rate);
				sellList.add(wrapper);
			}
		} catch (ICurrencyServiceGetSellCurrencyRatesDomainFaultFaultFaultMessage e) {
			AdminUtils.logDebug(logger, MessageConstants.GETTING_OBJECT_FAILED_ON_SERVER, MessageConstants.CURRENCY_ENTITY);
			response.sendRedirect(request.getContextPath() + MessageConstants.ERROR_VIEW);
		}
		model.addAttribute("sellRates", sellList);
		return VIEW_NAME;
	}
}
