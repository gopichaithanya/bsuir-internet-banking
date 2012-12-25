package by.bsuir.banking.domain;

import java.math.BigDecimal;
import java.util.Date;

import by.bsuir.banking.proxy.internetbanking.Transfer;


public class TransferHistoryWrapper implements Comparable<TransferHistoryWrapper> {
	private Transfer transfer;
	private String currency;
	private String senderCardNumber;
	private String receiverCardNumber;
	
	public Transfer getTransfer() {
		return transfer;
	}
	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}
	
	public TransferHistoryWrapper(Transfer transfer){
		this.transfer = transfer;
	}
	
	public Integer getId(){
		return transfer.getId();
	}
	
	public Integer getAccountId(){
		return transfer.getAccountId();
	}
	
	public Integer getReceiverAccountId(){
		return transfer.getReceiverAccountId();
	}
	
	public BigDecimal getAmount(){
		return transfer.getAmount();
	}
	
	public Date getDateTime(){
		return transfer.getDateTime().toGregorianCalendar().getTime();
	}
	
	@Override
	  public int compareTo(TransferHistoryWrapper o) {
	    return getDateTime().compareTo(o.getDateTime());
	  }

	
	public String getCurrency(){
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public boolean isIsSuccessful(){
		return transfer.isIsSuccessful();
	}
	
	public String getStatus(){
		if(isIsSuccessful()){
			return "SUCCESS";
		}else{
			return "FAILED";
		}
	}
	public String getSenderCardNumber() {
		return senderCardNumber;
	}
	public void setSenderCardNumber(String senderCardNumber) {
		this.senderCardNumber = senderCardNumber;
	}
	public String getReceiverCardNumber() {
		return receiverCardNumber;
	}
	public void setReceiverCardNumber(String receiverCardNumber) {
		this.receiverCardNumber = receiverCardNumber;
	}
}
