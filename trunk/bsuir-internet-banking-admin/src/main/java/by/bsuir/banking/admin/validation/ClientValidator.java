package by.bsuir.banking.admin.validation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.bsuir.banking.admin.domain.ClientWrapper;

@Component
public class ClientValidator implements Validator {
	private static final String FIRST_NAME_FIELD = "firstName";
	private static final String LAST_NAME_FIELD = "lastName";
	private static final String MIDDLE_NAME_FIELD = "middleName";
	private static final String PHONE_NUMBER_PATTERN = "[0-9]{8,10}";
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String NAME_PATTERN = "[A-Za-zÀ-ÿà-ÿ]{1,30}";
	private static final int MIN_AGE = 18;
	private static final int MAX_AGE = 120;
	private static final Calendar today = Calendar.getInstance();
	private static final Calendar birthdate = Calendar.getInstance();
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ClientWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ClientWrapper client = (ClientWrapper) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		if (client.getFirstName() == null) {
			errors.rejectValue(FIRST_NAME_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (client.getFirstName().isEmpty()) {
			errors.rejectValue(FIRST_NAME_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!client.getFirstName().matches(NAME_PATTERN)) {
			errors.rejectValue(FIRST_NAME_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_NAME);
		}
		if (client.getLastName() == null) {
			errors.rejectValue(LAST_NAME_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (client.getLastName().isEmpty()) {
			errors.rejectValue(LAST_NAME_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!client.getLastName().matches(NAME_PATTERN)) {
			errors.rejectValue(LAST_NAME_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_NAME);
		}
		if (client.getMiddleName() != null && !client.getMiddleName().isEmpty() && !client.getMiddleName().matches(NAME_PATTERN)) {
			errors.rejectValue(MIDDLE_NAME_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_NAME);
		}
		if (client.getPhoneNumber() == null) {
			errors.rejectValue("phoneNumber", MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (client.getPhoneNumber().trim().isEmpty()){
			errors.rejectValue("phoneNumber", MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!client.getPhoneNumber().trim().matches(PHONE_NUMBER_PATTERN)) {
			errors.rejectValue("phoneNumber", MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PHONE_NUMBER_FORMAT);
		}
		if (client.getBirthdayDate() == null) {
			errors.rejectValue("birthdayDate", "methodInvocation", MessageValidation.EMPTY_FIELD);
		} else if (!equalOrMoreThanEighteen(client.getBirthdayDate())) {
			errors.rejectValue("birthdayDate", MessageValidation.WRONG_BIRTHDATE, MessageValidation.WRONG_BIRTHDATE);
		} else if (!lessThan120(client.getBirthdayDate())) {
			errors.rejectValue("birthdayDate", MessageValidation.WRONG_BIRTHDATE, MessageValidation.WRONG_BIRTHDATE);
		}
		if (client.getEmail() == null) {
			errors.rejectValue("email", MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (client.getEmail().trim().isEmpty()){
			errors.rejectValue("email", MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!client.getEmail().trim().matches(EMAIL_PATTERN)) {
			errors.rejectValue("email", MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_EMAIL_ADDRESS_FORMAT);
		}

	}
	
	private boolean equalOrMoreThanEighteen (Date date) {
		if (differenceBetweenYears(date) > MIN_AGE) {
			return true;
		}
			else if (differenceBetweenYears(date) == MIN_AGE & differenceBetweenDays(date) >= 0) {
				return true;
		} else { 
			return false;
			}
	}
	
	private boolean lessThan120 (Date date) {
		if (differenceBetweenYears(date) < MAX_AGE) {
			return true;
		} else if ((differenceBetweenYears(date) == MAX_AGE & differenceBetweenDays(date) > 0)) {
			return true;
		} else { 
			return false;
			}
	}
	
	private int differenceBetweenYears (Date date) {
		today.getTime();
		birthdate.setTime(date);
		return today.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR);
	}
	
	private int differenceBetweenDays (Date date) {
		today.getTime();
		birthdate.setTime(date);
		return today.get(Calendar.DAY_OF_YEAR) - birthdate.get(Calendar.DAY_OF_YEAR);
	}

}
