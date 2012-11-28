package by.bsuir.banking.validator;

import java.util.Date;

import org.springframework.validation.*;



public class DateValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Date.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "format error", null);
		
	}

}
