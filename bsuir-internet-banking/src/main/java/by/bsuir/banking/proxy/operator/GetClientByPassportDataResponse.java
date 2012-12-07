
package by.bsuir.banking.proxy.operator;

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
 *         &lt;element name="GetClientByPassportDataResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}Client" minOccurs="0"/>
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
    "getClientByPassportDataResult"
})
@XmlRootElement(name = "GetClientByPassportDataResponse")
public class GetClientByPassportDataResponse {

    @XmlElementRef(name = "GetClientByPassportDataResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<Client> getClientByPassportDataResult;

    /**
     * Gets the value of the getClientByPassportDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Client }{@code >}
     *     
     */
    public JAXBElement<Client> getGetClientByPassportDataResult() {
        return getClientByPassportDataResult;
    }

    /**
     * Sets the value of the getClientByPassportDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Client }{@code >}
     *     
     */
    public void setGetClientByPassportDataResult(JAXBElement<Client> value) {
        this.getClientByPassportDataResult = ((JAXBElement<Client> ) value);
    }

}
