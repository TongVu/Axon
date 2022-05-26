package com.axonactive.R3SpringBootDemo.service.impl;

import com.axonactive.R3SpringBootDemo.dtoData.AssignmentDTO;
import com.axonactive.R3SpringBootDemo.entity.Assignment;
import com.axonactive.R3SpringBootDemo.repository.AssignmentRepository;
import com.axonactive.R3SpringBootDemo.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImp implements AssignmentService {

    @Autowired
    private final AssignmentRepository assignmentRepository;

    @Override
    public List<Assignment> getAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment saveAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
        return assignment;
    }

    @Override
    public void deleteAssignmentById(Long id) {
        assignmentRepository.deleteById(id);
    }

    @Override
    public Optional<Assignment> findAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    @Override
    public Optional<Assignment> findAssignmentByEmployeeEmployeeid(String id) {
        return assignmentRepository.findAssignmentByEmployeeEmployeeid(id);
    }

    @Override
    public Optional<Assignment> findAssignmentByProjectProjectid(Long id) {
        return assignmentRepository.findAssignmentByProjectProjectid(id);
    }

    @Override
    public Optional<Assignment> findAssignmentByNumberOfHourGreaterThan(int hour) {
        return assignmentRepository.findAssignmentByNumberOfHourGreaterThan(hour);
    }

    @Override
    public Assignment toAssignmentEntity(AssignmentDTO assignmentDTO) {
        return new Assignment(
                assignmentDTO.getId(),
                assignmentDTO.getNumberOfHour(),
                assignmentDTO.getEmployee(),
                assignmentDTO.getProject()
        );
    }

    @Override
    public List<Assignment> toAssignmentEntity(List<AssignmentDTO> assignmentDTOList) {
        List<Assignment> assignmentList = new ArrayList<>();
        for (AssignmentDTO assignmentDto : assignmentDTOList) {
            assignmentList.add(this.toAssignmentEntity(assignmentDto));
        }

        return assignmentList;
    }

    @Override
    public AssignmentDTO toAssignmentDTO(Assignment assignment) {
        return new AssignmentDTO(
                assignment.getId(),
                assignment.getNumberOfHour(),
                assignment.getEmployee(),
                assignment.getProject()
        );
    }

    @Override
    public List<AssignmentDTO> toAssignmentDTO(List<Assignment> assignmentList){
        List<AssignmentDTO> assignmentDTOList = new ArrayList<>();
        for (Assignment assignment : assignmentList)
            assignmentDTOList.add(this.toAssignmentDTO(assignment));

        return assignmentDTOList;
    }

}
