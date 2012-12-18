package by.bsuir.banking.admin.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.bsuir.banking.domain.EripWrapper;
import by.bsuir.banking.domain.LegalPersonWrapper;
import by.bsuir.banking.domain.PaymentInfo;
import by.bsuir.banking.domain.SavedPaymentWrapper;
import by.bsuir.banking.proxy.internetbanking.City;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllSavedPaymentsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllSavedPaymentsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCitiesForRegionAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCitiesForRegionDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetServicesForCityAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetServicesForCityDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.LegalPerson;
import by.bsuir.banking.proxy.internetbanking.Region;
import by.bsuir.banking.proxy.internetbanking.SavedPayment;
import by.bsuir.banking.proxy.internetbanking.Service;

public class PaymentUtil {
	private static IInternetBankingService service = ServiceProvider
			.getInternetBankingService();
	private static List<LegalPerson> persons;
	private static Map<Integer, String> categoryLabels;
	private static Map<Integer, String> eripLabels;
	private static List<LegalPersonWrapper> allLegalPersons;
	private static List<EripWrapper> allEripPayments;
	private static List<City> allCities;
	private static List<Region> allRegions;
	private static List<SavedPaymentWrapper> allSavedPayments;

	private static List<LegalPerson> getPersons(String securityToken)
			throws IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage {
		persons = service.getAllLegalPersons(securityToken).getLegalPerson();

		fillCategoryLabels(persons);
		return persons;
	}

	private static void fillCategoryLabels(List<LegalPerson> persons2) {
		categoryLabels = new HashMap<Integer, String>();
		for (LegalPerson person : persons2) {
			String label = "";
			switch (person.getLegalPersonCategoryId()) {
			case 5:
				label = "Номер договора. Не менее 6 цифр";
				break;
			case 2:
				label = "Номер телефона. В формате yyyxxxxxxx, где y - код";
				break;
			case 3:
				label = "Номер контракта. Не менее 8 цифр";
				break;
			case 4:
				label = "Номер заказа билета. Не менее 6 цифр";
				break;
			case 6:
				label = "Номер телефона. В формате yyyxxxxx, где y - код";
				break;
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
				label = "Лицевой счет";
				break;
			default:
				break;
			}
			categoryLabels.put(person.getLegalPersonCategoryId(), label);
		}

	}

	public static String getLabelForCategory(Integer categoryId) {
		return categoryLabels.get(categoryId);
	}

	public static LegalPerson getLegalPersonById(Integer id,
			String securityToken)
			throws IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage {
		for (LegalPerson person : getPersons(securityToken)) {
			if (person.getId().equals(id)) {
				return person;
			}
		}
		return null;
	}

	public static String formInformation(PaymentInfo payment) {
		String info = payment.getInfoLabel() + ":" + payment.getInfoString();
		return info;
	}

	public static List<LegalPersonWrapper> getAllLegalPersons(
			String securityToken)
			throws IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage {
		allLegalPersons = new ArrayList<LegalPersonWrapper>();
		for (LegalPerson person : service.getAllLegalPersons(securityToken)
				.getLegalPerson()) {
			allLegalPersons.add(new LegalPersonWrapper(person));
		}
		return allLegalPersons;
	}

	public static LegalPersonWrapper getLegalPersonByAccountId(Integer id,
			String securityToken)
			throws IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage {
		for (LegalPersonWrapper person : getAllLegalPersons(securityToken)) {
			if (person.getAccount().getId() == id) {
				return person;
			}
		}
		return null;
	}

	public static List<EripWrapper> getAllEripPayments(String securityToken)
			throws IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage,
			IInternetBankingServiceGetCitiesForRegionAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetCitiesForRegionDomainFaultFaultFaultMessage,
			IInternetBankingServiceGetServicesForCityAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetServicesForCityDomainFaultFaultFaultMessage {
		allEripPayments = new ArrayList<EripWrapper>();
		for (Region region : service.getAllRegions(securityToken).getRegion()) {
			for (City city : service.getCitiesForRegion(region.getId(),
					securityToken).getCity()) {
				for (Service erip : service.getServicesForCity(city.getId(),
						securityToken).getService()) {
					allEripPayments.add(new EripWrapper(erip));
				}
			}
		}
		fillEripLabels(allEripPayments);
		return allEripPayments;
	}

