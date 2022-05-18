package com.axonactive.demo.restcontrollers;

import com.axonactive.demo.services.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/assigments")
public class AssignmentRESTController {
    private final AssignmentService assignmentService;
}
