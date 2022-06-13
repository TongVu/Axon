package com.axonactive.companyspringrun2.Service;

import com.axonactive.companyspringrun2.Entities.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAllProject();

    Project saveProject(Project project);

    void deleteProject(Integer id);

    Optional<Project> findProject(Integer id);
}
