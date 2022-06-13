package com.axonactive.companyspringrun2.Service.implement;

import com.axonactive.companyspringrun2.Entities.DepartmentLocation;
import com.axonactive.companyspringrun2.Service.DepartmentLocationService;
import com.axonactive.companyspringrun2.Service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.axonactive.companyspringrun2.Service.implement.DepartmentServiceImplTest.department;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DepartmentLocationImplTest {

    @Autowired
    DepartmentLocationService departmentLocationService;
    @Autowired
    DepartmentService departmentService;

//    Department department = Department.builder()
//            .id(101)
//            .departmentName("IT")
//            .startDate(LocalDate.of(2022,05,18))
//            .build();

    public static DepartmentLocation departmentLocation = DepartmentLocation.builder()
            .id(201)
            .location("HCM")
            .department(department)
            .build();

    @Test
    void testGetAllDepartmentLocation_shouldReturnNoDate_whenJustCreateTable() {
        List<DepartmentLocation>departmentLocationList = departmentLocationService.getAllDepartmentLocation();
        assertEquals(0,departmentLocationList.size());
    }

    @Test
    void testSaveDepartmentLocation_shouldReturnTheNewDepartmentLocation_WhenCreateTableAndAddOneNewDepartmentLocation() {
        departmentService.saveDepartment(department);
        departmentLocationService.saveDepartmentLocation(departmentLocation);
        assertEquals(departmentLocation,departmentLocationService.getAllDepartmentLocation().get(0));
    }

    @Test
    void testDeleteDepartmentLocation_ShouldReturnNoData_whenCreateTableAddAndDeleteOneDepartmentLocation() {
        departmentService.saveDepartment(department);
        departmentLocationService.saveDepartmentLocation(departmentLocation);
        departmentLocationService.deleteDepartmentLocation(departmentLocation.getId());
        assertEquals(0,departmentLocationService.getAllDepartmentLocation().size());
    }

    @Test
    void testFindDepartmentLocation_ShouldReturnTheDepartmentLocation_whenFindById() {
        departmentService.saveDepartment(department);
        departmentLocationService.saveDepartmentLocation(departmentLocation);
        assertEquals(departmentLocation,departmentLocationService.findDepartmentLocation(departmentLocation.getId()).get());
    }
}