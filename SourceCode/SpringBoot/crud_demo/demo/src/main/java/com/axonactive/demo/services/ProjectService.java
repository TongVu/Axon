package com.axonactive.demo.services;

import com.axonactive.demo.entities.Department;
import com.axonactive.demo.entities.Project;

import java.util.List;
import java.util.Optional;


public interface ProjectService {
    List<Project> getAllProject();

    void saveProject(Project project);

    void deleteProjectById(Long id);

    Optional<Project> findProjectById(Long id);

}
