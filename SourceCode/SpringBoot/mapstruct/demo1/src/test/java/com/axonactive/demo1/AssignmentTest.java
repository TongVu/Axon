package com.axonactive.demo1;

import com.axonactive.demo.entity.Assignment;
import com.axonactive.demo.entity.Location;
import com.axonactive.service.AssignmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;
@SpringBootTest
public class AssignmentTest {
    @Autowired
    AssignmentService assignmentService;

    @Test
    void testGetAll_shouldReturn0_whenJustCreatedTable() {
        Assertions.assertEquals(0, assignmentService.getAll().size());
    }

    @Test
    void testAdd_shouldReturnOne_whenAddOne() {
        Assignment assignment = Assignment.builder()
                .build();
        assignmentService.saveAssignment(assignment);
        Assertions.assertEquals(1, assignmentService.getAll().size());
    }

    @Test
    void testGetId_shouldReturnTrue_whenIdExist() {
        Assignment assignment = Assignment.builder()
                .build();
        assignmentService.saveAssignment(assignment);
        int id = assignmentService.
                getAssignmentById(assignment.getId()).
                get().getId();
        Assertions.assertEquals(assignment.getId(), id);
    }

    @Test
    void testGetId_ShouldReturnTrue_whenIdNotExist() {
        boolean result = false;
        for (Assignment entity : assignmentService.getAll()
        ) {
            if (entity.getId() == 100000000)
                result = true;
        }
        Assertions.assertFalse(result);
    }

    @Test
    void testAdd_shouldReturnFalse_whenDeleteOne() {
        Assignment assignment = Assignment.builder()
                .build();
        assignmentService.saveAssignment(assignment);
        assignmentService.deleteAssignment(assignment.getId());
        boolean result = false;
        for (Assignment entity : assignmentService.getAll()
        ) {
            if (Objects.equals(entity.getId(), assignment.getId()))
                result = true;
        }
        Assertions.assertFalse(result);
    }
}
