
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
 *         &lt;element name="GetPeriodPaymentsForCardResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfPayment" minOccurs="0"/>
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
    "getPeriodPaymentsForCardResult"
})
@XmlRootElement(name = "GetPeriodPaymentsForCardResponse")
public class GetPeriodPaymentsForCardResponse {

    @XmlElementRef(name = "GetPeriodPaymentsForCardResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfPayment> getPeriodPaymentsForCardResult;

    /**
     * Gets the value of the getPeriodPaymentsForCardResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPayment }{@code >}
     *     
     */
    public JAXBElement<ArrayOfPayment> getGetPeriodPaymentsForCardResult() {
        return getPeriodPaymentsForCardResult;
    }

    /**
     * Sets the value of the getPeriodPaymentsForCardResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPayment }{@code >}
     *     
     */
    public void setGetPeriodPaymentsForCardResult(JAXBElement<ArrayOfPayment> value) {
        this.getPeriodPaymentsForCardResult = ((JAXBElement<ArrayOfPayment> ) value);
    }

}
