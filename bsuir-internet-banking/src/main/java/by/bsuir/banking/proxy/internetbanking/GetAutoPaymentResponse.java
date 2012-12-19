
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
 *         &lt;element name="GetAutoPaymentResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}AutoPayment" minOccurs="0"/>
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
    "getAutoPaymentResult"
})
@XmlRootElement(name = "GetAutoPaymentResponse")
public class GetAutoPaymentResponse {

    @XmlElementRef(name = "GetAutoPaymentResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<AutoPayment> getAutoPaymentResult;

    /**
     * Gets the value of the getAutoPaymentResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AutoPayment }{@code >}
     *     
     */
    public JAXBElement<AutoPayment> getGetAutoPaymentResult() {
        return getAutoPaymentResult;
    }

    /**
     * Sets the value of the getAutoPaymentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AutoPayment }{@code >}
     *     
     */
    public void setGetAutoPaymentResult(JAXBElement<AutoPayment> value) {
        this.getAutoPaymentResult = ((JAXBElement<AutoPayment> ) value);
    }

}
