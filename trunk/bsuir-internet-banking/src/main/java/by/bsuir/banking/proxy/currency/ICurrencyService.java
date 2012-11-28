
package by.bsuir.banking.proxy.currency;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ICurrencyService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ICurrencyService {


    /**
     * 
     * @return
     *     returns by.bsuir.banking.proxy.currency.ArrayOfCurrencyType
     * @throws ICurrencyServiceGetCurrencyTypesDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetCurrencyTypes", action = "http://tempuri.org/ICurrencyService/GetCurrencyTypes")
    @WebResult(name = "GetCurrencyTypesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetCurrencyTypes", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.currency.GetCurrencyTypes")
    @ResponseWrapper(localName = "GetCurrencyTypesResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.currency.GetCurrencyTypesResponse")
    public ArrayOfCurrencyType getCurrencyTypes()
        throws ICurrencyServiceGetCurrencyTypesDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @return
     *     returns by.bsuir.banking.proxy.currency.ArrayOfSellCurrencyRate
     * @throws ICurrencyServiceGetSellCurrencyRatesDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetSellCurrencyRates", action = "http://tempuri.org/ICurrencyService/GetSellCurrencyRates")
    @WebResult(name = "GetSellCurrencyRatesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetSellCurrencyRates", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.currency.GetSellCurrencyRates")
    @ResponseWrapper(localName = "GetSellCurrencyRatesResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.currency.GetSellCurrencyRatesResponse")
    public ArrayOfSellCurrencyRate getSellCurrencyRates()
        throws ICurrencyServiceGetSellCurrencyRatesDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @return
     *     returns by.bsuir.banking.proxy.currency.ArrayOfPurchaseCurrencyRate
     * @throws ICurrencyServiceGetPurchaseCurrencyRatesDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetPurchaseCurrencyRates", action = "http://tempuri.org/ICurrencyService/GetPurchaseCurrencyRates")
    @WebResult(name = "GetPurchaseCurrencyRatesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetPurchaseCurrencyRates", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.currency.GetPurchaseCurrencyRates")
    @ResponseWrapper(localName = "GetPurchaseCurrencyRatesResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.currency.GetPurchaseCurrencyRatesResponse")
    public ArrayOfPurchaseCurrencyRate getPurchaseCurrencyRates()
        throws ICurrencyServiceGetPurchaseCurrencyRatesDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param sellCurrencyRates
     * @throws ICurrencyServiceUpdateSellCurrencyRatesAuthorizationFaultFaultFaultMessage
     * @throws ICurrencyServiceUpdateSellCurrencyRatesDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "UpdateSellCurrencyRates", action = "http://tempuri.org/ICurrencyService/UpdateSellCurrencyRates")
    @RequestWrapper(localName = "UpdateSellCurrencyRates", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.currency.UpdateSellCurrencyRates")
    @ResponseWrapper(localName = "UpdateSellCurrencyRatesResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.currency.UpdateSellCurrencyRatesResponse")
    public void updateSellCurrencyRates(
        @WebParam(name = "sellCurrencyRates", targetNamespace = "http://tempuri.org/")
        ArrayOfSellCurrencyRate sellCurrencyRates,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICurrencyServiceUpdateSellCurrencyRatesAuthorizationFaultFaultFaultMessage, ICurrencyServiceUpdateSellCurrencyRatesDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param purchaseCurrencyRates
     * @throws ICurrencyServiceUpdatePurchaseCurrencyRatesDomainFaultFaultFaultMessage
     * @throws ICurrencyServiceUpdatePurchaseCurrencyRatesAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "UpdatePurchaseCurrencyRates", action = "http://tempuri.org/ICurrencyService/UpdatePurchaseCurrencyRates")
    @RequestWrapper(localName = "UpdatePurchaseCurrencyRates", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.currency.UpdatePurchaseCurrencyRates")
    @ResponseWrapper(localName = "UpdatePurchaseCurrencyRatesResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.currency.UpdatePurchaseCurrencyRatesResponse")
    public void updatePurchaseCurrencyRates(
        @WebParam(name = "purchaseCurrencyRates", targetNamespace = "http://tempuri.org/")
        ArrayOfPurchaseCurrencyRate purchaseCurrencyRates,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICurrencyServiceUpdatePurchaseCurrencyRatesAuthorizationFaultFaultFaultMessage, ICurrencyServiceUpdatePurchaseCurrencyRatesDomainFaultFaultFaultMessage
    ;

}
