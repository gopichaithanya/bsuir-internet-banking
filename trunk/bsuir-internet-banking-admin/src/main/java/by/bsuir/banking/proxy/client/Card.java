
package by.bsuir.banking.proxy.client;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Card complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Card">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CardTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IsLocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MoneyLimit" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationsLimit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SecretWord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Card", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", propOrder = {
    "accountId",
    "cardTypeId",
    "id",
    "isLocked",
    "moneyLimit",
    "number",
    "operationsLimit",
    "secretWord"
})
public class Card {

    @XmlElement(name = "AccountId")
    protected Integer accountId;
    @XmlElement(name = "CardTypeId")
    protected Integer cardTypeId;
    @XmlElement(name = "Id")
    protected Integer id;
    @XmlElement(name = "IsLocked")
    protected Boolean isLocked;
    @XmlElement(name = "MoneyLimit")
    protected BigDecimal moneyLimit;
    @XmlElementRef(name = "Number", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", type = JAXBElement.class)
    protected JAXBElement<String> number;
    @XmlElement(name = "OperationsLimit")
    protected Integer operationsLimit;
    @XmlElementRef(name = "SecretWord", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", type = JAXBElement.class)
    protected JAXBElement<String> secretWord;

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
     * Gets the value of the cardTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCardTypeId() {
        return cardTypeId;
    }

    /**
     * Sets the value of the cardTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCardTypeId(Integer value) {
        this.cardTypeId = value;
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
     * Gets the value of the isLocked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsLocked() {
        return isLocked;
    }

    /**
     * Sets the value of the isLocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsLocked(Boolean value) {
        this.isLocked = value;
    }

    /**
     * Gets the value of the moneyLimit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMoneyLimit() {
        return moneyLimit;
    }

    /**
     * Sets the value of the moneyLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMoneyLimit(BigDecimal value) {
        this.moneyLimit = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNumber(JAXBElement<String> value) {
        this.number = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the operationsLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOperationsLimit() {
        return operationsLimit;
    }

    /**
     * Sets the value of the operationsLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOperationsLimit(Integer value) {
        this.operationsLimit = value;
    }

    /**
     * Gets the value of the secretWord property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecretWord() {
        return secretWord;
    }

    /**
     * Sets the value of the secretWord property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecretWord(JAXBElement<String> value) {
        this.secretWord = ((JAXBElement<String> ) value);
    }

}
