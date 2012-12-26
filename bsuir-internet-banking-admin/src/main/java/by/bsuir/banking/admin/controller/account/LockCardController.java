package by.bsuir.banking.admin.controller.account;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import by.bsuir.banking.admin.domain.SecretWordWrapper;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForOperatorAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForOperatorDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceLockCardDomainFaultFaultFaultMessage;

@Controller
@RequestMapping("/account/{clientId}/card/{accountId}/lock/{cardId}")
@SessionAttributes("secretWord")
public class LockCardController extends EntityController{
	private static IInternetBankingService service;
	private static String VIEW_NAME="lock-unlock-card";
	
	public LockCardController(){
		service = ServiceProvider.getInternetBankingInstance();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String createForm(HttpSession session, @PathVariable("clientId") Integer clientId,
			@PathVariable("accountId") Integer accountId, @PathVariable("cardId") Integer cardId,
			RedirectAttributes attrs, Model model){
		String securityToken = getSecurityToken(session);
		try {
			Card card = service.getCardForOperator(cardId, securityToken);
			AccountCardWrapper wrapper = new AccountCardWrapper();
			wrapper.setCard(card);
			if(wrapper.isExpired()){
				attrs.addFlashAttribute("error", "Card has expired. All operations are forbidden.");
				return "redirect:/account/"+clientId+"/view/"+accountId;
			}
			if(wrapper.isLocked()){
				attrs.addFlashAttribute("error", "Card is already locked");
				return "redirect:/account/"+clientId+"/view/"+accountId;
			}
			SecretWordWrapper secretWord = new SecretWordWrapper();
			model.addAttribute("secretWord", secretWord);
		} catch (IInternetBankingServiceGetCardForOperatorAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetCardForOperatorDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		
		return VIEW_NAME;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitForm(HttpSession session, @PathVariable("clientId") Integer clientId,
			@PathVariable("accountId") Integer accountId, @PathVariable("cardId") Integer cardId,
			RedirectAttributes attrs, Model model, @Valid @ModelAttribute("secretWord") SecretWordWrapper secretWord, BindingResult result){
		if(result.hasErrors()){
			return VIEW_NAME;
		}
		String securityToken = getSecurityToken(session);
		try {
			Card card = service.getCardForOperator(cardId, securityToken);
			AccountCardWrapper wrapper = new AccountCardWrapper();
			wrapper.setCard(card);
			if(!wrapper.getSecretWord().equals(secretWord.getSecretWord())){
				result.reject("lockError", "Secret word is wrong");
				return VIEW_NAME;
			}
			service.lockCard(wrapper.getCardNumber(), secretWord.getSecretWord());
		} catch (IInternetBankingServiceGetCardForOperatorAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetCardForOperatorDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceLockCardDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		
		attrs.addAttribute("success", "Card was locked. Now all operations with this card are forbidden");
		return "redirect:/account/"+clientId+"/view/"+accountId;
	}
}
