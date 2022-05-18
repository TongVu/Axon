package com.axonactive.demo.repositories;

import com.axonactive.demo.entities.Department;
import com.axonactive.demo.entities.DepartmentLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentLocationRepository
        extends JpaRepository<DepartmentLocation, Long> {
}
