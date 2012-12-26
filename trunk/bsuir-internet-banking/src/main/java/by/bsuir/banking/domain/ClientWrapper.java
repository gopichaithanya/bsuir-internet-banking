 package by.bsuir.banking.domain;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.hibernate.validator.constraints.NotEmpty;

import by.bsuir.banking.proxy.internetbanking.Client;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;



/**
 * Fake bean for Client entity
 * 
 * @author Katherine
 * 
 */
public class ClientWrapper {
	private static ObjectFactory factory = new ObjectFactory();
	private Client client;

	public ClientWrapper() {
		client = factory.createClient();
	}

	public ClientWrapper(Client client) {
		this.client = client;
	}
 
	/**
	 * Getting client instance for this wrapper
	 * 
	 * @return
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Getting address
	 * @return
	 */
	@NotEmpty
	public String getAddress() {
		return (client.getAdress() == null) ? null : client.getAdress()
				.getValue();
	}

	/**
	 * Setting address
	 * @param value
	 */
	public void setAddress(String value) {
		client.setAdress(factory.createClientAdress(value));
	}
	
	/**
	 * Getting birthday
	 * @return
	 */
	public Date getBirthdayDate(){
		return (client.getBirthdayDate() == null) ? null : client.getBirthdayDate().toGregorianCalendar().getTime();
	}
	
	/**
	 * Setting birthday date
	 * @param value
	 * @throws DatatypeConfigurationException
	 */
	public void setBirthdayDate(Date value) throws DatatypeConfigurationException{
		GregorianCalendar calendar  = new GregorianCalendar();
		calendar.setTime(value);
		client.setBirthdayDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
	}
	
	/**
	 * Getting first name
	 * @return
	 */
	@NotEmpty
	public String getFirstName(){
		return (client.getFirstName() == null) ? null : client.getFirstName().getValue();
	}
	
	/**
	 * Setting first name
	 * @param value
	 */
	public void setFirstName(String value){
		client.setFirstName(factory.createClientFirstName(value));
	}
	
	/**
	 * Getting middle name
	 * @return
	 */
	public String getMiddleName(){
		return (client.getMiddleName() == null) ? null : client.getMiddleName().getValue();
	}
	
	/**
	 * Setting middle name
	 * @param value
	 */
	public void setMiddleName(String value){
		client.setMiddleName(factory.createClientMiddleName(value));
	}
	
	/**
	 * Getting last name
	 * @return
	 */
	@NotEmpty
	public String getLastName(){
		return (client.getLastName() == null) ? null : client.getLastName().getValue();
	}
	
	/**
	 * Setting last name
	 * @param value
	 */
	public void setLastName(String value){
		client.setLastName(factory.createClientLastName(value));
	}
	
	/**
	 * Getting login
	 * @return
	 */
	public String getLogin(){
		return (client.getLogin() == null) ? null : client.getLogin().getValue();
	}
	
	/**
	 * Setting login
	 * @param value
	 */
	public void setLogin(String value){
		client.setLogin(factory.createClientLogin(value));
	}
	
	/**
	 * Getting password
	 * @return
	 */
	public String getPassword(){
		return (client.getPassword() == null) ? null : client.getPassword().getValue();
	}
	
	/**
	 * Setting password
	 * @param value
	 */
	public void setPassword(String value){
		client.setPassword(factory.createClientPassword(value));
	}
	
	/**
	 * Getting id
	 * @return
	 */
	public Integer getId(){
		return client.getId();
	}
	
	public boolean isLocked(){
		return client.isIsLocked();
	}
	
	public void setLocked(boolean value){
		client.setIsLocked(value);
	}
	
//	/**
//	 * Getting passport (wrapper)
//	 * @return
//	 */
//	public PassportWrapper getPassport(){
//		return (client.getPassport() == null) ? null : new PassportWrapper(client.getPassport().getValue());
//	}
	
	/**
	 * Setting passport (wrapper)
	 * @param value
	 */
//	public void setPassport(PassportWrapper value){
//		client.setPassport(factory.createClientPassport(value.getPassport()));
//	}
//	
//	/**
//	 * Getting passport id
//	 * @return
//	 */
//	public Integer getPassportId(){
//		return client.getPassportId();
//	}
//	
//	/**
//	 * Getting phone number
//	 */
//	@NotEmpty
//	public String getPhoneNumber(){
//		return (client.getPhoneNumber() == null) ? null : client.getPhoneNumber().getValue();
//	}
//	
//	/**
//	 * Setting phone number
//	 */
//	public void setPhoneNumber(String value){
//		client.setPhoneNumber(factory.createClientPhoneNumber(value));
//	}
}
