package by.bsuir.banking.admin.utils;

import by.bsuir.banking.proxy.authentication.AuthenticationService;
import by.bsuir.banking.proxy.authentication.IAuthenticationService;
import by.bsuir.banking.proxy.card.CardService;
import by.bsuir.banking.proxy.card.ICardService;
import by.bsuir.banking.proxy.client.ClientService;
import by.bsuir.banking.proxy.client.IClientService;
import by.bsuir.banking.proxy.currency.CurrencyService;
import by.bsuir.banking.proxy.currency.ICurrencyService;
import by.bsuir.banking.proxy.lockcard.ILockCardService;
import by.bsuir.banking.proxy.lockcard.LockCardService;


public class ServiceProvider {
	
	private static IAuthenticationService authInstance;
	private static ICurrencyService currencyInstance;
	private static ICardService cardInstance;
	private static ILockCardService lockCardInstance;
	private static IClientService clientInstance;
	
	public static IAuthenticationService getAuthenticationService(){
		if(authInstance == null){
			AuthenticationService endpoint = new AuthenticationService();
			authInstance = endpoint.getBasicHttpBindingIAuthenticationService();
		}
		return authInstance;
	}
	
	
	public static ICurrencyService getCurrencyService(){
		if(currencyInstance == null){
			CurrencyService endpoint = new CurrencyService();
			currencyInstance = endpoint.getBasicHttpBindingICurrencyService();
		}
		return currencyInstance;
	}
	
	public static ICardService getCardService(){
		if(cardInstance == null){
			CardService endpoint = new CardService();
			cardInstance = endpoint.getBasicHttpBindingICardService();
		}
		return cardInstance;
	}
	
	public static ILockCardService getLockCardService(){
		if(lockCardInstance == null){
			LockCardService endpoint = new LockCardService();
			lockCardInstance = endpoint.getBasicHttpBindingILockCardService();
		}
		return lockCardInstance;
	}
	
	public static IClientService getClientService(){
		if(clientInstance == null){
			ClientService endpoint = new ClientService();
			clientInstance = endpoint.getBasicHttpBindingIClientService();
		}
		return clientInstance;
	}
}
