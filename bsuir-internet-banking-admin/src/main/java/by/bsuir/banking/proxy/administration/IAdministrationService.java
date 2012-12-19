
package by.bsuir.banking.proxy.administration;

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
@WebService(name = "IAdministrationService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IAdministrationService {


    /**
     * 
     * @param newAdministrator
     * @param securityToken
     * @return
     *     returns java.lang.Integer
     * @throws IAdministrationServiceCreateNewAdministratorAuthorizationFaultFaultFaultMessage
     * @throws IAdministrationServiceCreateNewAdministratorDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "CreateNewAdministrator", action = "http://tempuri.org/IAdministrationService/CreateNewAdministrator")
    @WebResult(name = "CreateNewAdministratorResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "CreateNewAdministrator", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.CreateNewAdministrator")
    @ResponseWrapper(localName = "CreateNewAdministratorResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.CreateNewAdministratorResponse")
    public Integer createNewAdministrator(
        @WebParam(name = "newAdministrator", targetNamespace = "http://tempuri.org/")
        Administrator newAdministrator,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IAdministrationServiceCreateNewAdministratorAuthorizationFaultFaultFaultMessage, IAdministrationServiceCreateNewAdministratorDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param newOperator
     * @return
     *     returns java.lang.Integer
     * @throws IAdministrationServiceCreateNewOperatorAuthorizationFaultFaultFaultMessage
     * @throws IAdministrationServiceCreateNewOperatorDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "CreateNewOperator", action = "http://tempuri.org/IAdministrationService/CreateNewOperator")
    @WebResult(name = "CreateNewOperatorResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "CreateNewOperator", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.CreateNewOperator")
    @ResponseWrapper(localName = "CreateNewOperatorResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.CreateNewOperatorResponse")
    public Integer createNewOperator(
        @WebParam(name = "newOperator", targetNamespace = "http://tempuri.org/")
        Operator newOperator,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IAdministrationServiceCreateNewOperatorAuthorizationFaultFaultFaultMessage, IAdministrationServiceCreateNewOperatorDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param pageNumber
     * @param itemsPerPage
     * @return
     *     returns by.bsuir.banking.proxy.administration.ArrayOfAdministrator
     * @throws IAdministrationServiceGetAllAdministratorsDomainFaultFaultFaultMessage
     * @throws IAdministrationServiceGetAllAdministratorsAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetAllAdministrators", action = "http://tempuri.org/IAdministrationService/GetAllAdministrators")
    @WebResult(name = "GetAllAdministratorsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetAllAdministrators", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.GetAllAdministrators")
    @ResponseWrapper(localName = "GetAllAdministratorsResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.GetAllAdministratorsResponse")
    public ArrayOfAdministrator getAllAdministrators(
        @WebParam(name = "pageNumber", targetNamespace = "http://tempuri.org/")
        Integer pageNumber,
        @WebParam(name = "itemsPerPage", targetNamespace = "http://tempuri.org/")
        Integer itemsPerPage,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IAdministrationServiceGetAllAdministratorsAuthorizationFaultFaultFaultMessage, IAdministrationServiceGetAllAdministratorsDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param pageNumber
     * @param itemsPerPage
     * @return
     *     returns by.bsuir.banking.proxy.administration.ArrayOfOperator
     * @throws IAdministrationServiceGetAllOperatorsDomainFaultFaultFaultMessage
     * @throws IAdministrationServiceGetAllOperatorsAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetAllOperators", action = "http://tempuri.org/IAdministrationService/GetAllOperators")
    @WebResult(name = "GetAllOperatorsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetAllOperators", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.GetAllOperators")
    @ResponseWrapper(localName = "GetAllOperatorsResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.GetAllOperatorsResponse")
    public ArrayOfOperator getAllOperators(
        @WebParam(name = "pageNumber", targetNamespace = "http://tempuri.org/")
        Integer pageNumber,
        @WebParam(name = "itemsPerPage", targetNamespace = "http://tempuri.org/")
        Integer itemsPerPage,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IAdministrationServiceGetAllOperatorsAuthorizationFaultFaultFaultMessage, IAdministrationServiceGetAllOperatorsDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param updatedAdministrator
     * @param securityToken
     * @throws IAdministrationServiceUpdateAdministratorDomainFaultFaultFaultMessage
     * @throws IAdministrationServiceUpdateAdministratorAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "UpdateAdministrator", action = "http://tempuri.org/IAdministrationService/UpdateAdministrator")
    @RequestWrapper(localName = "UpdateAdministrator", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.UpdateAdministrator")
    @ResponseWrapper(localName = "UpdateAdministratorResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.UpdateAdministratorResponse")
    public void updateAdministrator(
        @WebParam(name = "updatedAdministrator", targetNamespace = "http://tempuri.org/")
        Administrator updatedAdministrator,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IAdministrationServiceUpdateAdministratorAuthorizationFaultFaultFaultMessage, IAdministrationServiceUpdateAdministratorDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param updatedOperator
     * @throws IAdministrationServiceUpdateOperatorAuthorizationFaultFaultFaultMessage
     * @throws IAdministrationServiceUpdateOperatorDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "UpdateOperator", action = "http://tempuri.org/IAdministrationService/UpdateOperator")
    @RequestWrapper(localName = "UpdateOperator", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.UpdateOperator")
    @ResponseWrapper(localName = "UpdateOperatorResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.UpdateOperatorResponse")
    public void updateOperator(
        @WebParam(name = "updatedOperator", targetNamespace = "http://tempuri.org/")
        Operator updatedOperator,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IAdministrationServiceUpdateOperatorAuthorizationFaultFaultFaultMessage, IAdministrationServiceUpdateOperatorDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param administratorId
     * @throws IAdministrationServiceRemoveAdministratorDomainFaultFaultFaultMessage
     * @throws IAdministrationServiceRemoveAdministratorAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "RemoveAdministrator", action = "http://tempuri.org/IAdministrationService/RemoveAdministrator")
    @RequestWrapper(localName = "RemoveAdministrator", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.RemoveAdministrator")
    @ResponseWrapper(localName = "RemoveAdministratorResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.RemoveAdministratorResponse")
    public void removeAdministrator(
        @WebParam(name = "administratorId", targetNamespace = "http://tempuri.org/")
        Integer administratorId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IAdministrationServiceRemoveAdministratorAuthorizationFaultFaultFaultMessage, IAdministrationServiceRemoveAdministratorDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param operatorId
     * @param securityToken
     * @throws IAdministrationServiceRemoveOperatorAuthorizationFaultFaultFaultMessage
     * @throws IAdministrationServiceRemoveOperatorDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "RemoveOperator", action = "http://tempuri.org/IAdministrationService/RemoveOperator")
    @RequestWrapper(localName = "RemoveOperator", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.RemoveOperator")
    @ResponseWrapper(localName = "RemoveOperatorResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.RemoveOperatorResponse")
    public void removeOperator(
        @WebParam(name = "operatorId", targetNamespace = "http://tempuri.org/")
        Integer operatorId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IAdministrationServiceRemoveOperatorAuthorizationFaultFaultFaultMessage, IAdministrationServiceRemoveOperatorDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @return
     *     returns java.lang.Integer
     * @throws IAdministrationServiceGetAdministratorsCountDomainFaultFaultFaultMessage
     * @throws IAdministrationServiceGetAdministratorsCountAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetAdministratorsCount", action = "http://tempuri.org/IAdministrationService/GetAdministratorsCount")
    @WebResult(name = "GetAdministratorsCountResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetAdministratorsCount", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.GetAdministratorsCount")
    @ResponseWrapper(localName = "GetAdministratorsCountResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.GetAdministratorsCountResponse")
    public Integer getAdministratorsCount(
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IAdministrationServiceGetAdministratorsCountAuthorizationFaultFaultFaultMessage, IAdministrationServiceGetAdministratorsCountDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @return
     *     returns java.lang.Integer
     * @throws IAdministrationServiceGetOperatorsCountDomainFaultFaultFaultMessage
     * @throws IAdministrationServiceGetOperatorsCountAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetOperatorsCount", action = "http://tempuri.org/IAdministrationService/GetOperatorsCount")
    @WebResult(name = "GetOperatorsCountResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetOperatorsCount", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.GetOperatorsCount")
    @ResponseWrapper(localName = "GetOperatorsCountResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.GetOperatorsCountResponse")
    public Integer getOperatorsCount(
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IAdministrationServiceGetOperatorsCountAuthorizationFaultFaultFaultMessage, IAdministrationServiceGetOperatorsCountDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param operatorId
     * @param securityToken
     * @return
     *     returns by.bsuir.banking.proxy.administration.Operator
     * @throws IAdministrationServiceGetOperatorByIdDomainFaultFaultFaultMessage
     * @throws IAdministrationServiceGetOperatorByIdAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetOperatorById", action = "http://tempuri.org/IAdministrationService/GetOperatorById")
    @WebResult(name = "GetOperatorByIdResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetOperatorById", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.GetOperatorById")
    @ResponseWrapper(localName = "GetOperatorByIdResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.GetOperatorByIdResponse")
    public Operator getOperatorById(
        @WebParam(name = "operatorId", targetNamespace = "http://tempuri.org/")
        Integer operatorId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IAdministrationServiceGetOperatorByIdAuthorizationFaultFaultFaultMessage, IAdministrationServiceGetOperatorByIdDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param administratorId
     * @return
     *     returns by.bsuir.banking.proxy.administration.Administrator
     * @throws IAdministrationServiceGetAdministratorByIdAuthorizationFaultFaultFaultMessage
     * @throws IAdministrationServiceGetAdministratorByIdDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetAdministratorById", action = "http://tempuri.org/IAdministrationService/GetAdministratorById")
    @WebResult(name = "GetAdministratorByIdResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetAdministratorById", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.GetAdministratorById")
    @ResponseWrapper(localName = "GetAdministratorByIdResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.administration.GetAdministratorByIdResponse")
    public Administrator getAdministratorById(
        @WebParam(name = "administratorId", targetNamespace = "http://tempuri.org/")
        Integer administratorId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws IAdministrationServiceGetAdministratorByIdAuthorizationFaultFaultFaultMessage, IAdministrationServiceGetAdministratorByIdDomainFaultFaultFaultMessage
    ;

}