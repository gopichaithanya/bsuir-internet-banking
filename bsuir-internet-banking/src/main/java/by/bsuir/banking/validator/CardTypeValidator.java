package by.bsuir.banking.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.bsuir.banking.domain.CardTypeWrapper;

@Component
public class CardTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CardTypeWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		CardTypeWrapper cardType = (CardTypeWrapper) obj;
		if (cardType.getId() == null) {
			errors.reject(MessageValidation.NULL_VALUE);
		}
		if (cardType.getName() == null) {
			errors.reject(MessageValidation.NULL_VALUE);
		} else if (cardType.getName().trim().isEmpty()) {
			errors.reject(MessageValidation.EMPTY_VALUE);
		}
	}

}
