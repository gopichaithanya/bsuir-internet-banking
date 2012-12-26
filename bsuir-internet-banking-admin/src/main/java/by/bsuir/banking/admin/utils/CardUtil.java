package by.bsuir.banking.admin.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import by.bsuir.banking.admin.domain.CardTypeWrapper;
import by.bsuir.banking.admin.domain.CurrencyTypeWrapper;
import by.bsuir.banking.proxy.internetbanking.ArrayOfCardType;
import by.bsuir.banking.proxy.internetbanking.ArrayOfCurrencyType;
import by.bsuir.banking.proxy.internetbanking.CardType;
import by.bsuir.banking.proxy.internetbanking.CurrencyType;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllCardTypesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage;

public class CardUtil {

	private static IInternetBankingService service = ServiceProvider
			.getInternetBankingInstance();
	private static List<CardTypeWrapper> cardTypes = null;
	private static List<CurrencyTypeWrapper> currencyTypes = null;

	public static Date getExpirationDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, 1);
		return calendar.getTime();
	}

	public static Integer getOperationsLimit(Integer currencyTypeId) {
		// TODO generate limit based on currency type
		if(currencyTypeId != 1){
			return 10;
		}
		return 20;
	}

	public static BigDecimal getMoneyLimit(Integer currencyTypeId) {
		// TODO generate limit based on card type and currency type
		BigDecimal sum = null;
		switch (currencyTypeId) {
		case 1://BYR
			sum = new BigDecimal("10000000");
			break;
		case 2://USD
			sum = new BigDecimal("1000");
			break;
		case 3://EUR
			sum=new BigDecimal("1000");
			break;
		case 4://RUR
			sum=new BigDecimal("30000");
			break;
		default:
			break;
		}
		return sum;
	}

	public static CardTypeWrapper getCardType(Integer cardTypeId, String securityToken) throws IInternetBankingServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage, IInternetBankingServiceGetAllCardTypesDomainFaultFaultFaultMessage {
		for(CardTypeWrapper wrapper: getCardTypes(securityToken)){
			if(wrapper.getId() == cardTypeId){
				return wrapper;
			}
		}
		return null;
	}

	public static List<CardTypeWrapper> getCardTypes(String securityToken)
			throws IInternetBankingServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllCardTypesDomainFaultFaultFaultMessage {
		if (cardTypes == null || cardTypes.size() == 0) {
			cardTypes = new ArrayList<CardTypeWrapper>();
			ArrayOfCardType cardArr = service.getAllCardTypes(securityToken);
			for (CardType cardType : cardArr.getCardType()) {
				cardTypes.add(new CardTypeWrapper(cardType));
			}
		}
		return cardTypes;
	}

	public static List<CurrencyTypeWrapper> getCurrencyTypes()
			throws IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage {
		if (currencyTypes == null || currencyTypes.size() == 0) {
			currencyTypes = new ArrayList<CurrencyTypeWrapper>();
			ArrayOfCurrencyType curArr = service.getCurrencyTypes();
			for (CurrencyType curType : curArr.getCurrencyType()) {
				currencyTypes.add(new CurrencyTypeWrapper(curType));
			}
		}
		return currencyTypes;
	}
	
	public static String changeCardNumber(String cardNumber){
		return cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12, 16);
	}

}
