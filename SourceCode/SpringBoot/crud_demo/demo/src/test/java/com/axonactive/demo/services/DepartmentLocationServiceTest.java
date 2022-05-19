package com.axonactive.demo.services;

import com.axonactive.demo.entities.Department;
import com.axonactive.demo.entities.DepartmentLocation;
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
class DepartmentLocationServiceTest {

    @Autowired
    DepartmentLocationService departmentLocationService;

    @Autowired
    DepartmentService departmentService;

    private Department newDep;
    private DepartmentLocation depLoc;

    @BeforeEach
    void setup() {
        newDep = Department.builder()
                .departmentName("Hr")
                .startDate(LocalDate.of(2003, 05, 15))
                .build();
        departmentService.saveDepartment(newDep);

        depLoc = DepartmentLocation.builder()
                .location("Hong Kong")
                .department(newDep)
                .build();
    }

    @Test
    void getAllDepartmentLocation_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, departmentLocationService.getAllDepartmentLocation().size());
    }

    @Test
    void getAllDepartmentLocation_shouldReturnData_whenTableHasData(){
        departmentLocationService.saveDepartmentLocation(depLoc);

        assertEquals(depLoc, departmentLocationService.getAllDepartmentLocation().get(0));
    }

    @Test
    void saveDepartmentLocation_shouldInsertDataToTable_whenGivenDepartmentLocationInstance() {
        departmentLocationService.saveDepartmentLocation(depLoc);

        assertEquals(1, departmentLocationService.getAllDepartmentLocation().size());
    }


    @Test
    void deleteDepartmentLocation_shouldReturnZero_whenTableDeletedGivenId() {
        departmentLocationService.saveDepartmentLocation(depLoc);
        departmentLocationService.deleteDepartmentLocation(depLoc.getId());

        assertEquals(0, departmentLocationService.getAllDepartmentLocation().size());
    }

    @Test
    void findDepartmentLocationById_shouldReturnNull_whenGivenIdNotFounded() {
        departmentLocationService.saveDepartmentLocation(depLoc);
        departmentLocationService.deleteDepartmentLocation(depLoc.getId());

        assertEquals(Optional.empty(), departmentLocationService.findDepartmentLocationById(depLoc.getId()));
    }
}