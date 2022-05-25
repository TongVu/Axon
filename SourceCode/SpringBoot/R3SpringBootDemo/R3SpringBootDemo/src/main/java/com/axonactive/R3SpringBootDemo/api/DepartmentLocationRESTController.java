package com.axonactive.R3SpringBootDemo.api;

import com.axonactive.R3SpringBootDemo.entity.DepartmentLocation;
import com.axonactive.R3SpringBootDemo.service.DepartmentLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = DepartmentLocationRESTController.PATH )
public class DepartmentLocationRESTController {
    public static final String PATH = "/api/departmentlocation";
    private final DepartmentLocationService departmentLocationService;

    @GetMapping("/get")
    public List<DepartmentLocation> getAll(){
        return departmentLocationService.getAllDepartmentLocation();
    }

    @PostMapping("/add")
    public DepartmentLocation create(@RequestBody DepartmentLocation newDepartmentLocation){
        return departmentLocationService.saveDepartmentLocation(newDepartmentLocation);
    }
}
