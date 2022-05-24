package com.axonactive.R3SpringBootDemo.service;

import com.axonactive.R3SpringBootDemo.entity.Department;
import com.axonactive.R3SpringBootDemo.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
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

    @Test
    void getAllEmployee_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, employeeService.getAllEmployee().size());
    }

    @Nested
    class employeeServiceTestAfterSave{

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

            employeeService.saveEmployee(newEmp);
        }


        @Test
        void getAllEmployee_shouldReturnData_whenTableHasData() {

            assertEquals(newEmp.getId(), employeeService.getAllEmployee().get(0).getId());
        }

        @Test
        void saveEmployee_shouldInsertDataToTable_whenGivenEmployee() {

            assertEquals(1, employeeService.getAllEmployee().size());
        }


        @Test
        void deleteEmployee_shouldReturnZero_whenTableDeletedGivenId() {
            employeeService.deleteEmployeeById(newEmp.getId());

            assertEquals(0, employeeService.getAllEmployee().size());
        }

        @Test
        void findEmployeeById_shouldReturnNull_whenGivenIdNotFounded() {
            employeeService.deleteEmployeeById(newEmp.getId());

            assertEquals(Optional.empty(), employeeService.findEmployeeById(newEmp.getId()));
        }

        @Test
        void findEmployeeByFirstNameLike_shouldReturnZero_whenNoEmployeeHasNameLikeThat() {
            assertEquals(0, employeeService.findEmployeeByFirstNameLike("KL").size());
        }

        @Test
        void findEmployeeByFirstNameLike_shouldReturnEmployee_whenHaveEmployeeHaveNameLikeThat() {
            assertEquals(1, employeeService.findEmployeeByFirstNameLike("Tong").size());
        }

        @Test
        void findEmployeeByFirstNameLikeAndLastNameLike_shouldReturnNoData_whenNoEmployeeHasNameLikeThat() {
            assertEquals(0, employeeService.findEmployeeByFirstNameLikeAndLastNameLike("Ying", "Yang").size());
        }

        @Test
        void findEmployeeByFirstNameLikeAndLastNameLike_shouldReturnData_whenHasEmployeeHaveNameLikeThat() {
            assertEquals(1, employeeService.findEmployeeByFirstNameLikeAndLastNameLike("%o%", "%u%").size());
        }

        @Test
        void findEmployeeByFirstNameIgnoreCaseLike_shouldReturnData_WhenHasEmployeeHaveNameLikeThat() {
            assertEquals(1, employeeService.findEmployeeByFirstNameIgnoreCaseLike("g").size());
        }

        @Test
        void findEmployeeByDateOfBirthBefore_shouldReturnNoData_whenNotFounded() {

            assertNotNull(employeeService.findEmployeeByDateOfBirthBefore(1995, 3, 10).size());
        }

        @Test
        void findEmployeeByDateOfBirthBefore_shouldReturnData_whenFounded() {
            assertEquals(1, employeeService.findEmployeeByDateOfBirthBefore(1995, 4, 27).size());
        }

        @Test
        void findEmployeeByAgeLessThan_shouldReturnData_whenFounded() {
            assertEquals(1, employeeService.findEmployeeByAgeLessThan(30).size());
        }

        @Test
        void findEmployeeByDateOfBirthBetween_shouldReturnData_whenFounded() {

            assertEquals(1,
                    employeeService.findEmployeeByDateOfBirthBetween(LocalDate.of(1995, 04, 20),
                            LocalDate.of(1995, 04, 30)).size()
            );
        }

        @Test
        void findEmployeeByDateOfBirthBetween_shouldReturnNoData_whenNotFounded() {
            assertEquals(1,
                    employeeService.findEmployeeByDateOfBirthBetween(LocalDate.of(1995, 04, 20),
                            LocalDate.of(1995, 04, 30)).size()
            );
        }

        @Test
        void findEmployeeByDepartmentDepartmentId_shouldReturnData_whenFounded() {
            assertEquals(1, employeeService.findEmployeeByDepartmentId(newDep.getId()).size());
        }

        @Test
        void findEmployeeByDepartmentDepartmentId_shouldReturnNoData_whenNotFounded() {
            assertEquals(0, employeeService.findEmployeeByDepartmentId(123415L).size());
        }

        @Test
        void findEmployeeByFirstNameContaining_shouldReturnData_whenFounded(){
            assertEquals(newEmp.getId(),
                    employeeService.findEmployeeByFirstNameContaining("n").get(0).getId());
        }

        @Test
        void findEmployeeByFirstNameContaining_shouldReturnNoData_whenNotFounded(){
            assertEquals(0,
                    employeeService.findEmployeeByFirstNameContaining("l").size());
        }
    }
}