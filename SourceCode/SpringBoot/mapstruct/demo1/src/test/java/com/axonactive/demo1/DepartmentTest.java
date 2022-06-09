package com.axonactive.demo1;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.demo.entity.Location;
import com.axonactive.service.DepartmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
public class DepartmentTest {
    @Autowired
    DepartmentService departmentService;

    @Test
    void testGetAll_shouldReturn0_whenJustCreatedTable() {
        Assertions.assertEquals(0, departmentService.getAll().size());
    }

    @Test
    void testAdd_shouldReturnOne_whenAddOne() {
        Department department = Department.builder()
                .departmentName("ALibaba")
                .build();
        departmentService.saveDepartment(department);
        Assertions.assertEquals(1, departmentService.getAll().size());
    }

    @Test
    void testGetId_shouldReturnTrue_whenIdExist() {
        Department department = Department.builder()
                .departmentLocation(Location.HCM)
                .departmentName("Alibaba")
                .build();
        departmentService.saveDepartment(department);
        int id = departmentService.
                getDepartmentById(department.getDepartmentId()).
                get().getDepartmentId();
        Assertions.assertEquals(department.getDepartmentId(), id);
    }

    @Test
    void testGetId_ShouldReturnTrue_whenIdNotExist() {
        boolean result = false;
        for (Department entity : departmentService.getAll()
        ) {
            if (entity.getDepartmentId() == 100000000)
                result = true;
        }
        Assertions.assertFalse(result);
    }

    @Test
    void testAdd_shouldReturnFalse_whenDeleteOne() {
        Department department = Department.builder()
                .departmentLocation(Location.HCM)
                .departmentName("Alibaba")
                .build();
        departmentService.saveDepartment(department);
        departmentService.deleteDepartment(department.getDepartmentId());
        boolean result = false;
        for (Department entity : departmentService.getAll()
        ) {
            if (Objects.equals(entity.getDepartmentId(), department.getDepartmentId()))
                result = true;
        }
        Assertions.assertFalse(result);
    }
}
