package com.axonactive.R3SpringBootDemo.restapi;

import com.axonactive.R3SpringBootDemo.entity.Assignment;
import com.axonactive.R3SpringBootDemo.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = AssignmentRESTController.PATH)
public class AssignmentRESTController {
    public static final String PATH = "assignments/";
    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/list")
    public List<Assignment> getAllAssignment(){
        return assignmentService.getAll();
    }

    @GetMapping("/list/{id}")
    public Optional<Assignment> getAssignmentById(@PathVariable (value = "id") Long id){
        return assignmentService.findAssignmentById(id);
    }

    @PostMapping("/add")
    public Assignment add(@RequestBody Assignment newAssignment){
        return assignmentService.saveAssignment(newAssignment);
    }

    @DeleteMapping("/deleteAssignment/{id}")
    public Map<String, Boolean> delete(@RequestParam (value = "id") Long id) throws ResourceNotFoundException{
        Assignment assignmentToDeleted = assignmentService.findAssignmentById(id).
                orElseThrow(() -> new ResourceNotFoundException("Assignment not found " + id));

        assignmentService.deleteAssignmentById(id);
        Map<String, Boolean> res = new HashMap<>();
        res.put("Deleted", Boolean.TRUE);
        return res;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Assignment> updateById(@RequestParam (value = "id") Long id,
                                                 @RequestBody Assignment assignment) throws ResourceNotFoundException{
        Assignment assignmentToUpdate = assignmentService.findAssignmentById(id).
                orElseThrow(() -> new ResourceNotFoundException("Assignment not found " + id));

        assignmentToUpdate.setEmployee(assignment.getEmployee());
        assignmentToUpdate.setProject(assignment.getProject());
        assignmentToUpdate.setNumberOfHour(assignment.getNumberOfHour());
        Assignment updatedAssignment = assignmentService.saveAssignment(assignmentToUpdate);

        return ResponseEntity.ok().body(updatedAssignment);
    }

}
