package com.crud.repo;

import com.crud.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager EntityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Electrical")
                        .departmentAddress("Haryana")
                        .departmentCodeNo("m1")
                        .build();

        EntityManager.persist(department);

    }
    @Test
    @DisplayName("finding by name")
    public void whenFindById_then_Retrun_Department(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Electrical");
    }
}