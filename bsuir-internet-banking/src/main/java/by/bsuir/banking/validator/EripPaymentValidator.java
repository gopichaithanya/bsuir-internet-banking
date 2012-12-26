 package by.bsuir.banking.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.bsuir.banking.domain.MoneyWrapper;
import by.bsuir.banking.domain.PaymentInfo;

@Component
public class EripPaymentValidator implements Validator {
	private final MoneyValidator moneyValidator;
	private static final String INFO_STRING_FIELD = "infoString";
	private static final String MOBILE_PHONE_NUMBER_PATTERN = "[0-9]{3}[0-9]{7}";
	private static final String HOME_PHONE_NUMBER_PATTERN = "[0-9]{3}[0-9]{5,6}";
	private static final String CONTRACT_NUMBER_PATTERN = "[0-9]{8,13}";
	private static final String PROVIDER_CONTRACT_NUMBER_PATTERN = "[0-9]{6,13}";
	private static final String WRONG_NUMBER_PATTERN = "0{1,}";
	private static final String PERSANAL_ACCOUNT_PATTERN = "[0-3]{9,13}";

	@Autowired
	public EripPaymentValidator(MoneyValidator moneyValidator) {
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
		return PaymentInfo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PaymentInfo erip = (PaymentInfo) target;
		if (erip.getInfoString() == null) {
			errors.rejectValue(INFO_STRING_FIELD, MessageValidation.NULL_VALUE,
					MessageValidation.EMPTY_FIELD);
		} else if (erip.getInfoString().trim().isEmpty()) {
			errors.rejectValue(INFO_STRING_FIELD, MessageValidation.EMPTY_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (erip.getInfoString().trim().matches(WRONG_NUMBER_PATTERN)) {
			errors.rejectValue(INFO_STRING_FIELD,
					MessageValidation.WRONG_FORMAT, MessageValidation.NOT_EXIST);
		} else {
			switch (erip.getErip().getId()) {
			case 4:
				//label = ". Не менее 6 цифр.";
				if (!erip.getInfoString().trim().matches(PROVIDER_CONTRACT_NUMBER_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_CONTRACT_FORMAT);
				}
				break;
			case 1:
			case 2:
			case 3:
			case 5:
			case 6:
				//label = ". В формате yyyxxxxxxx, где y - код.";
				if (!erip.getInfoString().trim().matches(MOBILE_PHONE_NUMBER_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PHONE_NUMBER_FORMAT);
				}
				break;
			case 7:
				//label = ". В формате yyyxxxxx, где y - код.";
				if (!erip.getInfoString().trim().matches(HOME_PHONE_NUMBER_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PHONE_NUMBER_FORMAT);
				}
				break;
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				//label = ". Не менее 9 цифр.";
				if (!erip.getInfoString().trim().matches(PERSANAL_ACCOUNT_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PERSONAL_ACCOUNT_FORMAT);
				}
				break;
			case 13:
			case 14:
				//label = ". Не менее 6 цифр.";
				if (!erip.getInfoString().trim().matches(PROVIDER_CONTRACT_NUMBER_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_CONTRACT_FORMAT);
				}
				break;
			case 15:
				//label = ". Не менее 9 цифр.";
				if (!erip.getInfoString().trim().matches(PERSANAL_ACCOUNT_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PERSONAL_ACCOUNT_FORMAT);
				}
				break;
			case 16:
			case 17:
				//label = ". Не менее 6 цифр.";
				if (!erip.getInfoString().trim().matches(PROVIDER_CONTRACT_NUMBER_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_CONTRACT_FORMAT);
				}
				break;
			case 18:
			case 19:
				//label = ". Не менее 8 цифр.";
				if (!erip.getInfoString().trim().matches(PROVIDER_CONTRACT_NUMBER_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_CONTRACT_FORMAT);
				}
				break;
			default:
				break;
			}
			
		}
		try {
			errors.pushNestedPath("amount");
			ValidationUtils.invokeValidator(this.moneyValidator,
					erip.getAmount(), errors);
		} finally {
			errors.popNestedPath();
		}
	}

}
