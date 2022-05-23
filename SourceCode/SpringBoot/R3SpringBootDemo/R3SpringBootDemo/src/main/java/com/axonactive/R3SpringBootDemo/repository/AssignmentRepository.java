package com.axonactive.R3SpringBootDemo.repository;

import com.axonactive.R3SpringBootDemo.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository
        extends JpaRepository<Assignment, Long> {
}
