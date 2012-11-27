
package by.bsuir.banking.proxy.operator;

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
 * generated in the by.bsuir.banking.proxy.operator package. 
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
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _Client_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Client");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _ArrayOfClient_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "ArrayOfClient");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _Passport_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Passport");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _DomainFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "DomainFault");
    private final static QName _DomainFaultMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", "Message");
    private final static QName _GetPageofClientsSecurityToken_QNAME = new QName("http://tempuri.org/", "securityToken");
    private final static QName _GetClientByPassportDataSeria_QNAME = new QName("http://tempuri.org/", "seria");
    private final static QName _GetClientByPassportDataNumber_QNAME = new QName("http://tempuri.org/", "number");
    private final static QName _GetPageofClientsResponseGetPageofClientsResult_QNAME = new QName("http://tempuri.org/", "GetPageofClientsResult");
    private final static QName _GetClientsByNameResponseGetClientsByNameResult_QNAME = new QName("http://tempuri.org/", "GetClientsByNameResult");
    private final static QName _GetClientResponseGetClientResult_QNAME = new QName("http://tempuri.org/", "GetClientResult");
    private final static QName _UpdateClientClient_QNAME = new QName("http://tempuri.org/", "client");
    private final static QName _ClientMiddleName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "MiddleName");
    private final static QName _ClientLogin_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Login");
    private final static QName _ClientPassword_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Password");
    private final static QName _ClientAdress_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Adress");
    private final static QName _ClientPhoneNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "PhoneNumber");
    private final static QName _ClientFirstName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "FirstName");
    private final static QName _ClientLastName_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "LastName");
    private final static QName _GetClientsByNameLastName_QNAME = new QName("http://tempuri.org/", "lastName");
    private final static QName _GetClientsByNameMiddleName_QNAME = new QName("http://tempuri.org/", "middleName");
    private final static QName _GetClientsByNameFirstName_QNAME = new QName("http://tempuri.org/", "firstName");
    private final static QName _GetClientByPassportDataResponseGetClientByPassportDataResult_QNAME = new QName("http://tempuri.org/", "GetClientByPassportDataResult");
    private final static QName _PassportNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Number");
    private final static QName _PassportAuthority_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Authority");
    private final static QName _PassportSeria_QNAME = new QName("http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", "Seria");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.bsuir.banking.proxy.operator
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateClientResponse }
     * 
     */
    public CreateClientResponse createCreateClientResponse() {
        return new CreateClientResponse();
    }

    /**
     * Create an instance of {@link DomainFault }
     * 
     */
    public DomainFault createDomainFault() {
        return new DomainFault();
    }

    /**
     * Create an instance of {@link AuthorizationFault }
     * 
     */
    public AuthorizationFault createAuthorizationFault() {
        return new AuthorizationFault();
    }

    /**
     * Create an instance of {@link UpdateClientResponse }
     * 
     */
    public UpdateClientResponse createUpdateClientResponse() {
        return new UpdateClientResponse();
    }

    /**
     * Create an instance of {@link DeleteClient }
     * 
     */
    public DeleteClient createDeleteClient() {
        return new DeleteClient();
    }

    /**
     * Create an instance of {@link GetPageofClients }
     * 
     */
    public GetPageofClients createGetPageofClients() {
        return new GetPageofClients();
    }

    /**
     * Create an instance of {@link GetClientsCount }
     * 
     */
    public GetClientsCount createGetClientsCount() {
        return new GetClientsCount();
    }

    /**
     * Create an instance of {@link GetClientByPassportData }
     * 
     */
    public GetClientByPassportData createGetClientByPassportData() {
        return new GetClientByPassportData();
    }

    /**
     * Create an instance of {@link GetPageofClientsResponse }
     * 
     */
    public GetPageofClientsResponse createGetPageofClientsResponse() {
        return new GetPageofClientsResponse();
    }

    /**
     * Create an instance of {@link GetClientsByNameResponse }
     * 
     */
    public GetClientsByNameResponse createGetClientsByNameResponse() {
        return new GetClientsByNameResponse();
    }

    /**
     * Create an instance of {@link GetClientResponse }
     * 
     */
    public GetClientResponse createGetClientResponse() {
        return new GetClientResponse();
    }

    /**
     * Create an instance of {@link CreateClient }
     * 
     */
    public CreateClient createCreateClient() {
        return new CreateClient();
    }

    /**
     * Create an instance of {@link UpdateClient }
     * 
     */
    public UpdateClient createUpdateClient() {
        return new UpdateClient();
    }

    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }

    /**
     * Create an instance of {@link GetClient }
     * 
     */
    public GetClient createGetClient() {
        return new GetClient();
    }

    /**
     * Create an instance of {@link DeleteClientResponse }
     * 
     */
    public DeleteClientResponse createDeleteClientResponse() {
        return new DeleteClientResponse();
    }

    /**
     * Create an instance of {@link GetClientsByName }
     * 
     */
    public GetClientsByName createGetClientsByName() {
        return new GetClientsByName();
    }

    /**
     * Create an instance of {@link GetClientByPassportDataResponse }
     * 
     */
    public GetClientByPassportDataResponse createGetClientByPassportDataResponse() {
        return new GetClientByPassportDataResponse();
    }

    /**
     * Create an instance of {@link ArrayOfClient }
     * 
     */
    public ArrayOfClient createArrayOfClient() {
        return new ArrayOfClient();
    }

    /**
     * Create an instance of {@link Passport }
     * 
     */
    public Passport createPassport() {
        return new Passport();
    }

    /**
     * Create an instance of {@link GetClientsCountResponse }
     * 
     */
    public GetClientsCountResponse createGetClientsCountResponse() {
        return new GetClientsCountResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "ArrayOfClient")
    public JAXBElement<ArrayOfClient> createArrayOfClient(ArrayOfClient value) {
        return new JAXBElement<ArrayOfClient>(_ArrayOfClient_QNAME, ArrayOfClient.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Passport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.DAL.Model", name = "Passport")
    public JAXBElement<Passport> createPassport(Passport value) {
        return new JAXBElement<Passport>(_Passport_QNAME, Passport.class, null, value);
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
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/InternetBanking.Services.Interfaces.FaultContracts", name = "Message", scope = DomainFault.class)
    public JAXBElement<String> createDomainFaultMessage(String value) {
        return new JAXBElement<String>(_DomainFaultMessage_QNAME, String.class, DomainFault.class, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetPageofClients.class)
    public JAXBElement<String> createGetPageofClientsSecurityToken(String value) {
        return new JAXBElement<String>(_GetPageofClientsSecurityToken_QNAME, String.class, GetPageofClients.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = DeleteClient.class)
    public JAXBElement<String> createDeleteClientSecurityToken(String value) {
        return new JAXBElement<String>(_GetPageofClientsSecurityToken_QNAME, String.class, DeleteClient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetClientsCount.class)
    public JAXBElement<String> createGetClientsCountSecurityToken(String value) {
        return new JAXBElement<String>(_GetPageofClientsSecurityToken_QNAME, String.class, GetClientsCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetClientByPassportData.class)
    public JAXBElement<String> createGetClientByPassportDataSecurityToken(String value) {
        return new JAXBElement<String>(_GetPageofClientsSecurityToken_QNAME, String.class, GetClientByPassportData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "seria", scope = GetClientByPassportData.class)
    public JAXBElement<String> createGetClientByPassportDataSeria(String value) {
        return new JAXBElement<String>(_GetClientByPassportDataSeria_QNAME, String.class, GetClientByPassportData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "number", scope = GetClientByPassportData.class)
    public JAXBElement<String> createGetClientByPassportDataNumber(String value) {
        return new JAXBElement<String>(_GetClientByPassportDataNumber_QNAME, String.class, GetClientByPassportData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPageofClientsResult", scope = GetPageofClientsResponse.class)
    public JAXBElement<ArrayOfClient> createGetPageofClientsResponseGetPageofClientsResult(ArrayOfClient value) {
        return new JAXBElement<ArrayOfClient>(_GetPageofClientsResponseGetPageofClientsResult_QNAME, ArrayOfClient.class, GetPageofClientsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetClientsByNameResult", scope = GetClientsByNameResponse.class)
    public JAXBElement<ArrayOfClient> createGetClientsByNameResponseGetClientsByNameResult(ArrayOfClient value) {
        return new JAXBElement<ArrayOfClient>(_GetClientsByNameResponseGetClientsByNameResult_QNAME, ArrayOfClient.class, GetClientsByNameResponse.class, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = UpdateClient.class)
    public JAXBElement<String> createUpdateClientSecurityToken(String value) {
        return new JAXBElement<String>(_GetPageofClientsSecurityToken_QNAME, String.class, UpdateClient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Client }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "client", scope = UpdateClient.class)
    public JAXBElement<Client> createUpdateClientClient(Client value) {
        return new JAXBElement<Client>(_UpdateClientClient_QNAME, Client.class, UpdateClient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = CreateClient.class)
    public JAXBElement<String> createCreateClientSecurityToken(String value) {
        return new JAXBElement<String>(_GetPageofClientsSecurityToken_QNAME, String.class, CreateClient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Client }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "client", scope = CreateClient.class)
    public JAXBElement<Client> createCreateClientClient(Client value) {
        return new JAXBElement<Client>(_UpdateClientClient_QNAME, Client.class, CreateClient.class, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetClient.class)
    public JAXBElement<String> createGetClientSecurityToken(String value) {
        return new JAXBElement<String>(_GetPageofClientsSecurityToken_QNAME, String.class, GetClient.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "securityToken", scope = GetClientsByName.class)
    public JAXBElement<String> createGetClientsByNameSecurityToken(String value) {
        return new JAXBElement<String>(_GetPageofClientsSecurityToken_QNAME, String.class, GetClientsByName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "lastName", scope = GetClientsByName.class)
    public JAXBElement<String> createGetClientsByNameLastName(String value) {
        return new JAXBElement<String>(_GetClientsByNameLastName_QNAME, String.class, GetClientsByName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "middleName", scope = GetClientsByName.class)
    public JAXBElement<String> createGetClientsByNameMiddleName(String value) {
        return new JAXBElement<String>(_GetClientsByNameMiddleName_QNAME, String.class, GetClientsByName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "firstName", scope = GetClientsByName.class)
    public JAXBElement<String> createGetClientsByNameFirstName(String value) {
        return new JAXBElement<String>(_GetClientsByNameFirstName_QNAME, String.class, GetClientsByName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Client }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetClientByPassportDataResult", scope = GetClientByPassportDataResponse.class)
    public JAXBElement<Client> createGetClientByPassportDataResponseGetClientByPassportDataResult(Client value) {
        return new JAXBElement<Client>(_GetClientByPassportDataResponseGetClientByPassportDataResult_QNAME, Client.class, GetClientByPassportDataResponse.class, value);
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

}
