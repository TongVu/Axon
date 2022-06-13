package com.axonactive.companyspringrun2.Service;

import com.axonactive.companyspringrun2.Entities.Assignment;

import java.util.List;
import java.util.Optional;

public interface AssignmentService {
    List<Assignment> getAllAssignment();

    Assignment saveAssignment(Assignment assignment);

    void deleteAssignment(Integer id);

    Optional<Assignment> findAssignment(Integer id);
}
