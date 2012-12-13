package by.bsuir.banking.admin.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.bsuir.banking.admin.domain.PassportWrapper;

@Component
public class PassportValidator implements Validator {
	
	private static final String NUMBER_PATTERN = "[0-9]{7}";
	private static final String SERIA_PATTERN = "[A-Za-z]{2}";

	@Override
	public boolean supports(Class<?> clazz) {
		return PassportWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		PassportWrapper passport = (PassportWrapper) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number",  MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seria", MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "authority",  MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		if(!passport.getNumber().matches(NUMBER_PATTERN)) {
			errors.rejectValue("number", MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PHONE_NUMBER_FORMAT);
		}
		if(!passport.getSeria().matches(SERIA_PATTERN)) {
			errors.rejectValue("seria", MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PASSPORT_SERIA);
		}
	}

}
