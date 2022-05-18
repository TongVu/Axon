package com.axonactive.demo.services;

import com.axonactive.demo.entities.Assignment;

import java.util.List;
import java.util.Optional;

public interface AssignmentService {
    List<Assignment> getAll();

    void saveAssignment(Assignment assignment);

    void deleteAssignmentById(Long id);

    Optional<Assignment> findAssignmentById(Long id);

}
