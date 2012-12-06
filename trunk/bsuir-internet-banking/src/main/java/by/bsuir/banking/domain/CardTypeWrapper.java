package by.bsuir.banking.domain;

import by.bsuir.banking.proxy.internetbanking.CardType;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;

/**
 * Wrapper for card type
 * @author Katherine
 *
 */
public class CardTypeWrapper {
	private static ObjectFactory factory = new ObjectFactory();
	private CardType type;
	
	public CardTypeWrapper(){
		type = factory.createCardType();
	}
	
	public CardTypeWrapper(CardType type){
		this.type = type;
	}
	
	public CardType getCardType(){
		return type;
	}
	
	public Integer getId(){
		return type.getId();
	}
	
	public String getName(){
		return (type.getName() == null) ? null : type.getName().getValue();
	}
}
