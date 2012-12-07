
package by.bsuir.banking.proxy.administration;

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
 * generated in the by.bsuir.banking.proxy.administration package. 
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
    private final static QName _Operator_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Operator");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _AuthorizationFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "AuthorizationFault");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _ArrayOfAdministrator_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfAdministrator");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _Administrator_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Administrator");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _ArrayOfOperator_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfOperator");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _DomainFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "DomainFault");
    private final static QName _CreateNewOperatorSecurityToken_QNAME = new QName("http://tempuri.org/", "securityToken");
    private final static QName _CreateNewOperatorNewOperator_QNAME = new QName("http://tempuri.org/", "newOperator");
    private final static QName _DomainFaultMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "Message");
    private final static QName _AdministratorMiddleName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "MiddleName");
    private final static QName _AdministratorLogin_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Login");
    private final static QName _AdministratorPassword_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Password");
    private final static QName _AdministratorFirstName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "FirstName");
    private final static QName _AdministratorLastName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "LastName");
    private final static QName _UpdateOperatorUpdatedOperator_QNAME = new QName("http://tempuri.org/", "updatedOperator");
    private final static QName _GetAllOperatorsResponseGetAllOperatorsResult_QNAME = new QName("http://tempuri.org/", "GetAllOperatorsResult");
    private final static QName _CreateNewAdministratorNewAdministrator_QNAME = new QName("http://tempuri.org/", "newAdministrator");
    private final static QName _GetAdministratorByIdResponseGetAdministratorByIdResult_QNAME = new QName("http://tempuri.org/", "GetAdministratorByIdResult");
    private final static QName _GetOperatorByIdResponseGetOperatorByIdResult_QNAME = new QName("http://tempuri.org/", "GetOperatorByIdResult");
    private final static QName _UpdateAdministratorUpdatedAdministrator_QNAME = new QName("http://tempuri.org/", "updatedAdministrator");
    private final static QName _GetAllAdministratorsResponseGetAllAdministratorsResult_QNAME = new QName("http://tempuri.org/", "GetAllAdministratorsResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.bsuir.banking.proxy.administration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveAdministratorResponse }
     * 
     */
    public RemoveAdministratorResponse createRemoveAdministratorResponse() {
        return new RemoveAdministratorResponse();
    }

    /**
     * Create an instance of {@link GetAllAdministrators }
     * 
     */
    public GetAllAdministrators createGetAllAdministrators() {
        return new GetAllAdministrators();
    }

    /**
     * Create an instance of {@link RemoveOperatorResponse }
     * 
     */
    public RemoveOperatorResponse createRemoveOperatorResponse() {
        return new RemoveOperatorResponse();
    }

    /**
     * Create an instance of {@link GetAdministratorById }
     * 
     */
    public GetAdministratorById createGetAdministratorById() {
        return new GetAdministratorById();
    }

    /**
     * Create an instance of {@link UpdateOperator }
     * 
     */
    public UpdateOperator createUpdateOperator() {
        return new UpdateOperator();
    }

    /**
     * Create an instance of {@link Operator }
     * 
     */
    public Operator createOperator() {
        return new Operator();
    }

    /**
     * Create an instance of {@link GetAdministratorsCount }
     * 
     */
    public GetAdministratorsCount createGetAdministratorsCount() {
        return new GetAdministratorsCount();
    }

    /**
     * Create an instance of {@link GetOperatorById }
     * 
     */
    public GetOperatorById createGetOperatorById() {
        return new GetOperatorById();
    }

    /**
     * Create an instance of {@link GetAdministratorByIdResponse }
     * 
     */
    public GetAdministratorByIdResponse createGetAdministratorByIdResponse() {
        return new GetAdministratorByIdResponse();
    }

    /**
     * Create an instance of {@link ArrayOfAdministrator }
     * 
     */
    public ArrayOfAdministrator createArrayOfAdministrator() {
        return new ArrayOfAdministrator();
    }

    /**
     * Create an instance of {@link GetOperatorByIdResponse }
     * 
     */
    public GetOperatorByIdResponse createGetOperatorByIdResponse() {
        return new GetOperatorByIdResponse();
    }

    /**
     * Create an instance of {@link GetAllOperators }
     * 
     */
    public GetAllOperators createGetAllOperators() {
        return new GetAllOperators();
    }

    /**
     * Create an instance of {@link GetAllAdministratorsResponse }
     * 
     */
    public GetAllAdministratorsResponse createGetAllAdministratorsResponse() {
        return new GetAllAdministratorsResponse();
    }

    /**
     * Create an instance of {@link GetOperatorsCount }
     * 
     */
    public GetOperatorsCount createGetOperatorsCount() {
        return new GetOperatorsCount();
    }

    /**
     * Create an instance of {@link RemoveOperator }
     * 
     */
    public RemoveOperator createRemoveOperator() {
        return new RemoveOperator();
    }

    /**
     * Create an instance of {@link AuthorizationFault }
     * 
     */
    public AuthorizationFault createAuthorizationFault() {
        return new AuthorizationFault();
    }

    /**
     * Create an instance of {@link CreateNewOperator }
     * 
     */
    public CreateNewOperator createCreateNewOperator() {
        return new CreateNewOperator();
    }

    /**
     * Create an instance of {@link DomainFault }
     * 
     */
    public DomainFault createDomainFault() {
        return new DomainFault();
    }

    /**
     * Create an instance of {@link ArrayOfOperator }
     * 
     */
    public ArrayOfOperator createArrayOfOperator() {
        return new ArrayOfOperator();
    }

    /**
     * Create an instance of {@link Administrator }
     * 
     */
    public Administrator createAdministrator() {
        return new Administrator();
    }

    /**
     * Create an instance of {@link GetAllOperatorsResponse }
     * 
     */
    public GetAllOperatorsResponse createGetAllOperatorsResponse() {
        return new GetAllOperatorsResponse();
    }

    /**
     * Create an instance of {@link RemoveAdministrator }
     * 
     */
    public RemoveAdministrator createRemoveAdministrator() {
        return new RemoveAdministrator();
    }

    /**
     * Create an instance of {@link CreateNewAdministrator }
     * 
     */
    public CreateNewAdministrator createCreateNewAdministrator() {
        return new CreateNewAdministrator();
    }

    /**
     * Create an instance of {@link CreateNewAdministratorResponse }
     * 
     */
    public CreateNewAdministratorResponse createCreateNewAdministratorResponse() {
        return new CreateNewAdministratorResponse();
    }

    /**
     * Create an instance of {@link GetAdministratorsCountResponse }
     * 
     */
    public GetAdministratorsCountResponse createGetAdministratorsCountResponse() {
        return new GetAdministratorsCountResponse();
    }

    /**
     * Create an instance of {@link CreateNewOperatorResponse }
     * 
     */
    public CreateNewOperatorResponse createCreateNewOperatorResponse() {
        return new CreateNewOperatorResponse();
    }

    /**
     * Create an instance of {@link UpdateAdministrator }
     * 
     */
    public UpdateAdministrator createUpdateAdministrator() {
        return new UpdateAdministrator();
    }

    /**
     * Create an instance of {@link UpdateOperatorResponse }
     * 
     */
    public UpdateOperatorResponse createUpdateOperatorResponse() {
        return new UpdateOperatorResponse();
    }

    /**
     * Create an instance of {@link UpdateAdministratorResponse }
     * 
     */
    public UpdateAdministratorResponse createUpdateAdministratorResponse() {
        return new UpdateAdministratorResponse();
    }

    /**
     * Create an instance of {@link GetOperatorsCountResponse }
     * 
     */
    public GetOperatorsCountResponse createGetOperatorsCountResponse() {
        return new GetOperatorsCountResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Operator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Operator")
    public JAXBElement<Operator> createOperator(Operator value) {
        return new JAXBElement<Operator>(_Operator_QNAME, Operator.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAdministrator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfAdministrator")
    public JAXBElement<ArrayOfAdministrator> createArrayOfAdministrator(ArrayOfAdministrator value) {
        return new JAXBElement<ArrayOfAdministrator>(_ArrayOfAdministrator_QNAME, ArrayOfAdministrator.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Administrator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Administrator")
    public JAXBElement<Administrator> createAdministrator(Administrator value) {
        return new JAXBElement<Administrator>(_Administrator_QNAME, Administrator.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOperator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfOperator")
    public JAXBElement<ArrayOfOperator> createArrayOfOperator(ArrayOfOperator value) {
        return new JAXBElement<ArrayOfOperator>(_ArrayOfOperator_QNAME, ArrayOfOperator.class, null, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = CreateNewOperator.class)
    public JAXBElement<String> createCreateNewOperatorSecurityToken(String value) {
        return new JAXBElement<String>(_CreateNewOperatorSecurityToken_QNAME, String.class, CreateNewOperator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Operator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "newOperator", scope = CreateNewOperator.class)
    public JAXBElement<Operator> createCreateNewOperatorNewOperator(Operator value) {
        return new JAXBElement<Operator>(_CreateNewOperatorNewOperator_QNAME, Operator.class, CreateNewOperator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAllAdministrators.class)
    public JAXBElement<String> createGetAllAdministratorsSecurityToken(String value) {
        return new JAXBElement<String>(_CreateNewOperatorSecurityToken_QNAME, String.class, GetAllAdministrators.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAdministratorById.class)
    public JAXBElement<String> createGetAdministratorByIdSecurityToken(String value) {
        return new JAXBElement<String>(_CreateNewOperatorSecurityToken_QNAME, String.class, GetAdministratorById.class, value);
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
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "MiddleName", scope = Administrator.class)
    public JAXBElement<String> createAdministratorMiddleName(String value) {
        return new JAXBElement<String>(_AdministratorMiddleName_QNAME, String.class, Administrator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Login", scope = Administrator.class)
    public JAXBElement<String> createAdministratorLogin(String value) {
        return new JAXBElement<String>(_AdministratorLogin_QNAME, String.class, Administrator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Password", scope = Administrator.class)
    public JAXBElement<String> createAdministratorPassword(String value) {
        return new JAXBElement<String>(_AdministratorPassword_QNAME, String.class, Administrator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "FirstName", scope = Administrator.class)
    public JAXBElement<String> createAdministratorFirstName(String value) {
        return new JAXBElement<String>(_AdministratorFirstName_QNAME, String.class, Administrator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "LastName", scope = Administrator.class)
    public JAXBElement<String> createAdministratorLastName(String value) {
        return new JAXBElement<String>(_AdministratorLastName_QNAME, String.class, Administrator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = UpdateOperator.class)
    public JAXBElement<String> createUpdateOperatorSecurityToken(String value) {
        return new JAXBElement<String>(_CreateNewOperatorSecurityToken_QNAME, String.class, UpdateOperator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Operator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "updatedOperator", scope = UpdateOperator.class)
    public JAXBElement<Operator> createUpdateOperatorUpdatedOperator(Operator value) {
        return new JAXBElement<Operator>(_UpdateOperatorUpdatedOperator_QNAME, Operator.class, UpdateOperator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOperator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllOperatorsResult", scope = GetAllOperatorsResponse.class)
    public JAXBElement<ArrayOfOperator> createGetAllOperatorsResponseGetAllOperatorsResult(ArrayOfOperator value) {
        return new JAXBElement<ArrayOfOperator>(_GetAllOperatorsResponseGetAllOperatorsResult_QNAME, ArrayOfOperator.class, GetAllOperatorsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "MiddleName", scope = Operator.class)
    public JAXBElement<String> createOperatorMiddleName(String value) {
        return new JAXBElement<String>(_AdministratorMiddleName_QNAME, String.class, Operator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Login", scope = Operator.class)
    public JAXBElement<String> createOperatorLogin(String value) {
        return new JAXBElement<String>(_AdministratorLogin_QNAME, String.class, Operator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Password", scope = Operator.class)
    public JAXBElement<String> createOperatorPassword(String value) {
        return new JAXBElement<String>(_AdministratorPassword_QNAME, String.class, Operator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "FirstName", scope = Operator.class)
    public JAXBElement<String> createOperatorFirstName(String value) {
        return new JAXBElement<String>(_AdministratorFirstName_QNAME, String.class, Operator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "LastName", scope = Operator.class)
    public JAXBElement<String> createOperatorLastName(String value) {
        return new JAXBElement<String>(_AdministratorLastName_QNAME, String.class, Operator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = RemoveAdministrator.class)
    public JAXBElement<String> createRemoveAdministratorSecurityToken(String value) {
        return new JAXBElement<String>(_CreateNewOperatorSecurityToken_QNAME, String.class, RemoveAdministrator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = CreateNewAdministrator.class)
    public JAXBElement<String> createCreateNewAdministratorSecurityToken(String value) {
        return new JAXBElement<String>(_CreateNewOperatorSecurityToken_QNAME, String.class, CreateNewAdministrator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Administrator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "newAdministrator", scope = CreateNewAdministrator.class)
    public JAXBElement<Administrator> createCreateNewAdministratorNewAdministrator(Administrator value) {
        return new JAXBElement<Administrator>(_CreateNewAdministratorNewAdministrator_QNAME, Administrator.class, CreateNewAdministrator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAdministratorsCount.class)
    public JAXBElement<String> createGetAdministratorsCountSecurityToken(String value) {
        return new JAXBElement<String>(_CreateNewOperatorSecurityToken_QNAME, String.class, GetAdministratorsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetOperatorById.class)
    public JAXBElement<String> createGetOperatorByIdSecurityToken(String value) {
        return new JAXBElement<String>(_CreateNewOperatorSecurityToken_QNAME, String.class, GetOperatorById.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Administrator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAdministratorByIdResult", scope = GetAdministratorByIdResponse.class)
    public JAXBElement<Administrator> createGetAdministratorByIdResponseGetAdministratorByIdResult(Administrator value) {
        return new JAXBElement<Administrator>(_GetAdministratorByIdResponseGetAdministratorByIdResult_QNAME, Administrator.class, GetAdministratorByIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Operator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOperatorByIdResult", scope = GetOperatorByIdResponse.class)
    public JAXBElement<Operator> createGetOperatorByIdResponseGetOperatorByIdResult(Operator value) {
        return new JAXBElement<Operator>(_GetOperatorByIdResponseGetOperatorByIdResult_QNAME, Operator.class, GetOperatorByIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetAllOperators.class)
    public JAXBElement<String> createGetAllOperatorsSecurityToken(String value) {
        return new JAXBElement<String>(_CreateNewOperatorSecurityToken_QNAME, String.class, GetAllOperators.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = UpdateAdministrator.class)
    public JAXBElement<String> createUpdateAdministratorSecurityToken(String value) {
        return new JAXBElement<String>(_CreateNewOperatorSecurityToken_QNAME, String.class, UpdateAdministrator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Administrator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "updatedAdministrator", scope = UpdateAdministrator.class)
    public JAXBElement<Administrator> createUpdateAdministratorUpdatedAdministrator(Administrator value) {
        return new JAXBElement<Administrator>(_UpdateAdministratorUpdatedAdministrator_QNAME, Administrator.class, UpdateAdministrator.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAdministrator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllAdministratorsResult", scope = GetAllAdministratorsResponse.class)
    public JAXBElement<ArrayOfAdministrator> createGetAllAdministratorsResponseGetAllAdministratorsResult(ArrayOfAdministrator value) {
        return new JAXBElement<ArrayOfAdministrator>(_GetAllAdministratorsResponseGetAllAdministratorsResult_QNAME, ArrayOfAdministrator.class, GetAllAdministratorsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetOperatorsCount.class)
    public JAXBElement<String> createGetOperatorsCountSecurityToken(String value) {
        return new JAXBElement<String>(_CreateNewOperatorSecurityToken_QNAME, String.class, GetOperatorsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = RemoveOperator.class)
    public JAXBElement<String> createRemoveOperatorSecurityToken(String value) {
        return new JAXBElement<String>(_CreateNewOperatorSecurityToken_QNAME, String.class, RemoveOperator.class, value);
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
