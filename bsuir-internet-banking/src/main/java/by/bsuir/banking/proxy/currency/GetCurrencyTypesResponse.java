
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
 *         &lt;element name="GetCurrencyTypesResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfCurrencyType" minOccurs="0"/>
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
    "getCurrencyTypesResult"
})
@XmlRootElement(name = "GetCurrencyTypesResponse")
public class GetCurrencyTypesResponse {

    @XmlElementRef(name = "GetCurrencyTypesResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfCurrencyType> getCurrencyTypesResult;

    /**
     * Gets the value of the getCurrencyTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCurrencyType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCurrencyType> getGetCurrencyTypesResult() {
        return getCurrencyTypesResult;
    }

    /**
     * Sets the value of the getCurrencyTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCurrencyType }{@code >}
     *     
     */
    public void setGetCurrencyTypesResult(JAXBElement<ArrayOfCurrencyType> value) {
        this.getCurrencyTypesResult = ((JAXBElement<ArrayOfCurrencyType> ) value);
    }

}
