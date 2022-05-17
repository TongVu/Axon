package com.axonactive.demo.service.impl;

import com.axonactive.demo.entity.Assignment;
import com.axonactive.demo.service.AssignmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AssignmentServiceImplTest {

    @Autowired
    AssignmentService assignmentService;

    @Test
    void getAllAssignment_shouldReturnNoData_whenTableJustCreated() {
        List<Assignment> assignments = assignmentService.getAll();
        assertEquals(0, assignments.size());
    }
}