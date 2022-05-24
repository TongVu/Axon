package com.axonactive.R3SpringBootDemo.service;

import com.axonactive.R3SpringBootDemo.entity.Project;

import java.util.List;
import java.util.Optional;


public interface ProjectService {
    List<Project> getAllProject();

    void saveProject(Project project);

    void deleteProjectById(Long id);

    Optional<Project> findProjectById(Long id);

    List<Project> findProjectByProjectName(String name);

    List<Project> findProjectByDepartmentId(Long id);
    List<Project> findProjectByDepartmentDepartmentName(String deptName);
    List<Project> findProjectByProjectNameLike(String projectName);
}
