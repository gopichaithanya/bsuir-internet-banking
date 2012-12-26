package by.bsuir.banking.admin.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.bsuir.banking.admin.domain.PassportWrapper;

@Component
public class PassportValidator implements Validator {
	private static final String DATE_OF_EXPIRY_FIELD = "dateOfExpiry";
	private static final String DATE_OF_ISSUE_FIELD = "dateOfIssue";
	private static final String AUTHORITY_FIELD = "authority";
	private static final String NUMBER_PATTERN = "[0-9]{7}";
	private static final String SERIA_PATTERN = "[A-Za-z]{2}";
	private static final String AUTHORITY_PATTERN = "[A-Za-zР-пр-џ -]{1,}";

	@Override
	public boolean supports(Class<?> clazz) {
		return PassportWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		PassportWrapper passport = (PassportWrapper) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number",  MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seria", MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, AUTHORITY_FIELD,  MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		if(!passport.getNumber().matches(NUMBER_PATTERN)) {
			errors.rejectValue("number", MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PASSPORT_NUMBER);
		}
		if(!passport.getSeria().matches(SERIA_PATTERN)) {
			errors.rejectValue("seria", MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PASSPORT_SERIA);
		}
		if (passport.getDateOfExpiry() == null) {
			errors.rejectValue(DATE_OF_EXPIRY_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		}
		if (passport.getDateOfIssue() == null) {
			errors.rejectValue(DATE_OF_ISSUE_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		}
		if (passport.getAuthority() == null) {
			errors.rejectValue(AUTHORITY_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (passport.getAuthority().trim().isEmpty()) {
			errors.rejectValue(AUTHORITY_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!passport.getAuthority().matches(AUTHORITY_PATTERN)) {
			errors.rejectValue(AUTHORITY_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_AUTHORITY);
		}
	}

}
