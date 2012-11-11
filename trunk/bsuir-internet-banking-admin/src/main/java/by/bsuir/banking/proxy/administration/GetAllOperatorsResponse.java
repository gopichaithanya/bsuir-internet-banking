
package by.bsuir.banking.proxy.administration;

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
 *         &lt;element name="GetAllOperatorsResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfOperator" minOccurs="0"/>
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
    "getAllOperatorsResult"
})
@XmlRootElement(name = "GetAllOperatorsResponse")
public class GetAllOperatorsResponse {

    @XmlElementRef(name = "GetAllOperatorsResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfOperator> getAllOperatorsResult;

    /**
     * Gets the value of the getAllOperatorsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOperator }{@code >}
     *     
     */
    public JAXBElement<ArrayOfOperator> getGetAllOperatorsResult() {
        return getAllOperatorsResult;
    }

    /**
     * Sets the value of the getAllOperatorsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOperator }{@code >}
     *     
     */
    public void setGetAllOperatorsResult(JAXBElement<ArrayOfOperator> value) {
        this.getAllOperatorsResult = ((JAXBElement<ArrayOfOperator> ) value);
    }

}
