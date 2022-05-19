package com.axonactive.demo.services;

import com.axonactive.demo.entities.Department;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RequiredArgsConstructor
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DepartmentServiceTest {
    @Autowired
    DepartmentService departmentService;

    private Department newDep = Department.builder()
            .departmentName("Hr")
            .startDate(LocalDate.of(2003, 05, 15))
            .build();

    @Test
    void getAllDepartment_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, departmentService.getAllDepartment().size());
    }

    @Test
    void saveDepartment_shouldInsertDepartmentToTable_whenGivenADepartment() {
        departmentService.saveDepartment(newDep);

        assertEquals(1, departmentService.getAllDepartment().size());
    }

    @Test
    void deleteDepartmentById_shouldDropDepartmentFromTable_whenGivenDepartmentId() {
        departmentService.saveDepartment(newDep);
        departmentService.deleteDepartmentById(newDep.getId());
        assertEquals(0, departmentService.getAllDepartment().size());
    }

    @Test
    void findDepartmentById_shouldReturnData_whenGivenDepartmentId() {
        departmentService.saveDepartment(newDep);
        assertEquals(newDep.getId(), departmentService.findDepartmentById(newDep.getId()).get().getId());
    }

    @Test
    void findDepartmentById_shouldReturnNoData_whenGivenDepartmentIdNotFounded() {
        departmentService.saveDepartment(newDep);
        departmentService.deleteDepartmentById(newDep.getId());
        assertEquals(Optional.empty(), departmentService.findDepartmentById(newDep.getId()));
    }
}