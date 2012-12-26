  package by.bsuir.banking.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.bsuir.banking.domain.MoneyWrapper;

@Component
public class MoneyValidator implements Validator {
	private static final String AMOUNT_FIELD = "enteredAmount";
	private static final String NUMBER_PATTERN = "[0-9]+((\\.|\\,)?[0-9]+)?";
	private static final String HUGE_NUMBER_PATTERN = "[0-9]{1,10}((\\.|\\,){1}[0-9]+){0,}";
	private static final String WRONG_NUMBER_FORMAT_PATTERN = "0{1}0+[1-9]?((\\.|\\,)?[0-9]+)?";
	private static final String ZERO_PATTERN = "(0){1}((\\.|\\,){1}[0-9]+)?";

	@Override
	public boolean supports(Class<?> clazz) {
		return MoneyWrapper.class.equals(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {
		MoneyWrapper money = (MoneyWrapper) target;
		if (money.getEnteredAmount() == null) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (money.getEnteredAmount().trim().isEmpty()) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!money.getEnteredAmount().trim().matches(NUMBER_PATTERN)) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.NULL_VALUE, MessageValidation.WRONG_NUMBER_FORMAT);
		} else if (money.getEnteredAmount().trim().matches(ZERO_PATTERN)) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.LESS_MIN_VALUE, MessageValidation.MIN_AMOUNT);
		} else if (money.getEnteredAmount().trim().matches(WRONG_NUMBER_FORMAT_PATTERN)){
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.STARTS_WITH_ZERO);
		} else if (!money.getEnteredAmount().trim().matches(HUGE_NUMBER_PATTERN)) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.HUGE_VALUE, MessageValidation.HUGE_NUMBER);
		}
	}

} 
