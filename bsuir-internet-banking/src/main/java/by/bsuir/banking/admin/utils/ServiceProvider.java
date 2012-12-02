package by.bsuir.banking.admin.utils;

import by.bsuir.banking.proxy.authentication.AuthenticationService;
import by.bsuir.banking.proxy.authentication.IAuthenticationService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.InternetBankingService;


public class ServiceProvider {
	
	private static IAuthenticationService authInstance;
	private static IInternetBankingService internetBankingInstance;
	
	public static IAuthenticationService getAuthenticationService(){
		if(authInstance == null){
			AuthenticationService endpoint = new AuthenticationService();
			authInstance = endpoint.getBasicHttpBindingIAuthenticationService();
		}
		return authInstance;
	}
	
	
	public static IInternetBankingService getInternetBankingService(){
		if(internetBankingInstance == null){
			InternetBankingService endpoint = new InternetBankingService();
			internetBankingInstance = endpoint.getBasicHttpBindingIInternetBankingService();
		}
		return internetBankingInstance;
	}
}
