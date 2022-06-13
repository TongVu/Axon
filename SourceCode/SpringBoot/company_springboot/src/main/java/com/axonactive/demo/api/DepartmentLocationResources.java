package com.axonactive.demo.api;

import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.service.DepartmentLocationService;
import com.axonactive.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentLocationResources {
    private final DepartmentLocationService departmentLocationService;

    @GetMapping("/departmentlocation")
    public List<DepartmentLocation> getAllDepartmentLocation(){
        List<DepartmentLocation> allDepartmentLocation = departmentLocationService.getAll();
        return allDepartmentLocation;
    }
}
