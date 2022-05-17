package com.axonactive.demo.service.impl;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class DepartmentServiceImplTest {
    @Autowired
    DepartmentService departmentService;

    @Test
    void testCreateDepartmentByBuilder(){
        Department dep = Department.builder()
                .id(41145621)
                .departmentName("Builder")
                .build();
        System.out.println(dep);
    }

    @Test
    void getAll_shouldReturnNoData_whenTableJustCreated() {
        assertEquals(0, departmentService.getAll().size());
    }
}