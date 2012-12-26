package by.bsuir.banking.admin.controller.account;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import by.bsuir.banking.admin.domain.MoneyWrapper;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.admin.validation.MoneyValidator;
import by.bsuir.banking.proxy.internetbanking.Account;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountByIdAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAccountByIdDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForAccountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForAccountDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceReplenishAccountAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceReplenishAccountDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.Money;

@Controller
@RequestMapping("/account/{clientId}/replenish/{accountId}")
@SessionAttributes("amount")
public class ReplenishAccountController extends EntityController {
	private static String VIEW_NAME = "account-replenish";
	private IInternetBankingService service;
	@Autowired
	private MoneyValidator moneyValidator;

	public ReplenishAccountController() {
		service = ServiceProvider.getInternetBankingInstance();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String createForm(HttpSession session, RedirectAttributes attrs,
			@PathVariable("clientId") Integer clientId,
			@PathVariable("accountId") Integer accountId, Model model) {
		String securityToken = getSecurityToken(session);
		try {
			Card card = service.getCardForAccount(accountId, securityToken);
			AccountCardWrapper wrapper = new AccountCardWrapper();
			wrapper.setCard(card);
			if (card == null) {
				attrs.addFlashAttribute("error",
						"Account has no card. Create card first");
				return "redirect:/account/" + clientId + "/view/" + accountId;
			}
			if (wrapper.isExpired()) {
				attrs.addFlashAttribute("error",
						"Card has expired. All operations are forbidden");
				return "redirect:/account/" + clientId + "/view/" + accountId;
			}
			if (wrapper.isLocked()) {
				attrs.addFlashAttribute("error",
						"Card is locked. All operations are forbidden. Unlock it first");
				return "redirect:/account/" + clientId + "/view/" + accountId;
			}
			MoneyWrapper amount = new MoneyWrapper(new Money());
			Account account = service.getAccountById(accountId, securityToken);
			amount.setCurrencyTypeId(account.getCurrencyTypeId());
			amount.setCurrencyType(account.getCurrencyType().getValue()
					.getShortName().getValue());
			model.addAttribute("amount", amount);
		} catch (IInternetBankingServiceGetCardForAccountAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetCardForAccountDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetAccountByIdAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAccountByIdDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}

		return VIEW_NAME;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpSession session, RedirectAttributes attrs,
			@PathVariable("clientId") Integer clientId,
			@PathVariable("accountId") Integer accountId, Model model,
			@Valid @ModelAttribute("amount") MoneyWrapper amount,
			BindingResult result) {
		moneyValidator.validate(amount, result);
		if (result.hasErrors()) {
			return VIEW_NAME;
		}
		amount.setAmount(BigDecimal.valueOf(Double.valueOf(amount.getEnteredAmount().trim())));
		try {
			service.replenishAccount(accountId, amount.getMoney(), getSecurityToken(session));
		} catch (IInternetBankingServiceReplenishAccountAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceReplenishAccountDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		attrs.addFlashAttribute("success",
				"Account was successfully replenished.");
		return "redirect:/account/" + clientId + "/view/" + accountId;
	}
}
