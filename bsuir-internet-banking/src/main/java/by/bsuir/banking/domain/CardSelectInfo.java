package by.bsuir.banking.domain;

import java.util.Date;

import by.bsuir.banking.admin.utils.CardUtil;

/**
 * Wrapper for client's card when we put card in the select/radio button choice
 * 
 * @author Katherine
 * 
 */
public class CardSelectInfo {
	private CardWrapper cardWrapper;
	private MoneyWrapper ballance;
	public String displayValue;

	public CardSelectInfo(CardWrapper card, MoneyWrapper ballance) {
		cardWrapper = card;
		this.ballance = ballance;
	}

	public CardWrapper getCardWrapper() {
		return cardWrapper;
	}

	public void setCardWrapper(CardWrapper card) {
		cardWrapper = card;
	}

	public MoneyWrapper getBallance() {
		return ballance;
	}

	public void setBallance(MoneyWrapper ballance) {
		this.ballance = ballance;
	}

	public String getCardNumber() {
		return cardWrapper.getCardNumber();
	}

	public void setCardNumber(String number) { 
		cardWrapper.setCardNumber(number);
	}

	public String getDisplayValue() {
		return CardUtil.changeCardNumber(cardWrapper.getCardNumber()) + ": "
				+ cardWrapper.getCardType().getName() + ", "
				+ ballance.getAmount() + " " + ballance.getCurrencyType()+ ", " + getStatus();
	}
	
	public Integer getCardId(){
		return cardWrapper.getCardId();
	}
	
	public String getCurrencyType(){
		return ballance.getCurrencyType();
	}
	
	public boolean isExpired(){
		return (new Date().compareTo(cardWrapper.getExpirationDate()) >= 0);
	}
	public String getStatus(){
		if(!isExpired()){
			return "Valid";
		}else{
			return "Expired";
		}
		
	}
}
