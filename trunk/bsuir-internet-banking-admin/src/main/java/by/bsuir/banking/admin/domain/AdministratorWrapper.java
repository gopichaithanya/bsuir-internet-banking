package by.bsuir.banking.admin.domain;

import org.hibernate.validator.constraints.NotEmpty;

import by.bsuir.banking.dotnetclient.Administrator;
import by.bsuir.banking.dotnetclient.ObjectFactory;

/**
 * Class that wraps Administrator proxy,
 * used for validation purpose. 
 * 
 * @author Katherine
 * 
 */
public class AdministratorWrapper {
	
	private static ObjectFactory factory = new ObjectFactory();
	private Administrator administrator;
	
	public AdministratorWrapper(){
		administrator = factory.createAdministrator();
	}
	
	/**
	 * Getting administrator instance
	 */
	public Administrator getAdministrator(){
		return administrator;
	}
	
	/**
	 * Getting firstName property of the administrator object.
	 * @return String value of the first name property.
	 */
	@NotEmpty
	public String getFirstName(){
		return (administrator.getFirstName() == null) ? null : administrator.getFirstName().getValue(); 
	}
	
	/**
	 * Setting first name of the administrator object
	 * @param firstNameValue
	 */
	public void setFirstName(String firstNameValue){
		administrator.setFirstName(factory.createAdministratorFirstName(firstNameValue));
	}
	
	/**
	 * Getting lastName property of the administrator object.
	 * @return String value of the last name property.
	 */
	@NotEmpty
	public String getLastName(){
		return (administrator.getLastName() == null) ? null : administrator.getLastName().getValue();
	}
	
	/**
	 * Setting last name of the administrator object
	 * @param lastNameValue
	 */
	public void setLastName(String lastNameValue){
		administrator.setLastName(factory.createAdministratorLastName(lastNameValue));
	}
	
	/**
	 * Getting middleName property of the administrator object.
	 * @return String value of the middle name property.
	 */
	public String getMiddleName(){
		return (administrator.getMiddleName() == null) ? null : administrator.getMiddleName().getValue();
	}
	
	/**
	 * Setting middle name of the administrator object
	 * @param middleNameValue
	 */
	public void setMiddleName(String middleNameValue){
		administrator.setMiddleName(factory.createAdministratorMiddleName(middleNameValue));
	}
	
	/**
	 * Getting login property of the administrator object.
	 * @return String value of the login property.
	 */
	@NotEmpty
	public String getLogin(){
		return (administrator.getLogin() == null) ? null : administrator.getLogin().getValue();
	}
	
	/**
	 * Setting login of the administrator object
	 * @param loginValue
	 */
	public void setLogin(String loginValue){
		administrator.setLogin(factory.createAdministratorLogin(loginValue));
	}
	
	/**
	 * Getting password property of the administrator object.
	 * @return String value of the password property.
	 */
	@NotEmpty
	public String getPassword(){
		return (administrator.getPassword() == null) ? null : administrator.getPassword().getValue();
	}
	
	/**
	 * Setting password of the administrator object
	 * @param passwordValue
	 */
	public void setPassword(String passwordValue){
		administrator.setPassword(factory.createAdministratorPassword(passwordValue));
	}
	
	/**
	 * Getting id property of the administrator object.
	 * There's no setter for this property - id is autogenerated
	 * @return String value of the id property.
	 */
	public Integer getId(){
		return administrator.getId();
	}
}
