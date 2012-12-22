package by.bsuir.banking.controller.payment.auto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.bsuir.banking.admin.utils.CardUtil;
import by.bsuir.banking.admin.utils.InformationParser;
import by.bsuir.banking.admin.utils.MessageConstants;
import by.bsuir.banking.admin.utils.PaymentUtil;
import by.bsuir.banking.admin.utils.ServiceProvider;
import by.bsuir.banking.controller.login.EntityController;
import by.bsuir.banking.domain.AutoPaymentInfo;
import by.bsuir.banking.domain.CardSelectInfo;
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.ClientWrapper;
import by.bsuir.banking.domain.EripWrapper;
import by.bsuir.banking.domain.LegalPersonWrapper;
import by.bsuir.banking.domain.MoneyWrapper;
import by.bsuir.banking.domain.SavedPaymentWrapper;
import by.bsuir.banking.proxy.internetbanking.AutoPayment;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.City;
import by.bsuir.banking.proxy.internetbanking.Client;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceCreateAutoPaymentAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceCreateAutoPaymentDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonCategoriesAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonCategoriesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllSavedPaymentsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllSavedPaymentsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetBallanceDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCitiesForRegionAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCitiesForRegionDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetClientDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetLegalPersonsForCategoryAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetLegalPersonsForCategoryDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetServicesForCityAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetServicesForCityDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.LegalPerson;
import by.bsuir.banking.proxy.internetbanking.LegalPersonCategory;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;
import by.bsuir.banking.proxy.internetbanking.Region;
import by.bsuir.banking.proxy.internetbanking.Service;

@Controller
@RequestMapping("/autopayment/create")
@SessionAttributes({ "payment", "cardList", "cardSelect", "days" })
public class CreateAutoPaymentController extends EntityController {
	private static final String VIEW_NAME_CHECK = "autopayment-check";
	private static String VIEW_NAME = "autopayment-create";
	private static String VIEW_NAME_LIST = "payment-list";
	private static IInternetBankingService service;

