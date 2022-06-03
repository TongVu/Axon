package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.service.AircraftService;
import com.axonactive.homeSpringBoot.service.CertificateService;
import com.axonactive.homeSpringBoot.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class CertificateServiceImplTest {
    @Autowired
    CertificateService certificateService;

    private Certificate certificate1;

    @Test
    void getAllCertificates_shouldReturnNoData_whenTableFirstCreated(){
        assertEquals(0, certificateService.findAll().size());
    }


    @Nested
    class TestAfterSaved{
        @Autowired
        CertificateService certificateService;

        @Autowired
        EmployeeService employeeService;

        @Autowired
        AircraftService aircraftService;

        private Certificate certificate1;
        private Employee employeeCanFly747AirCraft;
        private Aircraft aircraft747;

        @BeforeEach
        void setup(){
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
        void findEmployeeIdByAircraftId() {
            assertEquals(1, certificateService.findEmployeeIdByAircraftId(aircraft747.getId()).size());
        }

        @Test
        void findAircraftIdsThatEmployeesHaveLastNameIsNguyenCanFly_shouldReturnData_whenFound() {
            assertEquals(1,
                    certificateService.findAircraftIdsThatEmployeesHaveLastNameIsNguyenCanFly().size());
        }

        @Test
        void findByAircraftTypeLike_shouldReturnData_whenFound() {
            assertEquals(1, certificateService.findByAircraftTypeLike("Boeing%").size());
        }

        @Test
        void findTotalPilotsOfEachAircraft_shouldReturnData_whenFound() {
            assertEquals(1,
                    certificateService.findTotalPilotsOfEachAircraft().size());
        }
    }
}