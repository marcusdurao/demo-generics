package com.durao.demogenerics.controllers;

import com.durao.demogenerics.dto.EmployeeDTO;
import com.durao.demogenerics.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
        EmployeeDTO obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        List<EmployeeDTO> obj = service.findAll();
        return ResponseEntity.ok(obj);
    }
}
