package com.axonactive.companyspringrun2.controllers.implement;

import com.axonactive.companyspringrun2.Entities.Department;
import com.axonactive.companyspringrun2.Service.DepartmentService;
import com.axonactive.companyspringrun2.Service.security.JwtAuthenticationService;
import com.axonactive.companyspringrun2.controllers.DepartmentController;
import com.axonactive.companyspringrun2.exception.NotFoundException;
import com.axonactive.companyspringrun2.exception.UnauthorizedAccessException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentControllerImpl implements DepartmentController {

    private final JwtAuthenticationService authenticationService;
    private final DepartmentService departmentService;

    @Override
    @GetMapping("/list")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @Override
    @PostMapping("/create")
    public Department newDepartment(@RequestHeader("Authorization") String authorization,
                                    @RequestBody Department department) throws UnauthorizedAccessException {
        authenticationService.checkAuthorizedToken(authorization);
         return departmentService.saveDepartment(department);
    }

    @Override
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Integer id) throws NotFoundException {
        return departmentService.findDepartment(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    @PutMapping("/update/{id}")
    public Department updateDepartment(@RequestBody Department newDepartment, @PathVariable Integer id) throws NotFoundException {
        return departmentService.findDepartment(id)
                .map(department -> {
                    department.setDepartmentName(newDepartment.getDepartmentName());
                    department.setStartDate(newDepartment.getStartDate());
                    return departmentService.saveDepartment(department);
                })
                .orElseThrow(() -> new NotFoundException(id));

    }

    @Override
    @DeleteMapping("/delete/{id}")
     public void deleteDepartment(@PathVariable Integer id){

    }
}
