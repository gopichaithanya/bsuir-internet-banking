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

	@NotEmpty
	private String username;

	@NotEmpty
	private String confirmUsername;

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
