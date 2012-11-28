
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
 *         &lt;element name="GetPageofClientsResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfClient" minOccurs="0"/>
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
    "getPageofClientsResult"
})
@XmlRootElement(name = "GetPageofClientsResponse")
public class GetPageofClientsResponse {

    @XmlElementRef(name = "GetPageofClientsResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfClient> getPageofClientsResult;

    /**
     * Gets the value of the getPageofClientsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfClient }{@code >}
     *     
     */
    public JAXBElement<ArrayOfClient> getGetPageofClientsResult() {
        return getPageofClientsResult;
    }

    /**
     * Sets the value of the getPageofClientsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfClient }{@code >}
     *     
     */
    public void setGetPageofClientsResult(JAXBElement<ArrayOfClient> value) {
        this.getPageofClientsResult = ((JAXBElement<ArrayOfClient> ) value);
    }

}
