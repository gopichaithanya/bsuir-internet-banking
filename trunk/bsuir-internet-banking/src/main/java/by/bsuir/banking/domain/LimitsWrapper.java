package by.bsuir.banking.domain;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

public class LimitsWrapper {
	private BigDecimal moneyLimit;
	private Integer operationsLimit;
	@NotEmpty(message="Нужно ввести секретное слово")
	private String secretWord;

	public BigDecimal getMoneyLimit() {
		return moneyLimit;
	}

	public void setMoneyLimit(BigDecimal moneyLimit) {
		this.moneyLimit = moneyLimit;
	}

	public Integer getOperationsLimit() {
		return operationsLimit;
	}

	public void setOperationsLimit(Integer operationsLimit) {
		this.operationsLimit = operationsLimit;
	}

	public String getSecretWord() {
		return secretWord;
	}

	
	public void setSecretWord(String secretWord) {
		this.secretWord = secretWord;
	}
	
	
}
