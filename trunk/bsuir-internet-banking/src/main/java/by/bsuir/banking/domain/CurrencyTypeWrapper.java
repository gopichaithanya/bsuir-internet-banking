package by.bsuir.banking.domain;

import by.bsuir.banking.proxy.internetbanking.CurrencyType;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;

public class CurrencyTypeWrapper {

	private static ObjectFactory factory = new ObjectFactory();
	private CurrencyType type;
	
	public CurrencyTypeWrapper(){
		type = factory.createCurrencyType();
	}
	
	public CurrencyTypeWrapper(CurrencyType type){
		this.type = type;
	}
	
	public CurrencyType getCurrencyType(){
		return type;
	}
	
	public String getName(){
		return (type.getName() == null) ? null : type.getName().getValue();
	}
	
	public void setName(String value){
		type.setName(factory.createCurrencyTypeName(value));
	}
	
	public String getShortName(){
		return (type.getShortName() == null) ? null : type.getShortName().getValue();
	}
	
	public void setShortName(String value){
		type.setShortName(factory.createCurrencyTypeShortName(value));
	}
	
	public Integer getId(){
		return type.getId(); 
	}
}
