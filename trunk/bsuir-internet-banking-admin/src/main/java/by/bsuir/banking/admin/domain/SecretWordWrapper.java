package by.bsuir.banking.admin.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class SecretWordWrapper {
	@NotEmpty
	private String secretWord;

	public SecretWordWrapper(){
		
	}
	
	public SecretWordWrapper(String value){
		secretWord = value;
	}
	
	public String getSecretWord() {
		return secretWord;
	}

	public void setSecretWord(String secretWord) {
		this.secretWord = secretWord;
	}
}
