package by.bsuir.banking.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.bsuir.banking.domain.ChangeUsernameWrapper;

@Component
public class ChangeLoginValidator implements Validator {
	private final static String USERNAME_FIELD = "username";
	private final static String CONFIRM_USERNAME_FIELD = "confirmUsername"; 
	private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_-]{3,15}$";
	

	@Override
	public boolean supports(Class<?> clazz) {
		return ChangeLoginValidator.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ChangeUsernameWrapper login = (ChangeUsernameWrapper) target;
		if (login.getUsername() == null) {
			errors.rejectValue(USERNAME_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (login.getUsername().isEmpty()) {
			errors.rejectValue(USERNAME_FIELD, MessageValidation.EMPTY_FIELD, MessageValidation.EMPTY_FIELD);
		} else if(!login.getUsername().matches(USERNAME_PATTERN)) {
			errors.rejectValue(USERNAME_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_USERNAME);
		}
		if (login.getConfirmUsername() == null) {
			errors.rejectValue(CONFIRM_USERNAME_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (login.getConfirmUsername().isEmpty()) {
			errors.rejectValue(CONFIRM_USERNAME_FIELD, MessageValidation.EMPTY_FIELD, MessageValidation.EMPTY_FIELD);
		} else if(!login.getConfirmUsername().equals(login.getUsername())) {
			errors.rejectValue(CONFIRM_USERNAME_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.DO_NOT_MATCH_USERNAMES);
		}
	}

}
