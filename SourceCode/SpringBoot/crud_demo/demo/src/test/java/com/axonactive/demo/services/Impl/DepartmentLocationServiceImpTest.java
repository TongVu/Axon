package com.axonactive.demo.services.Impl;

import com.axonactive.demo.entities.DepartmentLocation;
import com.axonactive.demo.services.DepartmentLocationService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class DepartmentLocationServiceImpTest {
    @Autowired
    DepartmentLocationServiceImp departmentLocationServiceImp;

    @Test
    void getAllDepartmentLocation_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, departmentLocationServiceImp.getAllDepartmentLocation().size());
    }

    @Test
    void saveDepartmentLocation_shouldInsertDataToTable_whenGivenDepartmentLocationInstance() {
        DepartmentLocation newDepartmentLocation = DepartmentLocation.builder()
                .id(12345L)
                .location("Singapore")
                .build();
    }

    @Test
    void deleteDepartmentLocation() {
    }

    @Test
    void findDepartmentLocationById() {
    }
}