package com.axonactive.demo.services;

import com.axonactive.demo.entities.*;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class RelativeServiceTest {
    @Autowired
    RelativeService relativeService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    private Employee newEmp;
    private Department newDep;
    private Relative newRelative;

    @BeforeEach
    void setup() {
        newDep = Department.builder()
                .departmentName("Hr")
                .startDate(LocalDate.of(2003, 05, 15))
                .build();
        departmentService.saveDepartment(newDep);

        newEmp = Employee.builder()
                .gender("Male")
                .employeeid("10101")
                .dateOfBirth(LocalDate.of(1995, 04, 24))
                .firstName("Tong")
                .middleName(" ")
                .lastName("Vu")
                .salary(2400)
                .department(newDep)
                .build();
        employeeService.saveEmployee(newEmp);

        newRelative = Relative.builder()
                .employee(newEmp)
                .fullName("Bill Gates")
                .gender(1)
                .relationship("Friend")
                .phoneNumber("0934222333")
                .build();
    }

    @Test
    void getAllRelative_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, relativeService.getAllRelative().size());
    }

    @Test
    void getAllRelative_shouldReturnData_whenTableHasData(){
        relativeService.saveRelative(newRelative);

        assertEquals(newRelative.getId(), relativeService.getAllRelative().get(0).getId());
    }

    @Test
    void saveRelative_shouldInsertDataToTable_whenGivenProject() {
        relativeService.saveRelative(newRelative);

        assertEquals(1, relativeService.getAllRelative().size());
    }


    @Test
    void deleteRelative_shouldReturnZero_whenTableDeletedGivenId() {
        relativeService.saveRelative(newRelative);
        relativeService.deleteRelativeById(newRelative.getId());

        assertEquals(0, relativeService.getAllRelative().size());
    }

    @Test
    void findRelativeById_shouldReturnNull_whenGivenIdNotFounded() {
        relativeService.saveRelative(newRelative);
        relativeService.deleteRelativeById(newRelative.getId());

        assertEquals(Optional.empty(), relativeService.findRelativeById(newRelative.getId()));
    }
}