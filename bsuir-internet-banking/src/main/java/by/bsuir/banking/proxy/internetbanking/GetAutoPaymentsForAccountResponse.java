
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
 *         &lt;element name="GetAutoPaymentsForAccountResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfAutoPayment" minOccurs="0"/>
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
    "getAutoPaymentsForAccountResult"
})
@XmlRootElement(name = "GetAutoPaymentsForAccountResponse")
public class GetAutoPaymentsForAccountResponse {

    @XmlElementRef(name = "GetAutoPaymentsForAccountResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfAutoPayment> getAutoPaymentsForAccountResult;

    /**
     * Gets the value of the getAutoPaymentsForAccountResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAutoPayment }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAutoPayment> getGetAutoPaymentsForAccountResult() {
        return getAutoPaymentsForAccountResult;
    }

    /**
     * Sets the value of the getAutoPaymentsForAccountResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAutoPayment }{@code >}
     *     
     */
    public void setGetAutoPaymentsForAccountResult(JAXBElement<ArrayOfAutoPayment> value) {
        this.getAutoPaymentsForAccountResult = ((JAXBElement<ArrayOfAutoPayment> ) value);
    }

}
