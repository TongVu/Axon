package com.axonactive.demo.service.impl;

import com.axonactive.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceImplTest {
    @Autowired
    EmployeeService employeeService;

    @Test
    void getAll_shouldReturnNoData_whenTableJustCreated() {
        assertEquals(0, employeeService.getAll().size());
    }
}