package by.bsuir.banking.admin.controller;

import by.bsuir.banking.dotnetclient.AdministrationService;
import by.bsuir.banking.dotnetclient.AuthenticationService;
import by.bsuir.banking.dotnetclient.IAdministrationService;
import by.bsuir.banking.dotnetclient.IAuthenticationService;

public class ServiceProvider {
	
	private static IAuthenticationService authInstance;
	private static IAdministrationService adminInstance;
	
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

}
