package by.bsuir.banking.admin.utils;

import java.util.List;

import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.LegalPerson;

public class PaymentUtil {
	private static IInternetBankingService service = ServiceProvider.getInternetBankingService();
	private static List<LegalPerson> persons;
	
	private static List<LegalPerson> getPersons(String securityToken) throws IInternetBankingServiceGetAllLegalPersonsAuthorizationFaultFaultFaultMessage, IInternetBankingServiceGetAllLegalPersonsDomainFaultFaultFaultMessage{
		if(persons == null){
			persons = service.getAllLegalPersons(securityToken).getLegalPerson();
		}
		return persons;
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
