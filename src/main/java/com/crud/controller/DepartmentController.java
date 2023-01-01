package com.crud.controller;

import com.crud.entity.Department;
import com.crud.error.DepartmentbyIdNotFoundExecption;
import com.crud.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

// Post is here =================================================================s

    @PostMapping("/registerDepartment")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        System.out.println(departmentService.saveDepartment(department));
        LOGGER.info("Inside saveDepartment of Department Controller");
        return departmentService.saveDepartment(department);
    }

// Get is here====================================================

    @GetMapping("/departmentUsers")
    public List<Department> getDepartment() {
        LOGGER.info("Inside getDepartment of Department Controller");
        return departmentService.getDepartment();

    }

    @GetMapping("/departmentUsers/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentbyIdNotFoundExecption {
        return departmentService.getDepartmentById(departmentId);
    }

// Delete is here=======================================

    @DeleteMapping("/deleteDepartment")
    public Department deleteDepartment() {
        return departmentService.deleteDepartment();
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public Department deleteDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.deleteDepartmentById(departmentId);
    }

// Update is here ============================================================

    @PutMapping("/udpateDepartment/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId , @RequestBody Department department ) {
        return departmentService.updateDepartment(departmentId, department);
    }

// again on get data ======================================

    @GetMapping("/getDepartmentByName/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name) {
        return departmentService.getDepartmentByName(name);
    }



}
