package com.axonactive.demo.service.impl;

import com.axonactive.demo.entity.Project;
import com.axonactive.demo.repository.ProjectRepository;
import com.axonactive.demo.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public List<Project> getAll(){
        return projectRepository.findAll();
    }
}
