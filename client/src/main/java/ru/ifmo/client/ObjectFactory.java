
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
    private final static QName _IllegalQException_QNAME = new QName("http://service.ifmo.ru/", "IllegalQException");
    private final static QName _InvalidCreatingParametersException_QNAME = new QName("http://service.ifmo.ru/", "InvalidCreatingParametersException");
    private final static QName _CreateSculptureResponse_QNAME = new QName("http://service.ifmo.ru/", "createSculptureResponse");
    private final static QName _DeleteSculptureResponse_QNAME = new QName("http://service.ifmo.ru/", "deleteSculptureResponse");
    private final static QName _UpdateSculptureResponse_QNAME = new QName("http://service.ifmo.ru/", "updateSculptureResponse");
    private final static QName _FindSculptures_QNAME = new QName("http://service.ifmo.ru/", "findSculptures");
    private final static QName _CreateSculpture_QNAME = new QName("http://service.ifmo.ru/", "createSculpture");
    private final static QName _UpdateSculpture_QNAME = new QName("http://service.ifmo.ru/", "updateSculpture");
    private final static QName _InvalidEntityException_QNAME = new QName("http://service.ifmo.ru/", "InvalidEntityException");
    private final static QName _GetAllSculptures_QNAME = new QName("http://service.ifmo.ru/", "getAllSculptures");
    private final static QName _AuthException_QNAME = new QName("http://service.ifmo.ru/", "AuthException");
    private final static QName _DeleteSculpture_QNAME = new QName("http://service.ifmo.ru/", "deleteSculpture");
    private final static QName _IllegalIdException_QNAME = new QName("http://service.ifmo.ru/", "IllegalIdException");
    private final static QName _InsertingException_QNAME = new QName("http://service.ifmo.ru/", "InsertingException");
    private final static QName _MyRequest_QNAME = new QName("http://service.ifmo.ru", "MyRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.ifmo.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ru.ifmo.client.SculptureServiceFault }
     * 
     */
    public ru.ifmo.client.SculptureServiceFault createSculptureServiceFault() {
        return new ru.ifmo.client.SculptureServiceFault();
    }

    /**
     * Create an instance of {@link DeleteSculpture }
     * 
     */
    public DeleteSculpture createDeleteSculpture() {
        return new DeleteSculpture();
    }

    /**
     * Create an instance of {@link ru.ifmo.client.GetAllSculptures }
     * 
     */
    public ru.ifmo.client.GetAllSculptures createGetAllSculptures() {
        return new ru.ifmo.client.GetAllSculptures();
    }

    /**
     * Create an instance of {@link ru.ifmo.client.UpdateSculpture }
     * 
     */
    public ru.ifmo.client.UpdateSculpture createUpdateSculpture() {
        return new ru.ifmo.client.UpdateSculpture();
    }

    /**
     * Create an instance of {@link ru.ifmo.client.CreateSculpture }
     * 
     */
    public ru.ifmo.client.CreateSculpture createCreateSculpture() {
        return new ru.ifmo.client.CreateSculpture();
    }

    /**
     * Create an instance of {@link ru.ifmo.client.CreateSculptureResponse }
     * 
     */
    public ru.ifmo.client.CreateSculptureResponse createCreateSculptureResponse() {
        return new ru.ifmo.client.CreateSculptureResponse();
    }

    /**
     * Create an instance of {@link DeleteSculptureResponse }
     * 
     */
    public DeleteSculptureResponse createDeleteSculptureResponse() {
        return new DeleteSculptureResponse();
    }

    /**
     * Create an instance of {@link ru.ifmo.client.UpdateSculptureResponse }
     * 
     */
    public ru.ifmo.client.UpdateSculptureResponse createUpdateSculptureResponse() {
        return new ru.ifmo.client.UpdateSculptureResponse();
    }

    /**
     * Create an instance of {@link ru.ifmo.client.FindSculptures }
     * 
     */
    public ru.ifmo.client.FindSculptures createFindSculptures() {
        return new ru.ifmo.client.FindSculptures();
    }

    /**
     * Create an instance of {@link ru.ifmo.client.GetAllSculpturesResponse }
     * 
     */
    public ru.ifmo.client.GetAllSculpturesResponse createGetAllSculpturesResponse() {
        return new ru.ifmo.client.GetAllSculpturesResponse();
    }

    /**
     * Create an instance of {@link ru.ifmo.client.FindSculpturesResponse }
     * 
     */
    public ru.ifmo.client.FindSculpturesResponse createFindSculpturesResponse() {
        return new ru.ifmo.client.FindSculpturesResponse();
    }

    /**
     * Create an instance of {@link ru.ifmo.client.Sculpture }
     * 
     */
    public ru.ifmo.client.Sculpture createSculpture() {
        return new ru.ifmo.client.Sculpture();
    }

    /**
     * Create an instance of {@link ru.ifmo.client.MyRequest }
     * 
     */
    public ru.ifmo.client.MyRequest createMyRequest() {
        return new ru.ifmo.client.MyRequest();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.FindSculpturesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "findSculpturesResponse")
    public JAXBElement<ru.ifmo.client.FindSculpturesResponse> createFindSculpturesResponse(ru.ifmo.client.FindSculpturesResponse value) {
        return new JAXBElement<ru.ifmo.client.FindSculpturesResponse>(_FindSculpturesResponse_QNAME, ru.ifmo.client.FindSculpturesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.SculptureServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "IllegalQException")
    public JAXBElement<ru.ifmo.client.SculptureServiceFault> createIllegalQException(ru.ifmo.client.SculptureServiceFault value) {
        return new JAXBElement<ru.ifmo.client.SculptureServiceFault>(_IllegalQException_QNAME, ru.ifmo.client.SculptureServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.SculptureServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "InvalidCreatingParametersException")
    public JAXBElement<ru.ifmo.client.SculptureServiceFault> createInvalidCreatingParametersException(ru.ifmo.client.SculptureServiceFault value) {
        return new JAXBElement<ru.ifmo.client.SculptureServiceFault>(_InvalidCreatingParametersException_QNAME, ru.ifmo.client.SculptureServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.CreateSculptureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "createSculptureResponse")
    public JAXBElement<ru.ifmo.client.CreateSculptureResponse> createCreateSculptureResponse(ru.ifmo.client.CreateSculptureResponse value) {
        return new JAXBElement<ru.ifmo.client.CreateSculptureResponse>(_CreateSculptureResponse_QNAME, ru.ifmo.client.CreateSculptureResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.UpdateSculptureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "updateSculptureResponse")
    public JAXBElement<ru.ifmo.client.UpdateSculptureResponse> createUpdateSculptureResponse(ru.ifmo.client.UpdateSculptureResponse value) {
        return new JAXBElement<ru.ifmo.client.UpdateSculptureResponse>(_UpdateSculptureResponse_QNAME, ru.ifmo.client.UpdateSculptureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.FindSculptures }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "findSculptures")
    public JAXBElement<ru.ifmo.client.FindSculptures> createFindSculptures(ru.ifmo.client.FindSculptures value) {
        return new JAXBElement<ru.ifmo.client.FindSculptures>(_FindSculptures_QNAME, ru.ifmo.client.FindSculptures.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.CreateSculpture }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "createSculpture")
    public JAXBElement<ru.ifmo.client.CreateSculpture> createCreateSculpture(ru.ifmo.client.CreateSculpture value) {
        return new JAXBElement<ru.ifmo.client.CreateSculpture>(_CreateSculpture_QNAME, ru.ifmo.client.CreateSculpture.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.UpdateSculpture }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "updateSculpture")
    public JAXBElement<ru.ifmo.client.UpdateSculpture> createUpdateSculpture(ru.ifmo.client.UpdateSculpture value) {
        return new JAXBElement<ru.ifmo.client.UpdateSculpture>(_UpdateSculpture_QNAME, ru.ifmo.client.UpdateSculpture.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.SculptureServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "InvalidEntityException")
    public JAXBElement<ru.ifmo.client.SculptureServiceFault> createInvalidEntityException(ru.ifmo.client.SculptureServiceFault value) {
        return new JAXBElement<ru.ifmo.client.SculptureServiceFault>(_InvalidEntityException_QNAME, ru.ifmo.client.SculptureServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.GetAllSculptures }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "getAllSculptures")
    public JAXBElement<ru.ifmo.client.GetAllSculptures> createGetAllSculptures(ru.ifmo.client.GetAllSculptures value) {
        return new JAXBElement<ru.ifmo.client.GetAllSculptures>(_GetAllSculptures_QNAME, ru.ifmo.client.GetAllSculptures.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.SculptureServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "AuthException")
    public JAXBElement<ru.ifmo.client.SculptureServiceFault> createAuthException(ru.ifmo.client.SculptureServiceFault value) {
        return new JAXBElement<ru.ifmo.client.SculptureServiceFault>(_AuthException_QNAME, ru.ifmo.client.SculptureServiceFault.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.SculptureServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "IllegalIdException")
    public JAXBElement<ru.ifmo.client.SculptureServiceFault> createIllegalIdException(ru.ifmo.client.SculptureServiceFault value) {
        return new JAXBElement<ru.ifmo.client.SculptureServiceFault>(_IllegalIdException_QNAME, ru.ifmo.client.SculptureServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.SculptureServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru/", name = "InsertingException")
    public JAXBElement<ru.ifmo.client.SculptureServiceFault> createInsertingException(ru.ifmo.client.SculptureServiceFault value) {
        return new JAXBElement<ru.ifmo.client.SculptureServiceFault>(_InsertingException_QNAME, ru.ifmo.client.SculptureServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ru.ifmo.client.MyRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ifmo.ru", name = "MyRequest")
    public JAXBElement<ru.ifmo.client.MyRequest> createMyRequest(ru.ifmo.client.MyRequest value) {
        return new JAXBElement<ru.ifmo.client.MyRequest>(_MyRequest_QNAME, ru.ifmo.client.MyRequest.class, null, value);
    }

}
