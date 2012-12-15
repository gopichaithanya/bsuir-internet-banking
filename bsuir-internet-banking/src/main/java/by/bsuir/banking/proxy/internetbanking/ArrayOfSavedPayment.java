
package by.bsuir.banking.proxy.internetbanking;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSavedPayment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSavedPayment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SavedPayment" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}SavedPayment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSavedPayment", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", propOrder = {
    "savedPayment"
})
public class ArrayOfSavedPayment {

    @XmlElement(name = "SavedPayment", nillable = true)
    protected List<SavedPayment> savedPayment;

    /**
     * Gets the value of the savedPayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the savedPayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSavedPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SavedPayment }
     * 
     * 
     */
    public List<SavedPayment> getSavedPayment() {
        if (savedPayment == null) {
            savedPayment = new ArrayList<SavedPayment>();
        }
        return this.savedPayment;
    }

}
