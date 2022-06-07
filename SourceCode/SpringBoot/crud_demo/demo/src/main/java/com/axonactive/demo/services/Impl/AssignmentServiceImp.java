package com.axonactive.demo.services.Impl;

import com.axonactive.demo.entities.Assignment;
import com.axonactive.demo.repositories.AssignmentRepository;
import com.axonactive.demo.services.AssignmentService;
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
    public void saveAssignment(Assignment assignment){
        assignmentRepository.save(assignment);
    }

    @Override
    public void deleteAssignmentById(Long id){

        assignmentRepository.deleteById(id);
    }

    @Override
    public Optional<Assignment> findAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }
}
