package by.bsuir.banking.admin.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.bsuir.banking.admin.domain.CardTypeWrapper;

@Component
public class CardTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CardTypeWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		CardTypeWrapper cardType = (CardTypeWrapper) obj;
		ValidationUtils.rejectIfEmpty(errors, "id", MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		ValidationUtils.rejectIfEmpty(errors, "name", MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
	}

}
