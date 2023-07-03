package com.durao.demogenerics.services;

import com.durao.demogenerics.dto.EmployeeDTO;
import com.durao.demogenerics.entities.Employee;
import com.durao.demogenerics.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements GenericService<Employee, EmployeeDTO, Long> {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public JpaRepository<Employee, Long> getRepository() {
        return repository;
    }
}
