package com.axonactive.demo.repository;

import com.axonactive.demo.entity.Assignment;
import com.axonactive.demo.entity.Relative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
}
