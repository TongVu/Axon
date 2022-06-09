package com.axonactive.service.impl;

import com.axonactive.demo.entity.Assignment;
import com.axonactive.repository.AssignmentRepository;
import com.axonactive.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private List<Assignment> allAssignment=new ArrayList<>();

    private final AssignmentRepository assignmentRepository;

    @Override
    public List<Assignment> getAll() {
        List<Assignment> allAssignment = assignmentRepository.findAll();
        return allAssignment;
    }

    @Override
    public Optional<Assignment> getAssignmentById(Integer id) {
        return assignmentRepository.findById(id);
    }

    @Override
    public void saveAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
    }

    @Override
    public void deleteAssignment(Integer id) {
        assignmentRepository.deleteById(id);
    }
}
