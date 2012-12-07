
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
 *         &lt;element name="GetPeriodTransfersForCardResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfTransfer" minOccurs="0"/>
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
    "getPeriodTransfersForCardResult"
})
@XmlRootElement(name = "GetPeriodTransfersForCardResponse")
public class GetPeriodTransfersForCardResponse {

    @XmlElementRef(name = "GetPeriodTransfersForCardResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfTransfer> getPeriodTransfersForCardResult;

    /**
     * Gets the value of the getPeriodTransfersForCardResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTransfer }{@code >}
     *     
     */
    public JAXBElement<ArrayOfTransfer> getGetPeriodTransfersForCardResult() {
        return getPeriodTransfersForCardResult;
    }

    /**
     * Sets the value of the getPeriodTransfersForCardResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTransfer }{@code >}
     *     
     */
    public void setGetPeriodTransfersForCardResult(JAXBElement<ArrayOfTransfer> value) {
        this.getPeriodTransfersForCardResult = ((JAXBElement<ArrayOfTransfer> ) value);
    }

}
