 
package by.bsuir.banking.proxy.operator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
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
@WebService(name = "IOperatorService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IOperatorService {


    /**
     * 
     * @param securityToken
     * @param clientId
     * @return
     *     returns by.bsuir.banking.proxy.operator.Client
     * @throws IOperatorServiceGetClientDomainFaultFaultFaultMessage
     * @throws IOperatorServiceGetClientAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetClient", action = "http://tempuri.org/IOperatorService/GetClient")
    @WebResult(name = "GetClientResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetClient", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.GetClient")
    @ResponseWrapper(localName = "GetClientResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.GetClientResponse")
    public Client getClient(
        @WebParam(name = "clientId", targetNamespace = "http://tempuri.org/")
        Integer clientId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IOperatorServiceGetClientAuthorizationFaultFaultFaultMessage, IOperatorServiceGetClientDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param client
     * @param securityToken
     * @return
     *     returns java.lang.Integer
     * @throws IOperatorServiceCreateClientAuthorizationFaultFaultFaultMessage
     * @throws IOperatorServiceCreateClientDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "CreateClient", action = "http://tempuri.org/IOperatorService/CreateClient")
    @WebResult(name = "CreateClientResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "CreateClient", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.CreateClient")
    @ResponseWrapper(localName = "CreateClientResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.CreateClientResponse")
    public Integer createClient(
        @WebParam(name = "client", targetNamespace = "http://tempuri.org/")
        Client client,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IOperatorServiceCreateClientAuthorizationFaultFaultFaultMessage, IOperatorServiceCreateClientDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param client
     * @param securityToken
     * @throws IOperatorServiceUpdateClientDomainFaultFaultFaultMessage
     * @throws IOperatorServiceUpdateClientAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "UpdateClient", action = "http://tempuri.org/IOperatorService/UpdateClient")
    @RequestWrapper(localName = "UpdateClient", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.UpdateClient")
    @ResponseWrapper(localName = "UpdateClientResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.UpdateClientResponse")
    public void updateClient(
        @WebParam(name = "client", targetNamespace = "http://tempuri.org/")
        Client client,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IOperatorServiceUpdateClientAuthorizationFaultFaultFaultMessage, IOperatorServiceUpdateClientDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param clientId
     * @throws IOperatorServiceDeleteClientAuthorizationFaultFaultFaultMessage
     * @throws IOperatorServiceDeleteClientDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "DeleteClient", action = "http://tempuri.org/IOperatorService/DeleteClient")
    @RequestWrapper(localName = "DeleteClient", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.DeleteClient")
    @ResponseWrapper(localName = "DeleteClientResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.DeleteClientResponse")
    public void deleteClient(
        @WebParam(name = "clientId", targetNamespace = "http://tempuri.org/")
        Integer clientId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IOperatorServiceDeleteClientAuthorizationFaultFaultFaultMessage, IOperatorServiceDeleteClientDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param count
     * @param securityToken
     * @param pageNumber
     * @return
     *     returns by.bsuir.banking.proxy.operator.ArrayOfClient
     * @throws IOperatorServiceGetPageofClientsDomainFaultFaultFaultMessage
     * @throws IOperatorServiceGetPageofClientsAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetPageofClients", action = "http://tempuri.org/IOperatorService/GetPageofClients")
    @WebResult(name = "GetPageofClientsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetPageofClients", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.GetPageofClients")
    @ResponseWrapper(localName = "GetPageofClientsResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.GetPageofClientsResponse")
    public ArrayOfClient getPageofClients(
        @WebParam(name = "pageNumber", targetNamespace = "http://tempuri.org/")
        Integer pageNumber,
        @WebParam(name = "count", targetNamespace = "http://tempuri.org/")
        Integer count,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IOperatorServiceGetPageofClientsAuthorizationFaultFaultFaultMessage, IOperatorServiceGetPageofClientsDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @return
     *     returns java.lang.Integer
     * @throws IOperatorServiceGetClientsCountAuthorizationFaultFaultFaultMessage
     * @throws IOperatorServiceGetClientsCountDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetClientsCount", action = "http://tempuri.org/IOperatorService/GetClientsCount")
    @WebResult(name = "GetClientsCountResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetClientsCount", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.GetClientsCount")
    @ResponseWrapper(localName = "GetClientsCountResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.GetClientsCountResponse")
    public Integer getClientsCount(
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IOperatorServiceGetClientsCountAuthorizationFaultFaultFaultMessage, IOperatorServiceGetClientsCountDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param middleName
     * @param lastName
     * @param securityToken
     * @param firstName
     * @return
     *     returns by.bsuir.banking.proxy.operator.ArrayOfClient
     * @throws IOperatorServiceGetClientsByNameDomainFaultFaultFaultMessage
     * @throws IOperatorServiceGetClientsByNameAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetClientsByName", action = "http://tempuri.org/IOperatorService/GetClientsByName")
    @WebResult(name = "GetClientsByNameResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetClientsByName", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.GetClientsByName")
    @ResponseWrapper(localName = "GetClientsByNameResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.GetClientsByNameResponse")
    public ArrayOfClient getClientsByName(
        @WebParam(name = "firstName", targetNamespace = "http://tempuri.org/")
        String firstName,
        @WebParam(name = "middleName", targetNamespace = "http://tempuri.org/")
        String middleName,
        @WebParam(name = "lastName", targetNamespace = "http://tempuri.org/")
        String lastName,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IOperatorServiceGetClientsByNameAuthorizationFaultFaultFaultMessage, IOperatorServiceGetClientsByNameDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param seria
     * @param securityToken
     * @param number
     * @return
     *     returns by.bsuir.banking.proxy.operator.Client
     * @throws IOperatorServiceGetClientByPassportDataDomainFaultFaultFaultMessage
     * @throws IOperatorServiceGetClientByPassportDataAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetClientByPassportData", action = "http://tempuri.org/IOperatorService/GetClientByPassportData")
    @WebResult(name = "GetClientByPassportDataResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetClientByPassportData", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.GetClientByPassportData")
    @ResponseWrapper(localName = "GetClientByPassportDataResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.GetClientByPassportDataResponse")
    public Client getClientByPassportData(
        @WebParam(name = "seria", targetNamespace = "http://tempuri.org/")
        String seria,
        @WebParam(name = "number", targetNamespace = "http://tempuri.org/")
        String number,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IOperatorServiceGetClientByPassportDataAuthorizationFaultFaultFaultMessage, IOperatorServiceGetClientByPassportDataDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param newLogin
     * @param newPassword
     * @param clientId
     * @throws IOperatorServiceUnlockClientAuthorizationFaultFaultFaultMessage
     * @throws IOperatorServiceUnlockClientDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "UnlockClient", action = "http://tempuri.org/IOperatorService/UnlockClient")
    @RequestWrapper(localName = "UnlockClient", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.UnlockClient")
    @ResponseWrapper(localName = "UnlockClientResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.operator.UnlockClientResponse")
    public void unlockClient(
        @WebParam(name = "clientId", targetNamespace = "http://tempuri.org/")
        Integer clientId,
        @WebParam(name = "newLogin", targetNamespace = "http://tempuri.org/")
        String newLogin,
        @WebParam(name = "newPassword", targetNamespace = "http://tempuri.org/")
        String newPassword,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IOperatorServiceUnlockClientAuthorizationFaultFaultFaultMessage, IOperatorServiceUnlockClientDomainFaultFaultFaultMessage
    ;

}
