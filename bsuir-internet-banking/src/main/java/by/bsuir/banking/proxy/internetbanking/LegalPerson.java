
package by.bsuir.banking.proxy.internetbanking;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LegalPerson complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LegalPerson">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="LegalAccounts" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}ArrayOfLegalAccount" minOccurs="0"/>
 *         &lt;element name="LegalNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LegalPersonCategory" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}LegalPersonCategory" minOccurs="0"/>
 *         &lt;element name="LegalPersonCategoryId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalPerson", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", propOrder = {
    "address",
    "id",
    "legalAccounts",
    "legalNumber",
    "legalPersonCategory",
    "legalPersonCategoryId",
    "name",
    "phone"
})
public class LegalPerson {

    @XmlElementRef(name = "Address", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", type = JAXBElement.class)
    protected JAXBElement<String> address;
    @XmlElement(name = "Id")
    protected Integer id;
    @XmlElementRef(name = "LegalAccounts", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", type = JAXBElement.class)
    protected JAXBElement<ArrayOfLegalAccount> legalAccounts;
    @XmlElementRef(name = "LegalNumber", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", type = JAXBElement.class)
    protected JAXBElement<String> legalNumber;
    @XmlElementRef(name = "LegalPersonCategory", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", type = JAXBElement.class)
    protected JAXBElement<LegalPersonCategory> legalPersonCategory;
    @XmlElement(name = "LegalPersonCategoryId")
    protected Integer legalPersonCategoryId;
    @XmlElementRef(name = "Name", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", type = JAXBElement.class)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "Phone", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", type = JAXBElement.class)
    protected JAXBElement<String> phone;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddress(JAXBElement<String> value) {
        this.address = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the legalAccounts property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLegalAccount }{@code >}
     *     
     */
    public JAXBElement<ArrayOfLegalAccount> getLegalAccounts() {
        return legalAccounts;
    }

    /**
     * Sets the value of the legalAccounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLegalAccount }{@code >}
     *     
     */
    public void setLegalAccounts(JAXBElement<ArrayOfLegalAccount> value) {
        this.legalAccounts = ((JAXBElement<ArrayOfLegalAccount> ) value);
    }

    /**
     * Gets the value of the legalNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLegalNumber() {
        return legalNumber;
    }

    /**
     * Sets the value of the legalNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLegalNumber(JAXBElement<String> value) {
        this.legalNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the legalPersonCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LegalPersonCategory }{@code >}
     *     
     */
    public JAXBElement<LegalPersonCategory> getLegalPersonCategory() {
        return legalPersonCategory;
    }

    /**
     * Sets the value of the legalPersonCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LegalPersonCategory }{@code >}
     *     
     */
    public void setLegalPersonCategory(JAXBElement<LegalPersonCategory> value) {
        this.legalPersonCategory = ((JAXBElement<LegalPersonCategory> ) value);
    }

    /**
     * Gets the value of the legalPersonCategoryId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLegalPersonCategoryId() {
        return legalPersonCategoryId;
    }

    /**
     * Sets the value of the legalPersonCategoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLegalPersonCategoryId(Integer value) {
        this.legalPersonCategoryId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPhone(JAXBElement<String> value) {
        this.phone = ((JAXBElement<String> ) value);
    }

}
