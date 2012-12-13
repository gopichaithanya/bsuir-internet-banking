package by.bsuir.banking.admin.validation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BirthdayDateValidator implements Validator {
	private static final int MIN_AGE = 18;
	private static final int MAX_AGE = 120;
	private static final Calendar today = Calendar.getInstance();
	private static final Calendar birthdate = Calendar.getInstance();
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Date.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Date date = (Date) obj;		
		if (date == null) {
			errors.reject(MessageValidation.NULL_VALUE);
		} else if (!equalOrMoreThanEighteen(date)) {
			errors.reject(MessageValidation.WRONG_BIRTHDATE);
		} else if (!lessThan120(date)) {
			errors.reject(MessageValidation.WRONG_BIRTHDATE);
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
