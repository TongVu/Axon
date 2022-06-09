package com.axonactive.service;

import com.axonactive.demo.entity.Assignment;
import com.axonactive.demo.entity.DepartmentLocation;

import java.util.List;
import java.util.Optional;

public interface AssignmentService {
    List<Assignment> getAll();
    Optional<Assignment> getAssignmentById(Integer id);
    void saveAssignment(Assignment assignment);
    void deleteAssignment(Integer id);
}
