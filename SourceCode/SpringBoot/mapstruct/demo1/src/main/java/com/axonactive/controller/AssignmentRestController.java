package com.axonactive.controller;


import com.axonactive.demo.entity.Assignment;
import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.exceptions.ResourceNotFound;
import com.axonactive.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/assignment")
public class AssignmentRestController {
    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/list")
    public List<Assignment> getAll() {
        return assignmentService.getAll();
    }

    @GetMapping("/get/id")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFound {
        Assignment assignment = assignmentService.getAssignmentById(id).
                orElseThrow(() -> new ResourceNotFound("Assignment Not Found" + id));
        return ResponseEntity.ok().body(assignment);
    }

    @PostMapping
    public void create(@RequestBody Assignment assignment) {
        assignmentService.saveAssignment(assignment);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Integer Id) throws Exception {
        Assignment assignment = assignmentService.getAssignmentById(Id)
                .orElseThrow(() -> new ResourceNotFound("Assignment not found: " + Id));
        assignmentService.deleteAssignment(Id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
