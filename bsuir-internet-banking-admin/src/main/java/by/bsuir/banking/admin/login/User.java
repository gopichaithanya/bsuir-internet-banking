package by.bsuir.banking.admin.login;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * FormBean for authentication
 * @author Katherine
 *
 */
public class User {
	
	/**
	 * Username field
	 * TODO add other constraints
	 */
	@NotEmpty
	private String username;
	
	/**
	 * Password field
	 * TODO add other constraints
	 */
	@NotEmpty
	private String password;
	
	private String securityToken;
	
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
	
	public String getsSecurityToken(){
		return securityToken;
	}
	
	public void setSecurityToken(String securityToken){
		this.securityToken = securityToken;
	}
	
	
	

}
