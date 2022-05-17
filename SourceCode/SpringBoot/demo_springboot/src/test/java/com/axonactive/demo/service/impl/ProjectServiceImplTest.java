package com.axonactive.demo.service.impl;

import com.axonactive.demo.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceImplTest {
    @Autowired
    ProjectService projectService;

    @Test
    void getAll_shouldReturnNoData_whenTableJustCreated() {
        assertEquals(0, projectService.getAll().size());
    }
}