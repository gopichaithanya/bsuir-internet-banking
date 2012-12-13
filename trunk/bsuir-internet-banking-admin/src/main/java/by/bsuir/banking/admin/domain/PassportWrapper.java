package by.bsuir.banking.admin.domain;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.hibernate.validator.constraints.NotEmpty;

import by.bsuir.banking.proxy.operator.ObjectFactory;
import by.bsuir.banking.proxy.operator.Passport;

/**
 * Fake bean for Passport entity
 * 
 * @author Katherine
 * 
 */
public class PassportWrapper {
	private static ObjectFactory factory = new ObjectFactory();
	private Passport passport;
	
	public PassportWrapper(){
		passport = factory.createPassport();
	}
	
	public PassportWrapper(Passport passport){
		this.passport = passport;
	}

	/**
	 * Getting passport instance
	 * @return
	 */
	public Passport getPassport() {
		return passport;
	}
	
	/**
	 * Getting authority
	 * @return
	 */

	public String getAuthority(){
		return (passport.getAuthority() == null) ? null : passport.getAuthority().getValue();
	}
	
	/**
	 * Setting authority
	 * @param value
	 */
	public void setAuthority(String value){
		passport.setAuthority(factory.createPassportAuthority(value));
	}
	
	/**
	 * Getting date of expiry
	 * @return
	 */
	
	public Date getDateOfExpiry(){
		return (passport.getDateOfExpiry() == null) ? null : passport.getDateOfExpiry().toGregorianCalendar().getTime();
	}
	
	/**
	 * Setting date of expiry
	 * @param value
	 * @throws DatatypeConfigurationException
	 */
	public void setDateOfExpiry(Date value) throws DatatypeConfigurationException{
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(value);
		passport.setDateOfExpiry(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
	}
	
	/**
	 * Getting date of issue
	 * @return
	 */
	//@NotEmpty
	public Date getDateOfIssue(){
		return (passport.getDateOfIssue() == null) ? null : passport.getDateOfIssue().toGregorianCalendar().getTime();
	}
	
	/**
	 * Setting date of issue
	 * @param value
	 * @throws DatatypeConfigurationException
	 */
	public void setDateOfIssue(Date value) throws DatatypeConfigurationException{
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(value);
		passport.setDateOfIssue(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
	}
	
	/**
	 * Getting id
	 * @return
	 */
	public Integer getId(){
		return passport.getId();
	}
	
	/**
	 * Getting number
	 * @return
	 */
	@NotEmpty
	public String getNumber(){
		return (passport.getNumber() == null) ? null : passport.getNumber().getValue();
	}
	
	/**
	 * Setting number
	 * @param value
	 */
	public void setNumber(String value){
		passport.setNumber(factory.createPassportNumber(value));
	}
	
	/**
	 * Getting seria
	 * @return
	 */
	@NotEmpty
	public String getSeria(){
		return (passport.getSeria() == null) ? null : passport.getSeria().getValue();
	}
	
	/**
	 * Setting seria
	 * @param value
	 */
	public void setSeria(String value){
		passport.setSeria(factory.createPassportSeria(value));
	}
}
