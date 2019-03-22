package com.vsii.soap2.demo.service;

import com.vsii.soap2.demo.model.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeesService {
    Page<Employees> findAll(Pageable pageable);
    void save(Employees employees);
    void remove(int id);
    Employees findByUserName(String username);

    Employees findById(int id);

    Page<Employees> findAllByStudentName(String nickname, Pageable pageable);
}
