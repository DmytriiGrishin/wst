
package ru.ifmo.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.ifmo.service package.
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

    private final static QName _GetAllSculpturesResponse_QNAME = new QName("http://service.ifmo.ru/", "getAllSculpturesResponse");
    private final static QName _FindSculpturesResponse_QNAME = new QName("http://service.ifmo.ru/", "findSculpturesResponse");
    private final static QName _GetAllSculptures_QNAME = new QName("http://service.ifmo.ru/", "getAllSculptures");
    private final static QName _FindSculptures_QNAME = new QName("http://service.ifmo.ru/", "findSculptures");
    private final static QName _MyRequest_QNAME = new QName("http://service.ifmo.ru", "MyRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.ifmo.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindSculptures }
     * 
     */
    public FindSculptures createFindSculptures() {
        return new FindSculptures();
    }

    /**
     * Create an instance of {@link GetAllSculpturesResponse }
     * 
     */
    public GetAllSculpturesResponse createGetAllSculpturesResponse() {
        return new GetAllSculpturesResponse();
    }

    /**
     * Create an instance of {@link GetAllSculptures }
     * 
     */
    public GetAllSculptures createGetAllSculptures() {
        return new GetAllSculptures();
    }

    /**
     * Create an instance of {@link FindSculpturesResponse }
     * 
     */
    public FindSculpturesResponse createFindSculpturesResponse() {
        return new FindSculpturesResponse();
    }

    /**
     * Create an instance of {@link MyRequest }
     * 
     */
    public MyRequest createMyRequest() {
        return new MyRequest();
    }

    /**
     * Create an instance of {@link Sculpture }
     * 
     */
    public Sculpture createSculpture() {
        return new Sculpture();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSculpturesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "getAllSculpturesResponse")
    public JAXBElement<GetAllSculpturesResponse> createGetAllSculpturesResponse(GetAllSculpturesResponse value) {
        return new JAXBElement<GetAllSculpturesResponse>(_GetAllSculpturesResponse_QNAME, GetAllSculpturesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSculpturesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "findSculpturesResponse")
    public JAXBElement<FindSculpturesResponse> createFindSculpturesResponse(FindSculpturesResponse value) {
        return new JAXBElement<FindSculpturesResponse>(_FindSculpturesResponse_QNAME, FindSculpturesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSculptures }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "getAllSculptures")
    public JAXBElement<GetAllSculptures> createGetAllSculptures(GetAllSculptures value) {
        return new JAXBElement<GetAllSculptures>(_GetAllSculptures_QNAME, GetAllSculptures.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSculptures }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "findSculptures")
    public JAXBElement<FindSculptures> createFindSculptures(FindSculptures value) {
        return new JAXBElement<FindSculptures>(_FindSculptures_QNAME, FindSculptures.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MyRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru", name = "MyRequest")
    public JAXBElement<MyRequest> createMyRequest(MyRequest value) {
        return new JAXBElement<MyRequest>(_MyRequest_QNAME, MyRequest.class, null, value);
    }

}
