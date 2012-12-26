
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
 *         &lt;element name="GetAllSavedPaymentsResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfSavedPayment" minOccurs="0"/>
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
    "getAllSavedPaymentsResult"
})
@XmlRootElement(name = "GetAllSavedPaymentsResponse")
public class GetAllSavedPaymentsResponse {

    @XmlElementRef(name = "GetAllSavedPaymentsResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfSavedPayment> getAllSavedPaymentsResult;

    /**
     * Gets the value of the getAllSavedPaymentsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSavedPayment }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSavedPayment> getGetAllSavedPaymentsResult() {
        return getAllSavedPaymentsResult;
    }

    /**
     * Sets the value of the getAllSavedPaymentsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSavedPayment }{@code >}
     *     
     */
    public void setGetAllSavedPaymentsResult(JAXBElement<ArrayOfSavedPayment> value) {
        this.getAllSavedPaymentsResult = ((JAXBElement<ArrayOfSavedPayment> ) value);
    }

}
