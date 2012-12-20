package by.bsuir.banking.admin.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import by.bsuir.banking.domain.CardTypeWrapper;
import by.bsuir.banking.domain.CardWrapper;
import by.bsuir.banking.domain.CurrencyTypeWrapper;
import by.bsuir.banking.proxy.internetbanking.ArrayOfCardType;
import by.bsuir.banking.proxy.internetbanking.ArrayOfCurrencyType;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.CardType;
import by.bsuir.banking.proxy.internetbanking.CurrencyType;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingService;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetAllCardTypesDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage;
import by.bsuir.banking.proxy.internetbanking.IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage;

public class CardUtil {

	private static IInternetBankingService service = ServiceProvider
			.getInternetBankingService();
	private static List<CardTypeWrapper> cardTypes = null;
	private static List<CurrencyTypeWrapper> currencyTypes = null;
	private static List<CardWrapper> cards = null;

	public static Date getExpirationDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, 1);
		return calendar.getTime();
	}

	public static Integer getOperationsLimit(CardTypeWrapper cardTypeWrapper) {
		// TODO generate limit based on card type
		return 10;
	}

	public static BigDecimal getMoneyLimit(CardTypeWrapper cardTypeWrapper) {
		// TODO generate limit based on card type and currency type
		return new BigDecimal("100000");
	}

	public static CardTypeWrapper getCardType(Integer cardTypeId,
			String securityToken)
			throws IInternetBankingServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllCardTypesDomainFaultFaultFaultMessage {
		for (CardTypeWrapper wrapper : getCardTypes(securityToken)) {
			if (wrapper.getId() == cardTypeId) {
				return wrapper;
			}
		}
		return null;
	}

	public static List<CardTypeWrapper> getCardTypes(String securityToken)
			throws IInternetBankingServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetAllCardTypesDomainFaultFaultFaultMessage {
		cardTypes = new ArrayList<CardTypeWrapper>();
		ArrayOfCardType cardArr = service.getAllCardTypes(securityToken);
		for (CardType cardType : cardArr.getCardType()) {
			cardTypes.add(new CardTypeWrapper(cardType));
		}
		return cardTypes;
	}

	public static List<CurrencyTypeWrapper> getCurrencyTypes()
			throws IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage {
		currencyTypes = new ArrayList<CurrencyTypeWrapper>();
		ArrayOfCurrencyType curArr = service.getCurrencyTypes();
		for (CurrencyType curType : curArr.getCurrencyType()) {
			currencyTypes.add(new CurrencyTypeWrapper(curType));
		}
		return currencyTypes;
	}

	public static CurrencyTypeWrapper getCurrencyTypeById(Integer id)
			throws IInternetBankingServiceGetCurrencyTypesDomainFaultFaultFaultMessage {
		for (CurrencyTypeWrapper curType : getCurrencyTypes()) {
			if (curType.getCurrencyType().getId() == id) {
				return curType;
			}
		}
		return null;
	}

	public static String changeCardNumber(String cardNumber) {
		return cardNumber.substring(0, 4) + "XXXXXXXX"
				+ cardNumber.substring(12, 16);
	}

	public static List<CardWrapper> getCards(String securityToken)
			throws IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage {
		cards = new ArrayList<CardWrapper>();
		for (Card card : service.getCards(securityToken).getCard()) {
			cards.add(new CardWrapper(card));
		}
		return cards;
	}

	public static CardWrapper getCardByAccountId(Integer id,
			String securityToken)
			throws IInternetBankingServiceGetCardsAuthorizationFaultFaultFaultMessage,
			IInternetBankingServiceGetCardsDomainFaultFaultFaultMessage {
		for (CardWrapper card : getCards(securityToken)) {
			if (card.getCardsAccountId() == id) {
				return card;
			}
		}
		return null;
	}

 }
