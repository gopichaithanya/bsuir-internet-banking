
package by.bsuir.banking.proxy.internetbanking;

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
 *         &lt;element name="GetSavedPaymentsForAccountResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfSavedPayment" minOccurs="0"/>
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
    "getSavedPaymentsForAccountResult"
})
@XmlRootElement(name = "GetSavedPaymentsForAccountResponse")
public class GetSavedPaymentsForAccountResponse {

    @XmlElementRef(name = "GetSavedPaymentsForAccountResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfSavedPayment> getSavedPaymentsForAccountResult;

    /**
     * Gets the value of the getSavedPaymentsForAccountResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSavedPayment }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSavedPayment> getGetSavedPaymentsForAccountResult() {
        return getSavedPaymentsForAccountResult;
    }

    /**
     * Sets the value of the getSavedPaymentsForAccountResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSavedPayment }{@code >}
     *     
     */
    public void setGetSavedPaymentsForAccountResult(JAXBElement<ArrayOfSavedPayment> value) {
        this.getSavedPaymentsForAccountResult = ((JAXBElement<ArrayOfSavedPayment> ) value);
    }

}
