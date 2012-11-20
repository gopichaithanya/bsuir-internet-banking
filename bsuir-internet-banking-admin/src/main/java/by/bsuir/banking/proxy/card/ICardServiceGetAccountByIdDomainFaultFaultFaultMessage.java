
package by.bsuir.banking.proxy.card;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "DomainFault", targetNamespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts")
public class ICardServiceGetAccountByIdDomainFaultFaultFaultMessage
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DomainFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ICardServiceGetAccountByIdDomainFaultFaultFaultMessage(String message, DomainFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ICardServiceGetAccountByIdDomainFaultFaultFaultMessage(String message, DomainFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: by.bsuir.banking.proxy.card.DomainFault
     */
    public DomainFault getFaultInfo() {
        return faultInfo;
    }

}
