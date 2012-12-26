  package by.bsuir.banking.controller.history;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.bsuir.banking.admin.utils.InformationParser;
import by.bsuir.banking.admin.utils.PaymentUtil;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.EripWrapper;
import by.bsuir.banking.domain.LegalPersonWrapper;
import by.bsuir.banking.domain.PaymentHistoryWrapper;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCitiesForRegionAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCitiesForRegionDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetPeriodPaymentsForCardAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetPeriodPaymentsForCardDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetServicesForCityAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetServicesForCityDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.Payment;

/**
 * Controller for viewing operations history
 * @author Katherine
 *
 */
@Controller
@RequestMapping("/history/payment")
@SessionAttributes("cardSelect") 
public class ViewPaymentHistoryController  extends EntityController{ 

	private static final String VIEW_NAME = "history-payment";
	private IInternetBankingService service;
	
	public ViewPaymentHistoryController(){
		service = ServiceProvider.getInternetBankingService();
	}
	
	@RequestMapping
	public String paymentsHistory(HttpSession session, Model model){
		String securityToken = getSecurityToken(session);
		try {
			List<Card> cards = service.getCards(securityToken).getCard();
		
		GregorianCalendar calendarEnd = new GregorianCalendar();
		calendarEnd.setTime(new Date());
		XMLGregorianCalendar xmlEnd = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendarEnd);
		GregorianCalendar calendarStart = new GregorianCalendar();
		calendarStart.setTime(new Date());
		calendarStart.add(Calendar.MONTH, -3);
		XMLGregorianCalendar xmlStart = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendarStart);
		List<PaymentHistoryWrapper> payments = new ArrayList<PaymentHistoryWrapper>();
		for(Card card:cards){
			CardWrapper cardWrapper = new CardWrapper(card);
			for(Payment payment:service.getPeriodPaymentsForCard(cardWrapper.getCardId(), xmlStart, xmlEnd, securityToken).getPayment()){
				PaymentHistoryWrapper wrapper = new PaymentHistoryWrapper(payment);
				wrapper.setCardNumber(cardWrapper.getHiddenNumber());
				if(wrapper.getLegalAccountId() == 1){
					//erip
					Integer eripId = InformationParser.getEripIdFromInformation(wrapper.getInformation());
					EripWrapper erip = PaymentUtil.getServiceById(eripId, securityToken);
					wrapper.setErip(erip);
				}
				else{
					//regular
					LegalPersonWrapper legal = PaymentUtil.getLegalPersonByAccountId(wrapper.getLegalAccountId(), securityToken);
					wrapper.setLegalPerson(legal);
				}
				payments.add(wrapper);
			}
		}
		Collections.sort(payments);
		Collections.reverse(payments);
		model.addAttribute("payments",payments);
		} catch (IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetPeriodPaymentsForCardAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetPeriodPaymentsForCardDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
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
