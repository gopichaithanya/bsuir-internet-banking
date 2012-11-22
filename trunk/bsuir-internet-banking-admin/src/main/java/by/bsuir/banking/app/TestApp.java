package by.bsuir.banking.app;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.hibernate.validator.xml.ObjectFactory;

import by.bsuir.banking.proxy.administration.AdministrationService;
import by.bsuir.banking.proxy.administration.Administrator;
import by.bsuir.banking.proxy.administration.ArrayOfAdministrator;
import by.bsuir.banking.proxy.authentication.AuthenticationCredential;
import by.bsuir.banking.proxy.authentication.AuthenticationService;
import by.bsuir.banking.proxy.administration.IAdministrationService;
import by.bsuir.banking.proxy.authentication.IAuthenticationService;

public class TestApp {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < 10; i++) {
			System.out.println(new BigInteger(50, random).toString(32));
		}

		Calendar cal = Calendar.getInstance();
		ObjectFactory factory = new ObjectFactory();
		AuthenticationService authEndpoint = new AuthenticationService();
		IAuthenticationService authService = authEndpoint
				.getBasicHttpBindingIAuthenticationService();
		AuthenticationCredential credential = authService.authenticate(
				"Admin1", "Password1");
		String securityToken = credential.getSecurityToken().getValue();
		AdministrationService endpoint = new AdministrationService();
		IAdministrationService service = endpoint
				.getBasicHttpBindingIAdministrationService();
		Integer count = service.getAdministratorsCount(securityToken);
		System.out.println(count);
		ArrayOfAdministrator arrayOfAdministrator = service
				.getAllAdministrators(1, 10, securityToken);
		System.out.println(arrayOfAdministrator.getAdministrator().size());

		Administrator admin = service.getAdministratorById(1, securityToken);
		System.out.println(admin.getId());
		admin.setFirstName(factory.createElementTypeValue("NewName"));
		service.updateAdministrator(admin, securityToken);
	}

}
