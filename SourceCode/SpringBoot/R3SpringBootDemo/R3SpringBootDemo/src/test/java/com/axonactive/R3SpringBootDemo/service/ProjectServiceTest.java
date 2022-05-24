package com.axonactive.R3SpringBootDemo.service;

import com.axonactive.R3SpringBootDemo.entity.Department;
import com.axonactive.R3SpringBootDemo.entity.DepartmentLocation;
import com.axonactive.R3SpringBootDemo.entity.Project;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

    @Test
    void getAllProject_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, projectService.getAllProject().size());
    }

    @Nested
    class afterSave{

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
            projectService.saveProject(newProject);
        }

        @Test
        void getAllProject_shouldReturnData_whenTableHasData(){
            assertEquals(newProject.getProjectid(), projectService.getAllProject().get(0).getProjectid());
        }

        @Test
        void saveProject_shouldInsertDataToTable_whenGivenProject() {
            assertEquals(1, projectService.getAllProject().size());
        }


        @Test
        void deleteProject_shouldReturnZero_whenTableDeletedGivenId() {
            projectService.deleteProjectById(newProject.getProjectid());

            assertEquals(0, projectService.getAllProject().size());
        }

        @Test
        void findProjectById_shouldReturnNull_whenGivenIdNotFound() {
            projectService.deleteProjectById(newProject.getProjectid());

            assertEquals(Optional.empty(), projectService.findProjectById(newProject.getProjectid()));
        }

        @Test
        void findProjectByProjectName_shouldReturnData_whenFound(){
            assertEquals(1,projectService.findProjectByProjectName("FROM NON-IT TO TEAM LEADER").size());
        }

        @Test
        void findProjectByProjectName_shouldReturnNoData_whenNotFound(){
            assertEquals(0,projectService.findProjectByProjectName("HAHA").size());
        }

        @Test
        void findProjectByDepartmentId_shouldReturnData_whenFound(){
            assertEquals(1, projectService.findProjectByDepartmentId(newDep.getId()).size());
        }

        @Test
        void findProjectByDepartmentId_shouldReturnNoData_whenNotFound(){
            assertEquals(0, projectService.findProjectByDepartmentId(1481L).size());
        }

        @Test
        void findProjectByDepartmentDepartmentName_shouldReturnData_whenFound(){
            assertEquals(1, projectService.findProjectByDepartmentDepartmentName(newDep.getDepartmentName()).size());
        }

        @Test
        void findProjectByDepartmentDepartmentName_shouldReturnNoData_whenFound(){
            assertEquals(0, projectService.findProjectByDepartmentDepartmentName("John").size());
        }
    }
}