
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
 *         &lt;element name="GetAllLegalPersonCategoriesResult" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfLegalPersonCategory" minOccurs="0"/>
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
    "getAllLegalPersonCategoriesResult"
})
@XmlRootElement(name = "GetAllLegalPersonCategoriesResponse")
public class GetAllLegalPersonCategoriesResponse {

    @XmlElementRef(name = "GetAllLegalPersonCategoriesResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfLegalPersonCategory> getAllLegalPersonCategoriesResult;

    /**
     * Gets the value of the getAllLegalPersonCategoriesResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLegalPersonCategory }{@code >}
     *     
     */
    public JAXBElement<ArrayOfLegalPersonCategory> getGetAllLegalPersonCategoriesResult() {
        return getAllLegalPersonCategoriesResult;
    }

    /**
     * Sets the value of the getAllLegalPersonCategoriesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLegalPersonCategory }{@code >}
     *     
     */
    public void setGetAllLegalPersonCategoriesResult(JAXBElement<ArrayOfLegalPersonCategory> value) {
        this.getAllLegalPersonCategoriesResult = ((JAXBElement<ArrayOfLegalPersonCategory> ) value);
    }

}