	public static List<City> getAllCities(String securityToken)
			throws IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage,
			IInternetBankingServiceGetCitiesForRegionAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetCitiesForRegionDomainFaultFaultFaultMessage {
		allCities = new ArrayList<City>();
		for (Region region : service.getAllRegions(securityToken).getRegion()) {
			allCities.addAll(service.getCitiesForRegion(region.getId(),
					securityToken).getCity());
		}
		return allCities;
	}

	public static City getCityById(Integer id, String securityToken)
			throws IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage,
			IInternetBankingServiceGetCitiesForRegionAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetCitiesForRegionDomainFaultFaultFaultMessage {
		for (City city : getAllCities(securityToken)) {
			if (city.getId() == id) {
				return city;
			}
		}
		return null;
	}

	public static List<Region> getAllRegions(String securityToken)
			throws IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage {
		allRegions = new ArrayList<Region>();
		allRegions.addAll(service.getAllRegions(securityToken).getRegion());
		return allRegions;
	}

	public static Region getRegionById(Integer id, String securityToken)
			throws IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage {
		for (Region region : getAllRegions(securityToken)) {
			if (region.getId() == id) {
				return region;
			}
		}
		return null;
	}

	private static void fillEripLabels(List<EripWrapper> allEripPayments2) {
		eripLabels = new HashMap<Integer, String>();
		for (EripWrapper erip : allEripPayments2) {
			String label = "";
			switch (erip.getId()) {
			case 4:
				label = "Номер договора";
				break;
			case 1:
			case 2:
			case 3:
			case 5:
			case 6:
				label = "Номер телефона";
				break;
			case 7:
				label = "Номер контракта";
				break;
			case 8:
				label = "Номер заказа билета";
				break;
			case 9:
				label = "Номер телефона";
				break;
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
				label = "Лицевой счет";
				break;
			default:
				break;
			}
			eripLabels.put(erip.getId(), label);
		}

	}

	public static EripWrapper getServiceById(Integer id, String securityToken)
			throws IInternetBankingServiceGetAllRegionsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllRegionsDomainFaultFaultFaultMessage,
			IInternetBankingServiceGetCitiesForRegionAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetCitiesForRegionDomainFaultFaultFaultMessage,
			IInternetBankingServiceGetServicesForCityAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetServicesForCityDomainFaultFaultFaultMessage {
		for (EripWrapper erip : getAllEripPayments(securityToken)) {
			if (erip.getId() == id) {
				return erip;
			}
		}
		return null;
	}

	public static String getLabelForErip(Integer integer) {
		return eripLabels.get(integer);
	}

	public static String formInformationErip(PaymentInfo payment) {
		String info = payment.getErip().getRegion().getName().getValue() + ","
				+ payment.getErip().getCity().getName().getValue() + ","
				+ payment.getErip().getName() + "," + payment.getInfoLabel()
				+ ":" + payment.getInfoString();
		return info;
	}

	public static List<SavedPaymentWrapper> getAllSavedPayments(
			String securityToken)
			throws IInternetBankingServiceGetAllSavedPaymentsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllSavedPaymentsDomainFaultFaultFaultMessage {
		allSavedPayments = new ArrayList<SavedPaymentWrapper>();
		for (SavedPayment payment : service.getAllSavedPayments(securityToken)
				.getSavedPayment()) {
			// excluding ERIP accounts
			if (payment.getLegalAccountId() != 1) {
				allSavedPayments.add(new SavedPaymentWrapper(payment));
			}
		}
		return allSavedPayments;
	}

	public static SavedPaymentWrapper getSavedPaymentById(Integer id,
			String securityToken)
			throws IInternetBankingServiceGetAllSavedPaymentsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllSavedPaymentsDomainFaultFaultFaultMessage {
		for (SavedPaymentWrapper payment : getAllSavedPayments(securityToken)) {
			if (payment.getId() == id) {
				return payment;
			}
		}
		return null;
	}

}
