package com.axonactive.R3SpringBootDemo.repository;

import com.axonactive.R3SpringBootDemo.entity.DepartmentLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentLocationRepository
        extends JpaRepository<DepartmentLocation, Long> {
}
