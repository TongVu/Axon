package com.axonactive.demo.repositories;

import com.axonactive.demo.entities.Employee;
import com.axonactive.demo.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository
        extends JpaRepository<Project, Long> {
}
