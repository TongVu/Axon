package com.axonactive.R3SpringBootDemo.service;


import com.axonactive.R3SpringBootDemo.entity.Assignment;

import java.util.List;
import java.util.Optional;

public interface AssignmentService {
    List<Assignment> getAll();

    Assignment saveAssignment(Assignment assignment);

    void deleteAssignmentById(Long id);

    Optional<Assignment> findAssignmentById(Long id);

    Optional<Assignment> findAssignmentByEmployeeEmployeeid(String emplyeeId);
    Optional<Assignment> findAssignmentByProjectProjectid(Long id);
    Optional<Assignment> findAssignmentByNumberOfHourGreaterThan(int hour);
}
