package com.crud.service;

import com.crud.entity.Department;
import com.crud.repo.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    // we only want to test service we do not want know about repository, so we are mocking it.
    private DepartmentRepository departmentRepository;

    @BeforeEach
    // @BeforeEach when used the method will always trigger  before tests
    void setUp()  {
        // we use builder when we have multiple properties available,and we want to use different sets to create objects.
		Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Bangalore")
                .departmentCodeNo("007")
                .departmentId(1L)
                .build();
		Mockito.when(departmentRepository.findBydepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    // @DisplayName will change the method name when running.
    @DisplayName("Get data for valid Department Name")
    // can use @Disabled to disable a particular test case.
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(departmentName);
        // asserting data
        assertEquals(departmentName, found.getDepartmentName());

    }
}