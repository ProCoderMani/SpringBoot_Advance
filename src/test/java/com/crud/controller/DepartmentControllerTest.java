package com.crud.controller;

import com.crud.entity.Department;
import com.crud.error.DepartmentbyIdNotFoundExecption;
import com.crud.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;


    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("R and D")
                .departmentAddress("Delhi")
                .departmentCodeNo("mani-007")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {

      Department  inputDepartment = Department.builder()
                .departmentName("R and D")
                .departmentAddress("Delhi")
                .departmentCodeNo("mani-007")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
//  mockMvc.perform(MockMvcRequestBuilders.post("/registerDepartment")
        mockMvc.perform(post("/registerDepartment")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"R and D\",\n" +
                        "    \"departmentAddress\":\"Delhi\",\n" +
                        "    \"departmentCodeNo\":\"mani-007\"\n" +
                        "}")).andExpect(status().isOk());
        //"}")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getDepartmentById() throws DepartmentbyIdNotFoundExecption, Exception {

        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(get("/departmentUsers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}