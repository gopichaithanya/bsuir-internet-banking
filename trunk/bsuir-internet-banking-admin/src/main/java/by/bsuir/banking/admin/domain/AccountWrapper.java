package by.bsuir.banking.admin.domain;

import by.bsuir.banking.proxy.card.Account;
import by.bsuir.banking.proxy.card.ObjectFactory;

/**
 * Wrapper for 
 * @author Katherine
 *
 */
public class AccountWrapper {
	private static ObjectFactory factory = new ObjectFactory();
	private Account account;
	
	public AccountWrapper(){
		account = factory.createAccount();
	}
	
	public AccountWrapper(Account account){
		this.account = account;
	}
	
	public Account getAccount(){
		return account;
	}
	
	
}
