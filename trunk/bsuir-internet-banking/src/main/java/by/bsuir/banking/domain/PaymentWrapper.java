package by.bsuir.banking.domain;

import org.hibernate.validator.constraints.NotEmpty;

import by.bsuir.banking.admin.utils.PaymentUtil;

/**
 * Wrapper for payment,
 * contains information about additional field that we need for
 * particular payment
 * @author E.Krasnotschek
 *
 */
public class PaymentWrapper {
	
	private LegalPersonWrapper legalPerson;
	private ClientWrapper client;
	
	@NotEmpty
	private String infoString;
	private MoneyWrapper amount;
	
	
	public PaymentWrapper(LegalPersonWrapper person){
		legalPerson = person;
	}
	
	public PaymentWrapper(LegalPersonWrapper person, ClientWrapper client){
		legalPerson = person;
		this.client = client;
	}
	
	public LegalPersonWrapper getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(LegalPersonWrapper legalPerson) {
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
		return PaymentUtil.getLabelForCategory(legalPerson.getCategoryId());
	}
	
	public String getInfoString(){
		return infoString;
	}
	
	public void setInfoString(String value){
		infoString = value;
	}

	public MoneyWrapper getAmount(){
		return amount;
	}
	
	public void setAmount(MoneyWrapper value){
		
	}
	
}
