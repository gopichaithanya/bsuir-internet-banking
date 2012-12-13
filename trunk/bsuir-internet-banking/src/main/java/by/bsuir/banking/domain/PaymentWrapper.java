package by.bsuir.banking.domain;

import by.bsuir.banking.admin.utils.PaymentUtil;
import by.bsuir.banking.proxy.internetbanking.LegalPerson;

/**
 * Wrapper for payment,
 * contains information about additional field that we need for
 * particular payment
 * @author E.Krasnotschek
 *
 */
public class PaymentWrapper {
	
	private LegalPerson legalPerson;
	private ClientWrapper client;
	
	
	public PaymentWrapper(LegalPerson person){
		legalPerson = person;
	}
	
	public PaymentWrapper(LegalPerson person, ClientWrapper client){
		legalPerson = person;
		this.client = client;
	}
	
	public LegalPerson getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(LegalPerson legalPerson) {
		this.legalPerson = legalPerson;
	}

	public ClientWrapper getClient() {
		return client;
	}

	public void setClient(ClientWrapper client) {
		this.client = client;
	}

	public String getClientName() {
		if(client == null){
			return null;
		}
		
		return client.getFirstName() + " " + client.getMiddleName() + " " + client.getLastName();
	}
	
	public String getInfoLabel(){
		return PaymentUtil.getLabelForCategory(legalPerson.getLegalPersonCategoryId());
	}
	
	

	
	
}
