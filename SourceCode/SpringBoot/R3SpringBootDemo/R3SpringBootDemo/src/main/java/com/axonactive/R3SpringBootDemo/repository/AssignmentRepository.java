package com.axonactive.R3SpringBootDemo.repository;

import com.axonactive.R3SpringBootDemo.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.Assign;

import java.util.Optional;

public interface AssignmentRepository
        extends JpaRepository<Assignment, Long> {
    Optional<Assignment> findAssignmentByEmployeeEmployeeid(String employeeId);
    Optional<Assignment> findAssignmentByProjectProjectid(Long id);
    Optional<Assignment> findAssignmentByNumberOfHourGreaterThan(int hour);
}
