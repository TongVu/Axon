package com.axonactive.R3SpringBootDemo.service.impl;

import com.axonactive.R3SpringBootDemo.entity.Project;
import com.axonactive.R3SpringBootDemo.repository.ProjectRepository;
import com.axonactive.R3SpringBootDemo.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private final ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProject(){
        return projectRepository.findAll();
    }

    @Override
    public Project saveProject(Project project){
        projectRepository.save(project);
        return project;
    }

    @Override
    public void deleteProjectById(Long id){
        projectRepository.deleteById(id);
    }

    @Override
    public Optional<Project> findProjectById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> findProjectByProjectName(String name) {
        return projectRepository.findProjectByProjectName(name);
    }
    @Override
    public List<Project> findProjectByDepartmentId(Long id){
        return projectRepository.findProjectByDepartmentId(id);
    }

    @Override
    public List<Project> findProjectByDepartmentDepartmentName(String deptName){
        return projectRepository.findProjectByDepartmentDepartmentName(deptName);
    }
    @Override
    public List<Project> findProjectByProjectNameLike(String projectName){
        return projectRepository.findProjectByProjectNameLike(projectName);
    }
}
