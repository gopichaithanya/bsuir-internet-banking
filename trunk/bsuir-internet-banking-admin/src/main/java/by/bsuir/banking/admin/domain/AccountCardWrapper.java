package by.bsuir.banking.admin.domain;

import java.math.BigDecimal;

import by.bsuir.banking.proxy.card.Account;
import by.bsuir.banking.proxy.card.Card;
import by.bsuir.banking.proxy.card.ObjectFactory;

/**
 * Wrapper for account and card
 * @author Katherine
 *
 */
public class AccountCardWrapper {
	private static ObjectFactory factory = new ObjectFactory();
	private Account account;
	private Card card;
	
	public AccountCardWrapper(){
		account = factory.createAccount();
		card = factory.createCard();
	}
	
	public AccountCardWrapper(Account account, Card card){
		this.account = account;
		this.card = card;
	}
	
	
	public Account getAccount(){
		return account;
	}
	
	public Card getCard(){
		return card;
	}
	
	/*
	 * Account's properties
	 */
	
	public Integer getCurrencyTypeId(){
		return account.getCurrencyTypeId();
	}
	
	public void setCurrencyTypeId(Integer id){
		account.setCurrencyTypeId(id);
	}
	
	public BigDecimal getAmount(){
		return account.getAmount();
	}
	
	public void setAmount(BigDecimal value){
		account.setAmount(value);
	}
	
	public String getAccountNumber(){
		return (account.getNumber() == null) ? null : account.getNumber().getValue();
	}
	
	public void setAccountNumber(String value){
		account.setNumber(factory.createAccountNumber(value));
	}
	
	public Integer getClientId(){
		return account.getClientId();
	}
	
	//is it allowed to set client id?
	public void setClientId(Integer id){
		account.setClientId(id);
	}
	
	public Integer getAccountId(){
		return account.getId();
	}
	
	/*
	 * Card's properties
	 */
	public Integer getCardsAccountId(){
		return card.getAccountId();
	}
	
	public void setCardsAccountId(Integer id){
		card.setAccountId(id);
	}
	
	public Integer getCardTypeId(){
		return card.getCardTypeId();
	}
	
	public void setCardTypeId(Integer id){
		card.setCardTypeId(id);
	}
	
	public Integer getCardId(){
		return card.getId();
	}
	
	public Boolean isIsLocked(){
		return card.isIsLocked();
	}
	
	public void setIsLocked(Boolean value){
		card.setIsLocked(value);
	}
	
	public BigDecimal getMoneyLimit(){
		return card.getMoneyLimit();
	}
	
	public void setMoneyLimit(BigDecimal value){
		card.setMoneyLimit(value);
	}
	
	public String getCardNumber(){
		return (card.getNumber() == null) ? null : card.getNumber().getValue();
	}
	
	public Integer getOperationsLimit(){
		return card.getOperationsLimit();
	}
	
	public void setOperationsLimit(Integer value){
		card.setOperationsLimit(value);
	}
	
	public String getSecretWord(){
		return (card.getSecretWord() == null) ? null : card.getSecretWord().getValue();
	}
	
	public void setSecretWord(String value){
		card.setSecretWord(factory.createCardSecretWord(value));
	}
}