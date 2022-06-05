package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.service.AircraftService;
import com.axonactive.homeSpringBoot.service.CertificateService;
import com.axonactive.homeSpringBoot.service.EmployeeService;
import com.axonactive.homeSpringBoot.service.dto.EmployeeNotPilotDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    CertificateService certificateService;

    @Autowired
    AircraftService aircraftService;

    @Test
    void getAllEmployee_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, employeeService.findAll().size());
    }

    @Nested
    class AfterSave {
        @Autowired
        EmployeeService employeeService;

        @Autowired
        CertificateService certificateService;

        @Autowired
        AircraftService aircraftService;


        private Certificate certificate1;
        private Aircraft aircraft747;

        private Employee employeeCanFly747AirCraft;

        private Employee employee;
        private Employee employee2;

        @BeforeEach
        void setup() {
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

            employeeCanFly747AirCraft = Employee.builder()
                    .id("142519864")
                    .salary(227489)
                    .name("Nguyen Thi Xuan Dao")
                    .build();
            employeeService.save(employeeCanFly747AirCraft);

            aircraft747 = Aircraft.builder()
                    .type("Boeing 747 - 400")
                    .distance(13488)
                    .build();
            aircraftService.save(aircraft747);

            certificate1 = Certificate.builder()
                    .aircraft(aircraft747)
                    .employee(employeeCanFly747AirCraft)
                    .build();
            certificateService.save(certificate1);
        }

        @Test
        void findBySalaryLessThan_shouldReturnData_whenFound() {
            assertEquals(2, employeeService.findBySalaryLessThan(200000).size());
        }

        @Test
        void calculateTotalSalaryForAllEmployees_shouldSumAllEmployeesSalary_whenHaveData() {
            assertEquals(153972 + 146028 + 227489,
                    employeeService.calculateTotalSalaryForAllEmployees());
        }

        @Test
        void findAllNamesOfPilotCanFlyBoeingAircraft_shouldSumAllEmployeesSalary_whenHaveData() {
            assertEquals(employeeCanFly747AirCraft.getName(),
                    employeeService.findAllNamesOfPilotCanFlyBoeingAircraft().get(0));
        }

//        @Test
//        void findEmployeeWhoArentPilot() {
//            assertEquals(2, employeeService.findEmployeeWhoNotPilot().size());
//        }

        @Test
        void findEmployeeWhoIsNotPilot() {
            assertEquals(2, employeeService.findEmployeeWhoIsNotPilot().size());
        }

        @Test
        void findEmployeeWithHighestSalary() {
            assertEquals(1, employeeService.findEmployeeWithHighestSalary().size());
        }


    }
}