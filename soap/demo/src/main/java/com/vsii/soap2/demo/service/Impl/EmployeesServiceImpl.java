package com.vsii.soap2.demo.service.Impl;

import com.vsii.soap2.demo.repository.EmployeesRepository;
import com.vsii.soap2.demo.service.EmployeesService;
import com.vsii.soap2.demo.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;

    @Override
    public Page<Employees> findAll(Pageable pageable) {
        return employeesRepository.findAll(pageable);
    }

    @Override
    public void save(Employees employees) {
    employeesRepository.save(employees);
    }

    @Override
    public void remove(int id) {
        employeesRepository.deleteById(id);
    }

    @Override
    public Employees findByUserName(String username) {
        return employeesRepository.findByNameContaining(username);
    }

    @Override
    public Employees findById(int id) {
        return employeesRepository.findById(id).orElse(null );
    }

    @Override
    public Page<Employees> findAllByStudentName(String nickname, Pageable pageable) {
        return null;
    }
}
