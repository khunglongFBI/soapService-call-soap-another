package com.vsii.soap2.demo.repository;
import com.vsii.soap2.demo.model.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeesRepository extends PagingAndSortingRepository<Employees, Integer> {
    Page<Employees> findAll(Pageable pageable);
    Employees findByNameContaining(String name);
    void deleteById(int id);
}