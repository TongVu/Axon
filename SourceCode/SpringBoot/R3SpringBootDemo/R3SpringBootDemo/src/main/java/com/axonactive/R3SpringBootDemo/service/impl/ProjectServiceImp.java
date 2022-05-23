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
    public void saveProject(Project project){
        projectRepository.save(project);
    }

    @Override
    public void deleteProjectById(Long id){
        projectRepository.deleteById(id);
    }

    @Override
    public Optional<Project> findProjectById(Long id) {
        return projectRepository.findById(id);
    }
}