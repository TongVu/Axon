package com.axonactive.companyspringrun2.Service.implement;

import com.axonactive.companyspringrun2.Entities.Department;
import com.axonactive.companyspringrun2.Service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DepartmentServiceImplTest {

    @Autowired
    DepartmentService departmentService;


    public static Department department = Department.builder()
            .id(101)
            .departmentName("IT")
            .startDate(LocalDate.of(2022,05,18))
            .build();


    @Test
    void testGetAllDepartment_shouldReturnNoDate_whenJustCreateTable() {
        List<Department> departmentList = departmentService.getAllDepartment();
        assertEquals(0,departmentList.size());
    }

    @Test
    void testSaveDepartment_shouldReturnTheNewDepartment_WhenCreateTableAndAddOneNewDepartment() {
        departmentService.saveDepartment(department);
        assertEquals(department,departmentService.getAllDepartment().get(departmentService.getAllDepartment().size()-1));
    }

    @Test
    void testDeleteDepartment_ShouldReturnNoData_whenCreateTableAddAndDeleteOneDepartment() {
        departmentService.saveDepartment(department);
        departmentService.deleteDepartment(department.getId());
        assertEquals(0,departmentService.getAllDepartment().size());
    }

    @Test
    void testFindDepartment_ShouldReturnTheDepartment_whenFindById() {
        departmentService.saveDepartment(department);
        assertEquals(department,departmentService.findDepartment(department.getId()).get());
    }
}