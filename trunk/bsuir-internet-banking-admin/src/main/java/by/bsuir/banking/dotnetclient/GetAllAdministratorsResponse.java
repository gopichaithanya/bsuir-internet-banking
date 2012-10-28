
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
 *         &lt;element name="GetAllAdministratorsResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfAdministrator" minOccurs="0"/>
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
    "getAllAdministratorsResult"
})
@XmlRootElement(name = "GetAllAdministratorsResponse")
public class GetAllAdministratorsResponse {

    @XmlElementRef(name = "GetAllAdministratorsResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfAdministrator> getAllAdministratorsResult;

    /**
     * Gets the value of the getAllAdministratorsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAdministrator }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAdministrator> getGetAllAdministratorsResult() {
        return getAllAdministratorsResult;
    }

    /**
     * Sets the value of the getAllAdministratorsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAdministrator }{@code >}
     *     
     */
    public void setGetAllAdministratorsResult(JAXBElement<ArrayOfAdministrator> value) {
        this.getAllAdministratorsResult = ((JAXBElement<ArrayOfAdministrator> ) value);
    }

}
