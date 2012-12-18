package by.bsuir.banking.domain;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Wrapper for changing login
 * 
 * @author Katherine
 * 
 */
public class ChangeUsernameWrapper {

	public ChangeUsernameWrapper() {

	}
	
	@NotEmpty(message="Введите текущее имя пользователя")
	private String originalUsername;

	@NotEmpty(message="Введите новое имя пользователя")
	private String username;

	@NotEmpty(message="Подтвердите новое имя пользователя")
	private String confirmUsername;

	public String getOriginalUsername(){
		return originalUsername;
	}
	
	public void setOriginalUsername(String value){
		originalUsername = value;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String value) {
		username = value;
	}

	public String getConfirmUsername() {
		return confirmUsername;
	}

	public void setConfirmUsername(String value) {
		confirmUsername = value;
	}
}
