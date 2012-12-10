package by.bsuir.banking.domain;


/**
 * Class created especially for transfer form 
 * @author Katherine
 *
 */
public class TransferInfo {
	
	private String senderCardNumber;
	
	private String receiverCardNumber;
	
	private MoneyWrapper amount;
	
	
	public TransferInfo(){
		
	}
	
	public String getSenderCardNumber(){
		return senderCardNumber;
	}
	
	public void setSenderCardNumber(String value){
		senderCardNumber = value;
	}
	
	public String getReceiverCardNumber(){
		return receiverCardNumber;
	}
	
	public void setReceiverCardNumber(String value){
		receiverCardNumber = value;
	}
	
	public MoneyWrapper getAmount(){
		return amount;
	}
	
	public void setAmount(MoneyWrapper value){
		amount = value;
	}

}
