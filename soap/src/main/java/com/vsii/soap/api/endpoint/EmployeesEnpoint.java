package com.vsii.soap.api.endpoint;

import com.vsii.soap.config.SOAPConnector;
import com.vsii.soap.model.GetEmployeesRequest;
import com.vsii.soap.model.GetEmployeesResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeesEnpoint {
    private static final String NAMESPACE_URI = "http://localhost:8081/soap";
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetEmployeesRequest")
    @ResponsePayload
    public GetEmployeesResponse listEmployees(@PathVariable("id") int id, @RequestPayload GetEmployeesRequest request, SOAPConnector soapConnector){
        return soapConnector.getById(id);
    }


}
