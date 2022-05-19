package com.axonactive.demo.ffsfsadfsafe;

import com.axonactive.demo.entities.Assignment;
import com.axonactive.demo.services.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/assignments")

public class AssignmentRESTController {

    private final AssignmentService assignmentService;

    @GetMapping("/list")
    public List<Assignment> getAll(){
        return assignmentService.getAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Assignment> getAssignmentById(long id){
        return assignmentService.findAssignmentById(id);
    }

    @PostMapping("/add")
    public Assignment create(@RequestBody Assignment assignment) {
        assignmentService.saveAssignment(assignment);

        return assignment;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") long id) throws Exception {
       Assignment assignment = assignmentService.findAssignmentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        assignmentService.deleteAssignmentById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
