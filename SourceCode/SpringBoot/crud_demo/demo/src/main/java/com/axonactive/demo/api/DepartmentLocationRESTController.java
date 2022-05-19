package com.axonactive.demo.ffsfsadfsafe;

import com.axonactive.demo.entities.DepartmentLocation;
import com.axonactive.demo.services.DepartmentLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departmentlocation")

public class DepartmentLocationRESTController {

    private final DepartmentLocationService departmentLocationService;

    @GetMapping("/list")
    public List<DepartmentLocation> getAll(){
        return departmentLocationService.getAllDepartmentLocation();
    }

    @GetMapping("/get/{id}")
    public Optional<DepartmentLocation> getDepartmentLocationById(long id){
        return departmentLocationService.findDepartmentLocationById(id);
    }

    @PostMapping("/add")
    public DepartmentLocation create(@RequestBody DepartmentLocation departmentLocation) {
        departmentLocationService.saveDepartmentLocation(departmentLocation);

        return departmentLocation;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") long id) throws Exception {
       DepartmentLocation departmentLocation = departmentLocationService.findDepartmentLocationById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found: " + id));
        departmentLocationService.deleteDepartmentLocation(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
