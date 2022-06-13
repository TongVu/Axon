package com.axonactive.companyspringrun2.Service.implement;

import com.axonactive.companyspringrun2.Entities.Assignment;
import com.axonactive.companyspringrun2.Service.AssignmentService;
import com.axonactive.companyspringrun2.Service.DepartmentService;
import com.axonactive.companyspringrun2.Service.EmployeeService;
import com.axonactive.companyspringrun2.Service.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.axonactive.companyspringrun2.Service.implement.DepartmentServiceImplTest.department;
import static com.axonactive.companyspringrun2.Service.implement.EmployeeServiceImplTest.employee1;
import static com.axonactive.companyspringrun2.Service.implement.ProjectServiceImplTest.project;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AssignmentServiceImplTest {

    @Autowired
    AssignmentService assignmentService;

    @Autowired
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    Assignment assignment = Assignment.builder()
            .id(501)
            .numberOfHour(1000)
            .employee(employee1)
            .project(project)
            .build();

    @Test
    void getAllAssignment() {
        assertEquals(0,assignmentService.getAllAssignment().size());
    }

    @Test
    void saveAssignment() {
        departmentService.saveDepartment(department);
        employeeService.saveEmployee(employee1);
        projectService.saveProject(project);
        assignmentService.saveAssignment(assignment);
        assertEquals(assignment,assignmentService.getAllAssignment().get(0));
    }

    @Test
    void deleteAssignment() {
        departmentService.saveDepartment(department);
        employeeService.saveEmployee(employee1);
        projectService.saveProject(project);
        assignmentService.saveAssignment(assignment);
        assignmentService.deleteAssignment(assignment.getId());
        assertEquals(0,assignmentService.getAllAssignment().size());
    }

    @Test
    void findAssignment() {
        departmentService.saveDepartment(department);
        employeeService.saveEmployee(employee1);
        projectService.saveProject(project);
        assignmentService.saveAssignment(assignment);
        assertEquals(assignment,assignmentService.findAssignment(assignment.getId()).get());
    }
}