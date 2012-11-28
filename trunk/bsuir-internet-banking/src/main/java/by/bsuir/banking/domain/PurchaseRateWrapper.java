package by.bsuir.banking.domain;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

import by.bsuir.banking.proxy.currency.ObjectFactory;
import by.bsuir.banking.proxy.currency.PurchaseCurrencyRate;


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
	
	@NotEmpty
	public CurrencyTypeWrapper getCurrencyType(){
		return (rate.getCurrencyType() == null) ? null : new CurrencyTypeWrapper(rate.getCurrencyType().getValue());
	}
	
	public void setCurrencyType(CurrencyTypeWrapper value){
		rate.setCurrencyType(factory.createCurrencyType(value.getCurrencyType()));
	}
	
	@NotEmpty
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
