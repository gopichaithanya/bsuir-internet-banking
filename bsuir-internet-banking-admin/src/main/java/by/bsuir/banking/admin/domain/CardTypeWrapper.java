package by.bsuir.banking.admin.domain;

import by.bsuir.banking.proxy.card.CardType;
import by.bsuir.banking.proxy.card.ObjectFactory;

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
	
	public Integer getId(){
		return type.getId();
	}
	
	public String getName(){
		return (type.getName() == null) ? null : type.getName().getValue();
	}
}
