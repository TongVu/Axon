package com.axonactive.demo.services;

import com.axonactive.demo.entities.Department;
import com.axonactive.demo.entities.DepartmentLocation;
import com.axonactive.demo.entities.Employee;
import com.axonactive.demo.entities.Project;
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
class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    private Employee newEmp;
    private Department newDep;

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
    }

    @Test
    void getAllEmployee_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, employeeService.getAllEmployee().size());
    }

    @Test
    void getAllEmployee_shouldReturnData_whenTableHasData(){
        employeeService.saveEmployee(newEmp);

        assertEquals(newEmp.getId(), employeeService.getAllEmployee().get(0).getId());
    }

    @Test
    void saveEmployee_shouldInsertDataToTable_whenGivenEmployee() {
        employeeService.saveEmployee(newEmp);

        assertEquals(1, employeeService.getAllEmployee().size());
    }


    @Test
    void deleteEmployee_shouldReturnZero_whenTableDeletedGivenId() {
        employeeService.saveEmployee(newEmp);
        employeeService.deleteEmployeeById(newEmp.getId());

        assertEquals(0, employeeService.getAllEmployee().size());
    }

    @Test
    void findEmployeeById_shouldReturnNull_whenGivenIdNotFounded() {
        employeeService.saveEmployee(newEmp);
        employeeService.deleteEmployeeById(newEmp.getId());

        assertEquals(Optional.empty(), employeeService.findEmployeeById(newEmp.getId()));
    }
}