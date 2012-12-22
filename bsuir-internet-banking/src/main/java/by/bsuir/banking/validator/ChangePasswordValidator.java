package by.bsuir.banking.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.bsuir.banking.domain.ChangePasswordWrapper;

@Component
public class ChangePasswordValidator implements Validator {
	private final static String PASSWORD_FIELD = "password";
	private final static String CONFIRM_PASSWORD_FIELD = "confirmPassword";
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";

	@Override
	public boolean supports(Class<?> clazz) {
		return ChangePasswordWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ChangePasswordWrapper password = (ChangePasswordWrapper) target;
		if (password.getPassword() == null) {
			errors.rejectValue(PASSWORD_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (password.getPassword().isEmpty()) {
			errors.rejectValue(PASSWORD_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!password.getPassword().matches(PASSWORD_PATTERN)) {
			errors.rejectValue(PASSWORD_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PASSWORD);
		}
		if (password.getConfirmPassword() == null){
			errors.rejectValue(CONFIRM_PASSWORD_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (password.getConfirmPassword().isEmpty()) {
			errors.rejectValue(CONFIRM_PASSWORD_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!password.getPassword().equals(password.getConfirmPassword())) {
			errors.rejectValue(CONFIRM_PASSWORD_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.DO_NOT_MATCH_PASSWORD);
		}
	}

}
