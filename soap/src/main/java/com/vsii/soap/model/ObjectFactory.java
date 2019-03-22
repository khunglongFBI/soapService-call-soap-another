
package com.vsii.soap.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the model package. 
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
    private final static QName _GetEmployeeRequest_QNAME = new QName("http://localhost:8081/soap", "GetEmployeeRequest");
    private final static QName _GetEmployeeResponse_QNAME = new QName("http://localhost:8081/soap", "GetEmployeeResponse");


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEmployeesResponse }
     * 
     */
    public GetEmployeesResponse createGetEmployeesResponse() {
        return new GetEmployeesResponse();
    }

    /**
     * Create an instance of {@link Employees }
     * 
     */
    public Employees createEmployees() {
        return new Employees();
    }

    /**
     * Create an instance of {@link GetEmployeesRequest }
     * 
     */
    public GetEmployeesRequest createGetEmployeesRequest() {
        return new GetEmployeesRequest();
    }
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeesRequest }{@code >}}
     s
     */
    @XmlElementDecl(namespace = "http://localhost:8081/soap", name = "GetEmployeeRequest")
    public JAXBElement<GetEmployeesRequest> createGetEmployeeRequestImpl(GetEmployeesRequest value) {
        return new JAXBElement<GetEmployeesRequest>(_GetEmployeeRequest_QNAME, GetEmployeesRequest.class, null, value);
    }
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeesResponse }{@code >}}
     s
     */
    @XmlElementDecl(namespace = "http://localhost:8081/soap", name = "GetEmployeeResponse")
    public JAXBElement<GetEmployeesResponse> createGetEmployeeResponseImpl(GetEmployeesResponse value) {
        return new JAXBElement<GetEmployeesResponse>(_GetEmployeeResponse_QNAME, GetEmployeesResponse.class, null, value);
    }
}
