package by.bsuir.banking.admin.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.bsuir.banking.admin.domain.AccountCardWrapper;

@Component
public class SecretWordValidator implements Validator {
	private final static String SECRET_WORD_FIELD = "secretWord";
	private final static String SECRET_WORD_PATTERN = "[A-Za-zР-пр-џ-]{3,20}";

	@Override
	public boolean supports(Class<?> clazz) {
		return AccountCardWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AccountCardWrapper account = (AccountCardWrapper) target;
		if (account.getSecretWord() == null) {
			errors.rejectValue(SECRET_WORD_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (account.getSecretWord().trim().isEmpty()) {
			errors.rejectValue(SECRET_WORD_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!account.getSecretWord().matches(SECRET_WORD_PATTERN)) {
			errors.rejectValue(SECRET_WORD_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_SECRET_WORD);
		}
		
	}

}
