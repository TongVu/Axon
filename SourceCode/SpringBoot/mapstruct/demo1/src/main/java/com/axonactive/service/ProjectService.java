package com.axonactive.service;

import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.demo.entity.Project;
import com.axonactive.service.dto.AreaReportWithProjectAndEmployee;
import com.axonactive.service.dto.ProjectAtVietNameStatisticDto;
import com.axonactive.service.dto.ProjectAtVietnamStaticHasTotalSalaryDto;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAll();
    Optional<Project> getProjectById(Integer id);
    void saveProject(Project project);
    void deleteProject(Integer id);

    List<Project> projectAndTheirDepartment();

    List<ProjectAtVietNameStatisticDto> getAllProjectAtVietnam();

    List<ProjectAtVietnamStaticHasTotalSalaryDto> geAllProjectAtVietnamWithTotalSalary();

    AreaReportWithProjectAndEmployee areaReport(String area);

    List<Project> listProjectInArea(String Area);
}
