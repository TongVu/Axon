package com.axonactive.companyspringrun2.Service.implement;

import com.axonactive.companyspringrun2.Entities.Employee;
import com.axonactive.companyspringrun2.Entities.Relatives;
import com.axonactive.companyspringrun2.Service.DepartmentService;
import com.axonactive.companyspringrun2.Service.EmployeeService;
import com.axonactive.companyspringrun2.Service.RelativesService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.axonactive.companyspringrun2.Service.implement.DepartmentServiceImplTest.department;
import static com.axonactive.companyspringrun2.Service.implement.EmployeeServiceImplTest.employee1;
import static com.axonactive.companyspringrun2.Service.implement.EmployeeServiceImplTest.employee2;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class RelativesServiceImplTest {

    @Autowired
    RelativesService relativesService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    public static Relatives relative1 = Relatives.builder()
            .id(301)
            .fullName("David Nguyen")
            .gender(1)
            .relationship("Father")
            .phoneNumber("0705018299")
            .employee(employee1)
            .build();

    public static Relatives relative2 = Relatives.builder()
            .id(302)
            .fullName("Anh Nguyen")
            .gender(2)
            .relationship("Mother")
            .phoneNumber("0382829912")
            .employee(employee2)
            .build();

    @Test
    void testGetAllRelatives_shouldReturnNoDate_whenJustCreateTable() {
        assertEquals(0, relativesService.getAllRelatives().size());
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
        void addEmployeeDepartmentAndRelatives() {
            departmentService.saveDepartment(department);
            employeeService.saveEmployee(employee1);
            employeeService.saveEmployee(employee2);
            relativesService.saveRelative(relative1);
            relativesService.saveRelative(relative2);
        }


        @Test
        void testSaveRelatives_shouldReturnTheNewRelatives_WhenCreateTableAndAddOneNewRelatives() {
            departmentService.saveDepartment(department);
            employeeService.saveEmployee(employee1);
            relativesService.saveRelative(relative1);
            assertEquals(relative1, relativesService.getAllRelatives().get(0));
        }

        @Test
        void testDeleteRelative_ShouldReturnNoData_whenCreateTableAddAndDeleteOneRelative() {
            departmentService.saveDepartment(department);
            employeeService.saveEmployee(employee1);
            relativesService.saveRelative(relative1);
            relativesService.deleteRelative(relative1.getId());
            assertEquals(0, relativesService.getAllRelatives().size());
        }

        @Test
        void testFindRelative_ShouldReturnTheRelative_whenFindById() {
            departmentService.saveDepartment(department);
            employeeService.saveEmployee(employee1);
            relativesService.saveRelative(relative1);
            assertEquals(relative1, relativesService.findRelative(relative1.getId()).get());
        }

    }

}