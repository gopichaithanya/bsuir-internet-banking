
package by.bsuir.banking.proxy.currency;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetPurchaseCurrencyRatesResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfPurchaseCurrencyRate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getPurchaseCurrencyRatesResult"
})
@XmlRootElement(name = "GetPurchaseCurrencyRatesResponse")
public class GetPurchaseCurrencyRatesResponse {

    @XmlElementRef(name = "GetPurchaseCurrencyRatesResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfPurchaseCurrencyRate> getPurchaseCurrencyRatesResult;

    /**
     * Gets the value of the getPurchaseCurrencyRatesResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPurchaseCurrencyRate }{@code >}
     *     
     */
    public JAXBElement<ArrayOfPurchaseCurrencyRate> getGetPurchaseCurrencyRatesResult() {
        return getPurchaseCurrencyRatesResult;
    }

    /**
     * Sets the value of the getPurchaseCurrencyRatesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPurchaseCurrencyRate }{@code >}
     *     
     */
    public void setGetPurchaseCurrencyRatesResult(JAXBElement<ArrayOfPurchaseCurrencyRate> value) {
        this.getPurchaseCurrencyRatesResult = ((JAXBElement<ArrayOfPurchaseCurrencyRate> ) value);
    }

}
