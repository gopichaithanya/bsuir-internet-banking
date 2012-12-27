package by.bsuir.banking.validator;
/**
 * 
 * @author Svetlana
 *
 */

public class MessageValidation {
	
	public static final String NULL_VALUE = "nullValue";
	public static final String NEGATIVE_VALUE = "negativeValue";
	public static final String LESS_MIN_VALUE = "minValue";
	public static final String EMPTY_VALUE = "emptyValue";
	public static final String WRONG_FORMAT = "wrongFormat";
	public static final String WRONG_BIRTHDATE = "wrongBirhdate";
	public static final String NEGATIVE_OR_ZERO_VALUE = "negativeValue";
	public static final String HUGE_VALUE = "hugeNumber";
	public static final String MORE_MAX_VALUE = "maxValue";
	
	public static final String EMPTY_FIELD = "Пустое поле";
	public static final String MIN_AMOUNT = "Минимальная сумма 1.00 бел. рубль";
	public static final String WRONG_HOME_PHONE_NUMBER_FORMAT = "Неверный формат. Формат для номера телефона yyyxxxxx[xx]. yyy - код";
	public static final String WRONG_PHONE_NUMBER_FORMAT = "Неверный формат. Формат для номера телефона yyyxxxxxxx. yyy - код";
	public static final String WRONG_PASSPORT_NUMBER = "номер телефона не более 7 цифр";
	public static final String APPLICATION_PROBLEM = "К сожалению, не можем выполнить данную операцию. Повторите позже";
	public static final String WRONG_CONTRACT_FORMAT = "Неверный номер договора";
	public static final String NOT_EXIST = "Не существует данного номера";
	public static final String WRONG_NUMBER_FORMAT = "Неверный формат. Поле суммы может содержать только числа, без знаков +/-";
	public static final String HUGE_NUMBER = "Слишком большое значение";
	public static final String STARTS_WITH_ZERO = "Значение суммы не может начинатся с нуля";
	public static final String WRONG_INTEGER_FORMAT = "Может содержать только целые числа без знаков +/-";
	public static final String MIN_VALUE = "Минимальное значение 1";
	public static final String MAX_AMOUNT = "Максимальное значение 20 000 000 бел. рублей (или эквивалентной суммы в другой валюте)";
	public static final String MAX_VALUE = "Максимальное значение 20";
	public static final String WRONG_USERNAME = "Имя пользователя должно содержать не менее 3 и не более 15 символов(только латинские буквы, цифры, знак _ или -)";
	public static final String DO_NOT_MATCH_USERNAMES = "Новое и подтвержденное имя пользователя не совпадают";
	public static final String WRONG_PASSWORD = "Пароль должен содержать не менее 6 и не более 20, среди которых должна быть ОБЯЗАТЕЛЬНО хотя бы одна цифра и заглавная буква";
	public static final String DO_NOT_MATCH_PASSWORD = "Новый пароль и подтвержденный пароль не совпадают";
	public static final String WRONG_PERSONAL_ACCOUNT_FORMAT = "Неверный номер(9-13 цифр)";
	public static final String WRONG_WEB_WALLET_NUMBER = "Неверный номер веб-кошелька(первая латинская буква и 12 цифр)";
	

}
