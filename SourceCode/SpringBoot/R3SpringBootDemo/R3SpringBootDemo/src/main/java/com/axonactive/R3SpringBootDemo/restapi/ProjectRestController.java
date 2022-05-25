package com.axonactive.R3SpringBootDemo.restapi;

import com.axonactive.R3SpringBootDemo.entity.Project;
import com.axonactive.R3SpringBootDemo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ProjectRestController.PATH)
public class ProjectRestController {
    public static final String PATH = "projects";
    @Autowired
    ProjectService projectService;

    @GetMapping("/list")
    public List<Project> getAllProject(){
        return projectService.getAllProject();
    }

    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable(value = "id") Long id){
        return projectService.findProjectById(id);
    }

    @PostMapping("/add")
    public Project addProject(@RequestBody Project newProject){
        return projectService.saveProject(newProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable(value = "id") Long id,
                                        @RequestBody Project project){
        Project projectToUpdate = projectService.findProjectById(id).
                orElseThrow(() -> new ResourceNotFoundException("Project not found " + id));
        projectToUpdate.setProjectName(project.getProjectName());
        projectToUpdate.setArea(project.getArea());
        projectToUpdate.setDepartment(project.getDepartment());

        return ResponseEntity.ok().body(projectService.saveProject(projectToUpdate));
    }
}
