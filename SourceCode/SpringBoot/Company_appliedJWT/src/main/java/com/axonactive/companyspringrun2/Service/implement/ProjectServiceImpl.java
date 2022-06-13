package com.axonactive.companyspringrun2.Service.implement;

import com.axonactive.companyspringrun2.Entities.Project;
import com.axonactive.companyspringrun2.Repositories.ProjectRepository;
import com.axonactive.companyspringrun2.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Project saveProject(Project project) {
        projectRepository.save(project);
        return project;
    }

    @Override
    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Optional<Project> findProject(Integer id) {
        return projectRepository.findById(id);
    }
}
