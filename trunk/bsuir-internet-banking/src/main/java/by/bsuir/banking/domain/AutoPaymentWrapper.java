package by.bsuir.banking.domain;

import by.bsuir.banking.proxy.internetbanking.AutoPayment;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;

public class AutoPaymentWrapper {
	private AutoPayment payment;
	private ObjectFactory factory = new ObjectFactory();
	
	public AutoPaymentWrapper(){}
	
	public AutoPaymentWrapper(AutoPayment payment){
		this.payment = payment;
	}
	
	public Integer getId(){
		return payment.getId();
	}
	
	
	public Integer getAccountId(){
		return payment.getAccountId();
	}
	
	public void setAccountId(Integer id){
		payment.setAccountId(id);
	}
	
	public String getInformation(){
		return (payment.getInformation() == null)?null:payment.getInformation().getValue();
	}
	
	public void setInformation(String info){
		payment.setInformation(factory.createAutoPaymentInformation(info));
	}
	
	public Integer getDayOfMonth(){
		return payment.getDayOfMonth();
	}
	
	public void setDayOfMonth(Integer day){
		payment.setDayOfMonth(day);
	}
	
	public MoneyWrapper getAmount(){
		return (payment.getMoney() == null) ? null:new MoneyWrapper(payment.getMoney().getValue());
	}
	
	public void setAmount(MoneyWrapper amount){
		payment.setMoney(factory.createAutoPaymentMoney(amount.getMoney()));
	}
	
	public Integer getLegalAccountId(){
		return payment.getLegalAccountId();
	}
	
	public void setLegalAccountId(Integer id){
		payment.setLegalAccountId(id);
	}
}
