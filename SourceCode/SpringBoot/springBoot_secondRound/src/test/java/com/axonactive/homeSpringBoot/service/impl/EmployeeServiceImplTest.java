package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RequiredArgsConstructor
class EmployeeServiceImplTest {
    @Autowired
    EmployeeService employeeService;

    private Employee employee;
    private Employee employee2;

    @Test
    void getAllEmployee_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, employeeService.findAll().size());
    }



    @Nested
    class AfterSave{
        @Autowired
        EmployeeService employeeService;

        private Employee employee;
        private Employee employee2;

        @BeforeEach
        void setup () {
            employee = Employee.builder()
                    .id("011564812")
                    .name("Ton Van Quy")
                    .salary(153972)
                    .build();
            employeeService.save(employee);

            employee2 = Employee.builder()
                    .id("000000000")
                    .name("Nguyen Ngoc Truc Anh")
                    .salary(146028)
                    .build();
            employeeService.save(employee2);
        }

        @Test
        void findBySalaryLessThan_shouldReturnData_whenFound(){
            assertEquals(2, employeeService.findBySalaryLessThan(200000).size());
        }

        @Test
        void calculateTotalSalaryForAllEmployees_shouldSumAllEmployeesSalary_whenHaveData() {
            assertEquals(300000, employeeService.calculateTotalSalaryForAllEmployees());
        }

        @Test
        void findEmployeeByNameLike_shouldReturnData_whenFound() {
            assertEquals(1, employeeService.findEmployeeByNameLike("Nguyen").size());
        }
    }
}