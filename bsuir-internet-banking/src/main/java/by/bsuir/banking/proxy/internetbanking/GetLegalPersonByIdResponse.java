
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
 *         &lt;element name="GetLegalPersonByIdResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}LegalPerson" minOccurs="0"/>
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
    "getLegalPersonByIdResult"
})
@XmlRootElement(name = "GetLegalPersonByIdResponse")
public class GetLegalPersonByIdResponse {

    @XmlElementRef(name = "GetLegalPersonByIdResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<LegalPerson> getLegalPersonByIdResult;

    /**
     * Gets the value of the getLegalPersonByIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LegalPerson }{@code >}
     *     
     */
    public JAXBElement<LegalPerson> getGetLegalPersonByIdResult() {
        return getLegalPersonByIdResult;
    }

    /**
     * Sets the value of the getLegalPersonByIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LegalPerson }{@code >}
     *     
     */
    public void setGetLegalPersonByIdResult(JAXBElement<LegalPerson> value) {
        this.getLegalPersonByIdResult = ((JAXBElement<LegalPerson> ) value);
    }

}
