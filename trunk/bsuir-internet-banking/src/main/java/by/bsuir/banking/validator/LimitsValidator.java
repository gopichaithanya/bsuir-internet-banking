package by.bsuir.banking.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.LimitsWrapper;
import by.bsuir.banking.domain.MoneyWrapper;

@Component
public class LimitsValidator implements Validator {
	private static BigDecimal maxMoneyLimit = BigDecimal.valueOf(20000000l);;
	private static final String MONEY_LIMIT_FIELD = "enteredMoneyLimit";
	private static final String OPERATIONS_LIMIT_FIELD = "enteredOperationsLimit";
	private static final String DECIMAL_PATTERN = "[0-9]+((\\.|\\,)?[0-9]+)?";
	private static final String INTEGER_PATTERN = "[0-9]+";
	private static final String HUGE_DECIMAL_PATTERN = "[0-9]{1,7}((\\.|\\,){1}[0-9]+){0,}";
	private static final String HUGE_INTEGER_PATTERN = "[0-9]{1,7}";
	
	private static final String WRONG_DECIMAL_FORMAT_PATTERN = "0{1}0+[1-9]?((\\.|\\,)?[0-9]+)?"; //contains first number == 0
//	private static final String ZERO_DECIMAL_PATTERN = "(0){1}((\\.|\\,){1}[0-9]+)?"; //numbers less than 1.0
	private static final String WRONG_INTEGER_FORMAT_PATTERN = "0{1}0+[1-9]?"; //contains first number == 0
//	private static final String ZERO_INTEGER_PATTERN = "(0){1}((\\.|\\,){1}[0-9]+)?"; //numbers less than 1.0
	
	private static final Integer MAX_OPERATIONS_LIMIT = 20;
//	private static final BigDecimal MIN_MONEY_LIMIT = BigDecimal.ONE;

	@Override
	public boolean supports(Class<?> clazz) {
		return LimitsWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LimitsWrapper limits = (LimitsWrapper) target;
		if (limits.getEnteredMoneyLimit() == null) {
			errors.rejectValue(MONEY_LIMIT_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (limits.getEnteredMoneyLimit().trim().isEmpty()) {
			limits.setEnteredMoneyLimit(limits.getMoneyLimit().toString());
			//errors.rejectValue(MONEY_LIMIT_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!limits.getEnteredMoneyLimit().trim().matches(DECIMAL_PATTERN)) {
			errors.rejectValue(MONEY_LIMIT_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_NUMBER_FORMAT);
		} else if (limits.getEnteredMoneyLimit().trim().matches(WRONG_DECIMAL_FORMAT_PATTERN)) {
			errors.rejectValue(MONEY_LIMIT_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.STARTS_WITH_ZERO);
		} else if (!limits.getEnteredMoneyLimit().trim().matches(HUGE_DECIMAL_PATTERN)) {
			errors.rejectValue(MONEY_LIMIT_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.HUGE_VALUE);
		} else {
			BigDecimal moneyLimit = BigDecimal.valueOf(Double.valueOf(limits.getEnteredMoneyLimit().trim()));
			if (limits.getCurrencyTypeId() != null){
				maxMoneyLimit = getMoneyLimit(limits.getCurrencyTypeId());
			}
			if (moneyLimit.compareTo(BigDecimal.ONE) < 0) {
				errors.rejectValue(MONEY_LIMIT_FIELD, MessageValidation.LESS_MIN_VALUE, MessageValidation.MIN_VALUE);
			} else if (moneyLimit.compareTo(maxMoneyLimit) > 0) {
				errors.rejectValue(MONEY_LIMIT_FIELD, MessageValidation.MORE_MAX_VALUE, MessageValidation.MAX_AMOUNT);
			}
		}
		
		if (limits.getEnteredOperationsLimit() == null) {
			errors.rejectValue(OPERATIONS_LIMIT_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (limits.getEnteredOperationsLimit().trim().isEmpty()) {
			limits.setEnteredOperationsLimit(limits.getOperationsLimit().toString());
			//errors.rejectValue(OPERATIONS_LIMIT_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!limits.getEnteredOperationsLimit().trim().matches(INTEGER_PATTERN)) {
			errors.rejectValue(OPERATIONS_LIMIT_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_INTEGER_FORMAT);
		} else if (limits.getEnteredOperationsLimit().trim().matches(WRONG_INTEGER_FORMAT_PATTERN)) {
			errors.rejectValue(OPERATIONS_LIMIT_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.STARTS_WITH_ZERO);
		} else if (!limits.getEnteredOperationsLimit().trim().matches(HUGE_INTEGER_PATTERN)) {
			errors.rejectValue(OPERATIONS_LIMIT_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.HUGE_VALUE);
		} else {
			Integer operationsLimit = Integer.valueOf(limits.getEnteredOperationsLimit().trim());
			if (operationsLimit < 1) {
				errors.rejectValue(OPERATIONS_LIMIT_FIELD, MessageValidation.LESS_MIN_VALUE, MessageValidation.MIN_VALUE);
			} else if (operationsLimit > MAX_OPERATIONS_LIMIT) {
				errors.rejectValue(OPERATIONS_LIMIT_FIELD, MessageValidation.MORE_MAX_VALUE, MessageValidation.MAX_VALUE);
			}
		}
	}
	
	private BigDecimal getMoneyLimit(Integer currencyTypeId) {
		// TODO generate limit based on card type and currency type
		BigDecimal sum = null;
		switch (currencyTypeId) {
		case 1://BYR
			sum = new BigDecimal("20000000");
			break;
		case 2://USD
			sum = new BigDecimal("2000");
			break;
		case 3://EUR
			sum=new BigDecimal("2000");
			break;
		case 4://RUR
			sum=new BigDecimal("60000");
			break;
		default:
			break;
		}
		return sum;
	}

}
