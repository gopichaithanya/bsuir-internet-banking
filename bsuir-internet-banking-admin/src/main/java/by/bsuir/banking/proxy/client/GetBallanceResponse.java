
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
 *         &lt;element name="GetBallanceResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}Money" minOccurs="0"/>
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
    "getBallanceResult"
})
@XmlRootElement(name = "GetBallanceResponse")
public class GetBallanceResponse {

    @XmlElementRef(name = "GetBallanceResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<Money> getBallanceResult;

    /**
     * Gets the value of the getBallanceResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Money }{@code >}
     *     
     */
    public JAXBElement<Money> getGetBallanceResult() {
        return getBallanceResult;
    }

    /**
     * Sets the value of the getBallanceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Money }{@code >}
     *     
     */
    public void setGetBallanceResult(JAXBElement<Money> value) {
        this.getBallanceResult = ((JAXBElement<Money> ) value);
    }

}
