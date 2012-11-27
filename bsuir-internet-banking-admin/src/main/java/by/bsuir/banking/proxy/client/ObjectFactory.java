
package by.bsuir.banking.proxy.client;

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
 * generated in the by.bsuir.banking.proxy.client package. 
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
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _AuthorizationFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "AuthorizationFault");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _CardType_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "CardType");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _Money_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Money");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _Card_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Card");
    private final static QName _ArrayOfCard_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfCard");
    private final static QName _DomainFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "DomainFault");
    private final static QName _GetBallanceSecurityToken_QNAME = new QName("http://tempuri.org/", "securityToken");
    private final static QName _DomainFaultMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "Message");
    private final static QName _CardSecretWord_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "SecretWord");
    private final static QName _CardNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Number");
    private final static QName _CardCVV2_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "CVV2");
    private final static QName _CardTypeName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Name");
    private final static QName _GetCardsResponseGetCardsResult_QNAME = new QName("http://tempuri.org/", "GetCardsResult");
    private final static QName _GetCardResponseGetCardResult_QNAME = new QName("http://tempuri.org/", "GetCardResult");
    private final static QName _MoneyCurrencyType_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "CurrencyType");
    private final static QName _GetBallanceResponseGetBallanceResult_QNAME = new QName("http://tempuri.org/", "GetBallanceResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.bsuir.banking.proxy.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DomainFault }
     * 
     */
    public DomainFault createDomainFault() {
        return new DomainFault();
    }

    /**
     * Create an instance of {@link GetBallance }
     * 
     */
    public GetBallance createGetBallance() {
        return new GetBallance();
    }

    /**
     * Create an instance of {@link Card }
     * 
     */
    public Card createCard() {
        return new Card();
    }

    /**
     * Create an instance of {@link SetAmountLimitResponse }
     * 
     */
    public SetAmountLimitResponse createSetAmountLimitResponse() {
        return new SetAmountLimitResponse();
    }

    /**
     * Create an instance of {@link AuthorizationFault }
     * 
     */
    public AuthorizationFault createAuthorizationFault() {
        return new AuthorizationFault();
    }

    /**
     * Create an instance of {@link ArrayOfCard }
     * 
     */
    public ArrayOfCard createArrayOfCard() {
        return new ArrayOfCard();
    }

    /**
     * Create an instance of {@link CardType }
     * 
     */
    public CardType createCardType() {
        return new CardType();
    }

    /**
     * Create an instance of {@link GetCardsResponse }
     * 
     */
    public GetCardsResponse createGetCardsResponse() {
        return new GetCardsResponse();
    }

    /**
     * Create an instance of {@link GetCards }
     * 
     */
    public GetCards createGetCards() {
        return new GetCards();
    }

    /**
     * Create an instance of {@link SetAmountLimit }
     * 
     */
    public SetAmountLimit createSetAmountLimit() {
        return new SetAmountLimit();
    }

    /**
     * Create an instance of {@link GetCard }
     * 
     */
    public GetCard createGetCard() {
        return new GetCard();
    }

    /**
     * Create an instance of {@link GetCardResponse }
     * 
     */
    public GetCardResponse createGetCardResponse() {
        return new GetCardResponse();
    }

    /**
     * Create an instance of {@link SetOperationLimitResponse }
     * 
     */
    public SetOperationLimitResponse createSetOperationLimitResponse() {
        return new SetOperationLimitResponse();
    }

    /**
     * Create an instance of {@link Money }
     * 
     */
    public Money createMoney() {
        return new Money();
    }

    /**
     * Create an instance of {@link SetOperationLimit }
     * 
     */
    public SetOperationLimit createSetOperationLimit() {
        return new SetOperationLimit();
    }

    /**
     * Create an instance of {@link GetBallanceResponse }
     * 
     */
    public GetBallanceResponse createGetBallanceResponse() {
        return new GetBallanceResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorizationFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", name = "AuthorizationFault")
    public JAXBElement<AuthorizationFault> createAuthorizationFault(AuthorizationFault value) {
        return new JAXBElement<AuthorizationFault>(_AuthorizationFault_QNAME, AuthorizationFault.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetBallance.class)
    public JAXBElement<String> createGetBallanceSecurityToken(String value) {
        return new JAXBElement<String>(_GetBallanceSecurityToken_QNAME, String.class, GetBallance.class, value);
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
        return new JAXBElement<String>(_CardNumber_QNAME, String.class, Card.class, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Name", scope = CardType.class)
    public JAXBElement<String> createCardTypeName(String value) {
        return new JAXBElement<String>(_CardTypeName_QNAME, String.class, CardType.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetCards.class)
    public JAXBElement<String> createGetCardsSecurityToken(String value) {
        return new JAXBElement<String>(_GetBallanceSecurityToken_QNAME, String.class, GetCards.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = SetAmountLimit.class)
    public JAXBElement<String> createSetAmountLimitSecurityToken(String value) {
        return new JAXBElement<String>(_GetBallanceSecurityToken_QNAME, String.class, SetAmountLimit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetCard.class)
    public JAXBElement<String> createGetCardSecurityToken(String value) {
        return new JAXBElement<String>(_GetBallanceSecurityToken_QNAME, String.class, GetCard.class, value);
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
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "CurrencyType", scope = Money.class)
    public JAXBElement<String> createMoneyCurrencyType(String value) {
        return new JAXBElement<String>(_MoneyCurrencyType_QNAME, String.class, Money.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = SetOperationLimit.class)
    public JAXBElement<String> createSetOperationLimitSecurityToken(String value) {
        return new JAXBElement<String>(_GetBallanceSecurityToken_QNAME, String.class, SetOperationLimit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBallanceResult", scope = GetBallanceResponse.class)
    public JAXBElement<Money> createGetBallanceResponseGetBallanceResult(Money value) {
        return new JAXBElement<Money>(_GetBallanceResponseGetBallanceResult_QNAME, Money.class, GetBallanceResponse.class, value);
    }

}
