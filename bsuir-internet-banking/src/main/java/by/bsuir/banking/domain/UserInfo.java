package by.bsuir.banking.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * FormBean for authentication.
 * Temporary object.
 * @author Katherine
 *
 */
public class UserInfo {
	
	/**
	 * Username field
	 * TODO add other constraints
	 */
	@NotEmpty(message="��� ������������ �� ������ ���� ������")
	protected String username;
	
	/**
	 * Password field
	 * TODO add other constraints
	 */
	@NotEmpty(message="������ �� ������ ���� ������")
	protected String password;
	
	/**
	 * Security token that we get from .Net web-service
	 * for further authorization	
	 */
	private String securityToken;
	
	/**
	 * The field will not be string after upgrading to a new version of
	 * the web service 
	 */
	private String role;

	private String name;
	
	private Date lasDate;
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getRole(){
		return role;
	}
	
	public void setRole(String role){
		this.role = role;
	}
	
	public String getsSecurityToken(){
		return securityToken;
	}
	
	public void setSecurityToken(String securityToken){
		this.securityToken = securityToken;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String value){
		name = value;
	}

	public Date getLasDate() {
		return lasDate;
	}

	public void setLasDate(Date lasDate) {
		this.lasDate = lasDate;
	}
	

}

