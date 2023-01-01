package com.crud.service;

import com.crud.entity.Department;
import com.crud.error.DepartmentbyIdNotFoundExecption;
import com.crud.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class DepartmentServiceIpml implements DepartmentService {

    @Value("${idNotFound.message}")
    private String IdNotFoundExecption_Message;



    @Autowired
    private DepartmentRepository departmentRepository;

// post is here ===========================================================

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

// get is here ======================================================

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentbyIdNotFoundExecption {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()) {
            throw new DepartmentbyIdNotFoundExecption(IdNotFoundExecption_Message);
        }
        return department.get();
    }

// delete is here==================================================

    @Override
    public Department deleteDepartment() {
        departmentRepository.deleteAll();
        return null;
    }

    @Override
    public Department deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);;
        return null;
    }

// update is here ====================================================

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depb = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) &&  !"".equalsIgnoreCase(department.getDepartmentName()) ) {
            depb.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&  !"".equalsIgnoreCase(department.getDepartmentAddress()) ) {
            depb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCodeNo()) &&  !"".equalsIgnoreCase(department.getDepartmentCodeNo()) ) {
            depb.setDepartmentCodeNo(department.getDepartmentCodeNo());
        }

        return departmentRepository.save(depb);
    }

// again get=======================================================

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findBydepartmentNameIgnoreCase(name);
    }



}
