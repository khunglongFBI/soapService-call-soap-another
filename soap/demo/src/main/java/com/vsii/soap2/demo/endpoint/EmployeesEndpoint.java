package com.vsii.soap2.demo.endpoint;

import com.vsii.soap2.demo.model.GetEmployeesRequest;
import com.vsii.soap2.demo.model.GetEmployeesResponse;
import com.vsii.soap2.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.ws.Action;

@Endpoint
public class EmployeesEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8081/soap";
    @Autowired
    private EmployeesService employeesService;
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetEmployeesRequest")
    @ResponsePayload
    //@Action(input = "http://localhost:8081/soap/GetEmployeesRequest")
    public GetEmployeesResponse listEmployees(@RequestPayload GetEmployeesRequest request){
        GetEmployeesResponse response=new GetEmployeesResponse();
        response.setEmployees(employeesService.findById(request.getId()));
        return response;
    }
}
