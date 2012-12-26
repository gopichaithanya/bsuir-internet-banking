
package by.bsuir.banking.proxy.internetbanking;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="CreateAutoPaymentResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "createAutoPaymentResult"
})
@XmlRootElement(name = "CreateAutoPaymentResponse")
public class CreateAutoPaymentResponse {

    @XmlElement(name = "CreateAutoPaymentResult")
    protected Integer createAutoPaymentResult;

    /**
     * Gets the value of the createAutoPaymentResult property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCreateAutoPaymentResult() {
        return createAutoPaymentResult;
    }

    /**
     * Sets the value of the createAutoPaymentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCreateAutoPaymentResult(Integer value) {
        this.createAutoPaymentResult = value;
    }

}
