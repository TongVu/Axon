package com.axonactive.R3SpringBootDemo.service.impl;

import com.axonactive.R3SpringBootDemo.dtoData.ProjectDTO;
import com.axonactive.R3SpringBootDemo.entity.Project;
import com.axonactive.R3SpringBootDemo.repository.ProjectRepository;
import com.axonactive.R3SpringBootDemo.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImp implements ProjectService {

    @Autowired
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
    public void deleteProjectById(Long id) {
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
    public List<Project> findProjectByDepartmentId(Long id) {
        return projectRepository.findProjectByDepartmentId(id);
    }

    @Override
    public List<Project> findProjectByDepartmentDepartmentName(String deptName) {
        return projectRepository.findProjectByDepartmentDepartmentName(deptName);
    }

    @Override
    public List<Project> findProjectByProjectNameLike(String projectName) {
        return projectRepository.findProjectByProjectNameLike(projectName);
    }

    @Override
    public Project toProjectEntity(ProjectDTO projectDTO) {
        return new Project(
                projectDTO.getProjectid(),
                projectDTO.getArea(),
                projectDTO.getProjectName(),
                projectDTO.getDepartment()
        );
    }

    @Override
    public List<Project> toProjectEntity(List<ProjectDTO> projectDTOs){
        List<Project> projectList = new ArrayList<>();
        for (ProjectDTO projectDto : projectDTOs) {
            projectList.add(this.toProjectEntity(projectDto));
        }

        return projectList;
    }

    @Override
    public ProjectDTO toProjectDTO(Project project){
        return new ProjectDTO(
          project.getProjectid(),
          project.getArea(),
          project.getProjectName(),
          project.getDepartment()
        );
    }

    @Override
    public List<ProjectDTO> toProjectDTO(List<Project> projects){
        List<ProjectDTO> projectDTOList = new ArrayList<>();

        for (Project project : projects) {
            projectDTOList.add(this.toProjectDTO(project));
        }

        return projectDTOList;
    }
}
