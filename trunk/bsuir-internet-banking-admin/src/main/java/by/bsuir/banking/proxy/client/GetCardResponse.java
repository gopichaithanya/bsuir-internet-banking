
package by.bsuir.banking.proxy.client;

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
 *         &lt;element name="GetCardResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}Card" minOccurs="0"/>
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
    "getCardResult"
})
@XmlRootElement(name = "GetCardResponse")
public class GetCardResponse {

    @XmlElementRef(name = "GetCardResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<Card> getCardResult;

    /**
     * Gets the value of the getCardResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Card }{@code >}
     *     
     */
    public JAXBElement<Card> getGetCardResult() {
        return getCardResult;
    }

    /**
     * Sets the value of the getCardResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Card }{@code >}
     *     
     */
    public void setGetCardResult(JAXBElement<Card> value) {
        this.getCardResult = ((JAXBElement<Card> ) value);
    }

}
