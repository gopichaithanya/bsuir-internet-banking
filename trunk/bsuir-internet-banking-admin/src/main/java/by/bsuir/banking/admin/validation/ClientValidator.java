package by.bsuir.banking.admin.validation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.bsuir.banking.admin.domain.ClientWrapper;
import by.bsuir.banking.admin.domain.CurrencyTypeWrapper;

@Component
public class ClientValidator implements Validator {
	private static final String PHONE_NUMBER_PATTERN = "\\([0-9]{3}\\)[0-9]{5,7}";
	private static final String EMAIL_PATTERN = "";
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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		if (!client.getPhoneNumber().trim().matches(PHONE_NUMBER_PATTERN)) {
			errors.rejectValue("phoneNumber", MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PHONE_NUMBER_FORMAT);
		}
		if (client.getBirthdayDate() == null) {
			errors.rejectValue("birthdayDate", MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!equalOrMoreThanEighteen(client.getBirthdayDate())) {
			errors.rejectValue("birthdayDate", MessageValidation.WRONG_BIRTHDATE, MessageValidation.WRONG_BIRTHDATE);
		} else if (!lessThan120(client.getBirthdayDate())) {
			errors.rejectValue("birthdayDate", MessageValidation.WRONG_BIRTHDATE, MessageValidation.WRONG_BIRTHDATE);
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
