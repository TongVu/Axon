package com.axonactive.demo.service;

import com.axonactive.demo.entity.Assignment;
import com.axonactive.demo.entity.Department;

import java.util.List;

public interface AssignmentService {
    List<Assignment> getAll();
}
