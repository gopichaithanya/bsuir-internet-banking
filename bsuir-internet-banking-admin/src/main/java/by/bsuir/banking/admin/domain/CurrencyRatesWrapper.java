package by.bsuir.banking.admin.domain;

import java.util.ArrayList;
import java.util.List;


public class CurrencyRatesWrapper {
	
	private List<PurchaseRateWrapper> purchaseRatesList;
	private List<SellRateWrapper> sellRatesList;
	
	public CurrencyRatesWrapper(){
		purchaseRatesList = new ArrayList<PurchaseRateWrapper>();
		sellRatesList = new ArrayList<SellRateWrapper>();
	}
	
	public CurrencyRatesWrapper(List<PurchaseRateWrapper> purchaseList, List<SellRateWrapper> sellList){
		purchaseRatesList = purchaseList;
		sellRatesList = sellList;
	}
	
	public List<PurchaseRateWrapper> getPurchaseRates(){
		return purchaseRatesList;
	}
	
	public void setPurchaseRates(List<PurchaseRateWrapper> list){
		for(PurchaseRateWrapper purchaseRateWrapper : list) {
			purchaseRateWrapper.setAmount(purchaseRateWrapper.getRate().toString());
		}
		purchaseRatesList = list;
	}
	
	public List<SellRateWrapper> getSellRates(){
		return sellRatesList;
	}
	
	public void setSellRates(List<SellRateWrapper> list){
		sellRatesList = list;
	}
}
