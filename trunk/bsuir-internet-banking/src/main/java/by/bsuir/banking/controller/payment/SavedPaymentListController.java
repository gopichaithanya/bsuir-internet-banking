package by.bsuir.banking.controller.payment;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.admin.utils.CardUtil;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.PaymentUtil;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.LegalPersonWrapper;
import by.bsuir.banking.domain.SavedPaymentWrapper;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountByIdAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountByIdDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllSavedPaymentsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllSavedPaymentsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.LegalPerson;
import by.bsuir.banking.proxy.internetbanking.SavedPayment;

/**
 * 
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/payment/saved/list")

public class SavedPaymentListController extends EntityController {

	private static Logger logger = Logger.getLogger(SavedPaymentListController.class);
	private static final String VIEW_NAME = "savedpayment-list";
	private static IInternetBankingService service;
	
	public SavedPaymentListController() {
		service = ServiceProvider.getInternetBankingService();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String createList(HttpSession session, Model model){
		String securityToken = getSecurityToken(session);
		List<SavedPaymentWrapper> savedPayments = new ArrayList<SavedPaymentWrapper>();
		try {
			for(SavedPayment sp:service.getAllSavedPayments(securityToken).getSavedPayment()){
				SavedPaymentWrapper wrapper = new SavedPaymentWrapper(sp);
				wrapper.getAmount().setCurrencyType(CardUtil.getCurrencyTypeById(wrapper.getAmount().getCurrencyTypeId()).getShortName());
				wrapper.setCardNumber(CardUtil.changeCardNumber(CardUtil.getCardByAccountId(sp.getAccountId(), securityToken).getCardNumber()));
				LegalPersonWrapper person = PaymentUtil.getLegalPersonByAccountId(sp.getLegalAccountId(), securityToken);
				wrapper.setLegalPersonName(person.getName());
				wrapper.setLegalPersonId(person.getId());
				savedPayments.add(wrapper);
			}
			model.addAttribute("savedpayments",savedPayments);
		} catch (IInternetBankingServiceGetAllSavedPaymentsAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAllSavedPaymentsDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return VIEW_NAME;
	}
}
