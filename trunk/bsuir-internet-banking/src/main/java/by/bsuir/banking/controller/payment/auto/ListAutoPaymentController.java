package by.bsuir.banking.controller.payment.auto;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.banking.admin.utils.CardUtil;
import by.bsuir.banking.admin.utils.InformationParser;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.PaymentUtil;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.AutoPaymentInfo;
import by.bsuir.banking.domain.AutoPaymentWrapper;
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.ClientWrapper;
import by.bsuir.banking.domain.EripWrapper;
import by.bsuir.banking.domain.LegalPersonWrapper;
import by.bsuir.banking.proxy.internetbanking.AutoPayment;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.Client;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAutoPaymentsForClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAutoPaymentsForClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCitiesForRegionAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCitiesForRegionDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetServicesForCityAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetServicesForCityDomainFaultFaultFaultMessage;

@Controller
@RequestMapping("autopayment/list")
public class ListAutoPaymentController extends EntityController {
	private static String VIEW_NAME = "autopayment-list";
	private static IInternetBankingService service;

	public ListAutoPaymentController() {
		service = ServiceProvider.getInternetBankingService();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String createList(HttpSession session, Model model) {
		String securityToken = getSecurityToken(session);
		List<AutoPaymentWrapper> autoPayments = new ArrayList<AutoPaymentWrapper>();
		AutoPaymentWrapper wrapper = null;
		try {
			for (AutoPayment payment : service.getAutoPaymentsForClient(
					securityToken).getAutoPayment()) {
				wrapper = new AutoPaymentWrapper(payment);
				CardWrapper card = CardUtil.getCardByAccountId(
						wrapper.getAccountId(), securityToken);
				wrapper.setCardNumber(card.getHiddenNumber());
				
				if (payment.getLegalAccountId() == 1) {
					// erip payment
					Integer eripId = InformationParser.getEripIdFromInformation(wrapper.getInformation());
					EripWrapper erip = PaymentUtil.getServiceById(eripId, securityToken);
					wrapper.setErip(erip);
				} else {
					// regular payment
					LegalPersonWrapper lpWrapper = PaymentUtil.getLegalPersonByAccountId(wrapper.getLegalAccountId(), securityToken);
					wrapper.setLegalPerson(lpWrapper);
				}
				autoPayments.add(wrapper);
			}
			model.addAttribute("list", autoPayments);
		} catch (IInternetBankingServiceGetAutoPaymentsForClientAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAutoPaymentsForClientDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage e) {
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
		} catch (IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return VIEW_NAME;
	}
}
