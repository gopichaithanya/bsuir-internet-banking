 package by.bsuir.banking.domain;

import by.bsuir.banking.proxy.internetbanking.LegalAccount;
import by.bsuir.banking.proxy.internetbanking.LegalPerson;
import by.bsuir.banking.proxy.internetbanking.LegalPersonCategory;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;

/**
 * Wrapper for legal person
 * @author Katherine
 *
 */
public class LegalPersonWrapper {
	private LegalPerson person;
	private ObjectFactory factory;
	
	public LegalPersonWrapper(LegalPerson person){
		this.setPerson(person);
	}

	public LegalPerson getPerson() {
		return person;
	}

	public void setPerson(LegalPerson person) {
		this.person = person;
	}
	
	public String getAddress(){
		return (person.getAddress() == null) ? null : person.getAddress().getValue();
	}
	
	public void setAddress(String address){
		person.setAddress(factory.createLegalPersonAddress(address));
	}
	
	public Integer getId(){
		return person.getId();
	}
	
	public LegalAccount getAccount(){
		return (person.getLegalAccounts() == null) ? null : person.getLegalAccounts().getValue().getLegalAccount().get(0);
	}
	
	public String getLegalNumber(){
		return (person.getLegalNumber() == null) ? null : person.getLegalNumber().getValue();
	}
	
	public LegalPersonCategory getCategory(){
		return (person.getLegalPersonCategory() == null) ? null : person.getLegalPersonCategory().getValue();
	}
	
	public Integer getCategoryId(){
		return person.getLegalPersonCategoryId();
	}
	
	public String getName(){
		return (person.getName() == null) ? null : person.getName().getValue();
	}
	
	public String getPhone(){
		return (person.getPhone() == null) ? null : person.getPhone().getValue();
	}
}
