
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
 *         &lt;element name="GetAllLegalPersonsResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfLegalPerson" minOccurs="0"/>
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
    "getAllLegalPersonsResult"
})
@XmlRootElement(name = "GetAllLegalPersonsResponse")
public class GetAllLegalPersonsResponse {

    @XmlElementRef(name = "GetAllLegalPersonsResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfLegalPerson> getAllLegalPersonsResult;

    /**
     * Gets the value of the getAllLegalPersonsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLegalPerson }{@code >}
     *     
     */
    public JAXBElement<ArrayOfLegalPerson> getGetAllLegalPersonsResult() {
        return getAllLegalPersonsResult;
    }

    /**
     * Sets the value of the getAllLegalPersonsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLegalPerson }{@code >}
     *     
     */
    public void setGetAllLegalPersonsResult(JAXBElement<ArrayOfLegalPerson> value) {
        this.getAllLegalPersonsResult = ((JAXBElement<ArrayOfLegalPerson> ) value);
    }

}
