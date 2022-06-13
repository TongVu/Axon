package com.axonactive.companyspringrun2.controllers.implement;

import com.axonactive.companyspringrun2.Entities.Assignment;
import com.axonactive.companyspringrun2.Service.AssignmentService;
import com.axonactive.companyspringrun2.controllers.AssignmentController;
import com.axonactive.companyspringrun2.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignment")
public class AssignmentControllerImpl implements AssignmentController {

    private final AssignmentService assignmentService;

    @Override
    @GetMapping("/list")
    public List<Assignment> getAllAssignment() {
        return assignmentService.getAllAssignment();
    }

    @Override
    @PostMapping("/create")
    public Assignment saveAssignment(@RequestBody Assignment assignment) {
        return assignmentService.saveAssignment(assignment);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteAssignment(@PathVariable Integer id) throws NotFoundException {
        for (Assignment assignment:assignmentService.getAllAssignment()
        ) {
            if (assignment.getId().compareTo(id) == 0){
                assignmentService.deleteAssignment(id);
                System.out.println("Delete success!");
            }else throw new NotFoundException(id);
        }
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Assignment> findAssignment(@PathVariable Integer id) throws NotFoundException {
        return Optional.ofNullable(assignmentService.findAssignment(id)
                .orElseThrow(() -> new NotFoundException(id)));
    }

    @Override
    @PutMapping("/update/{id}")
    public Assignment updateAssignment(@RequestBody Assignment newAssignment,@PathVariable Integer id) throws NotFoundException {
        return assignmentService.findAssignment(id)
                .map(assignment -> {
                    assignment.setNumberOfHour(newAssignment.getNumberOfHour());
                    assignment.setEmployee(newAssignment.getEmployee());
                    assignment.setProject(newAssignment.getProject());
                    return assignmentService.saveAssignment(assignment);
                }).orElseThrow(() -> new NotFoundException(id));
    }


}
