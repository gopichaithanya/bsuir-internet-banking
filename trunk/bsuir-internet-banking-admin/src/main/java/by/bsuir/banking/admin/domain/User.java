package by.bsuir.banking.admin.domain;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * FormBean for authentication.
 * Temporary object.
 * @author Katherine
 *
 */
public class User {
	
	/**
	 * Username field
	 * TODO add other constraints
	 */
	@NotEmpty
	protected String username;
	
	/**
	 * Password field
	 * TODO add other constraints
	 */
	@NotEmpty
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
	
	
	

}
