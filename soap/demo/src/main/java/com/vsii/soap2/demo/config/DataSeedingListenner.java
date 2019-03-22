package com.vsii.soap2.demo.config;

import com.vsii.soap2.demo.model.Employees;
import com.vsii.soap2.demo.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class DataSeedingListenner implements ApplicationListener<ContextRefreshedEvent> {
    private static final Map<Integer, Employees> EMPLOYEES_MAP = new HashMap<>();
    @Autowired
    private EmployeesRepository employeesRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(employeesRepository.findByNameContaining("hien")==null)
        {
            Employees employees=new Employees();
            employees.setId(1);
            employees.setName("Quoc hien");
            employees.setRoom("ICC");
            employeesRepository.save(employees);
            EMPLOYEES_MAP.put(employees.getId(),employees);
        }
    }
}
