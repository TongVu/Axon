package com.axonactive.demo.api;

import com.axonactive.demo.service.EmployeeService;
import com.axonactive.demo.service.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('USER')")
@RestController
@RequestMapping("/api/{deptid}/employees")
@RequiredArgsConstructor
public class EmployeeDepartmentResources {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getEmployeeInADepartment(@PathVariable("deptid") Integer deptid){
        return employeeService.getEmployeeInDepartment(deptid);
    }

}
