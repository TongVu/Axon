package com.axonactive.R3SpringBootDemo.service;

import com.axonactive.R3SpringBootDemo.entity.Department;
import com.axonactive.R3SpringBootDemo.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void getAllEmployee_shouldReturnData_whenTableHasData() {
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

    @Test
    void findEmployeeByFirstNameLike_shouldReturnZero_whenNoEmployeeHasNameLikeThat(){
        employeeService.saveEmployee(newEmp);
        assertEquals(0, employeeService.findEmployeeByFirstNameLike("KL").size());
    }

    @Test
    void findEmployeeByFirstNameLike_shouldReturnEmployee_whenHaveEmployeeHaveNameLikeThat(){
        employeeService.saveEmployee(newEmp);
        assertEquals(1, employeeService.findEmployeeByFirstNameLike("Tong").size());
    }

    @Test
    void findEmployeeByFirstNameLikeAndLastNameLike_shouldReturnNoData_whenNoEmployeeHasNameLikeThat(){
        employeeService.saveEmployee(newEmp);
        assertEquals(0, employeeService.findEmployeeByFirstNameLikeAndLastNameLike("Ying", "Yang").size());
    }

    @Test
    void findEmployeeByFirstNameLikeAndLastNameLike_shouldReturnData_whenHasEmployeeHaveNameLikeThat(){
        employeeService.saveEmployee(newEmp);
        assertEquals(1, employeeService.findEmployeeByFirstNameLikeAndLastNameLike("%o%", "%u%").size());
    }

    @Test
    void findEmployeeByFirstNameIgnoreCaseLike_shouldReturnData_WhenHasEmployeeHaveNameLikeThat(){
        employeeService.saveEmployee(newEmp);
        assertEquals(1, employeeService.findEmployeeByFirstNameIgnoreCaseLike("g").size());
    }

    @Test
    void findEmployeeByDateOfBirthBefore_shouldReturnNoData_whenNotFounded() {
        employeeService.saveEmployee(newEmp);

        assertNotNull(employeeService.findEmployeeByDateOfBirthBefore(1995, 3, 10).size());
    }

    @Test
    void findEmployeeByDateOfBirthBefore_shouldReturnData_whenFounded(){
        employeeService.saveEmployee(newEmp);
        assertEquals(1, employeeService.findEmployeeByDateOfBirthBefore(1995,4,27).size());
    }
}