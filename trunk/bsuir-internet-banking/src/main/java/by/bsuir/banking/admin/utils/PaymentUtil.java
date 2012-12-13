package by.bsuir.banking.admin.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.LegalPerson;


public class PaymentUtil {
	private static IInternetBankingService service = ServiceProvider.getInternetBankingService();
	private static List<LegalPerson> persons;
	private static Map<Integer, String> categoryLabels;
	
	private static List<LegalPerson> getPersons(String securityToken) throws IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage, IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage{
		if(persons == null){
			persons = service.getAllLegalPersons(securityToken).getLegalPerson();
			
			fillCategoryLabels(persons);
		}
		return persons;
	}
	
	private static void fillCategoryLabels(List<LegalPerson> persons2) {
		categoryLabels = new HashMap<Integer, String>();
		for (LegalPerson person: persons2){
			String label = "";
			switch (person.getLegalPersonCategoryId()) {
			case 1:
				label = "����� ��������";
				break;
			case 2:
				label = "����� ��������";
				break;
			case 3:
				label = "����� ���������";
				break;
			case 4:
				label = "����� ������ ������"; 
			case 5:
				label = "����� ��������";
				break;
			case 6: case 7: case 8: case 9: case 10:
				label = "������� ����";
				break;
			default:
				break;
			}
			categoryLabels.put(person.getLegalPersonCategoryId(),label );
		}
		
	}
	
	public static String getLabelForCategory(Integer categoryId){
		return categoryLabels.get(categoryId);
	}

	public static  LegalPerson getLegalPersonById(Integer id, String securityToken) throws IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage, IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage{
		for(LegalPerson person:getPersons(securityToken)){
			if(person.getId().equals(id)){
				return person;
			}
		}
		return null;
	}
	 

}
