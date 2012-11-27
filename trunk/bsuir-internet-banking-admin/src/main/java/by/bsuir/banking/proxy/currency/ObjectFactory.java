
package by.bsuir.banking.proxy.currency;

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
 * generated in the by.bsuir.banking.proxy.currency package. 
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

    private final static QName _AuthorizationFaultMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "Message");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _PurchaseCurrencyRate_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "PurchaseCurrencyRate");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _AuthorizationFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "AuthorizationFault");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _SellCurrencyRate_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "SellCurrencyRate");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _CurrencyType_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "CurrencyType");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _ArrayOfCurrencyType_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfCurrencyType");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _ArrayOfPurchaseCurrencyRate_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfPurchaseCurrencyRate");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _ArrayOfSellCurrencyRate_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfSellCurrencyRate");
    private final static QName _DomainFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "DomainFault");
    private final static QName _GetSellCurrencyRatesResponseGetSellCurrencyRatesResult_QNAME = new QName("http://tempuri.org/", "GetSellCurrencyRatesResult");
    private final static QName _GetPurchaseCurrencyRatesResponseGetPurchaseCurrencyRatesResult_QNAME = new QName("http://tempuri.org/", "GetPurchaseCurrencyRatesResult");
    private final static QName _CurrencyTypeName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Name");
    private final static QName _CurrencyTypeShortName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ShortName");
    private final static QName _UpdatePurchaseCurrencyRatesSecurityToken_QNAME = new QName("http://tempuri.org/", "securityToken");
    private final static QName _UpdatePurchaseCurrencyRatesPurchaseCurrencyRates_QNAME = new QName("http://tempuri.org/", "purchaseCurrencyRates");
    private final static QName _UpdateSellCurrencyRatesSellCurrencyRates_QNAME = new QName("http://tempuri.org/", "sellCurrencyRates");
    private final static QName _GetCurrencyTypesResponseGetCurrencyTypesResult_QNAME = new QName("http://tempuri.org/", "GetCurrencyTypesResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.bsuir.banking.proxy.currency
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPurchaseCurrencyRatesResponse }
     * 
     */
    public GetPurchaseCurrencyRatesResponse createGetPurchaseCurrencyRatesResponse() {
        return new GetPurchaseCurrencyRatesResponse();
    }

    /**
     * Create an instance of {@link ArrayOfPurchaseCurrencyRate }
     * 
     */
    public ArrayOfPurchaseCurrencyRate createArrayOfPurchaseCurrencyRate() {
        return new ArrayOfPurchaseCurrencyRate();
    }

    /**
     * Create an instance of {@link UpdatePurchaseCurrencyRatesResponse }
     * 
     */
    public UpdatePurchaseCurrencyRatesResponse createUpdatePurchaseCurrencyRatesResponse() {
        return new UpdatePurchaseCurrencyRatesResponse();
    }

    /**
     * Create an instance of {@link PurchaseCurrencyRate }
     * 
     */
    public PurchaseCurrencyRate createPurchaseCurrencyRate() {
        return new PurchaseCurrencyRate();
    }

    /**
     * Create an instance of {@link CurrencyType }
     * 
     */
    public CurrencyType createCurrencyType() {
        return new CurrencyType();
    }

    /**
     * Create an instance of {@link UpdatePurchaseCurrencyRates }
     * 
     */
    public UpdatePurchaseCurrencyRates createUpdatePurchaseCurrencyRates() {
        return new UpdatePurchaseCurrencyRates();
    }

    /**
     * Create an instance of {@link ArrayOfSellCurrencyRate }
     * 
     */
    public ArrayOfSellCurrencyRate createArrayOfSellCurrencyRate() {
        return new ArrayOfSellCurrencyRate();
    }

    /**
     * Create an instance of {@link SellCurrencyRate }
     * 
     */
    public SellCurrencyRate createSellCurrencyRate() {
        return new SellCurrencyRate();
    }

    /**
     * Create an instance of {@link GetPurchaseCurrencyRates }
     * 
     */
    public GetPurchaseCurrencyRates createGetPurchaseCurrencyRates() {
        return new GetPurchaseCurrencyRates();
    }

    /**
     * Create an instance of {@link GetCurrencyTypesResponse }
     * 
     */
    public GetCurrencyTypesResponse createGetCurrencyTypesResponse() {
        return new GetCurrencyTypesResponse();
    }

    /**
     * Create an instance of {@link UpdateSellCurrencyRates }
     * 
     */
    public UpdateSellCurrencyRates createUpdateSellCurrencyRates() {
        return new UpdateSellCurrencyRates();
    }

    /**
     * Create an instance of {@link AuthorizationFault }
     * 
     */
    public AuthorizationFault createAuthorizationFault() {
        return new AuthorizationFault();
    }

    /**
     * Create an instance of {@link GetSellCurrencyRatesResponse }
     * 
     */
    public GetSellCurrencyRatesResponse createGetSellCurrencyRatesResponse() {
        return new GetSellCurrencyRatesResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCurrencyType }
     * 
     */
    public ArrayOfCurrencyType createArrayOfCurrencyType() {
        return new ArrayOfCurrencyType();
    }

    /**
     * Create an instance of {@link UpdateSellCurrencyRatesResponse }
     * 
     */
    public UpdateSellCurrencyRatesResponse createUpdateSellCurrencyRatesResponse() {
        return new UpdateSellCurrencyRatesResponse();
    }

    /**
     * Create an instance of {@link GetSellCurrencyRates }
     * 
     */
    public GetSellCurrencyRates createGetSellCurrencyRates() {
        return new GetSellCurrencyRates();
    }

    /**
     * Create an instance of {@link GetCurrencyTypes }
     * 
     */
    public GetCurrencyTypes createGetCurrencyTypes() {
        return new GetCurrencyTypes();
    }

    /**
     * Create an instance of {@link DomainFault }
     * 
     */
    public DomainFault createDomainFault() {
        return new DomainFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", name = "Message", scope = AuthorizationFault.class)
    public JAXBElement<String> createAuthorizationFaultMessage(String value) {
        return new JAXBElement<String>(_AuthorizationFaultMessage_QNAME, String.class, AuthorizationFault.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PurchaseCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "PurchaseCurrencyRate")
    public JAXBElement<PurchaseCurrencyRate> createPurchaseCurrencyRate(PurchaseCurrencyRate value) {
        return new JAXBElement<PurchaseCurrencyRate>(_PurchaseCurrencyRate_QNAME, PurchaseCurrencyRate.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SellCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "SellCurrencyRate")
    public JAXBElement<SellCurrencyRate> createSellCurrencyRate(SellCurrencyRate value) {
        return new JAXBElement<SellCurrencyRate>(_SellCurrencyRate_QNAME, SellCurrencyRate.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", name = "DomainFault")
    public JAXBElement<DomainFault> createDomainFault(DomainFault value) {
        return new JAXBElement<DomainFault>(_DomainFault_QNAME, DomainFault.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPurchaseCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPurchaseCurrencyRatesResult", scope = GetPurchaseCurrencyRatesResponse.class)
    public JAXBElement<ArrayOfPurchaseCurrencyRate> createGetPurchaseCurrencyRatesResponseGetPurchaseCurrencyRatesResult(ArrayOfPurchaseCurrencyRate value) {
        return new JAXBElement<ArrayOfPurchaseCurrencyRate>(_GetPurchaseCurrencyRatesResponseGetPurchaseCurrencyRatesResult_QNAME, ArrayOfPurchaseCurrencyRate.class, GetPurchaseCurrencyRatesResponse.class, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = UpdatePurchaseCurrencyRates.class)
    public JAXBElement<String> createUpdatePurchaseCurrencyRatesSecurityToken(String value) {
        return new JAXBElement<String>(_UpdatePurchaseCurrencyRatesSecurityToken_QNAME, String.class, UpdatePurchaseCurrencyRates.class, value);
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
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", name = "Message", scope = DomainFault.class)
    public JAXBElement<String> createDomainFaultMessage(String value) {
        return new JAXBElement<String>(_AuthorizationFaultMessage_QNAME, String.class, DomainFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = UpdateSellCurrencyRates.class)
    public JAXBElement<String> createUpdateSellCurrencyRatesSecurityToken(String value) {
        return new JAXBElement<String>(_UpdatePurchaseCurrencyRatesSecurityToken_QNAME, String.class, UpdateSellCurrencyRates.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCurrencyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCurrencyTypesResult", scope = GetCurrencyTypesResponse.class)
    public JAXBElement<ArrayOfCurrencyType> createGetCurrencyTypesResponseGetCurrencyTypesResult(ArrayOfCurrencyType value) {
        return new JAXBElement<ArrayOfCurrencyType>(_GetCurrencyTypesResponseGetCurrencyTypesResult_QNAME, ArrayOfCurrencyType.class, GetCurrencyTypesResponse.class, value);
    }

}