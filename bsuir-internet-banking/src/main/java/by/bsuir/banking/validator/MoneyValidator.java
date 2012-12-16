package by.bsuir.banking.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.bsuir.banking.domain.MoneyWrapper;

@Component
public class MoneyValidator implements Validator {
	private static final String AMOUNT_FIELD = "amount";

	@Override
	public boolean supports(Class<?> clazz) {
		return MoneyWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MoneyWrapper money = (MoneyWrapper) target;
		if (money.getAmount() == null) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_VALUE);
		} else if (money.getAmount().compareTo(BigDecimal.ZERO) < 0) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.NEGATIVE_VALUE, MessageValidation.NEGATIVE_FIELD);
		} else if (money.getAmount().compareTo(BigDecimal.ONE) < 0) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.LESS_MIN_VALUE, MessageValidation.MIN_AMOUNT);
		}
	}

}
