
package by.bsuir.banking.proxy.card;

import java.math.BigDecimal;
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
@WebService(name = "ICardService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ICardService {


    /**
     * 
     * @param securityToken
     * @param number
     * @return
     *     returns by.bsuir.banking.proxy.card.Account
     * @throws ICardServiceGetAccountByNumberDomainFaultFaultFaultMessage
     * @throws ICardServiceGetAccountByNumberAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetAccountByNumber", action = "http://tempuri.org/ICardService/GetAccountByNumber")
    @WebResult(name = "GetAccountByNumberResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetAccountByNumber", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetAccountByNumber")
    @ResponseWrapper(localName = "GetAccountByNumberResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetAccountByNumberResponse")
    public Account getAccountByNumber(
        @WebParam(name = "number", targetNamespace = "http://tempuri.org/")
        String number,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceGetAccountByNumberAuthorizationFaultFaultFaultMessage, ICardServiceGetAccountByNumberDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param accountId
     * @param securityToken
     * @return
     *     returns by.bsuir.banking.proxy.card.Account
     * @throws ICardServiceGetAccountByIdDomainFaultFaultFaultMessage
     * @throws ICardServiceGetAccountByIdAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetAccountById", action = "http://tempuri.org/ICardService/GetAccountById")
    @WebResult(name = "GetAccountByIdResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetAccountById", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetAccountById")
    @ResponseWrapper(localName = "GetAccountByIdResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetAccountByIdResponse")
    public Account getAccountById(
        @WebParam(name = "accountId", targetNamespace = "http://tempuri.org/")
        Integer accountId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceGetAccountByIdAuthorizationFaultFaultFaultMessage, ICardServiceGetAccountByIdDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param account
     * @throws ICardServiceOpenAccountDomainFaultFaultFaultMessage
     * @throws ICardServiceOpenAccountAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "OpenAccount", action = "http://tempuri.org/ICardService/OpenAccount")
    @RequestWrapper(localName = "OpenAccount", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.OpenAccount")
    @ResponseWrapper(localName = "OpenAccountResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.OpenAccountResponse")
    public void openAccount(
        @WebParam(name = "account", targetNamespace = "http://tempuri.org/")
        Account account,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceOpenAccountAuthorizationFaultFaultFaultMessage, ICardServiceOpenAccountDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param accountId
     * @param securityToken
     * @throws ICardServiceCloseAccountDomainFaultFaultFaultMessage
     * @throws ICardServiceCloseAccountAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "CloseAccount", action = "http://tempuri.org/ICardService/CloseAccount")
    @RequestWrapper(localName = "CloseAccount", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.CloseAccount")
    @ResponseWrapper(localName = "CloseAccountResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.CloseAccountResponse")
    public void closeAccount(
        @WebParam(name = "accountId", targetNamespace = "http://tempuri.org/")
        Integer accountId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceCloseAccountAuthorizationFaultFaultFaultMessage, ICardServiceCloseAccountDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param cardId
     * @param securityToken
     * @return
     *     returns by.bsuir.banking.proxy.card.Card
     * @throws ICardServiceGetCardAuthorizationFaultFaultFaultMessage
     * @throws ICardServiceGetCardDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetCard", action = "http://tempuri.org/ICardService/GetCard")
    @WebResult(name = "GetCardResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetCard", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetCard")
    @ResponseWrapper(localName = "GetCardResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetCardResponse")
    public Card getCard(
        @WebParam(name = "cardId", targetNamespace = "http://tempuri.org/")
        Integer cardId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceGetCardAuthorizationFaultFaultFaultMessage, ICardServiceGetCardDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param card
     * @throws ICardServiceCreateCardAuthorizationFaultFaultFaultMessage
     * @throws ICardServiceCreateCardDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "CreateCard", action = "http://tempuri.org/ICardService/CreateCard")
    @RequestWrapper(localName = "CreateCard", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.CreateCard")
    @ResponseWrapper(localName = "CreateCardResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.CreateCardResponse")
    public void createCard(
        @WebParam(name = "card", targetNamespace = "http://tempuri.org/")
        Card card,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceCreateCardAuthorizationFaultFaultFaultMessage, ICardServiceCreateCardDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param cardId
     * @param securityToken
     * @throws ICardServiceDeleteCardDomainFaultFaultFaultMessage
     * @throws ICardServiceDeleteCardAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "DeleteCard", action = "http://tempuri.org/ICardService/DeleteCard")
    @RequestWrapper(localName = "DeleteCard", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.DeleteCard")
    @ResponseWrapper(localName = "DeleteCardResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.DeleteCardResponse")
    public void deleteCard(
        @WebParam(name = "cardId", targetNamespace = "http://tempuri.org/")
        Integer cardId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceDeleteCardAuthorizationFaultFaultFaultMessage, ICardServiceDeleteCardDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param cardId
     * @param securityToken
     * @return
     *     returns java.math.BigDecimal
     * @throws ICardServiceGetAmountLimitDomainFaultFaultFaultMessage
     * @throws ICardServiceGetAmountLimitAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetAmountLimit", action = "http://tempuri.org/ICardService/GetAmountLimit")
    @WebResult(name = "GetAmountLimitResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetAmountLimit", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetAmountLimit")
    @ResponseWrapper(localName = "GetAmountLimitResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetAmountLimitResponse")
    public BigDecimal getAmountLimit(
        @WebParam(name = "cardId", targetNamespace = "http://tempuri.org/")
        Integer cardId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceGetAmountLimitAuthorizationFaultFaultFaultMessage, ICardServiceGetAmountLimitDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param cardId
     * @param securityToken
     * @return
     *     returns java.lang.Integer
     * @throws ICardServiceGetOperationLimitAuthorizationFaultFaultFaultMessage
     * @throws ICardServiceGetOperationLimitDomainFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetOperationLimit", action = "http://tempuri.org/ICardService/GetOperationLimit")
    @WebResult(name = "GetOperationLimitResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetOperationLimit", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetOperationLimit")
    @ResponseWrapper(localName = "GetOperationLimitResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetOperationLimitResponse")
    public Integer getOperationLimit(
        @WebParam(name = "cardId", targetNamespace = "http://tempuri.org/")
        Integer cardId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceGetOperationLimitAuthorizationFaultFaultFaultMessage, ICardServiceGetOperationLimitDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @return
     *     returns by.bsuir.banking.proxy.card.ArrayOfCardType
     * @throws ICardServiceGetAllCardTypesDomainFaultFaultFaultMessage
     * @throws ICardServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetAllCardTypes", action = "http://tempuri.org/ICardService/GetAllCardTypes")
    @WebResult(name = "GetAllCardTypesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetAllCardTypes", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetAllCardTypes")
    @ResponseWrapper(localName = "GetAllCardTypesResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetAllCardTypesResponse")
    public ArrayOfCardType getAllCardTypes(
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceGetAllCardTypesAuthorizationFaultFaultFaultMessage, ICardServiceGetAllCardTypesDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param clientId
     * @return
     *     returns by.bsuir.banking.proxy.card.ArrayOfAccount
     * @throws ICardServiceGetAccountsForClientDomainFaultFaultFaultMessage
     * @throws ICardServiceGetAccountsForClientAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetAccountsForClient", action = "http://tempuri.org/ICardService/GetAccountsForClient")
    @WebResult(name = "GetAccountsForClientResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetAccountsForClient", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetAccountsForClient")
    @ResponseWrapper(localName = "GetAccountsForClientResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetAccountsForClientResponse")
    public ArrayOfAccount getAccountsForClient(
        @WebParam(name = "clientId", targetNamespace = "http://tempuri.org/")
        Integer clientId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceGetAccountsForClientAuthorizationFaultFaultFaultMessage, ICardServiceGetAccountsForClientDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param securityToken
     * @param clientId
     * @return
     *     returns by.bsuir.banking.proxy.card.ArrayOfCard
     * @throws ICardServiceGetCardsForClientDomainFaultFaultFaultMessage
     * @throws ICardServiceGetCardsForClientAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetCardsForClient", action = "http://tempuri.org/ICardService/GetCardsForClient")
    @WebResult(name = "GetCardsForClientResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetCardsForClient", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetCardsForClient")
    @ResponseWrapper(localName = "GetCardsForClientResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetCardsForClientResponse")
    public ArrayOfCard getCardsForClient(
        @WebParam(name = "clientId", targetNamespace = "http://tempuri.org/")
        Integer clientId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceGetCardsForClientAuthorizationFaultFaultFaultMessage, ICardServiceGetCardsForClientDomainFaultFaultFaultMessage
    ;

    /**
     * 
     * @param accountId
     * @param securityToken
     * @return
     *     returns by.bsuir.banking.proxy.card.Card
     * @throws ICardServiceGetCardForAccountDomainFaultFaultFaultMessage
     * @throws ICardServiceGetCardForAccountAuthorizationFaultFaultFaultMessage
     */
    @WebMethod(operationName = "GetCardForAccount", action = "http://tempuri.org/ICardService/GetCardForAccount")
    @WebResult(name = "GetCardForAccountResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetCardForAccount", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetCardForAccount")
    @ResponseWrapper(localName = "GetCardForAccountResponse", targetNamespace = "http://tempuri.org/", className = "by.bsuir.banking.proxy.card.GetCardForAccountResponse")
    public Card getCardForAccount(
        @WebParam(name = "accountId", targetNamespace = "http://tempuri.org/")
        Integer accountId,
        @WebParam(name = "securityToken", targetNamespace = "http://tempuri.org/")
        String securityToken)
        throws ICardServiceGetCardForAccountAuthorizationFaultFaultFaultMessage, ICardServiceGetCardForAccountDomainFaultFaultFaultMessage
    ;

}
