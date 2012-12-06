package by.bsuir.banking.admin.domain;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Class for serching clients
 * @author Katherine
 *
 */
public class SearchCriteria {
	
	@NotEmpty
	private String seria;
	
	@NotEmpty
	private String number;
	
	private String firstName;
	private String lastName;
	private String middleName;
	
	
	public String getSeria(){
		return seria;
	}
	
	public void setSeria(String value){
		seria = value;
	}
	
	public String getNumber(){
		return number;
	}

	public void setNumber(String value){
		number = value;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String value){
		firstName = value;
	}
	
	public String getMiddleName(){
		return middleName;
	}
	
	public void setMiddleName(String value){
		middleName = value;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String value){
		lastName = value;
	}
}
