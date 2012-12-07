
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
 *         &lt;element name="GetAllCardTypesResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfCardType" minOccurs="0"/>
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
    "getAllCardTypesResult"
})
@XmlRootElement(name = "GetAllCardTypesResponse")
public class GetAllCardTypesResponse {

    @XmlElementRef(name = "GetAllCardTypesResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfCardType> getAllCardTypesResult;

    /**
     * Gets the value of the getAllCardTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCardType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCardType> getGetAllCardTypesResult() {
        return getAllCardTypesResult;
    }

    /**
     * Sets the value of the getAllCardTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCardType }{@code >}
     *     
     */
    public void setGetAllCardTypesResult(JAXBElement<ArrayOfCardType> value) {
        this.getAllCardTypesResult = ((JAXBElement<ArrayOfCardType> ) value);
    }

}
