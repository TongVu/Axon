package com.axonactive.controller;


import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.demo.entity.Project;
import com.axonactive.exceptions.ResourceNotFound;
import com.axonactive.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin
@RequestMapping("/api/project")
public class ProjectRestController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/list")
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/get/id")
    public ResponseEntity<Project> getProjectById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFound {
        Project project = projectService.getProjectById(id).
                orElseThrow(() -> new ResourceNotFound("Project Not Found" + id));
        return ResponseEntity.ok().body(project);
    }

    @PostMapping("/add")
    public void create(@RequestBody Project project) {
        projectService.saveProject(project);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Integer Id) throws Exception {
        Project project = projectService.getProjectById(Id)
                .orElseThrow(() -> new ResourceNotFound("Project not found: " + Id));
        projectService.deleteProject(Id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
