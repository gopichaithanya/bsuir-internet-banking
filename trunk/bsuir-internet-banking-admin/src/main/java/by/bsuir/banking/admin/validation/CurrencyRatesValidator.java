package by.bsuir.banking.admin.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.bsuir.banking.admin.domain.CurrencyRatesWrapper;
import by.bsuir.banking.admin.domain.CurrencyTypeWrapper;
import by.bsuir.banking.admin.domain.PurchaseRateWrapper;
import by.bsuir.banking.admin.domain.SellRateWrapper;

@Component
public class CurrencyRatesValidator implements Validator {
	private final SellRateValidator sellRateValidator;
	private final PurchaseRateValidator purchaseRateValidator;
	
	@Autowired
	public CurrencyRatesValidator(PurchaseRateValidator purchaseRateValidator, SellRateValidator sellRateValidator){
		if (sellRateValidator == null) {
            throw new IllegalArgumentException(
              "The supplied [SellRateValidator] is required and must not be null.");
        }
        if (!sellRateValidator.supports(SellRateWrapper.class)) {
            throw new IllegalArgumentException(
              "The supplied [Validator] must support the validation of [SellRateWrapper] instances.");
        }
		this.sellRateValidator = sellRateValidator;
		if (purchaseRateValidator == null) {
            throw new IllegalArgumentException(
              "The supplied [purchaseRateValidator] is required and must not be null.");
        }
        if (!purchaseRateValidator.supports(PurchaseRateWrapper.class)) {
            throw new IllegalArgumentException(
              "The supplied [Validator] must support the validation of [SellRateWrapper] instances.");
        }
		this.purchaseRateValidator = purchaseRateValidator;
	}
	

	@Override
	public boolean supports(Class<?> clazz) {
		return CurrencyRatesWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		CurrencyRatesWrapper rates = (CurrencyRatesWrapper) obj;
		ValidationUtils.rejectIfEmpty(errors, "purchaseRates", MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		int i=0;
		for (SellRateWrapper sellRate : rates.getSellRates()) {
			errors.pushNestedPath("sellRates["+i+"]");
			ValidationUtils.invokeValidator(this.sellRateValidator, sellRate, errors);
			errors.popNestedPath();
			i++;
		}
		i = 0;
		for (PurchaseRateWrapper purchaseRate : rates.getPurchaseRates()) {
			errors.pushNestedPath("purchaseRates[" + i + "]");
			ValidationUtils.invokeValidator(this.purchaseRateValidator, purchaseRate, errors);
			errors.popNestedPath();
			i++;
		}
	}

}
