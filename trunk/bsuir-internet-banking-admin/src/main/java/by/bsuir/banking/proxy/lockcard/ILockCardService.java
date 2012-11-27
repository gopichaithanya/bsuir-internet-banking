
package by.bsuir.banking.proxy.lockcard;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ILockCardService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ILockCardService {


    /**
     * 
     * @param secretWord
     * @param number
     * @throws ILockCardServiceLockCardDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "LockCard", action = "http://tempuri.org/ILockCardService/LockCard")
    @RequestWrapper(localName = "LockCard", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.lockcard.LockCard")
    @ResponseWrapper(localName = "LockCardResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.lockcard.LockCardResponse")
    public void lockCard(
        @WebParam(name = "number", targetNamespace = "http://tempuri.org/")
        String number,
        @WebParam(name = "secretWord", targetNamespace = "http://tempuri.org/")
        String secretWord)
        throws ILockCardServiceLockCardDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param secretWord
     * @param number
     * @throws ILockCardServiceUnlockCardDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "UnlockCard", action = "http://tempuri.org/ILockCardService/UnlockCard")
    @RequestWrapper(localName = "UnlockCard", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.lockcard.UnlockCard")
    @ResponseWrapper(localName = "UnlockCardResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.lockcard.UnlockCardResponse")
    public void unlockCard(
        @WebParam(name = "number", targetNamespace = "http://tempuri.org/")
        String number,
        @WebParam(name = "secretWord", targetNamespace = "http://tempuri.org/")
        String secretWord)
        throws ILockCardServiceUnlockCardDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param cardId
     * @param securityToken
     * @throws ILockCardServiceLockCardByIdDomainFaultFaultFaultMessage
     * @throws ILockCardServiceLockCardByIdAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "LockCardById", action = "http://tempuri.org/ILockCardService/LockCardById")
    @RequestWrapper(localName = "LockCardById", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.lockcard.LockCardById")
    @ResponseWrapper(localName = "LockCardByIdResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.lockcard.LockCardByIdResponse")
    public void lockCardById(
        @WebParam(name = "cardId", targetNamespace = "http://tempuri.org/")
        Integer cardId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ILockCardServiceLockCardByIdAuthorizationFaultFaultFaultMessage, ILockCardServiceLockCardByIdDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param cardId
     * @param securityToken
     * @throws ILockCardServiceUnlockCardByIdAuthorizationFaultFaultFaultMessage
     * @throws ILockCardServiceUnlockCardByIdDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "UnlockCardById", action = "http://tempuri.org/ILockCardService/UnlockCardById")
    @RequestWrapper(localName = "UnlockCardById", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.lockcard.UnlockCardById")
    @ResponseWrapper(localName = "UnlockCardByIdResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.lockcard.UnlockCardByIdResponse")
    public void unlockCardById(
        @WebParam(name = "cardId", targetNamespace = "http://tempuri.org/")
        Integer cardId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ILockCardServiceUnlockCardByIdAuthorizationFaultFaultFaultMessage, ILockCardServiceUnlockCardByIdDomainFaultFaultFaultMessage
    ;

}
