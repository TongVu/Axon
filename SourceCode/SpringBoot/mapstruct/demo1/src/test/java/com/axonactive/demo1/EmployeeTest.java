package com.axonactive.demo1;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.entity.Location;
import com.axonactive.service.DepartmentService;
import com.axonactive.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Objects;

@SpringBootTest
public class EmployeeTest {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @Test
    void testGetAll_shouldReturn0_whenJustCreatedTable() {
        Assertions.assertEquals(0, employeeService
                .getAll().size());
    }

    @Test
    void testAdd_shouldReturnOne_whenAddOne() {
        Employee employee = Employee.builder()
                .build();
        employeeService.saveEmployee(employee);
        Assertions.assertEquals(1, employeeService
                .getAll().size());
    }

    @Test
    void testGetId_shouldReturnTrue_whenIdExist() {
        Employee employee = Employee.builder()
                .build();
        employeeService.saveEmployee(employee);
        int id = employeeService
                .
                getEmployeeById(employee.getId()).
                get().getId();
        Assertions.assertEquals(employee.getId(), id);
    }

    @Test
    void testGetId_ShouldReturnTrue_whenIdNotExist() {
        boolean result = false;
        for (Employee entity : employeeService
                .getAll()
        ) {
            if (entity.getId() == 100000000)
                result = true;
        }
        Assertions.assertFalse(result);
    }

    @Test
    void testAdd_shouldReturnFalse_whenDeleteOne() {
        Employee employee = Employee.builder()
                .build();
        employeeService.saveEmployee(employee);
        employeeService.deleteEmployee(employee.getId());
        boolean result = false;
        for (Employee entity : employeeService
                .getAll()
        ) {
            if (Objects.equals(entity.getId(), employee.getId()))
                result = true;
        }
        Assertions.assertFalse(result);
    }

    Department ItDepartment = new Department(1, "IT", Location.HCM, LocalDate.now());

    @Test
    void findByFirstNameShouldReturn0WhenNoEmployeeWasInitiated() {
        Assertions.assertEquals(0, employeeService.findByFirstName("Alo").size());
    }

    @Test
    void shouldReturn1WhenThereIsOneEmployeeWithThatFirstName() {
        Employee employee = Employee.builder()
                .firstName("ALo")
                .build();
        employeeService.saveEmployee(employee);
        Assertions.assertEquals(0, employeeService.findByFirstName("Alo").size());
    }

    @Test
    void findByLastNameOrFirstNameShouldReturn0WhenNoEmployeeWasInitialized() {
        Assertions.assertEquals(0, employeeService.findByLastNameOrByFirstName("Alo", "Alo").size());
    }

    @Test
    void findByLastNameOrFirstNameShouldReturn1WhenEmployeeWasCreated() {
        Employee employee = Employee.builder()
                .firstName("ALo")
                .lastName("Adu")
                .build();
        employeeService.saveEmployee(employee);
        Assertions.assertEquals(1, employeeService.findByLastNameOrByFirstName("Adu", "ALo").size());
    }

    @Test
    void findByLastNameLike_ShouldReturn1WhenEmployeeExisted() {
        Employee employee = Employee.builder()
                .firstName("Alo")
                .lastName("Adu")
                .build();
        employeeService.saveEmployee(employee);
        Assertions.assertEquals(1, employeeService.findByEmployeeLastNameLike("%d%").size());
    }

    @BeforeEach
    public void init() {
        Department department= Department.builder()
                .departmentName("IT")
                .build();
        departmentService.saveDepartment(department);
        Employee employee = Employee.builder()
                .firstName("Alo")
                .lastName("Adu")
                .salary(1200)
                .department(department)
                .build();
        employeeService.saveEmployee(employee);
    }

    @Test
    void shouldReturn1EmployeeWithSalaryGreaterThan1000() {
        Assertions.assertEquals(1, employeeService.findBySalaryGreaterThan(1000).size());
    }

    @Test
    void shouldReturn1WhenEmployeeWithEmployeeLessThan2000() {
        Assertions.assertEquals(1, employeeService.findBySalaryLessThan(2000).size());
    }

    @Test
    void shouldReturn1WhenEmployeeWithSalaryEqualsTo1200(){
        Assertions.assertEquals(1,employeeService.findBySalary(1200).size());
    }
    @Test
    void  shouldReturn1WhenEmployeeIsInItDepartment(){
        Assertions.assertEquals(1,employeeService.findByDepartmentDepartmentName("IT").size());
    }
    @Test
    void  shouldReturn1WhenEmployeeIsInTheDepartmentNameLikeI(){
        Assertions.assertEquals(1,employeeService.findByDepartmentDepartmentNameLike("%I%").size());
    }
    @Test
    void shouldReturn1WhenSalaryBetween1000And2000(){
        Assertions.assertEquals(1,employeeService.findBySalaryBetween(1000,2000).size());
    }
    @Test
    void shouldReturn1WhenWhenAlreadySort(){
        Assertions.assertEquals(1,employeeService.findAllOrderByDepartment().size());
    }
}
