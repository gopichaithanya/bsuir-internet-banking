 package by.bsuir.banking.domain;

import by.bsuir.banking.admin.utils.InformationParser;
import by.bsuir.banking.proxy.internetbanking.AutoPayment;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;


/**
 * @author Katherine
 *
 */
public class AutoPaymentWrapper {
	private AutoPayment autoPayment;
	private ObjectFactory factory = new ObjectFactory();
	private String cardNumber;
	private LegalPersonWrapper legalPerson;
	private EripWrapper erip;
	
	
	public String getDisplayInfo(){
		if(legalPerson != null){
			return getInformation();
		}
		if(erip != null){
			return InformationParser.getEripInformation(getInformation());
		}
		return null;
	}
	
	public String getName(){
		if(legalPerson != null){
			return legalPerson.getName();
		}
		if(erip != null){
			return "(Расчет)" + erip.getName();
		}
		return null;
	}
	
	public AutoPaymentWrapper(AutoPayment payment){
		autoPayment = payment;
	}
	
	public Integer getId(){
		return autoPayment.getId();
	}
	
	public Integer getAccountId(){
		return autoPayment.getAccountId();
	}
	
	public void setAccountId(Integer accountId){
		autoPayment.setAccountId(accountId);
	}
	
	public Integer getLegalAccountId(){
		return autoPayment.getLegalAccountId();
	}
	
	public void setLegalAccountId(Integer value){
		autoPayment.setLegalAccountId(value);
	}
	
	public Integer getDayOfMonth(){
		return autoPayment.getDayOfMonth();
	}
	
	public void setDayOfMonth(Integer value){
		autoPayment.setDayOfMonth(value);
	}
	
	public String getInformation(){
		return (autoPayment.getInformation() == null)? null : autoPayment.getInformation().getValue();
	}
	
	public void setInformation(String info){
		autoPayment.setInformation(factory.createAutoPaymentInformation(info));
	}
	
	public MoneyWrapper getAmount(){
		return (autoPayment.getMoney() == null)? null : new MoneyWrapper(autoPayment.getMoney().getValue());
	}
	
	public void setAmount(MoneyWrapper amount){
		autoPayment.setMoney(factory.createAutoPaymentMoney(amount.getMoney()));
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LegalPersonWrapper getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(LegalPersonWrapper legalPerson) {
		this.legalPerson = legalPerson;
	}

	public EripWrapper getErip() {
		return erip;
	}

	public void setErip(EripWrapper erip) {
		this.erip = erip;
	}
	
	
}


