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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.bsuir.banking.admin.utils.CardUtil;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.MoneyWrapper;
import by.bsuir.banking.domain.TransferHistoryWrapper;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetPeriodTransfersForCardAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetPeriodTransfersForCardDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.Transfer;


@Controller
@RequestMapping("/history/transfer")
@SessionAttributes("cardSelect")
public class ViewTransferHistoryController extends EntityController {
	private static final String VIEW_NAME = "history-transfer";
	private IInternetBankingService service;
	
	public ViewTransferHistoryController(){
		service = ServiceProvider.getInternetBankingService();
	} 
	
	@RequestMapping(method=RequestMethod.GET)
	public String createList(Model model, HttpSession session){
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
			List<TransferHistoryWrapper> transfers = new ArrayList<TransferHistoryWrapper>();
			for(Card card:cards){
				CardWrapper cardWrapper = new CardWrapper(card);
				for(Transfer transfer:service.getPeriodTransfersForCard(cardWrapper.getCardId(), xmlStart, xmlEnd, securityToken).getTransfer()){
					TransferHistoryWrapper wrapper = new TransferHistoryWrapper(transfer);
					wrapper.setSenderCardNumber(cardWrapper.getHiddenNumber());
					CardWrapper receiverCrd = CardUtil.getCardByAccountId(wrapper.getReceiverAccountId(), securityToken);
					wrapper.setReceiverCardNumber(receiverCrd.getHiddenNumber());
					MoneyWrapper balance = new MoneyWrapper(service.getBallance(cardWrapper.getCardId(), securityToken));
					wrapper.setCurrency(balance.getCurrencyType());
					transfers.add(wrapper);
					
				}
			}
			Collections.sort(transfers);
			Collections.reverse(transfers);
			model.addAttribute("transfers", transfers);
			
		} catch (IInternetBankingServiceGetPeriodTransfersForCardAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetPeriodTransfersForCardDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return VIEW_NAME;
	}
	
	
} 
