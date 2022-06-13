package com.axonactive.companyspringrun2.controllers.implement;

import com.axonactive.companyspringrun2.Entities.Employee;
import com.axonactive.companyspringrun2.Entities.Project;
import com.axonactive.companyspringrun2.Service.ProjectService;
import com.axonactive.companyspringrun2.controllers.ProjectController;
import com.axonactive.companyspringrun2.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectControllerImpl implements ProjectController  {

    private final ProjectService projectService;

    @Override
    @GetMapping("/list")
    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

    @Override
    @PostMapping("/Create")
    public Project newProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @Override
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Integer id) throws NotFoundException {
        return projectService.findProject(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    @PutMapping("/update/{id}")
    public Optional<Project> updateProject(@RequestBody Project newProject,@PathVariable Integer id) throws NotFoundException {
        return Optional.ofNullable(projectService.findProject(id)
                .map(project -> {
                    project.setProjectName(newProject.getProjectName());
                    project.setArea(newProject.getArea());
                    project.setDepartment(newProject.getDepartment());
                    return projectService.saveProject(project);
                }).orElseThrow(() -> new NotFoundException(id)));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable Integer id) throws NotFoundException {
        for (Project project:projectService.getAllProject()
        ) {
            if (project.getId().compareTo(id) == 0){
                projectService.deleteProject(id);
                System.out.println("Delete success!");
            }else throw new NotFoundException(id);
        }
    }
}
