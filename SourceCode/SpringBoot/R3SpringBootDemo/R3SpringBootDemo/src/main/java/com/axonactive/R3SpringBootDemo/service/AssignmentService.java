package com.axonactive.R3SpringBootDemo.service;


import com.axonactive.R3SpringBootDemo.entity.Assignment;

import java.util.List;
import java.util.Optional;

public interface AssignmentService {
    List<Assignment> getAll();

    void saveAssignment(Assignment assignment);

    void deleteAssignmentById(Long id);

    Optional<Assignment> findAssignmentById(Long id);

}
