package com.axonactive.demo1;

import com.axonactive.demo.entity.Project;
import com.axonactive.demo.entity.Location;
import com.axonactive.service.ProjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;
@SpringBootTest
public class ProjectTest {
    @Autowired
    ProjectService projectService;

    @Test
    void testGetAll_shouldReturn0_whenJustCreatedTable() {
        Assertions.assertEquals(0, projectService.getAll().size());
    }

    @Test
    void testAdd_shouldReturnOne_whenAddOne() {
        Project project = Project.builder()
                .build();
        projectService.saveProject(project);
        Assertions.assertEquals(1, projectService.getAll().size());
    }

    @Test
    void testGetId_shouldReturnTrue_whenIdExist() {
        Project project = Project.builder()
                .area(Location.CANTHO)
                .build();
        projectService.saveProject(project);
        int id = projectService.
                getProjectById(project.getProjectId()).
                get().getProjectId();
        Assertions.assertEquals(project.getProjectId(), id);
    }

    @Test
    void testGetId_ShouldReturnTrue_whenIdNotExist() {
        boolean result = false;
        for (Project entity : projectService.getAll()
        ) {
            if (entity.getProjectId() == 100000000)
                result = true;
        }
        Assertions.assertFalse(result);
    }

    @Test
    void testAdd_shouldReturnFalse_whenDeleteOne() {
        Project project = Project.builder()
                .build();
        projectService.saveProject(project);
        projectService.deleteProject(project.getProjectId());
        boolean result = false;
        for (Project entity : projectService.getAll()
        ) {
            if (Objects.equals(entity.getProjectId(), project.getProjectId()))
                result = true;
        }
        Assertions.assertFalse(result);
    }
}
