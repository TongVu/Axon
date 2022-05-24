package com.axonactive.R3SpringBootDemo.repository;

import com.axonactive.R3SpringBootDemo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository
        extends JpaRepository<Project, Long> {
    List<Project> findProjectByProjectName(String name);
    List<Project> findProjectByDepartmentId(Long id);
    List<Project> findProjectByDepartmentDepartmentName(String deptName);
    List<Project> findProjectByProjectNameLike(String projectName);
}
