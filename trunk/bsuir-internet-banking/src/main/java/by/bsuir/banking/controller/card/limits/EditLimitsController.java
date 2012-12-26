 package by.bsuir.banking.controller.card.limits;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
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

import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.CardSelectInfo;
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.LimitsWrapper;
import by.bsuir.banking.domain.MoneyWrapper;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardForClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceSetAmountLimitAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceSetAmountLimitDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceSetOperationLimitAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceSetOperationLimitDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.Money;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;
import by.bsuir.banking.validator.LimitsValidator;
 
@Controller
@RequestMapping("card/{cardId}/limits/set")
@SessionAttributes({ "limits", "info" })
public class EditLimitsController extends EntityController {
	private static Logger logger = Logger.getLogger(EditLimitsController.class);
	private static IInternetBankingService service;
	private final static String VIEW_NAME = "limits-set";
	@Autowired
	private LimitsValidator limitsValidator; 

	public EditLimitsController() {
		service = ServiceProvider.getInternetBankingService();
	}

	/**
	 * @param session
	 * @param cardId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String createForm(HttpSession session,
			@PathVariable("cardId") Integer cardId, Model model) {
		String securityToken = getSecurityToken(session);
		try {
			Card card = service.getCardForClient(cardId, securityToken);
			Money ballance = service.getBallance(cardId, securityToken);
			MoneyWrapper moneyWrapper = new MoneyWrapper(ballance);
			CardSelectInfo cardinfo = new CardSelectInfo(new CardWrapper(card),
					moneyWrapper);
			LimitsWrapper limits = new LimitsWrapper();
			limits.setMoneyLimit(card.getMoneyLimit());
			limits.setOperationsLimit(card.getOperationsLimit());
			limits.setCurrencyTypeId(moneyWrapper.getCurrencyTypeId());
			model.addAttribute("limits", limits);
			model.addAttribute("info", cardinfo);
		} catch (IInternetBankingServiceGetCardForClientAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetCardForClientDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		return VIEW_NAME;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(HttpSession session,
			@PathVariable("cardId") Integer cardId,
			@Valid @ModelAttribute("limits") LimitsWrapper limits,
			BindingResult result, RedirectAttributes attrs) {
		String securityToken = getSecurityToken(session);
		limitsValidator.validate(limits, result);
		if (result.hasErrors()) {
			return VIEW_NAME;
		}
		limits.setMoneyLimit(BigDecimal.valueOf(Double.valueOf(limits.getEnteredMoneyLimit().trim())));
		limits.setOperationsLimit(Integer.valueOf(limits.getEnteredOperationsLimit().trim()));
		try {
			Card card = service.getCardForClient(cardId, securityToken);
			CardWrapper wrapper = new CardWrapper(card);
			Money ballance = service.getBallance(cardId, securityToken);
			
			if (!wrapper.getSecretWord().equals(limits.getSecretWord())) {
				result.reject("LimitsError",
						"Вы ввели неправильное секретное слово");
				return VIEW_NAME;
			}
			if (limits.getMoneyLimit().compareTo(card.getMoneyLimit()) != 0) {
				Money money = new ObjectFactory().createMoney();
				money.setAmount(limits.getMoneyLimit());
				money.setCurrencyTypeId(ballance.getCurrencyTypeId());
				service.setAmountLimit(cardId, money, limits.getSecretWord(),
						securityToken);
			}
			if (limits.getOperationsLimit() != card.getOperationsLimit()) {
				service.setOperationLimit(cardId, limits.getOperationsLimit(),
						limits.getSecretWord(), securityToken);
			}
		} catch (IInternetBankingServiceGetCardForClientAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetCardForClientDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceSetAmountLimitAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceSetAmountLimitDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceSetOperationLimitAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceSetOperationLimitDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}
		attrs.addFlashAttribute("success", "Лимиты были успешно обновлены");
		return "redirect:/card/" + cardId + "/view";
	}

}
