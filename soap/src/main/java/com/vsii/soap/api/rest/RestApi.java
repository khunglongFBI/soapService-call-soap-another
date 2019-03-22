package com.vsii.soap.api.rest;

import com.vsii.soap.config.SOAPConnector;
import com.vsii.soap.model.GetEmployeesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class RestApi {
    public  static final Logger logger = LoggerFactory.getLogger(RestApi.class);
    @Autowired
    private SOAPConnector soapConnector;
    @GetMapping("/{id}")
    public GetEmployeesResponse getById(@PathVariable("id") int id) {
        logger.info("REST invoked");
        return soapConnector.getById(id);
    }
}

