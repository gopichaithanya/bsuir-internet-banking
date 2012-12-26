package by.bsuir.banking.admin.controller.account;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.controller.EntityController;
import by.bsuir.banking.admin.domain.AccountCardWrapper;
import by.bsuir.banking.admin.domain.CardTypeWrapper;
import by.bsuir.banking.admin.domain.ClientWrapper;
import by.bsuir.banking.admin.utils.CardUtil;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.NumberGenerator;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.internetbanking.Account;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceCreateCardAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceCreateCardDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountByIdAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountByIdDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllCardTypesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForAccountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForAccountDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;
import by.bsuir.banking.proxy.operator.Client;
import by.bsuir.banking.proxy.operator.IOperatorService;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.IOperatorServiceGetClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.operator.OperatorService;

/**
 * Controller for creating card for account
 * (for example when the card is expired)
 * @author E.Krasnotschek
 *
 */
@Controller
@RequestMapping("/account/{clientId}/card/{accountId}/create")
@SessionAttributes({ "account_card", "cardTypes", "client" })
public class CreateCardController extends EntityController {
	private static Logger logger = Logger.getLogger(ListAccountController.class);
	private static IInternetBankingService service;
	private static final String VIEW_NAME = "card-create"; 
	
	public CreateCardController(){
		service = ServiceProvider.getInternetBankingInstance();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String createForm(@PathVariable("accountId") Integer accountId, HttpSession session,RedirectAttributes attrs,
			Model model, @PathVariable("clientId") Integer clientId){
		//get account to see if it already has a card
		String securityToken = getSecurityToken(session);
		try {
			Account account = service.getAccountById(accountId, securityToken);
			Card card = service.getCardForAccount(accountId, securityToken);
			if(card != null){
				//this account already has the card
				attrs.addFlashAttribute("error", "This account already has a card. Delete the card first.");
				return "redirect:account/"+clientId + "/view/"+accountId;
			}else{
				//createing empty card
				card = new ObjectFactory().createCard();
				AccountCardWrapper wrapper = new AccountCardWrapper(account, card);
				model.addAttribute("account_card", wrapper);
				model.addAttribute("cardTypes",
						CardUtil.getCardTypes(securityToken));
				IOperatorService operatorService = new OperatorService()
						.getBasicHttpBindingIOperatorService();
				Client client = operatorService.getClient(clientId, securityToken);
				model.addAttribute("client", new ClientWrapper(client));
			}
		} catch (IInternetBankingServiceGetAccountByIdAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAccountByIdDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardForAccountAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetCardForAccountDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllCardTypesDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOperatorServiceGetClientAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOperatorServiceGetClientDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return VIEW_NAME;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitForm(@PathVariable("accountId") Integer accountId, HttpSession session,RedirectAttributes attrs,
			Model model, @PathVariable("clientId") Integer clientId, @Valid @ModelAttribute("account_card") AccountCardWrapper wrapper,
			BindingResult result){
		if(result.hasErrors()){
			return VIEW_NAME;
		}
		String securityToken = getSecurityToken(session);
		try {
			
		wrapper.getCard().setAccountId(wrapper.getAccountId());
		CardTypeWrapper cardType = CardUtil.getCardType(
				wrapper.getCardTypeId(), securityToken);
		if (cardType != null) {
			String cardNumber = NumberGenerator.generateCardNumber(cardType.getName());
			wrapper.setCardNumber(cardNumber);
		}
		// TODO set expiration date
		wrapper.setExpirationDate(CardUtil.getExpirationDate());
		// TODO set money and operation limits based on card type
		wrapper.setOperationsLimit(CardUtil
				.getOperationsLimit(wrapper.getCurrencyTypeId()));
		wrapper.setMoneyLimit(CardUtil.getMoneyLimit(wrapper.getCurrencyTypeId()));
		wrapper.setCVV2(NumberGenerator.generateCVV2());
			service.createCard(wrapper.getCard(), securityToken);
		} catch (IInternetBankingServiceCreateCardAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceCreateCardDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAllCardTypesDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (DatatypeConfigurationException e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		attrs.addFlashAttribute("success", "Card was successfully created");
		return "redirect:/account/" +clientId + "/view/"+accountId;
		
	}
}
