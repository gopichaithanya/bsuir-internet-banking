
package by.bsuir.banking.proxy.internetbanking;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfLegalPersonCategory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfLegalPersonCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LegalPersonCategory" type="{http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model}LegalPersonCategory" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfLegalPersonCategory", namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", propOrder = {
    "legalPersonCategory"
})
public class ArrayOfLegalPersonCategory {

    @XmlElement(name = "LegalPersonCategory", nillable = true)
    protected List<LegalPersonCategory> legalPersonCategory;

    /**
     * Gets the value of the legalPersonCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legalPersonCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegalPersonCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LegalPersonCategory }
     * 
     * 
     */
    public List<LegalPersonCategory> getLegalPersonCategory() {
        if (legalPersonCategory == null) {
            legalPersonCategory = new ArrayList<LegalPersonCategory>();
        }
        return this.legalPersonCategory;
    }

}
