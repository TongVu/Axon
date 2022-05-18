package com.axonactive.demo.repositories;

import com.axonactive.demo.entities.Assignment;
import com.axonactive.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<Department, Long> {
}
