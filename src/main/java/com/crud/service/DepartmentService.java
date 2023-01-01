package com.crud.service;

import com.crud.entity.Department;
import com.crud.error.DepartmentbyIdNotFoundExecption;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

     List<Department> getDepartment();

     Department getDepartmentById(Long departmentId) throws DepartmentbyIdNotFoundExecption;

     Department deleteDepartment();

    Department deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department getDepartmentByName(String name);

}
