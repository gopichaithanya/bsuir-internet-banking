
package by.bsuir.banking.proxy.card;

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
 * generated in the by.bsuir.banking.proxy.card package. 
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

    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Account_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Account");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _AuthorizationFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "AuthorizationFault");
    private final static QName _CardType_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "CardType");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _ArrayOfCardType_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfCardType");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _ArrayOfAccount_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfAccount");
    private final static QName _CurrencyType_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "CurrencyType");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _Card_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Card");
    private final static QName _ArrayOfCard_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfCard");
    private final static QName _DomainFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "DomainFault");
    private final static QName _GetCardsForClientResponseGetCardsForClientResult_QNAME = new QName("http://tempuri.org/", "GetCardsForClientResult");
    private final static QName _GetCardResponseGetCardResult_QNAME = new QName("http://tempuri.org/", "GetCardResult");
    private final static QName _OpenAccountSecurityToken_QNAME = new QName("http://tempuri.org/", "securityToken");
    private final static QName _OpenAccountAccount_QNAME = new QName("http://tempuri.org/", "account");
    private final static QName _CardTypeName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Name");
    private final static QName _DomainFaultMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "Message");
    private final static QName _CreateCardCard_QNAME = new QName("http://tempuri.org/", "card");
    private final static QName _GetAccountByIdResponseGetAccountByIdResult_QNAME = new QName("http://tempuri.org/", "GetAccountByIdResult");
    private final static QName _GetAccountsForClientResponseGetAccountsForClientResult_QNAME = new QName("http://tempuri.org/", "GetAccountsForClientResult");
    private final static QName _GetAccountByNumberResponseGetAccountByNumberResult_QNAME = new QName("http://tempuri.org/", "GetAccountByNumberResult");
    private final static QName _CurrencyTypeShortName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ShortName");
    private final static QName _GetAllCardTypesResponseGetAllCardTypesResult_QNAME = new QName("http://tempuri.org/", "GetAllCardTypesResult");
    private final static QName _GetAccountByNumberNumber_QNAME = new QName("http://tempuri.org/", "number");
    private final static QName _AccountNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Number");
    private final static QName _GetCardForAccountResponseGetCardForAccountResult_QNAME = new QName("http://tempuri.org/", "GetCardForAccountResult");
    private final static QName _CardSecretWord_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "SecretWord");
    private final static QName _CardCVV2_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "CVV2");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.bsuir.banking.proxy.card
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetOperationLimitResponse }
     * 
     */
    public GetOperationLimitResponse createGetOperationLimitResponse() {
        return new GetOperationLimitResponse();
    }

    /**
     * Create an instance of {@link GetCardsForClientResponse }
     * 
     */
    public GetCardsForClientResponse createGetCardsForClientResponse() {
        return new GetCardsForClientResponse();
    }

    /**
     * Create an instance of {@link CloseAccountResponse }
     * 
     */
    public CloseAccountResponse createCloseAccountResponse() {
        return new CloseAccountResponse();
    }

    /**
     * Create an instance of {@link GetCardResponse }
     * 
     */
    public GetCardResponse createGetCardResponse() {
        return new GetCardResponse();
    }

    /**
     * Create an instance of {@link GetAmountLimitResponse }
     * 
     */
    public GetAmountLimitResponse createGetAmountLimitResponse() {
        return new GetAmountLimitResponse();
    }

    /**
     * Create an instance of {@link OpenAccount }
     * 
     */
    public OpenAccount createOpenAccount() {
        return new OpenAccount();
    }

    /**
     * Create an instance of {@link GetAccountById }
     * 
     */
    public GetAccountById createGetAccountById() {
        return new GetAccountById();
    }

    /**
     * Create an instance of {@link CloseAccount }
     * 
     */
    public CloseAccount createCloseAccount() {
        return new CloseAccount();
    }

    /**
     * Create an instance of {@link OpenAccountResponse }
     * 
     */
    public OpenAccountResponse createOpenAccountResponse() {
        return new OpenAccountResponse();
    }

    /**
     * Create an instance of {@link CardType }
     * 
     */
    public CardType createCardType() {
        return new CardType();
    }

    /**
     * Create an instance of {@link GetCardForAccount }
     * 
     */
    public GetCardForAccount createGetCardForAccount() {
        return new GetCardForAccount();
    }

    /**
     * Create an instance of {@link DomainFault }
     * 
     */
    public DomainFault createDomainFault() {
        return new DomainFault();
    }

    /**
     * Create an instance of {@link DeleteCard }
     * 
     */
    public DeleteCard createDeleteCard() {
        return new DeleteCard();
    }

    /**
     * Create an instance of {@link ArrayOfAccount }
     * 
     */
    public ArrayOfAccount createArrayOfAccount() {
        return new ArrayOfAccount();
    }

    /**
     * Create an instance of {@link CreateCard }
     * 
     */
    public CreateCard createCreateCard() {
        return new CreateCard();
    }

    /**
     * Create an instance of {@link GetAccountByIdResponse }
     * 
     */
    public GetAccountByIdResponse createGetAccountByIdResponse() {
        return new GetAccountByIdResponse();
    }

    /**
     * Create an instance of {@link GetCardsForClient }
     * 
     */
    public GetCardsForClient createGetCardsForClient() {
        return new GetCardsForClient();
    }

    /**
     * Create an instance of {@link GetAccountsForClientResponse }
     * 
     */
    public GetAccountsForClientResponse createGetAccountsForClientResponse() {
        return new GetAccountsForClientResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCardType }
     * 
     */
    public ArrayOfCardType createArrayOfCardType() {
        return new ArrayOfCardType();
    }

    /**
     * Create an instance of {@link GetAccountByNumberResponse }
     * 
     */
    public GetAccountByNumberResponse createGetAccountByNumberResponse() {
        return new GetAccountByNumberResponse();
    }

    /**
     * Create an instance of {@link DeleteCardResponse }
     * 
     */
    public DeleteCardResponse createDeleteCardResponse() {
        return new DeleteCardResponse();
    }

    /**
     * Create an instance of {@link GetCard }
     * 
     */
    public GetCard createGetCard() {
        return new GetCard();
    }

    /**
     * Create an instance of {@link GetAllCardTypes }
     * 
     */
    public GetAllCardTypes createGetAllCardTypes() {
        return new GetAllCardTypes();
    }

    /**
     * Create an instance of {@link CurrencyType }
     * 
     */
    public CurrencyType createCurrencyType() {
        return new CurrencyType();
    }

    /**
     * Create an instance of {@link GetAmountLimit }
     * 
     */
    public GetAmountLimit createGetAmountLimit() {
        return new GetAmountLimit();
    }

    /**
     * Create an instance of {@link GetAccountsForClient }
     * 
     */
    public GetAccountsForClient createGetAccountsForClient() {
        return new GetAccountsForClient();
    }

    /**
     * Create an instance of {@link GetAllCardTypesResponse }
     * 
     */
    public GetAllCardTypesResponse createGetAllCardTypesResponse() {
        return new GetAllCardTypesResponse();
    }

    /**
     * Create an instance of {@link GetAccountByNumber }
     * 
     */
    public GetAccountByNumber createGetAccountByNumber() {
        return new GetAccountByNumber();
    }

    /**
     * Create an instance of {@link GetCardForAccountResponse }
     * 
     */
    public GetCardForAccountResponse createGetCardForAccountResponse() {
        return new GetCardForAccountResponse();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link ArrayOfCard }
     * 
     */
    public ArrayOfCard createArrayOfCard() {
        return new ArrayOfCard();
    }

    /**
     * Create an instance of {@link GetOperationLimit }
     * 
     */
    public GetOperationLimit createGetOperationLimit() {
        return new GetOperationLimit();
    }

    /**
     * Create an instance of {@link CreateCardResponse }
     * 
     */
    public CreateCardResponse createCreateCardResponse() {
        return new CreateCardResponse();
    }

    /**
     * Create an instance of {@link Card }
     * 
     */
    public Card createCard() {
        return new Card();
    }

    /**
     * Create an instance of {@link AuthorizationFault }
     * 
     */
    public AuthorizationFault createAuthorizationFault() {
        return new AuthorizationFault();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCardType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfCardType")
    public JAXBElement<ArrayOfCardType> createArrayOfCardType(ArrayOfCardType value) {
        return new JAXBElement<ArrayOfCardType>(_ArrayOfCardType_QNAME, ArrayOfCardType.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfAccount")
    public JAXBElement<ArrayOfAccount> createArrayOfAccount(ArrayOfAccount value) {
        return new JAXBElement<ArrayOfAccount>(_ArrayOfAccount_QNAME, ArrayOfAccount.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Card }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Card")
    public JAXBElement<Card> createCard(Card value) {
        return new JAXBElement<Card>(_Card_QNAME, Card.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", name = "DomainFault")
    public JAXBElement<DomainFault> createDomainFault(DomainFault value) {
        return new JAXBElement<DomainFault>(_DomainFault_QNAME, DomainFault.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Card }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCardResult", scope = GetCardResponse.class)
    public JAXBElement<Card> createGetCardResponseGetCardResult(Card value) {
        return new JAXBElement<Card>(_GetCardResponseGetCardResult_QNAME, Card.class, GetCardResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = OpenAccount.class)
    public JAXBElement<String> createOpenAccountSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, OpenAccount.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAccountById.class)
    public JAXBElement<String> createGetAccountByIdSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, GetAccountById.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = CloseAccount.class)
    public JAXBElement<String> createCloseAccountSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, CloseAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Name", scope = CardType.class)
    public JAXBElement<String> createCardTypeName(String value) {
        return new JAXBElement<String>(_CardTypeName_QNAME, String.class, CardType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetCardForAccount.class)
    public JAXBElement<String> createGetCardForAccountSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, GetCardForAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = DeleteCard.class)
    public JAXBElement<String> createDeleteCardSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, DeleteCard.class, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = CreateCard.class)
    public JAXBElement<String> createCreateCardSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, CreateCard.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAccountByIdResult", scope = GetAccountByIdResponse.class)
    public JAXBElement<Account> createGetAccountByIdResponseGetAccountByIdResult(Account value) {
        return new JAXBElement<Account>(_GetAccountByIdResponseGetAccountByIdResult_QNAME, Account.class, GetAccountByIdResponse.class, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetCardsForClient.class)
    public JAXBElement<String> createGetCardsForClientSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, GetCardsForClient.class, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetCard.class)
    public JAXBElement<String> createGetCardSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, GetCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAllCardTypes.class)
    public JAXBElement<String> createGetAllCardTypesSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, GetAllCardTypes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Name", scope = CurrencyType.class)
    public JAXBElement<String> createCurrencyTypeName(String value) {
        return new JAXBElement<String>(_CardTypeName_QNAME, String.class, CurrencyType.class, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAmountLimit.class)
    public JAXBElement<String> createGetAmountLimitSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, GetAmountLimit.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAccountsForClient.class)
    public JAXBElement<String> createGetAccountsForClientSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, GetAccountsForClient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAccountByNumber.class)
    public JAXBElement<String> createGetAccountByNumberSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, GetAccountByNumber.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "number", scope = GetAccountByNumber.class)
    public JAXBElement<String> createGetAccountByNumberNumber(String value) {
        return new JAXBElement<String>(_GetAccountByNumberNumber_QNAME, String.class, GetAccountByNumber.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Number", scope = Account.class)
    public JAXBElement<String> createAccountNumber(String value) {
        return new JAXBElement<String>(_AccountNumber_QNAME, String.class, Account.class, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetOperationLimit.class)
    public JAXBElement<String> createGetOperationLimitSecurityToken(String value) {
        return new JAXBElement<String>(_OpenAccountSecurityToken_QNAME, String.class, GetOperationLimit.class, value);
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
        return new JAXBElement<String>(_AccountNumber_QNAME, String.class, Card.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", name = "Message", scope = AuthorizationFault.class)
    public JAXBElement<String> createAuthorizationFaultMessage(String value) {
        return new JAXBElement<String>(_DomainFaultMessage_QNAME, String.class, AuthorizationFault.class, value);
    }

}
