package by.bsuir.banking.admin.validation;

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
	private final BirthdayDateValidator dateValidator;
	private static final String PHONE_NUMBER_PATTERN = "\\([0-9]{3}\\)[0-9]{5,7}";
	private static final String EMAIL_PATTERN = "";
	
	@Autowired
	public ClientValidator(BirthdayDateValidator dateValidator) {
		if (dateValidator == null) {
			System.out.println("nnnnnnnnn!!!!!!!!!!!!!!!!!!!!!!");
            throw new IllegalArgumentException(
              "The supplied [Validator] is required and must not be null.");
            
        }
        if (!dateValidator.supports(Date.class)) {
            throw new IllegalArgumentException(
              "The supplied [Validator] must support the validation of [Date] instances.");
        }
		this.dateValidator = dateValidator;
	}

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
		try {
            errors.pushNestedPath("birthdayDate");
            ValidationUtils.invokeValidator(this.dateValidator, client.getBirthdayDate(), errors);
        } finally {
            errors.popNestedPath();
        }
	}

}
