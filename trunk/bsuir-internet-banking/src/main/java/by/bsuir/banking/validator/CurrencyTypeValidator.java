package by.bsuir.banking.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.bsuir.banking.domain.CurrencyTypeWrapper;

@Component
public class CurrencyTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> obj) {
		return CurrencyTypeWrapper.class.equals(obj);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		CurrencyTypeWrapper currencyType = (CurrencyTypeWrapper) obj;
		if (currencyType.getShortName() == null) {
			errors.reject(MessageValidation.NULL_VALUE); 
		}
		if (currencyType.getShortName().trim().isEmpty()) {
			errors.reject(MessageValidation.EMPTY_VALUE);
		}
	}

}
