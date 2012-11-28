
package by.bsuir.banking.proxy.card;

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
 *         &lt;element name="GetAccountsForClientResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfAccount" minOccurs="0"/>
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
    "getAccountsForClientResult"
})
@XmlRootElement(name = "GetAccountsForClientResponse")
public class GetAccountsForClientResponse {

    @XmlElementRef(name = "GetAccountsForClientResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfAccount> getAccountsForClientResult;

    /**
     * Gets the value of the getAccountsForClientResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAccount }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAccount> getGetAccountsForClientResult() {
        return getAccountsForClientResult;
    }

    /**
     * Sets the value of the getAccountsForClientResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAccount }{@code >}
     *     
     */
    public void setGetAccountsForClientResult(JAXBElement<ArrayOfAccount> value) {
        this.getAccountsForClientResult = ((JAXBElement<ArrayOfAccount> ) value);
    }

}
