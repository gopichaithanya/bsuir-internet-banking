package by.bsuir.banking.controller.payment.auto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.PaymentUtil;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.AutoPaymentWrapper;
import by.bsuir.banking.domain.LegalPersonWrapper;
import by.bsuir.banking.proxy.internetbanking.City;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonCategoriesAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonCategoriesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCitiesForRegionAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCitiesForRegionDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetLegalPersonsForCategoryAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetLegalPersonsForCategoryDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetServicesForCityAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetServicesForCityDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.LegalPerson;
import by.bsuir.banking.proxy.internetbanking.LegalPersonCategory;
import by.bsuir.banking.proxy.internetbanking.Payment;
import by.bsuir.banking.proxy.internetbanking.Region;
import by.bsuir.banking.proxy.internetbanking.Service;

@Controller
@RequestMapping("/autopayment/create")
public class CreateAutoPaymentController extends EntityController {
	private static String VIEW_NAME = "autopayment-create";
	private static String VIEW_NAME_LIST = "payment-list";
	private static IInternetBankingService service;
	
	public CreateAutoPaymentController(){
		service = ServiceProvider.getInternetBankingService();
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String createTree(HttpSession session, Model model){
		String securityToken = getSecurityToken(session);
		Map<LegalPersonCategory, List<LegalPerson>> categories = new HashMap<LegalPersonCategory, List<LegalPerson>>();
		Map<Region,Map<City,List<Service>>> eripPayments = new HashMap<Region, Map<City,List<Service>>>();
		
		try {
			//regular payments
			for (LegalPersonCategory category : service
					.getAllLegalPersonCategories(securityToken)
					.getLegalPersonCategory()) {
				if (category.getId() != 1) {
					List<LegalPerson> persons = new ArrayList<LegalPerson>();
					for (LegalPerson person : service
							.getLegalPersonsForCategory(category.getId(),
									securityToken).getLegalPerson()) {
						persons.add(person);

					}
					categories.put(category, persons);
				}
			}
			
			//erip payments
			for(Region region:service.getAllRegions(securityToken).getRegion()){
				Map<City,List<Service>> cities = new HashMap<City, List<Service>>();
				for(City city:service.getCitiesForRegion(region.getId(), securityToken).getCity()){
					List<Service> services = service.getServicesForCity(city.getId(), securityToken).getService();
					cities.put(city, services);
				}
				eripPayments.put(region, cities);
			}
			 
		} catch (IInternetBankingServiceGetAllLegalPersonCategoriesAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllLegalPersonCategoriesDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetLegalPersonsForCategoryAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetLegalPersonsForCategoryDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCitiesForRegionAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCitiesForRegionDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetServicesForCityAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetServicesForCityDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("tree", categories);
		model.addAttribute("eripTree", eripPayments);
		model.addAttribute("auto", true);
		return VIEW_NAME_LIST;
	}
	
	@RequestMapping(method=RequestMethod.GET, params={"type","id"})
	public String createForm(HttpSession session, @RequestParam("type") String type, @RequestParam("id") Integer id){
		String securityToken = getSecurityToken(session);
		try{
		if(type.equals("payment")){
			//create regular payment
			LegalPerson payment = PaymentUtil.getLegalPersonById(id, securityToken);
			
			AutoPaymentWrapper wrapper = new AutoPaymentWrapper();
		}else if(type.equals("erip")){
			//create erip payment
		}
		} catch (IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
			
		
		
		return VIEW_NAME;
	}
}
