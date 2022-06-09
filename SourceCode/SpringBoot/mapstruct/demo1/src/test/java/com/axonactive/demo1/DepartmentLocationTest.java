package com.axonactive.demo1;

import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.demo.entity.Location;
import com.axonactive.service.DepartmentLocationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
public class DepartmentLocationTest {
    @Autowired
    DepartmentLocationService departmentLocationService;

    @Test
    void testGetAll_shouldReturn0_whenJustCreatedTable() {
        Assertions.assertEquals(0, departmentLocationService.getAll().size());
    }

    @Test
    void testAdd_shouldReturnOne_whenAddOne() {
        DepartmentLocation departmentLocation1 = DepartmentLocation.builder()
                .location(Location.HCM)
                .build();
        departmentLocationService.saveDepartmentLocation(departmentLocation1);
        Assertions.assertEquals(1, departmentLocationService.getAll().size());
    }

    @Test
    void testGetId_shouldReturnTrue_whenIdExist() {
        DepartmentLocation departmentLocation2 = DepartmentLocation.builder()
                .location(Location.CANTHO)
                .build();
        departmentLocationService.saveDepartmentLocation(departmentLocation2);
        int id = departmentLocationService.
                getDepartmentLocationById(departmentLocation2.getId()).
                get().getId();
        Assertions.assertEquals(departmentLocation2.getId(), id);
    }

    @Test
    void testGetId_ShouldReturnTrue_whenIdNotExist() {
        boolean result = false;
        for (DepartmentLocation entity : departmentLocationService.getAll()
        ) {
            if (entity.getId() == 100000000)
                result = true;
        }
        Assertions.assertFalse(result);
    }

    @Test
    void testAdd_shouldReturnFalse_whenDeleteOne() {
        DepartmentLocation departmentLocation1 = DepartmentLocation.builder()
                .location(Location.HCM)
                .build();
        departmentLocationService.saveDepartmentLocation(departmentLocation1);
        departmentLocationService.deleteDepartmentLocation(departmentLocation1.getId());
        boolean result = false;
        for (DepartmentLocation entity : departmentLocationService.getAll()
        ) {
            if (Objects.equals(entity.getId(), departmentLocation1.getId()))
                result = true;
        }
        Assertions.assertFalse(result);
    }

}
