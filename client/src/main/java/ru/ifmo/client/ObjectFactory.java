
package ru.ifmo.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.ifmo.client package.
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
    private final static QName _CreateSculptureResponse_QNAME = new QName("http://service.ifmo.ru/", "createSculptureResponse");
    private final static QName _DeleteSculpture_QNAME = new QName("http://service.ifmo.ru/", "deleteSculpture");
    private final static QName _DeleteSculptureResponse_QNAME = new QName("http://service.ifmo.ru/", "deleteSculptureResponse");
    private final static QName _UpdateSculptureResponse_QNAME = new QName("http://service.ifmo.ru/", "updateSculptureResponse");
    private final static QName _FindSculptures_QNAME = new QName("http://service.ifmo.ru/", "findSculptures");
    private final static QName _CreateSculpture_QNAME = new QName("http://service.ifmo.ru/", "createSculpture");
    private final static QName _MyRequest_QNAME = new QName("http://service.ifmo.ru", "MyRequest");
    private final static QName _UpdateSculpture_QNAME = new QName("http://service.ifmo.ru/", "updateSculpture");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.ifmo.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateSculpture }
     * 
     */
    public UpdateSculpture createUpdateSculpture() {
        return new UpdateSculpture();
    }

    /**
     * Create an instance of {@link CreateSculpture }
     * 
     */
    public CreateSculpture createCreateSculpture() {
        return new CreateSculpture();
    }

    /**
     * Create an instance of {@link CreateSculptureResponse }
     * 
     */
    public CreateSculptureResponse createCreateSculptureResponse() {
        return new CreateSculptureResponse();
    }

    /**
     * Create an instance of {@link DeleteSculpture }
     * 
     */
    public DeleteSculpture createDeleteSculpture() {
        return new DeleteSculpture();
    }

    /**
     * Create an instance of {@link DeleteSculptureResponse }
     * 
     */
    public DeleteSculptureResponse createDeleteSculptureResponse() {
        return new DeleteSculptureResponse();
    }

    /**
     * Create an instance of {@link UpdateSculptureResponse }
     * 
     */
    public UpdateSculptureResponse createUpdateSculptureResponse() {
        return new UpdateSculptureResponse();
    }

    /**
     * Create an instance of {@link FindSculptures }
     * 
     */
    public FindSculptures createFindSculptures() {
        return new FindSculptures();
    }

    /**
     * Create an instance of {@link ru.ifmo.client.GetAllSculpturesResponse }
     * 
     */
    public ru.ifmo.client.GetAllSculpturesResponse createGetAllSculpturesResponse() {
        return new ru.ifmo.client.GetAllSculpturesResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.GetAllSculpturesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "getAllSculpturesResponse")
    public JAXBElement<ru.ifmo.client.GetAllSculpturesResponse> createGetAllSculpturesResponse(ru.ifmo.client.GetAllSculpturesResponse value) {
        return new JAXBElement<ru.ifmo.client.GetAllSculpturesResponse>(_GetAllSculpturesResponse_QNAME, ru.ifmo.client.GetAllSculpturesResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSculptureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "createSculptureResponse")
    public JAXBElement<CreateSculptureResponse> createCreateSculptureResponse(CreateSculptureResponse value) {
        return new JAXBElement<CreateSculptureResponse>(_CreateSculptureResponse_QNAME, CreateSculptureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSculpture }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "deleteSculpture")
    public JAXBElement<DeleteSculpture> createDeleteSculpture(DeleteSculpture value) {
        return new JAXBElement<DeleteSculpture>(_DeleteSculpture_QNAME, DeleteSculpture.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSculptureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "deleteSculptureResponse")
    public JAXBElement<DeleteSculptureResponse> createDeleteSculptureResponse(DeleteSculptureResponse value) {
        return new JAXBElement<DeleteSculptureResponse>(_DeleteSculptureResponse_QNAME, DeleteSculptureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSculptureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "updateSculptureResponse")
    public JAXBElement<UpdateSculptureResponse> createUpdateSculptureResponse(UpdateSculptureResponse value) {
        return new JAXBElement<UpdateSculptureResponse>(_UpdateSculptureResponse_QNAME, UpdateSculptureResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSculpture }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "createSculpture")
    public JAXBElement<CreateSculpture> createCreateSculpture(CreateSculpture value) {
        return new JAXBElement<CreateSculpture>(_CreateSculpture_QNAME, CreateSculpture.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MyRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru", name = "MyRequest")
    public JAXBElement<MyRequest> createMyRequest(MyRequest value) {
        return new JAXBElement<MyRequest>(_MyRequest_QNAME, MyRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSculpture }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "updateSculpture")
    public JAXBElement<UpdateSculpture> createUpdateSculpture(UpdateSculpture value) {
        return new JAXBElement<UpdateSculpture>(_UpdateSculpture_QNAME, UpdateSculpture.class, null, value);
    }

}
