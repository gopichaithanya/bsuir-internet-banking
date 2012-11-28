
package by.bsuir.banking.proxy.authentication;

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
 *         &lt;element name="AuthenticateResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}AuthenticationCredential" minOccurs="0"/>
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
    "authenticateResult"
})
@XmlRootElement(name = "AuthenticateResponse")
public class AuthenticateResponse {

    @XmlElementRef(name = "AuthenticateResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<AuthenticationCredential> authenticateResult;

    /**
     * Gets the value of the authenticateResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AuthenticationCredential }{@code >}
     *     
     */
    public JAXBElement<AuthenticationCredential> getAuthenticateResult() {
        return authenticateResult;
    }

    /**
     * Sets the value of the authenticateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AuthenticationCredential }{@code >}
     *     
     */
    public void setAuthenticateResult(JAXBElement<AuthenticationCredential> value) {
        this.authenticateResult = ((JAXBElement<AuthenticationCredential> ) value);
    }

}
