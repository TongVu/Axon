package com.axonactive.companyspringrun2.Service.implement;

import com.axonactive.companyspringrun2.Entities.Employee;
import com.axonactive.companyspringrun2.Service.DepartmentService;
import com.axonactive.companyspringrun2.Service.EmployeeService;
import com.axonactive.companyspringrun2.Service.RelativesService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static com.axonactive.companyspringrun2.Service.implement.DepartmentServiceImplTest.department;
import static com.axonactive.companyspringrun2.Service.implement.RelativesServiceImplTest.relative1;
import static com.axonactive.companyspringrun2.Service.implement.RelativesServiceImplTest.relative2;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmployeeServiceImplTest {

    public static Employee employee1 = Employee.builder()
            .id("NV001")
            .dateOfBirth(LocalDate.of(1999,2,8))
            .firstName("Thinh")
            .lastName("Nguyen" )
            .gender("Male")
            .salary(10000000)
            .department(department)
            .build();

    public static Employee employee2 = Employee.builder()
            .id("NV002")
            .dateOfBirth(LocalDate.of(1994,6,26))
            .firstName("Hung")
            .middleName("Quang")
            .lastName("Tran")
            .gender("Male")
            .salary(5000)
            .department(department)
            .build();


    @Autowired
    RelativesService relativesService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;



    @Test
    void testGetAllEmployee_shouldReturnNoDate_whenJustCreateTable() {
        assertEquals(0,employeeService.getAllEmployee().size());
    }

    @Nested
    class afterSave {

        @Autowired
        DepartmentService departmentService;

        @Autowired
        EmployeeService employeeService;

        @Autowired
        RelativesService relativesService;


        @BeforeEach
        void addEmployeeAndDepartment() {
            departmentService.saveDepartment(department);
            employeeService.saveEmployee(employee1);
            employeeService.saveEmployee(employee2);
            relativesService.saveRelative(relative1);
            relativesService.saveRelative(relative2);
        }

        @Test
        void testSaveEmployee_shouldReturnTheNewEmployee_WhenCreateTableAndAddOneNewEmployee() {
            assertEquals(2, employeeService.getAllEmployee().size());
        }

        @Test
        void testDeleteEmployee_ShouldReturn1_whenCreateTableAddAndDeleteOneEmployee() {
            employeeService.deleteEmployee(employee1.getId());
            assertEquals(1, employeeService.getAllEmployee().size());
        }

        @Test
        void testFindEmployee_ShouldReturnTheEmployee_whenFindById() {
            assertEquals(employee1, employeeService.findEmployee(employee1.getId()).get());
        }

        @Test
        void testFindEmployeeByLastName_shouldReturnTheEmployee_whenFindByLastName() {
            assertEquals(employee1, employeeService.findByLastname("Nguyen"));
        }

        @Test
        void testFindEmployeeByFirstName_shouldReturnTheEmployee_whenFindByFirstName() {
            assertEquals(employee1, employeeService.findByFirstName("Thinh"));
        }

        @Test
        void testFindEmployeeByLastNameOrFirstName_shouldReturnTheEmployee_whenFindByLastNameOrFirstName() {
            assertEquals(employee1, employeeService.findByLastNameOrFirstName("Nguyen", "Thinh"));
        }

        @Test
        void testFindEmployeeByDateOfBirth_shouldReturnTheEmployee_whenFindBetweenDate1andDate2() {
            assertEquals(employee1, employeeService.findByDateOfBirthBetween(LocalDate.of(1998, 02, 10),
                    LocalDate.of(2000, 8, 02)).get(0));
        }

//    @Test
//    void testFindEmployeeByAgeLessThan_shouldReturnTwoEmployee_whenFound(){
//        departmentService.saveDepartment(department);
//        employeeService.saveEmployee(employee1);
//        employeeService.saveEmployee(employee2);
//        assertEquals(2,employeeService.findByAgeLessThan(30).size());
//    }

        @Test
        void testFindByMiddleNameIsNull_shouldReturnTheEmployee1_whenFound() {
            assertEquals(employee1, employeeService.findByMiddleNameIsNull().get(0));

        }

        @Test
        void testFindByLastNameIsNotNull_ShouldReturnListOfEmployee_whenFound() {
            assertEquals(2, employeeService.findByLastNameIsNotNull().size());
        }

        @Test
        void testFindByLastNameIgnoreCase_shouldReturnTheEmployee_whenFound() {
            assertEquals(employee2, employeeService.findByLastNameIgnoreCase("tran"));
        }

        @Test
        void findByFirstNameStartingWith_shouldReturnTheEmployee_whenFound() {
            assertEquals(employee1, employeeService.findByFirstNameStaringWith("T"));
        }

        @Test
        void findByDepartmentId_ShouldReturnListOfTwoEmployee_whenFound(){
            assertEquals(2,employeeService.findByDepartmentId(101).size());
        }
        @Test
        void findByDepartmentName_shouldReturnListOfTwoEmployee_whenFound(){
            assertEquals(2,employeeService.findByDepartmentDepartmentName("IT").size());
        }
        @Test
        void findByDepartmentStartDate_shouldReturnListOfTwoEmployee_whenFound(){
            assertEquals(2,employeeService.findByDepartmentStartDate(2022,05,18).size());
        }
        @Test
        void findByDepartmentDepartmentNameIgnoreCase_shouldReturnTwoEmployee_whenFound(){
            assertEquals(2,employeeService.findByDepartmentDepartmentNameIgnoreCase("it").size());
        }

        @Test
        void findByDepartmentNameStaringWith_shouldReturnTwoEmployee_whenFound(){
            assertEquals(2,employeeService.findByDepartmentDepartmentNameStartingWith("I").size());
        }

        @Test
        void findByDepartmentNameIsNotNull_shouldReturnTwoEmployee_whenFound(){
            assertEquals(2,employeeService.findByDepartmentDepartmentNameIsNotNull().size());
        }

        @Test
        void test(){
            assertEquals(2,employeeService.findAllEmployeeAndTheirRelative().size());
        }

        @Test
        void test1(){
            assertEquals(1,departmentService.departmentNameAndNumberOfEmployees().size());
        }
    }
}