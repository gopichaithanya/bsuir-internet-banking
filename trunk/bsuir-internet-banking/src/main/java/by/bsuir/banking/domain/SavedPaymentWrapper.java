package by.bsuir.banking.domain;

import by.bsuir.banking.proxy.internetbanking.ObjectFactory;
import by.bsuir.banking.proxy.internetbanking.SavedPayment;

/**
 * 
 * @author Katherine
 *
 */
public class SavedPaymentWrapper {
	private SavedPayment savedPayment;
	private ObjectFactory factory = new ObjectFactory();
	private String cardNumber;
	private String legalPersonName;
	private Integer legalPersonId;
	
	public SavedPayment getSavedPayment() {
		return savedPayment;
	}

	public void setSavedPayment(SavedPayment savedPayment) {
		this.savedPayment = savedPayment;
	}
	
	public Integer getAccountId(){
		return savedPayment.getAccountId();
	}
	
	
	public void setAccountId(Integer id){
		savedPayment.setAccountId(id);
	}
	
	public Integer getId(){
		return savedPayment.getId();
	}
	
	public Integer getLegalAccountId(){
		return savedPayment.getLegalAccountId();
	}
	
	public void setLegalAccountId(Integer id){
		savedPayment.setLegalAccountId(id);
	}
	
	public MoneyWrapper getAmount(){
		return (savedPayment.getMoney() == null) ? null : new MoneyWrapper(savedPayment.getMoney().getValue());
	}
	
	public void setAmount(MoneyWrapper value){
		savedPayment.setMoney(factory.createMoney(value.getMoney()));
	}
	
	public String getInformation(){
		return (savedPayment.getInformation() == null) ? null : savedPayment.getInformation().getValue();
	}
	
	public void setInformation(String information){
		savedPayment.setInformation(factory.createSavedPaymentInformation(information));
	}
	
	public SavedPaymentWrapper(Integer accountId, Integer legalAccountId, String info, MoneyWrapper amount){
		savedPayment = new SavedPayment();
		setAccountId(accountId);
		setLegalAccountId(legalAccountId);
		setInformation(info);
		setAmount(amount);
	}
	
	public SavedPaymentWrapper(SavedPayment payment){
		savedPayment = payment;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public Integer getLegalPersonId() {
		return legalPersonId;
	}

	public void setLegalPersonId(Integer legalPersonId) {
		this.legalPersonId = legalPersonId;
	}
	
	
	
}
