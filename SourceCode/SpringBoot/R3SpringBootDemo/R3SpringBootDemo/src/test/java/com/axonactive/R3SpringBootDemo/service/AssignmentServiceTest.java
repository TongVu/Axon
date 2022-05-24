package com.axonactive.R3SpringBootDemo.service;

import com.axonactive.R3SpringBootDemo.entity.Assignment;
import com.axonactive.R3SpringBootDemo.entity.Department;
import com.axonactive.R3SpringBootDemo.entity.Employee;
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

@SpringBootTest
@RequiredArgsConstructor
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AssignmentServiceTest {

    @Autowired
    AssignmentService assignmentService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ProjectService projectService;

    @Autowired
    DepartmentService departmentService;

    private Department department;
    private Project project;
    private Employee employee;
    private Assignment assignment;

    @Test
    void getAllAssignment_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, assignmentService.getAll().size());
    }


    @Nested
    class afterSave{

        @Autowired
        AssignmentService assignmentService;

        @Autowired
        EmployeeService employeeService;

        @Autowired
        ProjectService projectService;

        @Autowired
        DepartmentService departmentService;

        private Department department;
        private Project project;
        private Employee employee;
        private Assignment assignment;

        @BeforeEach
        void setup() {
            department = Department.builder()
                    .departmentName("Hr")
                    .startDate(LocalDate.of(2003, 05, 15))
                    .build();
            departmentService.saveDepartment(department);

            project = Project.builder()
                    .area("Melbourne")
                    .projectName("FROM NON-IT TO TEAM LEADER")
                    .department(department)
                    .build();
            projectService.saveProject(project);

            employee = Employee.builder()
                    .gender("Male")
                    .employeeid("10101")
                    .dateOfBirth(LocalDate.of(1995, 04, 24))
                    .firstName("Tong")
                    .gender("Male")
                    .middleName(" ")
                    .lastName("Vu")
                    .salary(2400)
                    .department(department)
                    .build();
            employeeService.saveEmployee(employee);

            assignment = Assignment.builder()
                    .project(project)
                    .employee(employee)
                    .numberOfHour(2000)
                    .build();
            assignmentService.saveAssignment(assignment);
        }
        @Test
        void getAllAssignment_shouldReturnData_whenTableHasData() {
            assignmentService.saveAssignment(assignment);

            assertEquals(1, assignmentService.getAll().size());
        }

        @Test
        void saveAssignment_shouldInsertDataToTable_whenGivenAssignmentInstance() {
            assignmentService.saveAssignment(assignment);

            assertEquals(1, assignmentService.getAll().size());
        }


        @Test
        void deleteAssignment_shouldReturnZero_whenTableDeletedGivenId() {
            assignmentService.saveAssignment(assignment);
            assignmentService.deleteAssignmentById(employee.getId());

            assertEquals(0, assignmentService.getAll().size());
        }

        @Test
        void findAssignment_shouldReturnNull_whenGivenIdNotFounded() {
            assignmentService.saveAssignment(assignment);
            assignmentService.deleteAssignmentById(employee.getId());

            assertEquals(Optional.empty(), assignmentService.findAssignmentById(employee.getId()));
        }

        @Test
        void findAssignmentByEmployeeEmployeeId_shouldReturnNoData_whenNotFound(){
            assertEquals(Optional.empty(), assignmentService.findAssignmentByEmployeeEmployeeid("1245"));
        }

        @Test
        void findAssignmentByEmployeeEmployeeId_shouldReturnData_whenFound(){
            assertEquals(employee.getEmployeeid(),
                    assignmentService.findAssignmentByEmployeeEmployeeid("10101").get().getEmployee().getEmployeeid());
        }

        @Test
        void findAssignmentByProjectProjectid_shouldReturnData_whenFound(){
            assertEquals(project.getProjectid(),
                    assignmentService.findAssignmentByProjectProjectid(project.getProjectid()).get().getProject().getProjectid());
        }

        @Test
        void findAssignmentByProjectProjectid_shouldReturnNoData_whenNotFound(){
            assertEquals(Optional.empty(),
                    assignmentService.findAssignmentByProjectProjectid(1234L));
        }
        @Test
        void findAssignmentByNumberOfHour_shouldReturnData_whenFound(){
            assertEquals(assignment.getId(),
                    assignmentService.findAssignmentByNumberOfHourGreaterThan(1000).get().getId());
        }

        @Test
        void findAssignmentByNumberOfHour_shouldReturnNoData_whenNotFound(){
            assertEquals(Optional.empty(),
                    assignmentService.findAssignmentByNumberOfHourGreaterThan(5000));
        }
    }
}