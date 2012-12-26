 package by.bsuir.banking.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import by.bsuir.banking.admin.utils.CardUtil;
import by.bsuir.banking.proxy.internetbanking.Card;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;

/**
 * 
 * @author Svetlana
 *
 */
public class CardWrapper {
	private static ObjectFactory factory = new ObjectFactory();
	private Card card;
	
	public CardWrapper() {
		card = factory.createCard();
	}
	
	public CardWrapper(Card card) {
		this.card = card;
	}
	
	public Card getCard() {
		return card;
	}
	
	public Integer getCardsAccountId(){
		return card.getAccountId();
	}
	
	public void setCardsAccountId(Integer id){
		card.setAccountId(id);
	}
	
	public CardTypeWrapper getCardType(){
		return(card.getCardType() == null) ? null : new CardTypeWrapper(card.getCardType().getValue());
	}
	
	public void setCardtype(CardTypeWrapper value){
		card.setCardType(factory.createCardCardType(value.getCardType()));
	}
	
	public Integer getCardTypeId(){
		return card.getCardTypeId();
	}
	
	public void setCardTypeId(Integer id){
		card.setCardTypeId(id);
	}
	
	public Integer getCardId(){
		return card.getId();
	}
	
	
	public void setLocked(Boolean value){
		card.setIsLocked(value);
	}
	
	public BigDecimal getMoneyLimit(){
		return card.getMoneyLimit();
	}
	
	public void setMoneyLimit(BigDecimal value){
		card.setMoneyLimit(value);
	}
	
	public String getCardNumber(){
		return (card.getNumber() == null) ? null : card.getNumber().getValue();
	}
	
	public void setCardNumber(String value){
		card.setNumber(factory.createCardNumber(value));
	}
	
	public Integer getOperationsLimit(){
		return card.getOperationsLimit();
	}
	
	public void setOperationsLimit(Integer value){
		card.setOperationsLimit(value);
	}
	
	public String getSecretWord(){
		return (card.getSecretWord() == null) ? null : card.getSecretWord().getValue();
	}
	
	public void setSecretWord(String value){
		card.setSecretWord(factory.createCardSecretWord(value));
	}
	
	public String getCVV2(){
		return(card.getCVV2() == null) ?  null: card.getCVV2().getValue();
	}
	
	public void setCVV2(String value){
		card.setCVV2(factory.createCardCVV2(value));
	}
	
	public Date getExpirationDate(){
		return (card.getExpirationDate() == null) ? null : card.getExpirationDate().toGregorianCalendar().getTime();
	}
	
	public void setExpirationDate(Date value) throws DatatypeConfigurationException{
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(value);
		card.setExpirationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
	}
	
	public String getHiddenNumber(){
		return CardUtil.changeCardNumber(getCardNumber());
	}
	
	public boolean isExpired(){
		return (new Date().compareTo(getExpirationDate()) >= 0);
	}
	public String getStatus(){
		if(!isExpired()){
			return "Valid";
		}else{
			return "Expired";
		}
		
	}
	
	public boolean isLocked(){
		return card.isIsLocked();
	}

}
