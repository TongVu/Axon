package com.axonactive.demo.api;

import antlr.collections.List;
import com.axonactive.demo.entity.Department;
import com.axonactive.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentResources {
    private final DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartment(){
        List<Department> aLlDepartment = departmentService.getALl();
        return aLlDepartment;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
