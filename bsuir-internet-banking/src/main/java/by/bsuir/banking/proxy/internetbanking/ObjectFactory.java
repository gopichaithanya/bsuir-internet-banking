 
package by.bsuir.banking.proxy.internetbanking;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.bsuir.banking.proxy.internetbanking package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAccountsForClientSecurityToken_QNAME = new QName("http://tempuri.org/", "securityToken");
    private final static QName _GetAccountByIdResponseGetAccountByIdResult_QNAME = new QName("http://tempuri.org/", "GetAccountByIdResult");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _LegalPerson_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "LegalPerson");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _Account_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Account");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _Region_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Region");
    private final static QName _PurchaseCurrencyRate_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "PurchaseCurrencyRate");
    private final static QName _ArrayOfAutoPayment_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfAutoPayment");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _AuthorizationFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "AuthorizationFault");
    private final static QName _ArrayOfTransfer_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfTransfer");
    private final static QName _CardType_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "CardType");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _Client_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Client");
    private final static QName _ArrayOfCity_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfCity");
    private final static QName _ArrayOfLegalPersonCategory_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfLegalPersonCategory");
    private final static QName _SellCurrencyRate_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "SellCurrencyRate");
    private final static QName _ArrayOfPayment_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfPayment");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _Money_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Money");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _City_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "City");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _ArrayOfPurchaseCurrencyRate_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfPurchaseCurrencyRate");
    private final static QName _Card_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Card");
    private final static QName _DomainFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "DomainFault");
    private final static QName _Service_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Service");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Payment_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Payment");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _AutoPayment_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "AutoPayment");
    private final static QName _LegalPersonCategory_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "LegalPersonCategory");
    private final static QName _ArrayOfRegion_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfRegion");
    private final static QName _ArrayOfLegalAccount_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfLegalAccount");
    private final static QName _ArrayOfCardType_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfCardType");
    private final static QName _LegalAccount_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "LegalAccount");
    private final static QName _SavedPayment_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "SavedPayment");
    private final static QName _ArrayOfSavedPayment_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfSavedPayment");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _ArrayOfAccount_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfAccount");
    private final static QName _Transfer_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Transfer");
    private final static QName _CurrencyType_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "CurrencyType");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _ArrayOfCurrencyType_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfCurrencyType");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _ArrayOfLegalPerson_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfLegalPerson");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _Passport_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Passport");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _ArrayOfSellCurrencyRate_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfSellCurrencyRate");
    private final static QName _ArrayOfService_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfService");
    private final static QName _ArrayOfCard_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfCard");
    private final static QName _CreateAutoPaymentAutoPayment_QNAME = new QName("http://tempuri.org/", "autoPayment");
    private final static QName _ClientMiddleName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "MiddleName");
    private final static QName _ClientLogin_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Login");
    private final static QName _ClientPassword_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Password");
    private final static QName _ClientAdress_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Adress");
    private final static QName _ClientEmail_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Email");
    private final static QName _ClientPhoneNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "PhoneNumber");
    private final static QName _ClientFirstName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "FirstName");
    private final static QName _ClientLastName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "LastName");
    private final static QName _GetCitiesForRegionResponseGetCitiesForRegionResult_QNAME = new QName("http://tempuri.org/", "GetCitiesForRegionResult");
    private final static QName _GetCardsForClientResponseGetCardsForClientResult_QNAME = new QName("http://tempuri.org/", "GetCardsForClientResult");
    private final static QName _GetAutoPaymentsForClientResponseGetAutoPaymentsForClientResult_QNAME = new QName("http://tempuri.org/", "GetAutoPaymentsForClientResult");
    private final static QName _GetAllCardTypesResponseGetAllCardTypesResult_QNAME = new QName("http://tempuri.org/", "GetAllCardTypesResult");
    private final static QName _GetCardForAccountResponseGetCardForAccountResult_QNAME = new QName("http://tempuri.org/", "GetCardForAccountResult");
    private final static QName _GetCardForOperatorResponseGetCardForOperatorResult_QNAME = new QName("http://tempuri.org/", "GetCardForOperatorResult");
    private final static QName _DomainFaultMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "Message");
    private final static QName _CurrencyTypeName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Name");
    private final static QName _CurrencyTypeShortName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ShortName");
    private final static QName _GetAllLegalPersonCategoriesResponseGetAllLegalPersonCategoriesResult_QNAME = new QName("http://tempuri.org/", "GetAllLegalPersonCategoriesResult");
    private final static QName _ExecuteTransferReceiverCardNumber_QNAME = new QName("http://tempuri.org/", "receiverCardNumber");
    private final static QName _ExecuteTransferAmount_QNAME = new QName("http://tempuri.org/", "amount");
    private final static QName _ExecuteTransferCardNumber_QNAME = new QName("http://tempuri.org/", "cardNumber");
    private final static QName _UpdateSavedPaymentSavedPayment_QNAME = new QName("http://tempuri.org/", "savedPayment");
    private final static QName _UnlockCardSecretWord_QNAME = new QName("http://tempuri.org/", "secretWord");
    private final static QName _UnlockCardNumber_QNAME = new QName("http://tempuri.org/", "number");
    private final static QName _GetPeriodTransfersForAccountResponseGetPeriodTransfersForAccountResult_QNAME = new QName("http://tempuri.org/", "GetPeriodTransfersForAccountResult");
    private final static QName _GetBallanceResponseGetBallanceResult_QNAME = new QName("http://tempuri.org/", "GetBallanceResult");
    private final static QName _PayResponsePayResult_QNAME = new QName("http://tempuri.org/", "PayResult");
    private final static QName _PayInformation_QNAME = new QName("http://tempuri.org/", "information");
    private final static QName _PayReceiverLegalAccountNumber_QNAME = new QName("http://tempuri.org/", "receiverLegalAccountNumber");
    private final static QName _GetPurchaseCurrencyRatesResponseGetPurchaseCurrencyRatesResult_QNAME = new QName("http://tempuri.org/", "GetPurchaseCurrencyRatesResult");
    private final static QName _SetNewLoginNewLogin_QNAME = new QName("http://tempuri.org/", "newLogin");
    private final static QName _CreateCardCard_QNAME = new QName("http://tempuri.org/", "card");
    private final static QName _GetAutoPaymentResponseGetAutoPaymentResult_QNAME = new QName("http://tempuri.org/", "GetAutoPaymentResult");
    private final static QName _PassportNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Number");
    private final static QName _PassportAuthority_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Authority");
    private final static QName _PassportSeria_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Seria");
    private final static QName _GetCurrencyTypesResponseGetCurrencyTypesResult_QNAME = new QName("http://tempuri.org/", "GetCurrencyTypesResult");
    private final static QName _LegalPersonPhone_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Phone");
    private final static QName _LegalPersonAddress_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Address");
    private final static QName _LegalPersonLegalNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "LegalNumber");
    private final static QName _LegalPersonLegalAccounts_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "LegalAccounts");
    private final static QName _GetAllLegalPersonsResponseGetAllLegalPersonsResult_QNAME = new QName("http://tempuri.org/", "GetAllLegalPersonsResult");
    private final static QName _SetNewPasswordNewPassword_QNAME = new QName("http://tempuri.org/", "newPassword");
    private final static QName _GetCardsResponseGetCardsResult_QNAME = new QName("http://tempuri.org/", "GetCardsResult");
    private final static QName _GetPeriodPaymentsForAccountResponseGetPeriodPaymentsForAccountResult_QNAME = new QName("http://tempuri.org/", "GetPeriodPaymentsForAccountResult");
    private final static QName _PayERIPResponsePayERIPResult_QNAME = new QName("http://tempuri.org/", "PayERIPResult");
    private final static QName _GetAccountsForClientResponseGetAccountsForClientResult_QNAME = new QName("http://tempuri.org/", "GetAccountsForClientResult");
    private final static QName _GetLegalPersonByIdResponseGetLegalPersonByIdResult_QNAME = new QName("http://tempuri.org/", "GetLegalPersonByIdResult");
    private final static QName _GetPeriodPaymentsForCardResponseGetPeriodPaymentsForCardResult_QNAME = new QName("http://tempuri.org/", "GetPeriodPaymentsForCardResult");
    private final static QName _ExecuteTransferResponseExecuteTransferResult_QNAME = new QName("http://tempuri.org/", "ExecuteTransferResult");
    private final static QName _CardSecretWord_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "SecretWord");
    private final static QName _CardCVV2_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "CVV2");
    private final static QName _GetAllRegionsResponseGetAllRegionsResult_QNAME = new QName("http://tempuri.org/", "GetAllRegionsResult");
    private final static QName _GetClientResponseGetClientResult_QNAME = new QName("http://tempuri.org/", "GetClientResult");
    private final static QName _UpdateSellCurrencyRatesSellCurrencyRates_QNAME = new QName("http://tempuri.org/", "sellCurrencyRates");
    private final static QName _PaymentInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Information");
    private final static QName _GetAccountByNumberResponseGetAccountByNumberResult_QNAME = new QName("http://tempuri.org/", "GetAccountByNumberResult");
    private final static QName _OpenAccountAccount_QNAME = new QName("http://tempuri.org/", "account");
    private final static QName _GetSavedPaymentsForAccountResponseGetSavedPaymentsForAccountResult_QNAME = new QName("http://tempuri.org/", "GetSavedPaymentsForAccountResult");
    private final static QName _GetServicesForCityResponseGetServicesForCityResult_QNAME = new QName("http://tempuri.org/", "GetServicesForCityResult");
    private final static QName _GetSellCurrencyRatesResponseGetSellCurrencyRatesResult_QNAME = new QName("http://tempuri.org/", "GetSellCurrencyRatesResult");
    private final static QName _GetAutoPaymentsForAccountResponseGetAutoPaymentsForAccountResult_QNAME = new QName("http://tempuri.org/", "GetAutoPaymentsForAccountResult");
    private final static QName _PayERIPMoney_QNAME = new QName("http://tempuri.org/", "money");
    private final static QName _GetLegalPersonsForCategoryResponseGetLegalPersonsForCategoryResult_QNAME = new QName("http://tempuri.org/", "GetLegalPersonsForCategoryResult");
    private final static QName _GetAllSavedPaymentsResponseGetAllSavedPaymentsResult_QNAME = new QName("http://tempuri.org/", "GetAllSavedPaymentsResult");
    private final static QName _GetPeriodTransfersForCardResponseGetPeriodTransfersForCardResult_QNAME = new QName("http://tempuri.org/", "GetPeriodTransfersForCardResult");
    private final static QName _UpdatePurchaseCurrencyRatesPurchaseCurrencyRates_QNAME = new QName("http://tempuri.org/", "purchaseCurrencyRates");
    private final static QName _GetCardForClientResponseGetCardForClientResult_QNAME = new QName("http://tempuri.org/", "GetCardForClientResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.bsuir.banking.proxy.internetbanking
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPeriodPaymentsForCard }
     * 
     */
    public GetPeriodPaymentsForCard createGetPeriodPaymentsForCard() {
        return new GetPeriodPaymentsForCard();
    }

    /**
     * Create an instance of {@link GetAccountByIdResponse }
     * 
     */
    public GetAccountByIdResponse createGetAccountByIdResponse() {
        return new GetAccountByIdResponse();
    }

    /**
     * Create an instance of {@link GetAccountsForClient }
     * 
     */
    public GetAccountsForClient createGetAccountsForClient() {
        return new GetAccountsForClient();
    }

    /**
     * Create an instance of {@link ArrayOfCity }
     * 
     */
    public ArrayOfCity createArrayOfCity() {
        return new ArrayOfCity();
    }

    /**
     * Create an instance of {@link GetAllLegalPersons }
     * 
     */
    public GetAllLegalPersons createGetAllLegalPersons() {
        return new GetAllLegalPersons();
    }

    /**
     * Create an instance of {@link CreateAutoPayment }
     * 
     */
    public CreateAutoPayment createCreateAutoPayment() {
        return new CreateAutoPayment();
    }

    /**
     * Create an instance of {@link Money }
     * 
     */
    public Money createMoney() {
        return new Money();
    }

    /**
     * Create an instance of {@link GetAllCardTypes }
     * 
     */
    public GetAllCardTypes createGetAllCardTypes() {
        return new GetAllCardTypes();
    }

    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }

    /**
     * Create an instance of {@link GetCitiesForRegionResponse }
     * 
     */
    public GetCitiesForRegionResponse createGetCitiesForRegionResponse() {
        return new GetCitiesForRegionResponse();
    }

    /**
     * Create an instance of {@link ArrayOfSellCurrencyRate }
     * 
     */
    public ArrayOfSellCurrencyRate createArrayOfSellCurrencyRate() {
        return new ArrayOfSellCurrencyRate();
    }

    /**
     * Create an instance of {@link GetAutoPaymentsForClientResponse }
     * 
     */
    public GetAutoPaymentsForClientResponse createGetAutoPaymentsForClientResponse() {
        return new GetAutoPaymentsForClientResponse();
    }

    /**
     * Create an instance of {@link UpdateAutoPaymentResponse }
     * 
     */
    public UpdateAutoPaymentResponse createUpdateAutoPaymentResponse() {
        return new UpdateAutoPaymentResponse();
    }

    /**
     * Create an instance of {@link GetCardsForClientResponse }
     * 
     */
    public GetCardsForClientResponse createGetCardsForClientResponse() {
        return new GetCardsForClientResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCard }
     * 
     */
    public ArrayOfCard createArrayOfCard() {
        return new ArrayOfCard();
    }

    /**
     * Create an instance of {@link UnlockCardResponse }
     * 
     */
    public UnlockCardResponse createUnlockCardResponse() {
        return new UnlockCardResponse();
    }

    /**
     * Create an instance of {@link GetAllCardTypesResponse }
     * 
     */
    public GetAllCardTypesResponse createGetAllCardTypesResponse() {
        return new GetAllCardTypesResponse();
    }

    /**
     * Create an instance of {@link UnlockCardByIdResponse }
     * 
     */
    public UnlockCardByIdResponse createUnlockCardByIdResponse() {
        return new UnlockCardByIdResponse();
    }

    /**
     * Create an instance of {@link GetCardForAccountResponse }
     * 
     */
    public GetCardForAccountResponse createGetCardForAccountResponse() {
        return new GetCardForAccountResponse();
    }

    /**
     * Create an instance of {@link ArrayOfPayment }
     * 
     */
    public ArrayOfPayment createArrayOfPayment() {
        return new ArrayOfPayment();
    }

    /**
     * Create an instance of {@link GetAutoPaymentsForClient }
     * 
     */
    public GetAutoPaymentsForClient createGetAutoPaymentsForClient() {
        return new GetAutoPaymentsForClient();
    }

    /**
     * Create an instance of {@link GetCardForOperatorResponse }
     * 
     */
    public GetCardForOperatorResponse createGetCardForOperatorResponse() {
        return new GetCardForOperatorResponse();
    }

    /**
     * Create an instance of {@link ArrayOfService }
     * 
     */
    public ArrayOfService createArrayOfService() {
        return new ArrayOfService();
    }

    /**
     * Create an instance of {@link DomainFault }
     * 
     */
    public DomainFault createDomainFault() {
        return new DomainFault();
    }

    /**
     * Create an instance of {@link UpdatePurchaseCurrencyRatesResponse }
     * 
     */
    public UpdatePurchaseCurrencyRatesResponse createUpdatePurchaseCurrencyRatesResponse() {
        return new UpdatePurchaseCurrencyRatesResponse();
    }

    /**
     * Create an instance of {@link SetNewLoginResponse }
     * 
     */
    public SetNewLoginResponse createSetNewLoginResponse() {
        return new SetNewLoginResponse();
    }

    /**
     * Create an instance of {@link CloseAccountResponse }
     * 
     */
    public CloseAccountResponse createCloseAccountResponse() {
        return new CloseAccountResponse();
    }

    /**
     * Create an instance of {@link CreateAutoPaymentResponse }
     * 
     */
    public CreateAutoPaymentResponse createCreateAutoPaymentResponse() {
        return new CreateAutoPaymentResponse();
    }

    /**
     * Create an instance of {@link CurrencyType }
     * 
     */
    public CurrencyType createCurrencyType() {
        return new CurrencyType();
    }

    /**
     * Create an instance of {@link GetCurrencyTypes }
     * 
     */
    public GetCurrencyTypes createGetCurrencyTypes() {
        return new GetCurrencyTypes();
    }

    /**
     * Create an instance of {@link SetNewPasswordResponse }
     * 
     */
    public SetNewPasswordResponse createSetNewPasswordResponse() {
        return new SetNewPasswordResponse();
    }

    /**
     * Create an instance of {@link CloseAccount }
     * 
     */
    public CloseAccount createCloseAccount() {
        return new CloseAccount();
    }

    /**
     * Create an instance of {@link UpdateAutoPayment }
     * 
     */
    public UpdateAutoPayment createUpdateAutoPayment() {
        return new UpdateAutoPayment();
    }

    /**
     * Create an instance of {@link OpenAccountResponse }
     * 
     */
    public OpenAccountResponse createOpenAccountResponse() {
        return new OpenAccountResponse();
    }

    /**
     * Create an instance of {@link GetAllLegalPersonCategories }
     * 
     */
    public GetAllLegalPersonCategories createGetAllLegalPersonCategories() {
        return new GetAllLegalPersonCategories();
    }

    /**
     * Create an instance of {@link DeleteCard }
     * 
     */
    public DeleteCard createDeleteCard() {
        return new DeleteCard();
    }

    /**
     * Create an instance of {@link ArrayOfLegalAccount }
     * 
     */
    public ArrayOfLegalAccount createArrayOfLegalAccount() {
        return new ArrayOfLegalAccount();
    }

    /**
     * Create an instance of {@link GetAllLegalPersonCategoriesResponse }
     * 
     */
    public GetAllLegalPersonCategoriesResponse createGetAllLegalPersonCategoriesResponse() {
        return new GetAllLegalPersonCategoriesResponse();
    }

    /**
     * Create an instance of {@link GetCards }
     * 
     */
    public GetCards createGetCards() {
        return new GetCards();
    }

    /**
     * Create an instance of {@link ExecuteTransfer }
     * 
     */
    public ExecuteTransfer createExecuteTransfer() {
        return new ExecuteTransfer();
    }

    /**
     * Create an instance of {@link GetAccountById }
     * 
     */
    public GetAccountById createGetAccountById() {
        return new GetAccountById();
    }

    /**
     * Create an instance of {@link UpdateSavedPayment }
     * 
     */
    public UpdateSavedPayment createUpdateSavedPayment() {
        return new UpdateSavedPayment();
    }

    /**
     * Create an instance of {@link AuthorizationFault }
     * 
     */
    public AuthorizationFault createAuthorizationFault() {
        return new AuthorizationFault();
    }

    /**
     * Create an instance of {@link UnlockCardById }
     * 
     */
    public UnlockCardById createUnlockCardById() {
        return new UnlockCardById();
    }

    /**
     * Create an instance of {@link CreateSavedPayment }
     * 
     */
    public CreateSavedPayment createCreateSavedPayment() {
        return new CreateSavedPayment();
    }

    /**
     * Create an instance of {@link DeleteSavedPaymentResponse }
     * 
     */
    public DeleteSavedPaymentResponse createDeleteSavedPaymentResponse() {
        return new DeleteSavedPaymentResponse();
    }

    /**
     * Create an instance of {@link DeleteAutoPayment }
     * 
     */
    public DeleteAutoPayment createDeleteAutoPayment() {
        return new DeleteAutoPayment();
    }

    /**
     * Create an instance of {@link GetLegalPersonsForCategory }
     * 
     */
    public GetLegalPersonsForCategory createGetLegalPersonsForCategory() {
        return new GetLegalPersonsForCategory();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
    }

    /**
     * Create an instance of {@link GetLegalPersonById }
     * 
     */
    public GetLegalPersonById createGetLegalPersonById() {
        return new GetLegalPersonById();
    }

    /**
     * Create an instance of {@link Transfer }
     * 
     */
    public Transfer createTransfer() {
        return new Transfer();
    }

    /**
     * Create an instance of {@link UnlockCard }
     * 
     */
    public UnlockCard createUnlockCard() {
        return new UnlockCard();
    }

    /**
     * Create an instance of {@link UpdateSavedPaymentResponse }
     * 
     */
    public UpdateSavedPaymentResponse createUpdateSavedPaymentResponse() {
        return new UpdateSavedPaymentResponse();
    }

    /**
     * Create an instance of {@link GetCardForAccount }
     * 
     */
    public GetCardForAccount createGetCardForAccount() {
        return new GetCardForAccount();
    }

    /**
     * Create an instance of {@link GetPeriodTransfersForAccountResponse }
     * 
     */
    public GetPeriodTransfersForAccountResponse createGetPeriodTransfersForAccountResponse() {
        return new GetPeriodTransfersForAccountResponse();
    }

    /**
     * Create an instance of {@link CreateCardResponse }
     * 
     */
    public CreateCardResponse createCreateCardResponse() {
        return new CreateCardResponse();
    }

    /**
     * Create an instance of {@link GetCardForClient }
     * 
     */
    public GetCardForClient createGetCardForClient() {
        return new GetCardForClient();
    }

    /**
     * Create an instance of {@link GetBallance }
     * 
     */
    public GetBallance createGetBallance() {
        return new GetBallance();
    }

    /**
     * Create an instance of {@link GetBallanceResponse }
     * 
     */
    public GetBallanceResponse createGetBallanceResponse() {
        return new GetBallanceResponse();
    }

    /**
     * Create an instance of {@link SetAmountLimitResponse }
     * 
     */
    public SetAmountLimitResponse createSetAmountLimitResponse() {
        return new SetAmountLimitResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCurrencyType }
     * 
     */
    public ArrayOfCurrencyType createArrayOfCurrencyType() {
        return new ArrayOfCurrencyType();
    }

    /**
     * Create an instance of {@link ReplenishAccountResponse }
     * 
     */
    public ReplenishAccountResponse createReplenishAccountResponse() {
        return new ReplenishAccountResponse();
    }

    /**
     * Create an instance of {@link ArrayOfTransfer }
     * 
     */
    public ArrayOfTransfer createArrayOfTransfer() {
        return new ArrayOfTransfer();
    }

    /**
     * Create an instance of {@link Pay }
     * 
     */
    public Pay createPay() {
        return new Pay();
    }

    /**
     * Create an instance of {@link PayResponse }
     * 
     */
    public PayResponse createPayResponse() {
        return new PayResponse();
    }

    /**
     * Create an instance of {@link GetPurchaseCurrencyRatesResponse }
     * 
     */
    public GetPurchaseCurrencyRatesResponse createGetPurchaseCurrencyRatesResponse() {
        return new GetPurchaseCurrencyRatesResponse();
    }

    /**
     * Create an instance of {@link GetAutoPayment }
     * 
     */
    public GetAutoPayment createGetAutoPayment() {
        return new GetAutoPayment();
    }

    /**
     * Create an instance of {@link ArrayOfLegalPersonCategory }
     * 
     */
    public ArrayOfLegalPersonCategory createArrayOfLegalPersonCategory() {
        return new ArrayOfLegalPersonCategory();
    }

    /**
     * Create an instance of {@link ArrayOfAccount }
     * 
     */
    public ArrayOfAccount createArrayOfAccount() {
        return new ArrayOfAccount();
    }

    /**
     * Create an instance of {@link SetNewLogin }
     * 
     */
    public SetNewLogin createSetNewLogin() {
        return new SetNewLogin();
    }

    /**
     * Create an instance of {@link CreateCard }
     * 
     */
    public CreateCard createCreateCard() {
        return new CreateCard();
    }

    /**
     * Create an instance of {@link PurchaseCurrencyRate }
     * 
     */
    public PurchaseCurrencyRate createPurchaseCurrencyRate() {
        return new PurchaseCurrencyRate();
    }

    /**
     * Create an instance of {@link Passport }
     * 
     */
    public Passport createPassport() {
        return new Passport();
    }

    /**
     * Create an instance of {@link GetAutoPaymentResponse }
     * 
     */
    public GetAutoPaymentResponse createGetAutoPaymentResponse() {
        return new GetAutoPaymentResponse();
    }

    /**
     * Create an instance of {@link LockCard }
     * 
     */
    public LockCard createLockCard() {
        return new LockCard();
    }

    /**
     * Create an instance of {@link GetPeriodTransfersForAccount }
     * 
     */
    public GetPeriodTransfersForAccount createGetPeriodTransfersForAccount() {
        return new GetPeriodTransfersForAccount();
    }

    /**
     * Create an instance of {@link SetOperationLimit }
     * 
     */
    public SetOperationLimit createSetOperationLimit() {
        return new SetOperationLimit();
    }

    /**
     * Create an instance of {@link ArrayOfPurchaseCurrencyRate }
     * 
     */
    public ArrayOfPurchaseCurrencyRate createArrayOfPurchaseCurrencyRate() {
        return new ArrayOfPurchaseCurrencyRate();
    }

    /**
     * Create an instance of {@link LegalPersonCategory }
     * 
     */
    public LegalPersonCategory createLegalPersonCategory() {
        return new LegalPersonCategory();
    }

    /**
     * Create an instance of {@link CreateSavedPaymentResponse }
     * 
     */
    public CreateSavedPaymentResponse createCreateSavedPaymentResponse() {
        return new CreateSavedPaymentResponse();
    }

    /**
     * Create an instance of {@link GetPeriodPaymentsForAccount }
     * 
     */
    public GetPeriodPaymentsForAccount createGetPeriodPaymentsForAccount() {
        return new GetPeriodPaymentsForAccount();
    }

    /**
     * Create an instance of {@link GetCurrencyTypesResponse }
     * 
     */
    public GetCurrencyTypesResponse createGetCurrencyTypesResponse() {
        return new GetCurrencyTypesResponse();
    }

    /**
     * Create an instance of {@link GetPurchaseCurrencyRates }
     * 
     */
    public GetPurchaseCurrencyRates createGetPurchaseCurrencyRates() {
        return new GetPurchaseCurrencyRates();
    }

    /**
     * Create an instance of {@link LegalPerson }
     * 
     */
    public LegalPerson createLegalPerson() {
        return new LegalPerson();
    }

    /**
     * Create an instance of {@link GetAllLegalPersonsResponse }
     * 
     */
    public GetAllLegalPersonsResponse createGetAllLegalPersonsResponse() {
        return new GetAllLegalPersonsResponse();
    }

    /**
     * Create an instance of {@link SetNewPassword }
     * 
     */
    public SetNewPassword createSetNewPassword() {
        return new SetNewPassword();
    }

    /**
     * Create an instance of {@link GetCardsResponse }
     * 
     */
    public GetCardsResponse createGetCardsResponse() {
        return new GetCardsResponse();
    }

    /**
     * Create an instance of {@link UpdateSellCurrencyRatesResponse }
     * 
     */
    public UpdateSellCurrencyRatesResponse createUpdateSellCurrencyRatesResponse() {
        return new UpdateSellCurrencyRatesResponse();
    }

    /**
     * Create an instance of {@link ArrayOfRegion }
     * 
     */
    public ArrayOfRegion createArrayOfRegion() {
        return new ArrayOfRegion();
    }

    /**
     * Create an instance of {@link GetPeriodPaymentsForAccountResponse }
     * 
     */
    public GetPeriodPaymentsForAccountResponse createGetPeriodPaymentsForAccountResponse() {
        return new GetPeriodPaymentsForAccountResponse();
    }

    /**
     * Create an instance of {@link PayERIPResponse }
     * 
     */
    public PayERIPResponse createPayERIPResponse() {
        return new PayERIPResponse();
    }

    /**
     * Create an instance of {@link CardType }
     * 
     */
    public CardType createCardType() {
        return new CardType();
    }

    /**
     * Create an instance of {@link GetAccountsForClientResponse }
     * 
     */
    public GetAccountsForClientResponse createGetAccountsForClientResponse() {
        return new GetAccountsForClientResponse();
    }

    /**
     * Create an instance of {@link GetAllRegions }
     * 
     */
    public GetAllRegions createGetAllRegions() {
        return new GetAllRegions();
    }

    /**
     * Create an instance of {@link SetOperationLimitResponse }
     * 
     */
    public SetOperationLimitResponse createSetOperationLimitResponse() {
        return new SetOperationLimitResponse();
    }

    /**
     * Create an instance of {@link GetPeriodPaymentsForCardResponse }
     * 
     */
    public GetPeriodPaymentsForCardResponse createGetPeriodPaymentsForCardResponse() {
        return new GetPeriodPaymentsForCardResponse();
    }

    /**
     * Create an instance of {@link GetLegalPersonByIdResponse }
     * 
     */
    public GetLegalPersonByIdResponse createGetLegalPersonByIdResponse() {
        return new GetLegalPersonByIdResponse();
    }

    /**
     * Create an instance of {@link ExecuteTransferResponse }
     * 
     */
    public ExecuteTransferResponse createExecuteTransferResponse() {
        return new ExecuteTransferResponse();
    }

    /**
     * Create an instance of {@link ArrayOfLegalPerson }
     * 
     */
    public ArrayOfLegalPerson createArrayOfLegalPerson() {
        return new ArrayOfLegalPerson();
    }

    /**
     * Create an instance of {@link Card }
     * 
     */
    public Card createCard() {
        return new Card();
    }

    /**
     * Create an instance of {@link GetAllRegionsResponse }
     * 
     */
    public GetAllRegionsResponse createGetAllRegionsResponse() {
        return new GetAllRegionsResponse();
    }

    /**
     * Create an instance of {@link ArrayOfAutoPayment }
     * 
     */
    public ArrayOfAutoPayment createArrayOfAutoPayment() {
        return new ArrayOfAutoPayment();
    }

    /**
     * Create an instance of {@link GetClientResponse }
     * 
     */
    public GetClientResponse createGetClientResponse() {
        return new GetClientResponse();
    }

    /**
     * Create an instance of {@link GetClient }
     * 
     */
    public GetClient createGetClient() {
        return new GetClient();
    }

    /**
     * Create an instance of {@link UpdateSellCurrencyRates }
     * 
     */
    public UpdateSellCurrencyRates createUpdateSellCurrencyRates() {
        return new UpdateSellCurrencyRates();
    }

    /**
     * Create an instance of {@link Payment }
     * 
     */
    public Payment createPayment() {
        return new Payment();
    }

    /**
     * Create an instance of {@link SetAmountLimit }
     * 
     */
    public SetAmountLimit createSetAmountLimit() {
        return new SetAmountLimit();
    }

    /**
     * Create an instance of {@link GetAccountByNumberResponse }
     * 
     */
    public GetAccountByNumberResponse createGetAccountByNumberResponse() {
        return new GetAccountByNumberResponse();
    }

    /**
     * Create an instance of {@link Service }
     * 
     */
    public Service createService() {
        return new Service();
    }

    /**
     * Create an instance of {@link GetCardForOperator }
     * 
     */
    public GetCardForOperator createGetCardForOperator() {
        return new GetCardForOperator();
    }

    /**
     * Create an instance of {@link DeleteAutoPaymentResponse }
     * 
     */
    public DeleteAutoPaymentResponse createDeleteAutoPaymentResponse() {
        return new DeleteAutoPaymentResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCardType }
     * 
     */
    public ArrayOfCardType createArrayOfCardType() {
        return new ArrayOfCardType();
    }

    /**
     * Create an instance of {@link GetServicesForCity }
     * 
     */
    public GetServicesForCity createGetServicesForCity() {
        return new GetServicesForCity();
    }

    /**
     * Create an instance of {@link OpenAccount }
     * 
     */
    public OpenAccount createOpenAccount() {
        return new OpenAccount();
    }

    /**
     * Create an instance of {@link GetSavedPaymentsForAccountResponse }
     * 
     */
    public GetSavedPaymentsForAccountResponse createGetSavedPaymentsForAccountResponse() {
        return new GetSavedPaymentsForAccountResponse();
    }

    /**
     * Create an instance of {@link LockCardById }
     * 
     */
    public LockCardById createLockCardById() {
        return new LockCardById();
    }

    /**
     * Create an instance of {@link GetServicesForCityResponse }
     * 
     */
    public GetServicesForCityResponse createGetServicesForCityResponse() {
        return new GetServicesForCityResponse();
    }

    /**
     * Create an instance of {@link LegalAccount }
     * 
     */
    public LegalAccount createLegalAccount() {
        return new LegalAccount();
    }

    /**
     * Create an instance of {@link ArrayOfSavedPayment }
     * 
     */
    public ArrayOfSavedPayment createArrayOfSavedPayment() {
        return new ArrayOfSavedPayment();
    }

    /**
     * Create an instance of {@link GetSellCurrencyRatesResponse }
     * 
     */
    public GetSellCurrencyRatesResponse createGetSellCurrencyRatesResponse() {
        return new GetSellCurrencyRatesResponse();
    }

    /**
     * Create an instance of {@link GetAutoPaymentsForAccountResponse }
     * 
     */
    public GetAutoPaymentsForAccountResponse createGetAutoPaymentsForAccountResponse() {
        return new GetAutoPaymentsForAccountResponse();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link GetSellCurrencyRates }
     * 
     */
    public GetSellCurrencyRates createGetSellCurrencyRates() {
        return new GetSellCurrencyRates();
    }

    /**
     * Create an instance of {@link GetCardsForClient }
     * 
     */
    public GetCardsForClient createGetCardsForClient() {
        return new GetCardsForClient();
    }

    /**
     * Create an instance of {@link LockCardByIdResponse }
     * 
     */
    public LockCardByIdResponse createLockCardByIdResponse() {
        return new LockCardByIdResponse();
    }

    /**
     * Create an instance of {@link PayERIP }
     * 
     */
    public PayERIP createPayERIP() {
        return new PayERIP();
    }

    /**
     * Create an instance of {@link Region }
     * 
     */
    public Region createRegion() {
        return new Region();
    }

    /**
     * Create an instance of {@link GetAllSavedPayments }
     * 
     */
    public GetAllSavedPayments createGetAllSavedPayments() {
        return new GetAllSavedPayments();
    }

    /**
     * Create an instance of {@link GetLegalPersonsForCategoryResponse }
     * 
     */
    public GetLegalPersonsForCategoryResponse createGetLegalPersonsForCategoryResponse() {
        return new GetLegalPersonsForCategoryResponse();
    }

    /**
     * Create an instance of {@link GetAllSavedPaymentsResponse }
     * 
     */
    public GetAllSavedPaymentsResponse createGetAllSavedPaymentsResponse() {
        return new GetAllSavedPaymentsResponse();
    }

    /**
     * Create an instance of {@link ReplenishAccount }
     * 
     */
    public ReplenishAccount createReplenishAccount() {
        return new ReplenishAccount();
    }

    /**
     * Create an instance of {@link AutoPayment }
     * 
     */
    public AutoPayment createAutoPayment() {
        return new AutoPayment();
    }

    /**
     * Create an instance of {@link DeleteCardResponse }
     * 
     */
    public DeleteCardResponse createDeleteCardResponse() {
        return new DeleteCardResponse();
    }

    /**
     * Create an instance of {@link GetPeriodTransfersForCardResponse }
     * 
     */
    public GetPeriodTransfersForCardResponse createGetPeriodTransfersForCardResponse() {
        return new GetPeriodTransfersForCardResponse();
    }

    /**
     * Create an instance of {@link SellCurrencyRate }
     * 
     */
    public SellCurrencyRate createSellCurrencyRate() {
        return new SellCurrencyRate();
    }

    /**
     * Create an instance of {@link SavedPayment }
     * 
     */
    public SavedPayment createSavedPayment() {
        return new SavedPayment();
    }

    /**
     * Create an instance of {@link LockCardResponse }
     * 
     */
    public LockCardResponse createLockCardResponse() {
        return new LockCardResponse();
    }

    /**
     * Create an instance of {@link GetAutoPaymentsForAccount }
     * 
     */
    public GetAutoPaymentsForAccount createGetAutoPaymentsForAccount() {
        return new GetAutoPaymentsForAccount();
    }

    /**
     * Create an instance of {@link GetPeriodTransfersForCard }
     * 
     */
    public GetPeriodTransfersForCard createGetPeriodTransfersForCard() {
        return new GetPeriodTransfersForCard();
    }

    /**
     * Create an instance of {@link GetSavedPaymentsForAccount }
     * 
     */
    public GetSavedPaymentsForAccount createGetSavedPaymentsForAccount() {
        return new GetSavedPaymentsForAccount();
    }

    /**
     * Create an instance of {@link GetCardForClientResponse }
     * 
     */
    public GetCardForClientResponse createGetCardForClientResponse() {
        return new GetCardForClientResponse();
    }

    /**
     * Create an instance of {@link UpdatePurchaseCurrencyRates }
     * 
     */
    public UpdatePurchaseCurrencyRates createUpdatePurchaseCurrencyRates() {
        return new UpdatePurchaseCurrencyRates();
    }

    /**
     * Create an instance of {@link GetCitiesForRegion }
     * 
     */
    public GetCitiesForRegion createGetCitiesForRegion() {
        return new GetCitiesForRegion();
    }

    /**
     * Create an instance of {@link DeleteSavedPayment }
     * 
     */
    public DeleteSavedPayment createDeleteSavedPayment() {
        return new DeleteSavedPayment();
    }

    /**
     * Create an instance of {@link GetAccountByNumber }
     * 
     */
    public GetAccountByNumber createGetAccountByNumber() {
        return new GetAccountByNumber();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAccountsForClient.class)
    public JAXBElement<String> createGetAccountsForClientSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetAccountsForClient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAccountByIdResult", scope = GetAccountByIdResponse.class)
    public JAXBElement<Account> createGetAccountByIdResponseGetAccountByIdResult(Account value) {
        return new JAXBElement<Account>(_GetAccountByIdResponseGetAccountByIdResult_QNAME, Account.class, GetAccountByIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetPeriodPaymentsForCard.class)
    public JAXBElement<String> createGetPeriodPaymentsForCardSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetPeriodPaymentsForCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "LegalPerson")
    public JAXBElement<LegalPerson> createLegalPerson(LegalPerson value) {
        return new JAXBElement<LegalPerson>(_LegalPerson_QNAME, LegalPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Account")
    public JAXBElement<Account> createAccount(Account value) {
        return new JAXBElement<Account>(_Account_QNAME, Account.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Region }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Region")
    public JAXBElement<Region> createRegion(Region value) {
        return new JAXBElement<Region>(_Region_QNAME, Region.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PurchaseCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "PurchaseCurrencyRate")
    public JAXBElement<PurchaseCurrencyRate> createPurchaseCurrencyRate(PurchaseCurrencyRate value) {
        return new JAXBElement<PurchaseCurrencyRate>(_PurchaseCurrencyRate_QNAME, PurchaseCurrencyRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAutoPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfAutoPayment")
    public JAXBElement<ArrayOfAutoPayment> createArrayOfAutoPayment(ArrayOfAutoPayment value) {
        return new JAXBElement<ArrayOfAutoPayment>(_ArrayOfAutoPayment_QNAME, ArrayOfAutoPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorizationFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", name = "AuthorizationFault")
    public JAXBElement<AuthorizationFault> createAuthorizationFault(AuthorizationFault value) {
        return new JAXBElement<AuthorizationFault>(_AuthorizationFault_QNAME, AuthorizationFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTransfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfTransfer")
    public JAXBElement<ArrayOfTransfer> createArrayOfTransfer(ArrayOfTransfer value) {
        return new JAXBElement<ArrayOfTransfer>(_ArrayOfTransfer_QNAME, ArrayOfTransfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "CardType")
    public JAXBElement<CardType> createCardType(CardType value) {
        return new JAXBElement<CardType>(_CardType_QNAME, CardType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Client }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Client")
    public JAXBElement<Client> createClient(Client value) {
        return new JAXBElement<Client>(_Client_QNAME, Client.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfCity")
    public JAXBElement<ArrayOfCity> createArrayOfCity(ArrayOfCity value) {
        return new JAXBElement<ArrayOfCity>(_ArrayOfCity_QNAME, ArrayOfCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfLegalPersonCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfLegalPersonCategory")
    public JAXBElement<ArrayOfLegalPersonCategory> createArrayOfLegalPersonCategory(ArrayOfLegalPersonCategory value) {
        return new JAXBElement<ArrayOfLegalPersonCategory>(_ArrayOfLegalPersonCategory_QNAME, ArrayOfLegalPersonCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SellCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "SellCurrencyRate")
    public JAXBElement<SellCurrencyRate> createSellCurrencyRate(SellCurrencyRate value) {
        return new JAXBElement<SellCurrencyRate>(_SellCurrencyRate_QNAME, SellCurrencyRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfPayment")
    public JAXBElement<ArrayOfPayment> createArrayOfPayment(ArrayOfPayment value) {
        return new JAXBElement<ArrayOfPayment>(_ArrayOfPayment_QNAME, ArrayOfPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Money")
    public JAXBElement<Money> createMoney(Money value) {
        return new JAXBElement<Money>(_Money_QNAME, Money.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link City }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "City")
    public JAXBElement<City> createCity(City value) {
        return new JAXBElement<City>(_City_QNAME, City.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPurchaseCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfPurchaseCurrencyRate")
    public JAXBElement<ArrayOfPurchaseCurrencyRate> createArrayOfPurchaseCurrencyRate(ArrayOfPurchaseCurrencyRate value) {
        return new JAXBElement<ArrayOfPurchaseCurrencyRate>(_ArrayOfPurchaseCurrencyRate_QNAME, ArrayOfPurchaseCurrencyRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Card }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Card")
    public JAXBElement<Card> createCard(Card value) {
        return new JAXBElement<Card>(_Card_QNAME, Card.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", name = "DomainFault")
    public JAXBElement<DomainFault> createDomainFault(DomainFault value) {
        return new JAXBElement<DomainFault>(_DomainFault_QNAME, DomainFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Service }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Service")
    public JAXBElement<Service> createService(Service value) {
        return new JAXBElement<Service>(_Service_QNAME, Service.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Payment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Payment")
    public JAXBElement<Payment> createPayment(Payment value) {
        return new JAXBElement<Payment>(_Payment_QNAME, Payment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutoPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "AutoPayment")
    public JAXBElement<AutoPayment> createAutoPayment(AutoPayment value) {
        return new JAXBElement<AutoPayment>(_AutoPayment_QNAME, AutoPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalPersonCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "LegalPersonCategory")
    public JAXBElement<LegalPersonCategory> createLegalPersonCategory(LegalPersonCategory value) {
        return new JAXBElement<LegalPersonCategory>(_LegalPersonCategory_QNAME, LegalPersonCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRegion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfRegion")
    public JAXBElement<ArrayOfRegion> createArrayOfRegion(ArrayOfRegion value) {
        return new JAXBElement<ArrayOfRegion>(_ArrayOfRegion_QNAME, ArrayOfRegion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfLegalAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfLegalAccount")
    public JAXBElement<ArrayOfLegalAccount> createArrayOfLegalAccount(ArrayOfLegalAccount value) {
        return new JAXBElement<ArrayOfLegalAccount>(_ArrayOfLegalAccount_QNAME, ArrayOfLegalAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCardType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfCardType")
    public JAXBElement<ArrayOfCardType> createArrayOfCardType(ArrayOfCardType value) {
        return new JAXBElement<ArrayOfCardType>(_ArrayOfCardType_QNAME, ArrayOfCardType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "LegalAccount")
    public JAXBElement<LegalAccount> createLegalAccount(LegalAccount value) {
        return new JAXBElement<LegalAccount>(_LegalAccount_QNAME, LegalAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavedPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "SavedPayment")
    public JAXBElement<SavedPayment> createSavedPayment(SavedPayment value) {
        return new JAXBElement<SavedPayment>(_SavedPayment_QNAME, SavedPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSavedPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfSavedPayment")
    public JAXBElement<ArrayOfSavedPayment> createArrayOfSavedPayment(ArrayOfSavedPayment value) {
        return new JAXBElement<ArrayOfSavedPayment>(_ArrayOfSavedPayment_QNAME, ArrayOfSavedPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfAccount")
    public JAXBElement<ArrayOfAccount> createArrayOfAccount(ArrayOfAccount value) {
        return new JAXBElement<ArrayOfAccount>(_ArrayOfAccount_QNAME, ArrayOfAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Transfer")
    public JAXBElement<Transfer> createTransfer(Transfer value) {
        return new JAXBElement<Transfer>(_Transfer_QNAME, Transfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "CurrencyType")
    public JAXBElement<CurrencyType> createCurrencyType(CurrencyType value) {
        return new JAXBElement<CurrencyType>(_CurrencyType_QNAME, CurrencyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCurrencyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfCurrencyType")
    public JAXBElement<ArrayOfCurrencyType> createArrayOfCurrencyType(ArrayOfCurrencyType value) {
        return new JAXBElement<ArrayOfCurrencyType>(_ArrayOfCurrencyType_QNAME, ArrayOfCurrencyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfLegalPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfLegalPerson")
    public JAXBElement<ArrayOfLegalPerson> createArrayOfLegalPerson(ArrayOfLegalPerson value) {
        return new JAXBElement<ArrayOfLegalPerson>(_ArrayOfLegalPerson_QNAME, ArrayOfLegalPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Passport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Passport")
    public JAXBElement<Passport> createPassport(Passport value) {
        return new JAXBElement<Passport>(_Passport_QNAME, Passport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSellCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfSellCurrencyRate")
    public JAXBElement<ArrayOfSellCurrencyRate> createArrayOfSellCurrencyRate(ArrayOfSellCurrencyRate value) {
        return new JAXBElement<ArrayOfSellCurrencyRate>(_ArrayOfSellCurrencyRate_QNAME, ArrayOfSellCurrencyRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfService")
    public JAXBElement<ArrayOfService> createArrayOfService(ArrayOfService value) {
        return new JAXBElement<ArrayOfService>(_ArrayOfService_QNAME, ArrayOfService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfCard")
    public JAXBElement<ArrayOfCard> createArrayOfCard(ArrayOfCard value) {
        return new JAXBElement<ArrayOfCard>(_ArrayOfCard_QNAME, ArrayOfCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAllLegalPersons.class)
    public JAXBElement<String> createGetAllLegalPersonsSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetAllLegalPersons.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = CreateAutoPayment.class)
    public JAXBElement<String> createCreateAutoPaymentSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, CreateAutoPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutoPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "autoPayment", scope = CreateAutoPayment.class)
    public JAXBElement<AutoPayment> createCreateAutoPaymentAutoPayment(AutoPayment value) {
        return new JAXBElement<AutoPayment>(_CreateAutoPaymentAutoPayment_QNAME, AutoPayment.class, CreateAutoPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "CurrencyType", scope = Money.class)
    public JAXBElement<String> createMoneyCurrencyType(String value) {
        return new JAXBElement<String>(_CurrencyType_QNAME, String.class, Money.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "MiddleName", scope = Client.class)
    public JAXBElement<String> createClientMiddleName(String value) {
        return new JAXBElement<String>(_ClientMiddleName_QNAME, String.class, Client.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Login", scope = Client.class)
    public JAXBElement<String> createClientLogin(String value) {
        return new JAXBElement<String>(_ClientLogin_QNAME, String.class, Client.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Passport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Passport", scope = Client.class)
    public JAXBElement<Passport> createClientPassport(Passport value) {
        return new JAXBElement<Passport>(_Passport_QNAME, Passport.class, Client.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Password", scope = Client.class)
    public JAXBElement<String> createClientPassword(String value) {
        return new JAXBElement<String>(_ClientPassword_QNAME, String.class, Client.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Adress", scope = Client.class)
    public JAXBElement<String> createClientAdress(String value) {
        return new JAXBElement<String>(_ClientAdress_QNAME, String.class, Client.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Email", scope = Client.class)
    public JAXBElement<String> createClientEmail(String value) {
        return new JAXBElement<String>(_ClientEmail_QNAME, String.class, Client.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "PhoneNumber", scope = Client.class)
    public JAXBElement<String> createClientPhoneNumber(String value) {
        return new JAXBElement<String>(_ClientPhoneNumber_QNAME, String.class, Client.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "FirstName", scope = Client.class)
    public JAXBElement<String> createClientFirstName(String value) {
        return new JAXBElement<String>(_ClientFirstName_QNAME, String.class, Client.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "LastName", scope = Client.class)
    public JAXBElement<String> createClientLastName(String value) {
        return new JAXBElement<String>(_ClientLastName_QNAME, String.class, Client.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAllCardTypes.class)
    public JAXBElement<String> createGetAllCardTypesSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetAllCardTypes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCitiesForRegionResult", scope = GetCitiesForRegionResponse.class)
    public JAXBElement<ArrayOfCity> createGetCitiesForRegionResponseGetCitiesForRegionResult(ArrayOfCity value) {
        return new JAXBElement<ArrayOfCity>(_GetCitiesForRegionResponseGetCitiesForRegionResult_QNAME, ArrayOfCity.class, GetCitiesForRegionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCardsForClientResult", scope = GetCardsForClientResponse.class)
    public JAXBElement<ArrayOfCard> createGetCardsForClientResponseGetCardsForClientResult(ArrayOfCard value) {
        return new JAXBElement<ArrayOfCard>(_GetCardsForClientResponseGetCardsForClientResult_QNAME, ArrayOfCard.class, GetCardsForClientResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAutoPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAutoPaymentsForClientResult", scope = GetAutoPaymentsForClientResponse.class)
    public JAXBElement<ArrayOfAutoPayment> createGetAutoPaymentsForClientResponseGetAutoPaymentsForClientResult(ArrayOfAutoPayment value) {
        return new JAXBElement<ArrayOfAutoPayment>(_GetAutoPaymentsForClientResponseGetAutoPaymentsForClientResult_QNAME, ArrayOfAutoPayment.class, GetAutoPaymentsForClientResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCardType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllCardTypesResult", scope = GetAllCardTypesResponse.class)
    public JAXBElement<ArrayOfCardType> createGetAllCardTypesResponseGetAllCardTypesResult(ArrayOfCardType value) {
        return new JAXBElement<ArrayOfCardType>(_GetAllCardTypesResponseGetAllCardTypesResult_QNAME, ArrayOfCardType.class, GetAllCardTypesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Card }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCardForAccountResult", scope = GetCardForAccountResponse.class)
    public JAXBElement<Card> createGetCardForAccountResponseGetCardForAccountResult(Card value) {
        return new JAXBElement<Card>(_GetCardForAccountResponseGetCardForAccountResult_QNAME, Card.class, GetCardForAccountResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAutoPaymentsForClient.class)
    public JAXBElement<String> createGetAutoPaymentsForClientSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetAutoPaymentsForClient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Card }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCardForOperatorResult", scope = GetCardForOperatorResponse.class)
    public JAXBElement<Card> createGetCardForOperatorResponseGetCardForOperatorResult(Card value) {
        return new JAXBElement<Card>(_GetCardForOperatorResponseGetCardForOperatorResult_QNAME, Card.class, GetCardForOperatorResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", name = "Message", scope = DomainFault.class)
    public JAXBElement<String> createDomainFaultMessage(String value) {
        return new JAXBElement<String>(_DomainFaultMessage_QNAME, String.class, DomainFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Name", scope = CurrencyType.class)
    public JAXBElement<String> createCurrencyTypeName(String value) {
        return new JAXBElement<String>(_CurrencyTypeName_QNAME, String.class, CurrencyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ShortName", scope = CurrencyType.class)
    public JAXBElement<String> createCurrencyTypeShortName(String value) {
        return new JAXBElement<String>(_CurrencyTypeShortName_QNAME, String.class, CurrencyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = CloseAccount.class)
    public JAXBElement<String> createCloseAccountSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, CloseAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = UpdateAutoPayment.class)
    public JAXBElement<String> createUpdateAutoPaymentSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, UpdateAutoPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutoPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "autoPayment", scope = UpdateAutoPayment.class)
    public JAXBElement<AutoPayment> createUpdateAutoPaymentAutoPayment(AutoPayment value) {
        return new JAXBElement<AutoPayment>(_CreateAutoPaymentAutoPayment_QNAME, AutoPayment.class, UpdateAutoPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAllLegalPersonCategories.class)
    public JAXBElement<String> createGetAllLegalPersonCategoriesSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetAllLegalPersonCategories.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = DeleteCard.class)
    public JAXBElement<String> createDeleteCardSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, DeleteCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfLegalPersonCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllLegalPersonCategoriesResult", scope = GetAllLegalPersonCategoriesResponse.class)
    public JAXBElement<ArrayOfLegalPersonCategory> createGetAllLegalPersonCategoriesResponseGetAllLegalPersonCategoriesResult(ArrayOfLegalPersonCategory value) {
        return new JAXBElement<ArrayOfLegalPersonCategory>(_GetAllLegalPersonCategoriesResponseGetAllLegalPersonCategoriesResult_QNAME, ArrayOfLegalPersonCategory.class, GetAllLegalPersonCategoriesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetCards.class)
    public JAXBElement<String> createGetCardsSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetCards.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = ExecuteTransfer.class)
    public JAXBElement<String> createExecuteTransferSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, ExecuteTransfer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "receiverCardNumber", scope = ExecuteTransfer.class)
    public JAXBElement<String> createExecuteTransferReceiverCardNumber(String value) {
        return new JAXBElement<String>(_ExecuteTransferReceiverCardNumber_QNAME, String.class, ExecuteTransfer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "amount", scope = ExecuteTransfer.class)
    public JAXBElement<Money> createExecuteTransferAmount(Money value) {
        return new JAXBElement<Money>(_ExecuteTransferAmount_QNAME, Money.class, ExecuteTransfer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "cardNumber", scope = ExecuteTransfer.class)
    public JAXBElement<String> createExecuteTransferCardNumber(String value) {
        return new JAXBElement<String>(_ExecuteTransferCardNumber_QNAME, String.class, ExecuteTransfer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAccountById.class)
    public JAXBElement<String> createGetAccountByIdSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetAccountById.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = UpdateSavedPayment.class)
    public JAXBElement<String> createUpdateSavedPaymentSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, UpdateSavedPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavedPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "savedPayment", scope = UpdateSavedPayment.class)
    public JAXBElement<SavedPayment> createUpdateSavedPaymentSavedPayment(SavedPayment value) {
        return new JAXBElement<SavedPayment>(_UpdateSavedPaymentSavedPayment_QNAME, SavedPayment.class, UpdateSavedPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = UnlockCardById.class)
    public JAXBElement<String> createUnlockCardByIdSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, UnlockCardById.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", name = "Message", scope = AuthorizationFault.class)
    public JAXBElement<String> createAuthorizationFaultMessage(String value) {
        return new JAXBElement<String>(_DomainFaultMessage_QNAME, String.class, AuthorizationFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = CreateSavedPayment.class)
    public JAXBElement<String> createCreateSavedPaymentSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, CreateSavedPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavedPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "savedPayment", scope = CreateSavedPayment.class)
    public JAXBElement<SavedPayment> createCreateSavedPaymentSavedPayment(SavedPayment value) {
        return new JAXBElement<SavedPayment>(_UpdateSavedPaymentSavedPayment_QNAME, SavedPayment.class, CreateSavedPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = DeleteAutoPayment.class)
    public JAXBElement<String> createDeleteAutoPaymentSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, DeleteAutoPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetLegalPersonsForCategory.class)
    public JAXBElement<String> createGetLegalPersonsForCategorySecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetLegalPersonsForCategory.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Name", scope = City.class)
    public JAXBElement<String> createCityName(String value) {
        return new JAXBElement<String>(_CurrencyTypeName_QNAME, String.class, City.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetLegalPersonById.class)
    public JAXBElement<String> createGetLegalPersonByIdSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetLegalPersonById.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "secretWord", scope = UnlockCard.class)
    public JAXBElement<String> createUnlockCardSecretWord(String value) {
        return new JAXBElement<String>(_UnlockCardSecretWord_QNAME, String.class, UnlockCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "number", scope = UnlockCard.class)
    public JAXBElement<String> createUnlockCardNumber(String value) {
        return new JAXBElement<String>(_UnlockCardNumber_QNAME, String.class, UnlockCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetCardForAccount.class)
    public JAXBElement<String> createGetCardForAccountSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetCardForAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTransfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPeriodTransfersForAccountResult", scope = GetPeriodTransfersForAccountResponse.class)
    public JAXBElement<ArrayOfTransfer> createGetPeriodTransfersForAccountResponseGetPeriodTransfersForAccountResult(ArrayOfTransfer value) {
        return new JAXBElement<ArrayOfTransfer>(_GetPeriodTransfersForAccountResponseGetPeriodTransfersForAccountResult_QNAME, ArrayOfTransfer.class, GetPeriodTransfersForAccountResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetCardForClient.class)
    public JAXBElement<String> createGetCardForClientSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetCardForClient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetBallance.class)
    public JAXBElement<String> createGetBallanceSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetBallance.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBallanceResult", scope = GetBallanceResponse.class)
    public JAXBElement<Money> createGetBallanceResponseGetBallanceResult(Money value) {
        return new JAXBElement<Money>(_GetBallanceResponseGetBallanceResult_QNAME, Money.class, GetBallanceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PayResult", scope = PayResponse.class)
    public JAXBElement<String> createPayResponsePayResult(String value) {
        return new JAXBElement<String>(_PayResponsePayResult_QNAME, String.class, PayResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = Pay.class)
    public JAXBElement<String> createPaySecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, Pay.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "information", scope = Pay.class)
    public JAXBElement<String> createPayInformation(String value) {
        return new JAXBElement<String>(_PayInformation_QNAME, String.class, Pay.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "amount", scope = Pay.class)
    public JAXBElement<Money> createPayAmount(Money value) {
        return new JAXBElement<Money>(_ExecuteTransferAmount_QNAME, Money.class, Pay.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "cardNumber", scope = Pay.class)
    public JAXBElement<String> createPayCardNumber(String value) {
        return new JAXBElement<String>(_ExecuteTransferCardNumber_QNAME, String.class, Pay.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "receiverLegalAccountNumber", scope = Pay.class)
    public JAXBElement<String> createPayReceiverLegalAccountNumber(String value) {
        return new JAXBElement<String>(_PayReceiverLegalAccountNumber_QNAME, String.class, Pay.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPurchaseCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPurchaseCurrencyRatesResult", scope = GetPurchaseCurrencyRatesResponse.class)
    public JAXBElement<ArrayOfPurchaseCurrencyRate> createGetPurchaseCurrencyRatesResponseGetPurchaseCurrencyRatesResult(ArrayOfPurchaseCurrencyRate value) {
        return new JAXBElement<ArrayOfPurchaseCurrencyRate>(_GetPurchaseCurrencyRatesResponseGetPurchaseCurrencyRatesResult_QNAME, ArrayOfPurchaseCurrencyRate.class, GetPurchaseCurrencyRatesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAutoPayment.class)
    public JAXBElement<String> createGetAutoPaymentSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetAutoPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = SetNewLogin.class)
    public JAXBElement<String> createSetNewLoginSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, SetNewLogin.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "newLogin", scope = SetNewLogin.class)
    public JAXBElement<String> createSetNewLoginNewLogin(String value) {
        return new JAXBElement<String>(_SetNewLoginNewLogin_QNAME, String.class, SetNewLogin.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = CreateCard.class)
    public JAXBElement<String> createCreateCardSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, CreateCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Card }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "card", scope = CreateCard.class)
    public JAXBElement<Card> createCreateCardCard(Card value) {
        return new JAXBElement<Card>(_CreateCardCard_QNAME, Card.class, CreateCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "CurrencyType", scope = PurchaseCurrencyRate.class)
    public JAXBElement<CurrencyType> createPurchaseCurrencyRateCurrencyType(CurrencyType value) {
        return new JAXBElement<CurrencyType>(_CurrencyType_QNAME, CurrencyType.class, PurchaseCurrencyRate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutoPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAutoPaymentResult", scope = GetAutoPaymentResponse.class)
    public JAXBElement<AutoPayment> createGetAutoPaymentResponseGetAutoPaymentResult(AutoPayment value) {
        return new JAXBElement<AutoPayment>(_GetAutoPaymentResponseGetAutoPaymentResult_QNAME, AutoPayment.class, GetAutoPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Number", scope = Passport.class)
    public JAXBElement<String> createPassportNumber(String value) {
        return new JAXBElement<String>(_PassportNumber_QNAME, String.class, Passport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Authority", scope = Passport.class)
    public JAXBElement<String> createPassportAuthority(String value) {
        return new JAXBElement<String>(_PassportAuthority_QNAME, String.class, Passport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Seria", scope = Passport.class)
    public JAXBElement<String> createPassportSeria(String value) {
        return new JAXBElement<String>(_PassportSeria_QNAME, String.class, Passport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "secretWord", scope = LockCard.class)
    public JAXBElement<String> createLockCardSecretWord(String value) {
        return new JAXBElement<String>(_UnlockCardSecretWord_QNAME, String.class, LockCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "number", scope = LockCard.class)
    public JAXBElement<String> createLockCardNumber(String value) {
        return new JAXBElement<String>(_UnlockCardNumber_QNAME, String.class, LockCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetPeriodTransfersForAccount.class)
    public JAXBElement<String> createGetPeriodTransfersForAccountSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetPeriodTransfersForAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "secretWord", scope = SetOperationLimit.class)
    public JAXBElement<String> createSetOperationLimitSecretWord(String value) {
        return new JAXBElement<String>(_UnlockCardSecretWord_QNAME, String.class, SetOperationLimit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = SetOperationLimit.class)
    public JAXBElement<String> createSetOperationLimitSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, SetOperationLimit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Name", scope = LegalPersonCategory.class)
    public JAXBElement<String> createLegalPersonCategoryName(String value) {
        return new JAXBElement<String>(_CurrencyTypeName_QNAME, String.class, LegalPersonCategory.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetPeriodPaymentsForAccount.class)
    public JAXBElement<String> createGetPeriodPaymentsForAccountSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetPeriodPaymentsForAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCurrencyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCurrencyTypesResult", scope = GetCurrencyTypesResponse.class)
    public JAXBElement<ArrayOfCurrencyType> createGetCurrencyTypesResponseGetCurrencyTypesResult(ArrayOfCurrencyType value) {
        return new JAXBElement<ArrayOfCurrencyType>(_GetCurrencyTypesResponseGetCurrencyTypesResult_QNAME, ArrayOfCurrencyType.class, GetCurrencyTypesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Phone", scope = LegalPerson.class)
    public JAXBElement<String> createLegalPersonPhone(String value) {
        return new JAXBElement<String>(_LegalPersonPhone_QNAME, String.class, LegalPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Name", scope = LegalPerson.class)
    public JAXBElement<String> createLegalPersonName(String value) {
        return new JAXBElement<String>(_CurrencyTypeName_QNAME, String.class, LegalPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Address", scope = LegalPerson.class)
    public JAXBElement<String> createLegalPersonAddress(String value) {
        return new JAXBElement<String>(_LegalPersonAddress_QNAME, String.class, LegalPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalPersonCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "LegalPersonCategory", scope = LegalPerson.class)
    public JAXBElement<LegalPersonCategory> createLegalPersonLegalPersonCategory(LegalPersonCategory value) {
        return new JAXBElement<LegalPersonCategory>(_LegalPersonCategory_QNAME, LegalPersonCategory.class, LegalPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "LegalNumber", scope = LegalPerson.class)
    public JAXBElement<String> createLegalPersonLegalNumber(String value) {
        return new JAXBElement<String>(_LegalPersonLegalNumber_QNAME, String.class, LegalPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfLegalAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "LegalAccounts", scope = LegalPerson.class)
    public JAXBElement<ArrayOfLegalAccount> createLegalPersonLegalAccounts(ArrayOfLegalAccount value) {
        return new JAXBElement<ArrayOfLegalAccount>(_LegalPersonLegalAccounts_QNAME, ArrayOfLegalAccount.class, LegalPerson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfLegalPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllLegalPersonsResult", scope = GetAllLegalPersonsResponse.class)
    public JAXBElement<ArrayOfLegalPerson> createGetAllLegalPersonsResponseGetAllLegalPersonsResult(ArrayOfLegalPerson value) {
        return new JAXBElement<ArrayOfLegalPerson>(_GetAllLegalPersonsResponseGetAllLegalPersonsResult_QNAME, ArrayOfLegalPerson.class, GetAllLegalPersonsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "newPassword", scope = SetNewPassword.class)
    public JAXBElement<String> createSetNewPasswordNewPassword(String value) {
        return new JAXBElement<String>(_SetNewPasswordNewPassword_QNAME, String.class, SetNewPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = SetNewPassword.class)
    public JAXBElement<String> createSetNewPasswordSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, SetNewPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCardsResult", scope = GetCardsResponse.class)
    public JAXBElement<ArrayOfCard> createGetCardsResponseGetCardsResult(ArrayOfCard value) {
        return new JAXBElement<ArrayOfCard>(_GetCardsResponseGetCardsResult_QNAME, ArrayOfCard.class, GetCardsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPeriodPaymentsForAccountResult", scope = GetPeriodPaymentsForAccountResponse.class)
    public JAXBElement<ArrayOfPayment> createGetPeriodPaymentsForAccountResponseGetPeriodPaymentsForAccountResult(ArrayOfPayment value) {
        return new JAXBElement<ArrayOfPayment>(_GetPeriodPaymentsForAccountResponseGetPeriodPaymentsForAccountResult_QNAME, ArrayOfPayment.class, GetPeriodPaymentsForAccountResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PayERIPResult", scope = PayERIPResponse.class)
    public JAXBElement<String> createPayERIPResponsePayERIPResult(String value) {
        return new JAXBElement<String>(_PayERIPResponsePayERIPResult_QNAME, String.class, PayERIPResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Name", scope = CardType.class)
    public JAXBElement<String> createCardTypeName(String value) {
        return new JAXBElement<String>(_CurrencyTypeName_QNAME, String.class, CardType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAccountsForClientResult", scope = GetAccountsForClientResponse.class)
    public JAXBElement<ArrayOfAccount> createGetAccountsForClientResponseGetAccountsForClientResult(ArrayOfAccount value) {
        return new JAXBElement<ArrayOfAccount>(_GetAccountsForClientResponseGetAccountsForClientResult_QNAME, ArrayOfAccount.class, GetAccountsForClientResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAllRegions.class)
    public JAXBElement<String> createGetAllRegionsSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetAllRegions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetLegalPersonByIdResult", scope = GetLegalPersonByIdResponse.class)
    public JAXBElement<LegalPerson> createGetLegalPersonByIdResponseGetLegalPersonByIdResult(LegalPerson value) {
        return new JAXBElement<LegalPerson>(_GetLegalPersonByIdResponseGetLegalPersonByIdResult_QNAME, LegalPerson.class, GetLegalPersonByIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPeriodPaymentsForCardResult", scope = GetPeriodPaymentsForCardResponse.class)
    public JAXBElement<ArrayOfPayment> createGetPeriodPaymentsForCardResponseGetPeriodPaymentsForCardResult(ArrayOfPayment value) {
        return new JAXBElement<ArrayOfPayment>(_GetPeriodPaymentsForCardResponseGetPeriodPaymentsForCardResult_QNAME, ArrayOfPayment.class, GetPeriodPaymentsForCardResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ExecuteTransferResult", scope = ExecuteTransferResponse.class)
    public JAXBElement<String> createExecuteTransferResponseExecuteTransferResult(String value) {
        return new JAXBElement<String>(_ExecuteTransferResponseExecuteTransferResult_QNAME, String.class, ExecuteTransferResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "SecretWord", scope = Card.class)
    public JAXBElement<String> createCardSecretWord(String value) {
        return new JAXBElement<String>(_CardSecretWord_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Number", scope = Card.class)
    public JAXBElement<String> createCardNumber(String value) {
        return new JAXBElement<String>(_PassportNumber_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "CardType", scope = Card.class)
    public JAXBElement<CardType> createCardCardType(CardType value) {
        return new JAXBElement<CardType>(_CardType_QNAME, CardType.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "CVV2", scope = Card.class)
    public JAXBElement<String> createCardCVV2(String value) {
        return new JAXBElement<String>(_CardCVV2_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRegion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllRegionsResult", scope = GetAllRegionsResponse.class)
    public JAXBElement<ArrayOfRegion> createGetAllRegionsResponseGetAllRegionsResult(ArrayOfRegion value) {
        return new JAXBElement<ArrayOfRegion>(_GetAllRegionsResponseGetAllRegionsResult_QNAME, ArrayOfRegion.class, GetAllRegionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Client }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetClientResult", scope = GetClientResponse.class)
    public JAXBElement<Client> createGetClientResponseGetClientResult(Client value) {
        return new JAXBElement<Client>(_GetClientResponseGetClientResult_QNAME, Client.class, GetClientResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetClient.class)
    public JAXBElement<String> createGetClientSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetClient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = UpdateSellCurrencyRates.class)
    public JAXBElement<String> createUpdateSellCurrencyRatesSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, UpdateSellCurrencyRates.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSellCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sellCurrencyRates", scope = UpdateSellCurrencyRates.class)
    public JAXBElement<ArrayOfSellCurrencyRate> createUpdateSellCurrencyRatesSellCurrencyRates(ArrayOfSellCurrencyRate value) {
        return new JAXBElement<ArrayOfSellCurrencyRate>(_UpdateSellCurrencyRatesSellCurrencyRates_QNAME, ArrayOfSellCurrencyRate.class, UpdateSellCurrencyRates.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Information", scope = Payment.class)
    public JAXBElement<String> createPaymentInformation(String value) {
        return new JAXBElement<String>(_PaymentInformation_QNAME, String.class, Payment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "LegalAccount", scope = Payment.class)
    public JAXBElement<LegalAccount> createPaymentLegalAccount(LegalAccount value) {
        return new JAXBElement<LegalAccount>(_LegalAccount_QNAME, LegalAccount.class, Payment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Money", scope = Payment.class)
    public JAXBElement<Money> createPaymentMoney(Money value) {
        return new JAXBElement<Money>(_Money_QNAME, Money.class, Payment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Account", scope = Payment.class)
    public JAXBElement<Account> createPaymentAccount(Account value) {
        return new JAXBElement<Account>(_Account_QNAME, Account.class, Payment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "secretWord", scope = SetAmountLimit.class)
    public JAXBElement<String> createSetAmountLimitSecretWord(String value) {
        return new JAXBElement<String>(_UnlockCardSecretWord_QNAME, String.class, SetAmountLimit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = SetAmountLimit.class)
    public JAXBElement<String> createSetAmountLimitSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, SetAmountLimit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "amount", scope = SetAmountLimit.class)
    public JAXBElement<Money> createSetAmountLimitAmount(Money value) {
        return new JAXBElement<Money>(_ExecuteTransferAmount_QNAME, Money.class, SetAmountLimit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAccountByNumberResult", scope = GetAccountByNumberResponse.class)
    public JAXBElement<Account> createGetAccountByNumberResponseGetAccountByNumberResult(Account value) {
        return new JAXBElement<Account>(_GetAccountByNumberResponseGetAccountByNumberResult_QNAME, Account.class, GetAccountByNumberResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Name", scope = Service.class)
    public JAXBElement<String> createServiceName(String value) {
        return new JAXBElement<String>(_CurrencyTypeName_QNAME, String.class, Service.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetCardForOperator.class)
    public JAXBElement<String> createGetCardForOperatorSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetCardForOperator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetServicesForCity.class)
    public JAXBElement<String> createGetServicesForCitySecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetServicesForCity.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = OpenAccount.class)
    public JAXBElement<String> createOpenAccountSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, OpenAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "account", scope = OpenAccount.class)
    public JAXBElement<Account> createOpenAccountAccount(Account value) {
        return new JAXBElement<Account>(_OpenAccountAccount_QNAME, Account.class, OpenAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSavedPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSavedPaymentsForAccountResult", scope = GetSavedPaymentsForAccountResponse.class)
    public JAXBElement<ArrayOfSavedPayment> createGetSavedPaymentsForAccountResponseGetSavedPaymentsForAccountResult(ArrayOfSavedPayment value) {
        return new JAXBElement<ArrayOfSavedPayment>(_GetSavedPaymentsForAccountResponseGetSavedPaymentsForAccountResult_QNAME, ArrayOfSavedPayment.class, GetSavedPaymentsForAccountResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = LockCardById.class)
    public JAXBElement<String> createLockCardByIdSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, LockCardById.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetServicesForCityResult", scope = GetServicesForCityResponse.class)
    public JAXBElement<ArrayOfService> createGetServicesForCityResponseGetServicesForCityResult(ArrayOfService value) {
        return new JAXBElement<ArrayOfService>(_GetServicesForCityResponseGetServicesForCityResult_QNAME, ArrayOfService.class, GetServicesForCityResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSellCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSellCurrencyRatesResult", scope = GetSellCurrencyRatesResponse.class)
    public JAXBElement<ArrayOfSellCurrencyRate> createGetSellCurrencyRatesResponseGetSellCurrencyRatesResult(ArrayOfSellCurrencyRate value) {
        return new JAXBElement<ArrayOfSellCurrencyRate>(_GetSellCurrencyRatesResponseGetSellCurrencyRatesResult_QNAME, ArrayOfSellCurrencyRate.class, GetSellCurrencyRatesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Number", scope = LegalAccount.class)
    public JAXBElement<String> createLegalAccountNumber(String value) {
        return new JAXBElement<String>(_PassportNumber_QNAME, String.class, LegalAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "CurrencyType", scope = LegalAccount.class)
    public JAXBElement<CurrencyType> createLegalAccountCurrencyType(CurrencyType value) {
        return new JAXBElement<CurrencyType>(_CurrencyType_QNAME, CurrencyType.class, LegalAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAutoPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAutoPaymentsForAccountResult", scope = GetAutoPaymentsForAccountResponse.class)
    public JAXBElement<ArrayOfAutoPayment> createGetAutoPaymentsForAccountResponseGetAutoPaymentsForAccountResult(ArrayOfAutoPayment value) {
        return new JAXBElement<ArrayOfAutoPayment>(_GetAutoPaymentsForAccountResponseGetAutoPaymentsForAccountResult_QNAME, ArrayOfAutoPayment.class, GetAutoPaymentsForAccountResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Number", scope = Account.class)
    public JAXBElement<String> createAccountNumber(String value) {
        return new JAXBElement<String>(_PassportNumber_QNAME, String.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "CurrencyType", scope = Account.class)
    public JAXBElement<CurrencyType> createAccountCurrencyType(CurrencyType value) {
        return new JAXBElement<CurrencyType>(_CurrencyType_QNAME, CurrencyType.class, Account.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetCardsForClient.class)
    public JAXBElement<String> createGetCardsForClientSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetCardsForClient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = PayERIP.class)
    public JAXBElement<String> createPayERIPSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, PayERIP.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "information", scope = PayERIP.class)
    public JAXBElement<String> createPayERIPInformation(String value) {
        return new JAXBElement<String>(_PayInformation_QNAME, String.class, PayERIP.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "cardNumber", scope = PayERIP.class)
    public JAXBElement<String> createPayERIPCardNumber(String value) {
        return new JAXBElement<String>(_ExecuteTransferCardNumber_QNAME, String.class, PayERIP.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "money", scope = PayERIP.class)
    public JAXBElement<Money> createPayERIPMoney(Money value) {
        return new JAXBElement<Money>(_PayERIPMoney_QNAME, Money.class, PayERIP.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Name", scope = Region.class)
    public JAXBElement<String> createRegionName(String value) {
        return new JAXBElement<String>(_CurrencyTypeName_QNAME, String.class, Region.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAllSavedPayments.class)
    public JAXBElement<String> createGetAllSavedPaymentsSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetAllSavedPayments.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfLegalPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetLegalPersonsForCategoryResult", scope = GetLegalPersonsForCategoryResponse.class)
    public JAXBElement<ArrayOfLegalPerson> createGetLegalPersonsForCategoryResponseGetLegalPersonsForCategoryResult(ArrayOfLegalPerson value) {
        return new JAXBElement<ArrayOfLegalPerson>(_GetLegalPersonsForCategoryResponseGetLegalPersonsForCategoryResult_QNAME, ArrayOfLegalPerson.class, GetLegalPersonsForCategoryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSavedPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllSavedPaymentsResult", scope = GetAllSavedPaymentsResponse.class)
    public JAXBElement<ArrayOfSavedPayment> createGetAllSavedPaymentsResponseGetAllSavedPaymentsResult(ArrayOfSavedPayment value) {
        return new JAXBElement<ArrayOfSavedPayment>(_GetAllSavedPaymentsResponseGetAllSavedPaymentsResult_QNAME, ArrayOfSavedPayment.class, GetAllSavedPaymentsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = ReplenishAccount.class)
    public JAXBElement<String> createReplenishAccountSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, ReplenishAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "money", scope = ReplenishAccount.class)
    public JAXBElement<Money> createReplenishAccountMoney(Money value) {
        return new JAXBElement<Money>(_PayERIPMoney_QNAME, Money.class, ReplenishAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Information", scope = AutoPayment.class)
    public JAXBElement<String> createAutoPaymentInformation(String value) {
        return new JAXBElement<String>(_PaymentInformation_QNAME, String.class, AutoPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Money", scope = AutoPayment.class)
    public JAXBElement<Money> createAutoPaymentMoney(Money value) {
        return new JAXBElement<Money>(_Money_QNAME, Money.class, AutoPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTransfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPeriodTransfersForCardResult", scope = GetPeriodTransfersForCardResponse.class)
    public JAXBElement<ArrayOfTransfer> createGetPeriodTransfersForCardResponseGetPeriodTransfersForCardResult(ArrayOfTransfer value) {
        return new JAXBElement<ArrayOfTransfer>(_GetPeriodTransfersForCardResponseGetPeriodTransfersForCardResult_QNAME, ArrayOfTransfer.class, GetPeriodTransfersForCardResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Information", scope = SavedPayment.class)
    public JAXBElement<String> createSavedPaymentInformation(String value) {
        return new JAXBElement<String>(_PaymentInformation_QNAME, String.class, SavedPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Money", scope = SavedPayment.class)
    public JAXBElement<Money> createSavedPaymentMoney(Money value) {
        return new JAXBElement<Money>(_Money_QNAME, Money.class, SavedPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "CurrencyType", scope = SellCurrencyRate.class)
    public JAXBElement<CurrencyType> createSellCurrencyRateCurrencyType(CurrencyType value) {
        return new JAXBElement<CurrencyType>(_CurrencyType_QNAME, CurrencyType.class, SellCurrencyRate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAutoPaymentsForAccount.class)
    public JAXBElement<String> createGetAutoPaymentsForAccountSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetAutoPaymentsForAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetPeriodTransfersForCard.class)
    public JAXBElement<String> createGetPeriodTransfersForCardSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetPeriodTransfersForCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetSavedPaymentsForAccount.class)
    public JAXBElement<String> createGetSavedPaymentsForAccountSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetSavedPaymentsForAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = UpdatePurchaseCurrencyRates.class)
    public JAXBElement<String> createUpdatePurchaseCurrencyRatesSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, UpdatePurchaseCurrencyRates.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPurchaseCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "purchaseCurrencyRates", scope = UpdatePurchaseCurrencyRates.class)
    public JAXBElement<ArrayOfPurchaseCurrencyRate> createUpdatePurchaseCurrencyRatesPurchaseCurrencyRates(ArrayOfPurchaseCurrencyRate value) {
        return new JAXBElement<ArrayOfPurchaseCurrencyRate>(_UpdatePurchaseCurrencyRatesPurchaseCurrencyRates_QNAME, ArrayOfPurchaseCurrencyRate.class, UpdatePurchaseCurrencyRates.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Card }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCardForClientResult", scope = GetCardForClientResponse.class)
    public JAXBElement<Card> createGetCardForClientResponseGetCardForClientResult(Card value) {
        return new JAXBElement<Card>(_GetCardForClientResponseGetCardForClientResult_QNAME, Card.class, GetCardForClientResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = DeleteSavedPayment.class)
    public JAXBElement<String> createDeleteSavedPaymentSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, DeleteSavedPayment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetCitiesForRegion.class)
    public JAXBElement<String> createGetCitiesForRegionSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetCitiesForRegion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAccountByNumber.class)
    public JAXBElement<String> createGetAccountByNumberSecurityToken(String value) {
        return new JAXBElement<String>(_GetAccountsForClientSecurityToken_QNAME, String.class, GetAccountByNumber.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "number", scope = GetAccountByNumber.class)
    public JAXBElement<String> createGetAccountByNumberNumber(String value) {
        return new JAXBElement<String>(_UnlockCardNumber_QNAME, String.class, GetAccountByNumber.class, value);
    }

}
