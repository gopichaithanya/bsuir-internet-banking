
package by.bsuir.banking.proxy.currency;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPurchaseCurrencyRate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPurchaseCurrencyRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PurchaseCurrencyRate" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}PurchaseCurrencyRate" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPurchaseCurrencyRate", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", propOrder = {
    "purchaseCurrencyRate"
})
public class ArrayOfPurchaseCurrencyRate {

    @XmlElement(name = "PurchaseCurrencyRate", nillable = true)
    protected List<PurchaseCurrencyRate> purchaseCurrencyRate;

    /**
     * Gets the value of the purchaseCurrencyRate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the purchaseCurrencyRate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPurchaseCurrencyRate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PurchaseCurrencyRate }
     * 
     * 
     */
    public List<PurchaseCurrencyRate> getPurchaseCurrencyRate() {
        if (purchaseCurrencyRate == null) {
            purchaseCurrencyRate = new ArrayList<PurchaseCurrencyRate>();
        }
        return this.purchaseCurrencyRate;
    }

}
