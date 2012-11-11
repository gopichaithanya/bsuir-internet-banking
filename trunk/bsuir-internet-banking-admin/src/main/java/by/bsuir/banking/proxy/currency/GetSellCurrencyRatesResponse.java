
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
 *         &lt;element name="GetSellCurrencyRatesResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfSellCurrencyRate" minOccurs="0"/>
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
    "getSellCurrencyRatesResult"
})
@XmlRootElement(name = "GetSellCurrencyRatesResponse")
public class GetSellCurrencyRatesResponse {

    @XmlElementRef(name = "GetSellCurrencyRatesResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfSellCurrencyRate> getSellCurrencyRatesResult;

    /**
     * Gets the value of the getSellCurrencyRatesResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSellCurrencyRate }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSellCurrencyRate> getGetSellCurrencyRatesResult() {
        return getSellCurrencyRatesResult;
    }

    /**
     * Sets the value of the getSellCurrencyRatesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSellCurrencyRate }{@code >}
     *     
     */
    public void setGetSellCurrencyRatesResult(JAXBElement<ArrayOfSellCurrencyRate> value) {
        this.getSellCurrencyRatesResult = ((JAXBElement<ArrayOfSellCurrencyRate> ) value);
    }

}
