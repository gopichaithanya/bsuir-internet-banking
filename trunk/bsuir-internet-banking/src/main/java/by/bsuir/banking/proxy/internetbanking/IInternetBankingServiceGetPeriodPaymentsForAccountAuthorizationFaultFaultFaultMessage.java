
package by.bsuir.banking.proxy.internetbanking;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "AuthorizationFault", targetNamespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts")
public class IInternetBankingServiceGetPeriodPaymentsForAccountAuthorizationFaultFaultFaultMessage
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private AuthorizationFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public IInternetBankingServiceGetPeriodPaymentsForAccountAuthorizationFaultFaultFaultMessage(String message, AuthorizationFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public IInternetBankingServiceGetPeriodPaymentsForAccountAuthorizationFaultFaultFaultMessage(String message, AuthorizationFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: by.bsuir.banking.proxy.internetbanking.AuthorizationFault
     */
    public AuthorizationFault getFaultInfo() {
        return faultInfo;
    }

}
