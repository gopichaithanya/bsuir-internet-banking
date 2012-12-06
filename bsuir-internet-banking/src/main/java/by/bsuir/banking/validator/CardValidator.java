package by.bsuir.banking.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.bsuir.banking.domain.CardTypeWrapper;
import by.bsuir.banking.domain.CardWrapper;

@Component
public class CardValidator implements Validator {
	private final CardTypeValidator cardTypeValidator;
	
	@Autowired
	public CardValidator(CardTypeValidator cardTypeValidator) {
		if (cardTypeValidator == null) {
			throw new IllegalArgumentException(
					"The supplied [Validator] is required and must not be null.");
		}
		if (!cardTypeValidator.supports(CardTypeWrapper.class)) {
			throw new IllegalArgumentException(
					"The supplied [Validator] must support the validation of [CurrencyTypeWrapper] instances.");
		}
		this.cardTypeValidator = cardTypeValidator;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CardWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		CardWrapper card = (CardWrapper) obj;
		if (card.getCardId() == null) {
			errors.reject(MessageValidation.NULL_VALUE);
		}
		if (card.getCardsAccountId() == null) {
			errors.reject(MessageValidation.NULL_VALUE);
		}
		if (card.getCardTypeId() == null) {
			errors.reject(MessageValidation.NULL_VALUE);
		}
	}

}
