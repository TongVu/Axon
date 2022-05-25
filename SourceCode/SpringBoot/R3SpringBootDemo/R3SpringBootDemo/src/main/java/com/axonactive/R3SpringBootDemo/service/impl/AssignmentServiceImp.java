package com.axonactive.R3SpringBootDemo.service.impl;

import com.axonactive.R3SpringBootDemo.entity.Assignment;
import com.axonactive.R3SpringBootDemo.repository.AssignmentRepository;
import com.axonactive.R3SpringBootDemo.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImp implements AssignmentService {

    @Autowired
    private final AssignmentRepository assignmentRepository;

    @Override
    public List<Assignment> getAll(){
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment saveAssignment(Assignment assignment){
        assignmentRepository.save(assignment);
        return assignment;
    }

    @Override
    public void deleteAssignmentById(Long id){
        assignmentRepository.deleteById(id);
    }

    @Override
    public Optional<Assignment> findAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    @Override
    public Optional<Assignment> findAssignmentByEmployeeEmployeeid(String id){
        return assignmentRepository.findAssignmentByEmployeeEmployeeid(id);
    }

    @Override
    public Optional<Assignment> findAssignmentByProjectProjectid(Long id){
        return assignmentRepository.findAssignmentByProjectProjectid(id);
    }

    @Override
    public Optional<Assignment> findAssignmentByNumberOfHourGreaterThan(int hour){
        return assignmentRepository.findAssignmentByNumberOfHourGreaterThan(hour);
    }

}
