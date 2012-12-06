 package by.bsuir.banking.validator;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.bsuir.banking.domain.CurrencyTypeWrapper;
import by.bsuir.banking.domain.SellRateWrapper;

@Component
public class SellRateValidator implements Validator {
	
	
	private final  CurrencyTypeValidator currencyTypeValidator;
	@Autowired
	public SellRateValidator(CurrencyTypeValidator currencyTypeValidator) {
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
	public boolean supports(Class clazz) {
		return SellRateWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		SellRateWrapper sellRate = (SellRateWrapper) obj;
		if (sellRate.getId() == null) {
			errors.reject(MessageValidation.NULL_VALUE);
		}
		if (sellRate.getRate() == null) {
			errors.reject(MessageValidation.NULL_VALUE);
		} else if (sellRate.getRate().compareTo(BigDecimal.ZERO)< 1) {
			errors.reject(MessageValidation.NEGATIVE_OR_ZERO_VALUE);
		}
		try {
            errors.pushNestedPath("currencyType");
            ValidationUtils.invokeValidator(this.currencyTypeValidator, sellRate.getCurrencyType(), errors);
        } finally {
            errors.popNestedPath();
        }
	}

}
