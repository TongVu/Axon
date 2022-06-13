package com.axonactive.companyspringrun2.controllers;

import com.axonactive.companyspringrun2.Entities.Project;
import com.axonactive.companyspringrun2.exception.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ProjectController {
    List<Project> getAllProject();
    Project newProject(@RequestBody Project Project);
    Project getProjectById(@PathVariable Integer id) throws NotFoundException;

    Optional<Project> updateProject(@RequestBody Project newDepartment,@PathVariable Integer id) throws NotFoundException;
    void deleteProject(@PathVariable Integer id) throws NotFoundException;
}
