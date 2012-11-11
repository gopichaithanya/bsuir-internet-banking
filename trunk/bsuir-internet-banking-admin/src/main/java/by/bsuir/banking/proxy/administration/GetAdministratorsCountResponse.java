
package by.bsuir.banking.proxy.administration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="GetAdministratorsCountResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "getAdministratorsCountResult"
})
@XmlRootElement(name = "GetAdministratorsCountResponse")
public class GetAdministratorsCountResponse {

    @XmlElement(name = "GetAdministratorsCountResult")
    protected Integer getAdministratorsCountResult;

    /**
     * Gets the value of the getAdministratorsCountResult property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGetAdministratorsCountResult() {
        return getAdministratorsCountResult;
    }

    /**
     * Sets the value of the getAdministratorsCountResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGetAdministratorsCountResult(Integer value) {
        this.getAdministratorsCountResult = value;
    }

}
