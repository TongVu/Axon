package com.axonactive.R3SpringBootDemo.restController.DTORestController;

import com.axonactive.R3SpringBootDemo.dtoData.AssignmentDTO;
import com.axonactive.R3SpringBootDemo.entity.Assignment;
import com.axonactive.R3SpringBootDemo.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(AssignmentDTORestController.PATH)
public class AssignmentDTORestController {
    public static final String PATH = "/assignment";

    @Autowired
    AssignmentService assignmentService;

    @GetMapping("")
    public List<AssignmentDTO> getAssignmentDTOs(){
        return assignmentService.toAssignmentDTO(assignmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignmentDTO> getAssignmentDTOById(@PathVariable(value = "id") Long id) throws Exception{
        Assignment assignment = assignmentService.findAssignmentById(id).
                orElseThrow(() -> new ResourceNotFoundException("Assignment not found " + id));

        return ResponseEntity.ok().body(assignmentService.toAssignmentDTO(assignment));
    }

    @PostMapping("/add")
    public Assignment add(@RequestBody AssignmentDTO assignmentDTO){
        return assignmentService.saveAssignment(assignmentService.toAssignmentEntity(assignmentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignmentDTO> update(@PathVariable(value = "id") Long id,
                                                @RequestBody AssignmentDTO assignmentDTO) throws Exception{
        Assignment assignment = assignmentService.findAssignmentById(id).
                orElseThrow(() -> new ResourceNotFoundException("Assigment not found " + id));
        assignment.setEmployee(assignmentDTO.getEmployee());
        assignment.setProject(assignmentDTO.getProject());
        assignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        Assignment updatedAssignment = assignmentService.saveAssignment(assignment);

        return ResponseEntity.ok().body(assignmentService.toAssignmentDTO(updatedAssignment));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id")Long id){
        Assignment assignment = assignmentService.findAssignmentById(id).
                orElseThrow(() -> new ResourceNotFoundException("Assignment not found " + id));
        Map<String, Boolean> response = new HashMap<>();

        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
