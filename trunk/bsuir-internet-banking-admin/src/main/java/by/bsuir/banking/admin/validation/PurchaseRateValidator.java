package by.bsuir.banking.admin.validation;

import java.math.BigDecimal;

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
		if(purchaseRate.getRate() == null) {
			errors.rejectValue("rate", MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (purchaseRate.getRate().compareTo(BigDecimal.ZERO)< 1) {
			errors.rejectValue("rate", MessageValidation.NEGATIVE_OR_ZERO_VALUE, MessageValidation.NEGATIVE_FIELD);
		}
		try {
            errors.pushNestedPath("currencyType");
            ValidationUtils.invokeValidator(this.currencyTypeValidator, purchaseRate.getCurrencyType(), errors);
        } finally {
            errors.popNestedPath();
        }
	}

}
