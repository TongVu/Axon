package com.axonactive.companyspringrun2.Service.implement;

import com.axonactive.companyspringrun2.Entities.Project;
import com.axonactive.companyspringrun2.Service.DepartmentService;
import com.axonactive.companyspringrun2.Service.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.axonactive.companyspringrun2.Service.implement.DepartmentServiceImplTest.department;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProjectServiceImplTest {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    ProjectService projectService;

    public static Project project = Project.builder()
            .id(401)
            .projectName("Phoenix")
            .area("Europe")
            .department(department)
            .build();

    @Test
    void estGetAllProjects_shouldReturnNoDate_whenJustCreateTable() {
        assertEquals(0,projectService.getAllProject().size());
    }

    @Test
    void testSaveProject_shouldReturnTheNewProject_WhenCreateTableAndAddOneNewProject() {
        departmentService.saveDepartment(department);
        projectService.saveProject(project);
        assertEquals(project,projectService.getAllProject().get(0));
    }

    @Test
    void testDeleteProject_ShouldReturnNoData_whenCreateTableAddAndDeleteOneProject() {
        departmentService.saveDepartment(department);
        projectService.saveProject(project);
        projectService.deleteProject(project.getId());
        assertEquals(0,projectService.getAllProject().size());

    }

    @Test
    void testFindProject_ShouldReturnTheProject_whenFindById() {
        departmentService.saveDepartment(department);
        projectService.saveProject(project);
        assertEquals(project,projectService.findProject(project.getId()).get());
    }
}