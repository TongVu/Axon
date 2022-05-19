package com.axonactive.demo.services;

import com.axonactive.demo.entities.Department;
import com.axonactive.demo.entities.DepartmentLocation;
import com.axonactive.demo.entities.Project;
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
class ProjectServiceTest {

    @Autowired
    ProjectService projectService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentLocationService departmentLocationService;

    private Project newProject;
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
        departmentLocationService.saveDepartmentLocation(depLoc);

        newProject = Project.builder()
                .area("Melbourne")
                .projectName("FROM NON-IT TO TEAM LEADER")
                .department(newDep)
                .build();
    }

    @Test
    void getAllProject_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, projectService.getAllProject().size());
    }

    @Test
    void getAllProject_shouldReturnData_whenTableHasData(){
        projectService.saveProject(newProject);

        assertEquals(newProject.getProjectid(), projectService.getAllProject().get(0).getProjectid());
    }

    @Test
    void saveProject_shouldInsertDataToTable_whenGivenProject() {
        projectService.saveProject(newProject);

        assertEquals(1, projectService.getAllProject().size());
    }


    @Test
    void deleteProject_shouldReturnZero_whenTableDeletedGivenId() {
        projectService.saveProject(newProject);
        projectService.deleteProjectById(newProject.getProjectid());

        assertEquals(0, projectService.getAllProject().size());
    }

    @Test
    void findProjectById_shouldReturnNull_whenGivenIdNotFounded() {
        projectService.saveProject(newProject);
        projectService.deleteProjectById(newProject.getProjectid());

        assertEquals(Optional.empty(), projectService.findProjectById(newProject.getProjectid()));
    }
}