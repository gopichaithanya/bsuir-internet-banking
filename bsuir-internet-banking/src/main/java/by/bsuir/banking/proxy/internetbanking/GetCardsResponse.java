
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
 *         &lt;element name="GetCardsResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfCard" minOccurs="0"/>
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
    "getCardsResult"
})
@XmlRootElement(name = "GetCardsResponse")
public class GetCardsResponse {

    @XmlElementRef(name = "GetCardsResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfCard> getCardsResult;

    /**
     * Gets the value of the getCardsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCard }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCard> getGetCardsResult() {
        return getCardsResult;
    }

    /**
     * Sets the value of the getCardsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCard }{@code >}
     *     
     */
    public void setGetCardsResult(JAXBElement<ArrayOfCard> value) {
        this.getCardsResult = ((JAXBElement<ArrayOfCard> ) value);
    }

}
