
package by.bsuir.banking.dotnetclient;

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
 *         &lt;element name="updatedOperator" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}Operator" minOccurs="0"/>
 *         &lt;element name="securityToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "updatedOperator",
    "securityToken"
})
@XmlRootElement(name = "UpdateOperator")
public class UpdateOperator {

    @XmlElementRef(name = "updatedOperator", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<Operator> updatedOperator;
    @XmlElementRef(name = "securityToken", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> securityToken;

    /**
     * Gets the value of the updatedOperator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Operator }{@code >}
     *     
     */
    public JAXBElement<Operator> getUpdatedOperator() {
        return updatedOperator;
    }

    /**
     * Sets the value of the updatedOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Operator }{@code >}
     *     
     */
    public void setUpdatedOperator(JAXBElement<Operator> value) {
        this.updatedOperator = ((JAXBElement<Operator> ) value);
    }

    /**
     * Gets the value of the securityToken property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecurityToken() {
        return securityToken;
    }

    /**
     * Sets the value of the securityToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecurityToken(JAXBElement<String> value) {
        this.securityToken = ((JAXBElement<String> ) value);
    }

}
