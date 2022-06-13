package com.axonactive.companyspringrun2.controllers;

import com.axonactive.companyspringrun2.Entities.Assignment;
import com.axonactive.companyspringrun2.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface AssignmentController {
    List<Assignment> getAllAssignment();

    Assignment saveAssignment(Assignment assignment);

    void deleteAssignment(Integer id) throws NotFoundException;

    Optional<Assignment> findAssignment(Integer id) throws NotFoundException;

    Assignment updateAssignment(Assignment newAssignment,Integer id) throws NotFoundException;
}
