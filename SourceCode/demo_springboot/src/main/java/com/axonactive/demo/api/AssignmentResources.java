package com.axonactive.demo.api;

import com.axonactive.demo.entity.Assignment;
import com.axonactive.demo.entity.Department;
import com.axonactive.demo.service.AssignmentService;
import com.axonactive.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignmentResources {
    private final AssignmentService assignmentService;

    @GetMapping("/assignment")
    public List<Assignment> getAllAssignment(){
        List<Assignment> allAssignment = assignmentService.getAll();
        return allAssignment;
    }
}
