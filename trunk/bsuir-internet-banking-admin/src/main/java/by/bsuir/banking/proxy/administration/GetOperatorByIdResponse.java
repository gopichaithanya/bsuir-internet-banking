
package by.bsuir.banking.proxy.administration;

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
 *         &lt;element name="GetOperatorByIdResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}Operator" minOccurs="0"/>
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
    "getOperatorByIdResult"
})
@XmlRootElement(name = "GetOperatorByIdResponse")
public class GetOperatorByIdResponse {

    @XmlElementRef(name = "GetOperatorByIdResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<Operator> getOperatorByIdResult;

    /**
     * Gets the value of the getOperatorByIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Operator }{@code >}
     *     
     */
    public JAXBElement<Operator> getGetOperatorByIdResult() {
        return getOperatorByIdResult;
    }

    /**
     * Sets the value of the getOperatorByIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Operator }{@code >}
     *     
     */
    public void setGetOperatorByIdResult(JAXBElement<Operator> value) {
        this.getOperatorByIdResult = ((JAXBElement<Operator> ) value);
    }

}
