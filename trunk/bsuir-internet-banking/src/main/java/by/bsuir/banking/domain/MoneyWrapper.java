package by.bsuir.banking.domain;

import java.math.BigDecimal;

import by.bsuir.banking.proxy.internetbanking.Money;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;

/**
 * 
 * @author Svetlana
 *
 */
public class MoneyWrapper {
	private static ObjectFactory factory = new ObjectFactory();
	private Money money;
	
	public MoneyWrapper() {
		money = factory.createMoney();
	}
	
	public MoneyWrapper(Money  money) {
		this.money = money;
	}
	
	public Money getMoney() {
		return money;
	}
	
	public String getCurrencyType() {
		return (money.getCurrencyType() == null) ? null : money.getCurrencyType().getValue();
	}
	
	public void setCurrencyType(String value) {
		money.setCurrencyType(factory.createMoneyCurrencyType(value));
	}
	
	public Integer getCurrencyTypeId() {
		return money.getCurrencyTypeId();
	}
	
	public void setCurrencyTypeId(Integer id) {
		money.setCurrencyTypeId(id);
	}
	
	public BigDecimal getAmount() {
		return money.getAmount();
	}
	
	public void setAmount(BigDecimal value) {
		money.setAmount(value);
	}
}
