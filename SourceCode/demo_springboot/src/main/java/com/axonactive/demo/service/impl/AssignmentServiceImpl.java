package com.axonactive.demo.service.impl;

import com.axonactive.demo.entity.Assignment;
import com.axonactive.demo.repository.AssignmentRepository;
import com.axonactive.demo.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService{
    private final AssignmentRepository assignmentRepository;

    @Override
    public List<Assignment> getAll(){
        return assignmentRepository.findAll();
    }
}
