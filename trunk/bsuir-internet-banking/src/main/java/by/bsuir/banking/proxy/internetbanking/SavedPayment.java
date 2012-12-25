
package by.bsuir.banking.proxy.internetbanking;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SavedPayment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SavedPayment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Information" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LegalAccountId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Money" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}Money" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SavedPayment", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", propOrder = {
    "accountId",
    "id",
    "information",
    "legalAccountId",
    "money"
})
public class SavedPayment {

    @XmlElement(name = "AccountId")
    protected Integer accountId;
    @XmlElement(name = "Id")
    protected Integer id;
    @XmlElementRef(name = "Information", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", type = JAXBElement.class)
    protected JAXBElement<String> information;
    @XmlElement(name = "LegalAccountId")
    protected Integer legalAccountId;
    @XmlElementRef(name = "Money", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", type = JAXBElement.class)
    protected JAXBElement<Money> money;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAccountId(Integer value) {
        this.accountId = value;
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
     * Gets the value of the information property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInformation() {
        return information;
    }

    /**
     * Sets the value of the information property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInformation(JAXBElement<String> value) {
        this.information = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the legalAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLegalAccountId() {
        return legalAccountId;
    }

    /**
     * Sets the value of the legalAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLegalAccountId(Integer value) {
        this.legalAccountId = value;
    }

    /**
     * Gets the value of the money property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Money }{@code >}
     *     
     */
    public JAXBElement<Money> getMoney() {
        return money;
    }

    /**
     * Sets the value of the money property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Money }{@code >}
     *     
     */
    public void setMoney(JAXBElement<Money> value) {
        this.money = ((JAXBElement<Money> ) value);
    }

}