	public CreateAutoPaymentController() {
		service = ServiceProvider.getInternetBankingService();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String createTree(HttpSession session, Model model) {
		String securityToken = getSecurityToken(session);
		Map<LegalPersonCategory, List<LegalPerson>> categories = new HashMap<LegalPersonCategory, List<LegalPerson>>();
		Map<Region, Map<City, List<Service>>> eripPayments = new HashMap<Region, Map<City, List<Service>>>();

		try {
			// regular payments
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

			// erip payments
			for (Region region : service.getAllRegions(securityToken)
					.getRegion()) {
				Map<City, List<Service>> cities = new HashMap<City, List<Service>>();
				for (City city : service.getCitiesForRegion(region.getId(),
						securityToken).getCity()) {
					List<Service> services = service.getServicesForCity(
							city.getId(), securityToken).getService();
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

	@RequestMapping(method = RequestMethod.GET, params = { "type", "id" })
	public String createForm(HttpSession session,
			@RequestParam("type") String type, @RequestParam("id") Integer id,
			Model model) {
		String securityToken = getSecurityToken(session);
		try {
			Client client = service.getClient(securityToken);
			List<CardWrapper> cards = new ArrayList<CardWrapper>();
			List<MoneyWrapper> ballance = new ArrayList<MoneyWrapper>();
			List<CardSelectInfo> cardSelect = new ArrayList<CardSelectInfo>();
			for (Card card : service.getCards(securityToken).getCard()) {
				CardWrapper cardWrapper = new CardWrapper(card);
				cards.add(cardWrapper);
				MoneyWrapper cardsBallance = new MoneyWrapper(
						service.getBallance(cardWrapper.getCardId(),
								securityToken));
				ballance.add(cardsBallance);
				cardSelect.add(new CardSelectInfo(cardWrapper, cardsBallance));
			}
			List<Integer> daysOfMonth = new ArrayList<Integer>();
			for (int i = 1; i < 29; i++) {
				daysOfMonth.add(i);
			}
			AutoPaymentInfo wrapper = null;
			if (type.equals("payment")) {
				// create regular payment
				LegalPerson lp = PaymentUtil.getLegalPersonById(id,
						securityToken);
				LegalPersonWrapper lpWrapper = new LegalPersonWrapper(lp);

				wrapper = new AutoPaymentInfo(new ClientWrapper(client),
						lpWrapper);

			} else if (type.equals("erip")) {
				// create erip payment
				EripWrapper erip = PaymentUtil
						.getServiceById(id, securityToken);
				
				erip.setCity(PaymentUtil.getCityById(erip.getCityId(),
						securityToken));
				erip.setRegion(PaymentUtil.getRegionById(erip.getCity()
						.getRegionId(), securityToken));
				wrapper = new AutoPaymentInfo(new ClientWrapper(client), erip);
				//ищем платеж среди сохраненных
				Integer savedId = PaymentUtil.getEripSavedId(id, securityToken);
				if (savedId != null) {
					SavedPaymentWrapper savedPayment = PaymentUtil
							.getEripSavedPaymentById(savedId, securityToken);
					//getting cardNumber information from saved payment
					CardWrapper card = CardUtil.getCardByAccountId(savedPayment.getAccountId(),
									securityToken);
					wrapper.setCardNumber(card.getCardNumber());
					wrapper.setInfoString(InformationParser.getInfoString(savedPayment.getInformation()));
					wrapper.setAmount(savedPayment.getAmount());
					wrapper.setSavedId(savedId);
				}
			}
			model.addAttribute("payment", wrapper);
			model.addAttribute("cardList", cards);
			model.addAttribute("cardSelect", cardSelect);
			model.addAttribute("days", daysOfMonth);
		} catch (IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetClientDomainFaultFaultFaultMessage e) {
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
		} catch (IInternetBankingServiceGetAllSavedPaymentsAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllSavedPaymentsDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return VIEW_NAME;
	}

	@RequestMapping(method = RequestMethod.GET, params = { "type", "savedId" })
	public String createFormSaved(HttpSession session,
			@RequestParam("type") String type, @RequestParam("savedId") Integer savedId,
			Model model){
		String securityToken = getSecurityToken(session);
		try {
			Client client = service.getClient(securityToken);
			List<CardWrapper> cards = new ArrayList<CardWrapper>();
			List<MoneyWrapper> ballance = new ArrayList<MoneyWrapper>();
			List<CardSelectInfo> cardSelect = new ArrayList<CardSelectInfo>();
			for (Card card : service.getCards(securityToken).getCard()) {
				CardWrapper cardWrapper = new CardWrapper(card);
				cards.add(cardWrapper);
				MoneyWrapper cardsBallance = new MoneyWrapper(
						service.getBallance(cardWrapper.getCardId(),
								securityToken));
				ballance.add(cardsBallance);
				cardSelect.add(new CardSelectInfo(cardWrapper, cardsBallance));
			}
			List<Integer> daysOfMonth = new ArrayList<Integer>();
			for (int i = 1; i < 29; i++) {
				daysOfMonth.add(i);
			}
			AutoPaymentInfo wrapper = null;
			if (type.equals("payment")) {
				// create regular payment
				SavedPaymentWrapper spWrapper = PaymentUtil.getSavedPaymentById(savedId, securityToken);
				System.out.println("!!!!!!!!!!!!!!!!!!!!" + spWrapper.getLegalPersonId());
				LegalPersonWrapper lpWrapper =PaymentUtil.getLegalPersonByAccountId(spWrapper.getLegalAccountId(), securityToken);
				wrapper = new AutoPaymentInfo(new ClientWrapper(client),
						lpWrapper);
				wrapper.setAmount(spWrapper.getAmount());
				wrapper.setCardNumber(spWrapper.getCardNumber());
				wrapper.setInfoString(InformationParser.getInfoString(spWrapper.getInformation()));
				wrapper.setSavedId(savedId);
			} else if (type.equals("erip")) {
				//it should not be erip
			}
			model.addAttribute("payment", wrapper);
			model.addAttribute("cardList", cards);
			model.addAttribute("cardSelect", cardSelect);
			model.addAttribute("days", daysOfMonth);
		} catch (IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.ERROR_VIEW;
		} catch (IInternetBankingServiceGetClientAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetClientDomainFaultFaultFaultMessage e) {
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
		} catch (IInternetBankingServiceGetAllSavedPaymentsAuthorizationFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IInternetBankingServiceGetAllSavedPaymentsDomainFaultFaultFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return VIEW_NAME;

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String validateForm(HttpSession session,
			@Valid @ModelAttribute("payment") AutoPaymentInfo payment,
			BindingResult result, RedirectAttributes attrs,
			@ModelAttribute("cardSelect") List<CardSelectInfo> cardSelect,
			Model model) {
		if (result.hasErrors()) {
			return VIEW_NAME;
		} else {
			payment.getAmount().setAmount(
					BigDecimal.valueOf(Double.valueOf(payment.getAmount()
							.getEnteredAmount().replace(',', '.'))));
		}

		if (session.getAttribute("cardSelect") == null) {
			attrs.addFlashAttribute("error", "Невозможно найти список карт");
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}

		for (CardSelectInfo card : cardSelect) {
			if (card.getCardNumber().equals(payment.getCardNumber())) {
				payment.setDisplayCard(card.getDisplayValue());
				if (card.isExpired()) {
					result.reject("paymentError",
							"Карта недействительна. Выберите другую карту или обратитесь к оператору");
					return VIEW_NAME;
				}
				if (card.isLocked()) {
					result.reject(
							"paymentError",
							"Карта заблокированна. Разблокируйте карту, выберите другую или обратитесь к оператору");
					return VIEW_NAME;
				}
			}
		}

		attrs.addFlashAttribute("cardSelect", cardSelect);
		attrs.addFlashAttribute("payment", payment);

		return "redirect:/autopayment/create/check";
	}

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String craeteCheck(HttpSession session, Model model,
			RedirectAttributes attrs) {
		if (!model.containsAttribute("payment")) {
			attrs.addFlashAttribute("error", "Вы еще не заполнили форму");
			return "redirect:/autopayment/create";
		}

		return VIEW_NAME_CHECK;
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String submitCheck(
			@Valid @ModelAttribute("payment") AutoPaymentInfo payment,
			BindingResult result, HttpSession session,
			RedirectAttributes attrs,
			@ModelAttribute("cardSelect") List<CardSelectInfo> cardSelect) {

		String securityToken = getSecurityToken(session);
		AutoPayment autoPayment = new AutoPayment();
		ObjectFactory factory = new ObjectFactory();
		Integer accountId = 0;
		for (CardSelectInfo card : cardSelect) {
			if (card.getCardNumber().equals(payment.getCardNumber())) {
				accountId = card.getCardWrapper().getCardsAccountId();
				// set currency type for amount
				/*
				 * List<CurrencyTypeWrapper> currrencies = CardUtil
				 * .getCurrencyTypes(); for (CurrencyTypeWrapper cur :
				 * currrencies) { if (cur.getShortName().equalsIgnoreCase(
				 * payment.getAmount().getCurrencyType())) {
				 * payment.getAmount().setCurrencyTypeId(
				 * cur.getCurrencyType().getId()); } }
				 */
				payment.getAmount().setCurrencyTypeId(1);
			}
		}
		// setting autopayment fields
		autoPayment.setAccountId(accountId);
		autoPayment.setDayOfMonth(payment.getDayOfMonth());
		autoPayment.setMoney(factory.createAutoPaymentMoney(payment.getAmount().getMoney()));
		if (payment.getLegalPerson() != null) {
			autoPayment.setInformation(factory.createAutoPaymentInformation(PaymentUtil.formInformation(payment)));
			autoPayment.setLegalAccountId(payment.getLegalPerson().getAccount().getId());
			
		}else if(payment.getErip() != null){
			autoPayment.setInformation(factory.createAutoPaymentInformation(PaymentUtil.formInformationErip(payment)));
			autoPayment.setLegalAccountId(payment.getErip().getAccountId());
		}
		try {
			service.createAutoPayment(autoPayment, securityToken);
		} catch (IInternetBankingServiceCreateAutoPaymentAuthorizationFaultFaultFaultMessage e) {
			return "redirect:" + MessageConstants.AUTH_FAILED_VIEW;
		} catch (IInternetBankingServiceCreateAutoPaymentDomainFaultFaultFaultMessage e) {
			attrs.addFlashAttribute("error", "Автоплатеж не может быть создан");
			return "redirect:" + MessageConstants.ERROR_VIEW;
		}

		attrs.addFlashAttribute("success", "Автоплатеж был успешно создан");
		return "redirect:/main";
	}
}
