package com.axonactive.demo.services.Impl;

import com.axonactive.demo.entities.Assignment;
import com.axonactive.demo.entities.Department;
import com.axonactive.demo.entities.Employee;
import com.axonactive.demo.entities.Project;
import com.axonactive.demo.repositories.AssignmentRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssignmentServiceImpTest {
    @Autowired
    AssignmentServiceImp assignmentServiceImp;

    @Test
    void getAll_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, assignmentServiceImp.getAll().size());
    }

    @Test
    void saveAssignment_shouldAddAssignmentToTable_whenGivenAnAssignment() {
        Department newDep = Department.builder()
                .id(123L)
                .startDate(LocalDate.of(2000, 04, 20))
                .departmentName("IT")
                .build();

        Project project = Project.builder()
                .projectid(1245L)
                .area("VietName")
                .projectName("AREA")
                .department(newDep)
                .build();

        Employee newEmployee = Employee.builder()
                .id(244L)
                .dateOfBirth(LocalDate.of(1995, 04, 24))
                .firstName("Tong")
                .gender("Male")
                .lastName("Vu")
                .middleName(" ")
                .salary(2300)
                .department(newDep)
                .build();

        Assignment newAssignment = Assignment.builder()
                .id(244L)
                .employee(newEmployee)
                .project(project)
                .numberOfHour(13)
                .build();

        assignmentServiceImp.saveAssignment(newAssignment);

        assertEquals(1, assignmentServiceImp.getAll().size());
    }

    @Test
    void deleteAssignmentById() {
    }

    @Test
    void findAssignmentById() {
    }
}