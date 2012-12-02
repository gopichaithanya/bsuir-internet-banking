
package by.bsuir.banking.proxy.internetbanking;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Payment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Payment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Account" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}Account" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ClientAccountId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="LegalAccount" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}LegalAccount" minOccurs="0"/>
 *         &lt;element name="LegalAccountId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payment", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", propOrder = {
    "account",
    "amount",
    "clientAccountId",
    "dateTime",
    "id",
    "legalAccount",
    "legalAccountId"
})
public class Payment {

    @XmlElementRef(name = "Account", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", type = JAXBElement.class)
    protected JAXBElement<Account> account;
    @XmlElement(name = "Amount")
    protected BigDecimal amount;
    @XmlElement(name = "ClientAccountId")
    protected Integer clientAccountId;
    @XmlElement(name = "DateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    @XmlElement(name = "Id")
    protected Integer id;
    @XmlElementRef(name = "LegalAccount", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", type = JAXBElement.class)
    protected JAXBElement<LegalAccount> legalAccount;
    @XmlElement(name = "LegalAccountId")
    protected Integer legalAccountId;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Account }{@code >}
     *     
     */
    public JAXBElement<Account> getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Account }{@code >}
     *     
     */
    public void setAccount(JAXBElement<Account> value) {
        this.account = ((JAXBElement<Account> ) value);
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the clientAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getClientAccountId() {
        return clientAccountId;
    }

    /**
     * Sets the value of the clientAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setClientAccountId(Integer value) {
        this.clientAccountId = value;
    }

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
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
     * Gets the value of the legalAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LegalAccount }{@code >}
     *     
     */
    public JAXBElement<LegalAccount> getLegalAccount() {
        return legalAccount;
    }

    /**
     * Sets the value of the legalAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LegalAccount }{@code >}
     *     
     */
    public void setLegalAccount(JAXBElement<LegalAccount> value) {
        this.legalAccount = ((JAXBElement<LegalAccount> ) value);
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

}
