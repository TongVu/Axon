package com.axonactive.repository;

import com.axonactive.demo.entity.Location;
import com.axonactive.demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
    List<Project> findByDepartmentDepartmentLocation(Location location);

    List<Project> findByProjectIdBetween(Integer min,Integer max);

    List<Project> findByAreaLike(Location location);

    List<Project> findByProjectNameLike(String name);

    List<Project> findByDepartmentDepartmentId(Integer id);

    List<Project> findByDepartmentDepartmentNameLike(String name);

    List<Project> findByDepartmentStartDateAfter(LocalDate date);

    List<Project> findByDepartmentStartDateBefore(LocalDate date);

    List<Project> findAllByOrderByProjectId();

    List<Project> findAllByOrderByProjectName();



}
