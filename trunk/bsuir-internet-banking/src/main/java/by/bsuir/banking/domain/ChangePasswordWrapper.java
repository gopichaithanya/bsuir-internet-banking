package by.bsuir.banking.domain;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Wrapper for changing password
 * contains
 * @author Katherine
 *
 */
public class ChangePasswordWrapper {
	
	public ChangePasswordWrapper(){
		
	}		
	
	@NotEmpty(message="������� ������������ ������")
	private String originalPassword;
	
	@NotEmpty(message="������� ����� ������")
	private String password;
	
	@NotEmpty(message="����������� ����� ������")
	private String confirmPassword;
	
	public String getOriginalPassword(){
		return originalPassword;
	}
	
	public void setOriginalPassword(String value){
		originalPassword = value;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String value){
		password = value;
	}
	
	public String getConfirmPassword(){
		return confirmPassword;
	}
	
	public void setConfirmPassword(String value){
		confirmPassword = value;
	}
}
