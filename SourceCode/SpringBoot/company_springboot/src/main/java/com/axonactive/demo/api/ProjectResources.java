package com.axonactive.demo.api;

import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.demo.entity.Project;
import com.axonactive.demo.service.DepartmentLocationService;
import com.axonactive.demo.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectResources {
    private final ProjectService projectService;

    @GetMapping("/project")
    public List<Project> getAllProject(){
        List<Project> allProject = projectService.getAll();
        return allProject;
    }
}
