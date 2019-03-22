package com.vsii.soap.config;

import com.vsii.soap.model.GetEmployeesRequest;
import com.vsii.soap.model.GetEmployeesResponse;
import com.vsii.soap.model.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SOAPConnector extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(SOAPConnector.class);


    private ObjectFactory factory;

    public SOAPConnector() {
        factory = new ObjectFactory();
    }

    public GetEmployeesResponse getById(int id) {
        log.info("SOAP invoked");
        GetEmployeesRequest request = factory.createGetEmployeesRequest();
        request.setId(id);

        GetEmployeesResponse response = (GetEmployeesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/ws", request,
                        new SoapActionCallback(
                                "http://localhost:8081/soap/GetEmployeesRequest"));

                return response;
       /* JAXBElement<GetEmployeesRequest> req = factory.createGetEmployeeRequestImpl(request);
        JAXBElement<?> res = (JAXBElement<?>) getWebServiceTemplate().marshalSendAndReceive(req);
        GetEmployeesResponse response = (GetEmployeesResponse) res.getValue();
        if (response == null)
            return null;
        return response.getEmployees();*/
    }
}