
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
 *         &lt;element name="GetClientsByNameResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfClient" minOccurs="0"/>
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
    "getClientsByNameResult"
})
@XmlRootElement(name = "GetClientsByNameResponse")
public class GetClientsByNameResponse {

    @XmlElementRef(name = "GetClientsByNameResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfClient> getClientsByNameResult;

    /**
     * Gets the value of the getClientsByNameResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfClient }{@code >}
     *     
     */
    public JAXBElement<ArrayOfClient> getGetClientsByNameResult() {
        return getClientsByNameResult;
    }

    /**
     * Sets the value of the getClientsByNameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfClient }{@code >}
     *     
     */
    public void setGetClientsByNameResult(JAXBElement<ArrayOfClient> value) {
        this.getClientsByNameResult = ((JAXBElement<ArrayOfClient> ) value);
    }

}
