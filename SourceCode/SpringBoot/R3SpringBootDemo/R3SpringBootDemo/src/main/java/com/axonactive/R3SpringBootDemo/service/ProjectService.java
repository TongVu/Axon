package com.axonactive.R3SpringBootDemo.service;

import com.axonactive.R3SpringBootDemo.entity.Project;

import java.util.List;
import java.util.Optional;


public interface ProjectService {
    List<Project> getAllProject();

    void saveProject(Project project);

    void deleteProjectById(Long id);

    Optional<Project> findProjectById(Long id);

}
