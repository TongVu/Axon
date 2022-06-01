package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.service.AircraftService;
import com.axonactive.homeSpringBoot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class EmployeeServiceImplTest {
    @Autowired
    EmployeeService employeeService;

    private Employee employee;

    @Test
    void getAllEmployee_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, employeeService.findAll().size());
    }

    @Nested
    class AfterSave{
        @Autowired
        EmployeeService employeeService;

        private Employee employee;

        @BeforeEach
        void setup () {
            employee = Employee.builder()
                    .id("011564812")
                    .name("Ton Van Quy")
                    .salary(153972)
                    .build();
            employeeService.save(employee);
        }

        @Test
        void findBySalaryLessThan_shouldReturnDate_whenFound(){
            assertEquals(1, employeeService.findBySalaryLessThan(200000).size());
        }
    }
}