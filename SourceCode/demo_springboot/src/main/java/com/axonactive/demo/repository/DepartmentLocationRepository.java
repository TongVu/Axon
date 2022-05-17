package com.axonactive.demo.repository;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.entity.DepartmentLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentLocationRepository extends JpaRepository<DepartmentLocation, Integer> {
}
