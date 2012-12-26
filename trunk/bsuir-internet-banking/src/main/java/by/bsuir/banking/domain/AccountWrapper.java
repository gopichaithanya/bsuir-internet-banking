  package by.bsuir.banking.domain;

import java.math.BigDecimal;

import by.bsuir.banking.proxy.internetbanking.Account;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;

public class AccountWrapper {
	
	private static ObjectFactory factory = new ObjectFactory();
	private Account account;
	
	public AccountWrapper() {
		account = factory.createAccount();
	}
	
	public AccountWrapper(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return this.account;
	}
	
	public CurrencyTypeWrapper getCurrencyType() {
		return (account.getCurrencyType() == null) ? null : new CurrencyTypeWrapper (account.getCurrencyType().getValue());
	}
	
	public void setCurrencyType(CurrencyTypeWrapper value) {
		account.setCurrencyType(factory.createAccountCurrencyType(value.getCurrencyType()));
	}
	
	public Integer getCurrencyTypeId() {
		return account.getCurrencyTypeId();
	}
	
	public void setCurrencyTypeId(Integer id) {
		account.setCurrencyTypeId(id);
	}
	
	public BigDecimal getAmount() {
		return account.getAmount();
	}
	
	public void setAmount(BigDecimal value) {
		account.setAmount(value);
	}
	
	public String getAccountNumber() {
		return (account.getNumber() == null) ? null : account.getNumber().getValue();
	}
	
	public void setAccountNumber(String value) {
		account.setNumber(factory.createAccountNumber(value));
	}
	
	public Integer getClientId() {
		return account.getClientId();
	}
	
	//is it allowed to set client id?
	public void setClientId(Integer id) {
		account.setClientId(id);
	}
	
	public Integer getAccountId() {
		return account.getId();
	}

}
