package by.bsuir.banking.admin.domain;

import java.math.BigDecimal;

import by.bsuir.banking.proxy.internetbanking.ObjectFactory;
import by.bsuir.banking.proxy.internetbanking.SellCurrencyRate;

public class SellRateWrapper {
	private static ObjectFactory factory = new ObjectFactory();
	private SellCurrencyRate rate;
	private String amount;
	
	public SellRateWrapper(){
		rate = factory.createSellCurrencyRate();
	}
	
	public SellRateWrapper(SellCurrencyRate rate){
		this.rate = rate;
		this.amount = rate.getRate().toString();
	}
	
	public SellCurrencyRate getSellCurrencyrate(){
		return rate;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
