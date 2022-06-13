package com.axonactive.companyspringrun2.Repositories;

import com.axonactive.companyspringrun2.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
