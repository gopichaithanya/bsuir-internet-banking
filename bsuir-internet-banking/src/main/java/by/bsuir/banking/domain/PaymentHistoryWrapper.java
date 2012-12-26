 package by.bsuir.banking.domain;

import java.math.BigDecimal;
import java.util.Date;

import by.bsuir.banking.admin.utils.InformationParser;
import by.bsuir.banking.proxy.internetbanking.LegalAccount;
import by.bsuir.banking.proxy.internetbanking.Payment;

public class PaymentHistoryWrapper implements Comparable<PaymentHistoryWrapper>{

	private Payment payment;
	private EripWrapper erip;
	private LegalPersonWrapper legalPerson;
	private String cardNumber;
	
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
	
	
	public PaymentHistoryWrapper(Payment payment){
		this.payment = payment;
	}
	
	public Integer getId(){
		return payment.getId();
	}

	public Integer getClientAccountId(){
		return payment.getClientAccountId();
	}
	
	public AccountWrapper getAccount(){
		return (payment.getAccount()==null)?null: new AccountWrapper(payment.getAccount().getValue());
	}
	
	
	public Integer getLegalAccountId(){
		return payment.getLegalAccountId();
	}
	
	public LegalAccount getLegalAccount(){
		return (payment.getLegalAccount()==null)?null:payment.getLegalAccount().getValue();
	}
	
	public BigDecimal getAmount(){
		return payment.getAmount();
	}
	
	public MoneyWrapper getMoney(){
		return (payment.getMoney() == null)? null : new MoneyWrapper(payment.getMoney().getValue());
	}
	
	public String getInformation(){
		return (payment.getInformation() == null) ? null : payment.getInformation().getValue();
	}
	
	public Date getDateTime(){
		return (payment.getDateTime() == null) ? null : payment.getDateTime().toGregorianCalendar().getTime();
	}
	
	@Override
	public String toString(){
		return "payment:\n"+
				"id="+ payment.getId() + "\n"+
				"accountId="+payment.getClientAccountId() + "\n"+
				"account=" + payment.getAccount() + "\n" +
				"legalId="+payment.getLegalAccountId() + "\n"+
				"legal="+payment.getLegalAccount()+"\n"+
				"amount="+payment.getAmount()+"\n"+
				"money="+payment.getMoney()+'\n'+
				"date="+payment.getDateTime();
				
	}

	public EripWrapper getErip() {
		return erip;
	}

	public void setErip(EripWrapper erip) {
		this.erip = erip;
	}

	public LegalPersonWrapper getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(LegalPersonWrapper legalPerson) {
		this.legalPerson = legalPerson;
	}
	
	public boolean isIsSuccessful(){
		return payment.isIsSuccessful();
	}
	
	public String getStatus(){
		if(isIsSuccessful()){
			return "SUCCESS";
		}else{
			return "FAILED";
		}
	}
	
	@Override
	  public int compareTo(PaymentHistoryWrapper o) {
	    return getDateTime().compareTo(o.getDateTime());
	  }

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
