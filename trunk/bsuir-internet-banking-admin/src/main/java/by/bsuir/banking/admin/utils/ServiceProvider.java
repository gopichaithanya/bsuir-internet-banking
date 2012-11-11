package by.bsuir.banking.admin.utils;

import by.bsuir.banking.proxy.administration.AdministrationService;
import by.bsuir.banking.proxy.authentication.AuthenticationService;
import by.bsuir.banking.proxy.administration.IAdministrationService;
import by.bsuir.banking.proxy.authentication.IAuthenticationService;
import by.bsuir.banking.proxy.currency.CurrencyService;
import by.bsuir.banking.proxy.currency.ICurrencyService;
import by.bsuir.banking.proxy.operator.IOperatorService;
import by.bsuir.banking.proxy.operator.OperatorService;

public class ServiceProvider {
	
	private static IAuthenticationService authInstance;
	private static IAdministrationService adminInstance;
	private static IOperatorService operInstance;
	private static ICurrencyService currencyInstance;
	
	public static IAuthenticationService getAuthenticationService(){
		if(authInstance == null){
			AuthenticationService endpoint = new AuthenticationService();
			authInstance = endpoint.getBasicHttpBindingIAuthenticationService();
		}
		return authInstance;
	}
	
	public static IAdministrationService getAdministrationService(){
		if(adminInstance == null){
			AdministrationService endpoint = new AdministrationService();
			adminInstance = endpoint.getBasicHttpBindingIAdministrationService();
		}
		return adminInstance;
	}
	
	public static IOperatorService getOperatorService(){
		if(operInstance == null){
			OperatorService endpoint = new OperatorService();
			operInstance = endpoint.getBasicHttpBindingIOperatorService();
		}
		return operInstance;
	}
	
	public static ICurrencyService getCurrencyService(){
		if(currencyInstance == null){
			CurrencyService endpoint = new CurrencyService();
			currencyInstance = endpoint.getBasicHttpBindingICurrencyService();
		}
		return currencyInstance;
	}

}
