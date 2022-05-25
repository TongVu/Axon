package com.axonactive.R3SpringBootDemo.restapi;

import com.axonactive.R3SpringBootDemo.entity.DepartmentLocation;
import com.axonactive.R3SpringBootDemo.service.DepartmentLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(DepartmentLocationRESTController.PATH)
public class DepartmentLocationRESTController {
    public static final String PATH = "departmentslocations";

    @Autowired
    DepartmentLocationService departmentLocationService;

    @GetMapping("/list")
    public List<DepartmentLocation> getAllDepartmentLocation(){
        return departmentLocationService.getAllDepartmentLocation();
    }

    @GetMapping("/list/{id}")
    public Optional<DepartmentLocation> getDepartmentLocationById(@PathVariable(value = "id") Long id){
        return departmentLocationService.findDepartmentLocationById(id);
    }

    @PostMapping("/add")
    public DepartmentLocation addDepartmentLocation(@RequestBody DepartmentLocation newDepartmentlocation) {
        return departmentLocationService.saveDepartmentLocation(newDepartmentlocation);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<DepartmentLocation> updateDepartmentLocation(@PathVariable(value = "id") Long id,
                                                   @RequestBody DepartmentLocation departmentLocation)
    throws Exception{
        DepartmentLocation departmentLocationToUpdate =
                departmentLocationService.findDepartmentLocationById(id).
                orElseThrow(() -> new ResourceNotFoundException("department location id not found"));
        departmentLocationToUpdate.setDepartment(departmentLocation.getDepartment());
        departmentLocationToUpdate.setLocation(departmentLocation.getLocation());
        DepartmentLocation updatedDeptLoc = departmentLocationService.saveDepartmentLocation(departmentLocationToUpdate);

        return ResponseEntity.ok().body(updatedDeptLoc);
    }

    @DeleteMapping("delete/{id}")
    public Map<String, Boolean> deleteDepartmentLocation(@PathVariable(value = "id") Long id,
                                                         @RequestBody DepartmentLocation departmentLocation){
        DepartmentLocation departmentLocationToDel =
                departmentLocationService.findDepartmentLocationById(id).
                        orElseThrow(() -> new ResourceNotFoundException("Department Location id not foun"));

        departmentLocationService.deleteDepartmentLocation(departmentLocationToDel.getId());
        Map<String, Boolean> res = new HashMap<>();
        res.put("Deleted", Boolean.TRUE);

        return res;
    }
}
