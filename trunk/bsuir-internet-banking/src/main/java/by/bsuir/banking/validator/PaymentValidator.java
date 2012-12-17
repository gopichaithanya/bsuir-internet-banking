package by.bsuir.banking.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.bsuir.banking.domain.MoneyWrapper;
import by.bsuir.banking.domain.PaymentInfo;

@Component
public class PaymentValidator implements Validator {
	private final MoneyValidator moneyValidator;
	private static final String INFO_STRING_FIELD = "infoString";
	private static final String MOBILE_PHONE_NUMBER_PATTERN = "[2-4]{1}[3-9]{1}[1-9]{1}[0-9]{6}";
	private static final String HOME_PHONE_NUMBER_PATTERN = "[0-9]{3}[0-9]{5,6}";
	private static final String CONTRACT_NUMBER_PATTERN = "[0-9]{8,13}";
	private static final String PROVIDER_CONTRACT_NUMBER_PATTERN = "[0-9]{6,13}";
	private static final String WRONG_NUMBER_PATTERN = "0{1,}";
	
	@Autowired
	public PaymentValidator(MoneyValidator moneyValidator) {
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
		PaymentInfo payment = (PaymentInfo) target;
		
		if (payment.getLegalPerson().getCategoryId() == null){
			errors.reject(MessageValidation.NULL_VALUE, MessageValidation.APPLICATION_PROBLEM);
		} else if (payment.getInfoString() == null) {
			errors.rejectValue(INFO_STRING_FIELD, MessageValidation.NULL_VALUE, MessageValidation.EMPTY_FIELD);
		} else if (payment.getInfoString().matches(WRONG_NUMBER_PATTERN)) {
			errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.NOT_EXIST);
		} else {
			switch (payment.getLegalPerson().getCategoryId()) {
			case 2:
				// "����� ��������"
				if (!payment.getInfoString().matches(MOBILE_PHONE_NUMBER_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PHONE_NUMBER_FORMAT);
				}
				break;
			case 3:
				// "����� ���������"
				if (!payment.getInfoString().matches(CONTRACT_NUMBER_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_CONTRACT_FORMAT);
				}
				break;
			case 4:
				// "����� ������ ������" 
				if (!payment.getInfoString().matches(PROVIDER_CONTRACT_NUMBER_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_CONTRACT_FORMAT);
				}
				break;
			case 5:
				// "����� ��������"
				if (!payment.getInfoString().matches(PROVIDER_CONTRACT_NUMBER_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_CONTRACT_FORMAT);
				}
				break;
			case 6:
				// "����� ��������"
				if (!payment.getInfoString().matches(HOME_PHONE_NUMBER_PATTERN)){
					errors.rejectValue(INFO_STRING_FIELD, MessageValidation.WRONG_FORMAT, MessageValidation.WRONG_PHONE_NUMBER_FORMAT);
				}
				break;
			case 7: case 8: case 9: case 10: case 11:
				// "������� ����"
				break;
			default:
				break;
			}
		}
		try {
			errors.pushNestedPath("amount");
			ValidationUtils.invokeValidator(this.moneyValidator,
					payment.getAmount(), errors);
		} finally {
			errors.popNestedPath();
		}
	}

}