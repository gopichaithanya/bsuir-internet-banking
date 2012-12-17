package by.bsuir.banking.domain;

import by.bsuir.banking.proxy.internetbanking.City;
import by.bsuir.banking.proxy.internetbanking.ObjectFactory;
import by.bsuir.banking.proxy.internetbanking.Region;
import by.bsuir.banking.proxy.internetbanking.Service;


public class EripWrapper {
	private Service erip;
	private City city;
	private Region region;
	private ObjectFactory factory = new ObjectFactory();

	public EripWrapper(Service service){
		erip = service;
	}
	
	public Service getErip() {
		return erip;
	}

	public void setErip(Service erip) {
		this.erip = erip;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City cityName) {
		this.city = cityName;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region regionName) {
		this.region = regionName;
	}
	
	public String getName(){
		return(erip.getName() == null) ? null : erip.getName().getValue();
	}
	
	public void setName(String value){
		erip.setName(factory.createServiceName(value));
	}
	
	public Integer getCityId(){
		return erip.getCityId();
	}
	
	public void setCityId(Integer value){
		erip.setCityId(value);
	}
	
	public Integer getId(){
		return erip.getId();
	}
	
}
