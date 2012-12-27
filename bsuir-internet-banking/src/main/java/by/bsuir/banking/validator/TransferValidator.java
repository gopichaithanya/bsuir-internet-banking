package by.bsuir.banking.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.bsuir.banking.domain.MoneyWrapper;
import by.bsuir.banking.domain.TransferInfo;

@Component
public class TransferValidator implements Validator {
	private final MoneyValidator moneyValidator;

	
	@Autowired
	public TransferValidator(MoneyValidator moneyValidator) {
		if (moneyValidator == null) {
			throw new IllegalArgumentException(
					"The supplied [Validator] is required and must not be null.");
		}
		if (!moneyValidator.supports(MoneyWrapper.class)) {
			throw new IllegalArgumentException(
					"The supplied [Validator] must support the validation of [MoneyWrapper] instances.");
		}
		this.moneyValidator = moneyValidator;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return TransferInfo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TransferInfo transfer = (TransferInfo) target;
		try {
			errors.pushNestedPath("amount");
			ValidationUtils.invokeValidator(this.moneyValidator,
					transfer.getAmount(), errors);
		} finally {
			errors.popNestedPath();
		}
	}
	
}
