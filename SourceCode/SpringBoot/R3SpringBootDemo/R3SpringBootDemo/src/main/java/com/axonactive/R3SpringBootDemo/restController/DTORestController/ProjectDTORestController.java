package com.axonactive.R3SpringBootDemo.restController.DTORestController;

import com.axonactive.R3SpringBootDemo.dtoData.ProjectDTO;
import com.axonactive.R3SpringBootDemo.entity.Project;
import com.axonactive.R3SpringBootDemo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(ProjectDTORestController.PATH)
public class ProjectDTORestController {
    public static final String PATH = "/project";

    @Autowired
    ProjectService projectService;

    @GetMapping("")
    public List<ProjectDTO> getAllProjectDTO(){
        return projectService.toProjectDTO(projectService.getAllProject());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectDTOById(@PathVariable(value = "id") Long id) throws Exception{
        Project project = projectService.findProjectById(id).
                orElseThrow(() -> new ResourceNotFoundException("Project not found " + id));
        return ResponseEntity.ok().body(projectService.toProjectDTO(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> update(@PathVariable(value = "id")Long id,
                                             @RequestBody ProjectDTO projectDTO){
        Project project = projectService.findProjectById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found " + id));
        project.setProjectName(projectDTO.getProjectName());
        project.setDepartment(projectDTO.getDepartment());
        Project updatedProject = projectService.saveProject(project);

        return ResponseEntity.ok().body(projectService.toProjectDTO(updatedProject));
    }

    @PostMapping("/add")
    public Project add(@RequestBody ProjectDTO projectDTO){
        return projectService.saveProject(projectService.toProjectEntity(projectDTO));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id")Long id) {
        Project project = projectService.findProjectById(id).
                orElseThrow(() -> new ResourceNotFoundException("Project not found " + id));
        projectService.deleteProjectById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
