package by.bsuir.banking.admin.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.bsuir.banking.admin.domain.CurrencyTypeWrapper;
import by.bsuir.banking.admin.domain.PurchaseRateWrapper;
import by.bsuir.banking.admin.validation.MessageValidation;

@Component
public class PurchaseRateValidator implements Validator {

	private final CurrencyTypeValidator currencyTypeValidator;
	private static final String AMOUNT_FIELD = "amount";
	private static final String NUMBER_PATTERN = "[0-9]+((\\.|\\,)?[0-9]+)?";
	private static final String HUGE_NUMBER_PATTERN = "[0-9]{1,10}((\\.|\\,){1}[0-9]+){0,}";
	private static final String WRONG_NUMBER_FORMAT_PATTERN = "0{1}0+[1-9]?((\\.|\\,)?[0-9]+)?";
	private static final String ZERO_PATTERN = "(0){1}((\\.|\\,){1}(0)+)?";
	
	@Autowired
	public PurchaseRateValidator(CurrencyTypeValidator currencyTypeValidator) {
		if (currencyTypeValidator == null) {
			throw new IllegalArgumentException(
					"The supplied [Validator] is required and must not be null.");
		}
		if (!currencyTypeValidator.supports(CurrencyTypeWrapper.class)) {
			throw new IllegalArgumentException(
					"The supplied [Validator] must support the validation of [CurrencyTypeWrapper] instances.");
		}
		this.currencyTypeValidator = currencyTypeValidator;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseRateWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		PurchaseRateWrapper purchaseRate = (PurchaseRateWrapper) obj;
		//ValidationUtils.rejectIfEmpty(errors, "rate", MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		if (purchaseRate.getId() == null) {
			errors.rejectValue("id",MessageValidation.NULL_VALUE, "problem with database?");
		}
		if (purchaseRate.getAmount() == null) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (purchaseRate.getAmount().trim().isEmpty()) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (!purchaseRate.getAmount().trim().matches(NUMBER_PATTERN)) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.NULL_VALUE, MessageValidation.WRONG_RATE_FORMAT);
		} else if (purchaseRate.getAmount().trim().matches(ZERO_PATTERN)) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.ZERO_VALUE, MessageValidation.ZERO_VALUE);
		} else if (purchaseRate.getAmount().trim().matches(WRONG_NUMBER_FORMAT_PATTERN)){
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_NUMBER_FORMAT);
		} else if (!purchaseRate.getAmount().trim().matches(HUGE_NUMBER_PATTERN)) {
			errors.rejectValue(AMOUNT_FIELD, MessageValidation.HUGE_VALUE, MessageValidation.HUGE_NUMBER);
		}
//		if(purchaseRate.getRate() == null) {
//			errors.rejectValue("rate", MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
//		} else if (purchaseRate.getRate().compareTo(BigDecimal.ZERO)< 1) {
//			errors.rejectValue("rate", MessageValidation.NEGATIVE_OR_ZERO_VALUE, MessageValidation.NEGATIVE_FIELD);
//		}
		try {
            errors.pushNestedPath("currencyType");
            ValidationUtils.invokeValidator(this.currencyTypeValidator, purchaseRate.getCurrencyType(), errors);
        } finally {
            errors.popNestedPath();
        }
	}

}
