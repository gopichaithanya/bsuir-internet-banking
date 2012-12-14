package by.bsuir.banking.admin.domain;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

import by.bsuir.banking.proxy.internetbanking.ObjectFactory;
import by.bsuir.banking.proxy.internetbanking.PurchaseCurrencyRate;


public class PurchaseRateWrapper {
	
	private static ObjectFactory factory = new ObjectFactory();
	private PurchaseCurrencyRate rate;

	public PurchaseCurrencyRate getPurchaseCurrencyRate(){
		return rate;
	}
	
	public PurchaseRateWrapper(){
		rate = factory.createPurchaseCurrencyRate();
	}
	
	public PurchaseRateWrapper(PurchaseCurrencyRate rate){
		this.rate = rate;
	}
	
	
	public CurrencyTypeWrapper getCurrencyType(){
		return (rate.getCurrencyType() == null) ? null : new CurrencyTypeWrapper(rate.getCurrencyType().getValue());
	}
	
	public void setCurrencyType(CurrencyTypeWrapper value){
		rate.setCurrencyType(factory.createCurrencyType(value.getCurrencyType()));
	}
	
	
	public BigDecimal getRate(){
		return rate.getRate();
	}
	
	public void setRate(BigDecimal value){
		rate.setRate(value);
	}
	
	public Integer getId(){
		return rate.getId();
	}
}
