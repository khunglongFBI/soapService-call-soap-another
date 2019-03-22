package com.vsii.soap2.demo.endpoint;

import com.vsii.soap2.demo.model.Employees;
import com.vsii.soap2.demo.service.EmployeesService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api")
public class EmployeesRestApi {
    public  static final Logger logger = LoggerFactory.getLogger(EmployeesRestApi.class);
    @Autowired
    EmployeesService employeesService;
    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") int id) {
        logger.info("Fetching User with id {}", id);
        Employees employees = employeesService.findById(id);
        if (employees == null) {
            logger.error("User with id {} not found.", id);
            return  new ResponseEntity(new CustomErrorType("User with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employees>(employees, HttpStatus.OK);
    }
}
