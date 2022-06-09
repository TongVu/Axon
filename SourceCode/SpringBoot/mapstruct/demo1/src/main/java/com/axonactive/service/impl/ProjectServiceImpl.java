package com.axonactive.service.impl;

import com.axonactive.demo.entity.Assignment;
import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.entity.Project;
import com.axonactive.repository.ProjectRepository;
import com.axonactive.service.AssignmentService;
import com.axonactive.service.DepartmentService;
import com.axonactive.service.EmployeeService;
import com.axonactive.service.ProjectService;
import com.axonactive.service.dto.AreaReportWithProjectAndEmployee;
import com.axonactive.service.dto.ProjectAtVietNameStatisticDto;
import com.axonactive.service.dto.ProjectAtVietnamStaticHasTotalSalaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final DepartmentService departmentService;
    private final AssignmentService assignmentService;
    private final EmployeeService employeeService;

    @Override
    public List<Project> getAll() {
        List<Project> allProject = projectRepository.findAll();
        return allProject;
    }

    @Override
    public Optional<Project> getProjectById(Integer id) {
        return projectRepository.findById(id);
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> projectAndTheirDepartment() {

        return projectRepository.findAll().stream()
                .filter(
                        p -> {
                            departmentService.getAll().stream()
                                    .filter(d -> d.getDepartmentId() == p.getDepartment().getDepartmentId())
                                    .toList();
                            return true;
                        }
                ).toList();

    }

    @Override
    public List<ProjectAtVietNameStatisticDto> getAllProjectAtVietnam() {
        return projectRepository.findAll()
                .stream()
                .map(p -> new ProjectAtVietNameStatisticDto(
                        p.getProjectId(),
                        p.getProjectName(),

                        assignmentService.getAll()
                                .stream()
                                .filter(a -> a.getProject().getProjectId() == p.getProjectId())
                                .toList()
                                .size(),

                        assignmentService.getAll()
                                .stream()
                                .filter(a -> a.getProject().getProjectId() == p.getProjectId())
                                .map(Assignment::getNumberOfHour)
                                .reduce(0, (total, a) -> total += a)
                ))
                .toList();
    }

    @Override
    public List<ProjectAtVietnamStaticHasTotalSalaryDto> geAllProjectAtVietnamWithTotalSalary() {
        return projectRepository.findAll()
                .stream()
                .map(p -> new ProjectAtVietnamStaticHasTotalSalaryDto(

                                p.getProjectId(),

                                p.getProjectName(),

                                assignmentService.getAll()
                                        .stream()
                                        .filter(a -> a.getProject().getProjectId() == p.getProjectId())
                                        .map(Assignment::getNumberOfHour)
                                        .reduce(0, (total, a) -> total += a),

                                assignmentService.getAll()
                                        .stream()
                                        .filter(a -> a.getProject().getProjectId() == p.getProjectId())
                                        .map(Assignment::getEmployee)
                                        .map(Employee::getSalary)
                                        .reduce(0, (total, a) -> total += a)
                        )

                )
                .toList();

    }

    @Override
    public AreaReportWithProjectAndEmployee areaReport(String area) {


//        return AreaReportWithProjectAndEmployee(
//                listProjectInArea(area),
//                listProjectInArea(area)
//                        .stream()
//                        .reduce()
        return projectRepository.findAll()
                .stream()

                .map(()->new AreaReportWithProjectAndEmployee(
                        projectRepository.findAll()
                                .stream()
                                .filter(p -> p.getArea().equalsIgnoreCase(area))
                                .toList(),
                        projectRepository.findAll()
                                .stream()
                                .filter(p -> p.getArea().equalsIgnoreCase(area))
                                .map(p-> getTotalHourForEachProject(p))
                                .reduce(0, (total, a) -> total += a),

                        projectRepository.findAll()
                                .stream()
                                .filter(p -> p.getArea().equalsIgnoreCase(area))
                                .map(p-> getTotalEmployees(p))
                                .count()
                ));





    }

    @Override
    public List<Project> listProjectInArea(String Area) {
        return projectRepository.findAll()
                .stream()
                .filter(p -> p.getArea().equalsIgnoreCase(Area))
                .toList();
    }

    private int getTotalHourForEachProject(Project project) {
        return assignmentService.getAll()
                .stream()
                .filter(a -> a.getProject().getProjectId() == project.getProjectId())
                .map(Assignment::getNumberOfHour)
                .reduce(0, (total, a) -> total += a);

    }
    private double getTotalEmployees(Project project) {
        return assignmentService.getAll()
                .stream()
                .filter(a -> a.getProject().getProjectId() == project.getProjectId())
                .map(Assignment::getEmployee)
                .map(Employee::getSalary)
                .count();

    }
}
