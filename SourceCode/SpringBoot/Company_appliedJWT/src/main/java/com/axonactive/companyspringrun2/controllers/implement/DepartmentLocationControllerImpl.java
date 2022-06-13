package com.axonactive.companyspringrun2.controllers.implement;

import com.axonactive.companyspringrun2.Entities.DepartmentLocation;
import com.axonactive.companyspringrun2.Service.DepartmentLocationService;
import com.axonactive.companyspringrun2.controllers.DepartmentLocationController;
import com.axonactive.companyspringrun2.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departmentLocation")
public class DepartmentLocationControllerImpl implements DepartmentLocationController {

    private final DepartmentLocationService departmentLocationService;

    @Override
    @GetMapping("/list")
    public List<DepartmentLocation> getAllDepartmentLocation() {
        return departmentLocationService.getAllDepartmentLocation();
    }

    @Override
    @PostMapping("/create")
    public DepartmentLocation newDepartmentLocation(@RequestBody DepartmentLocation departmentLocation) {
        return departmentLocationService.saveDepartmentLocation(departmentLocation);
    }

    @Override
    @GetMapping("/{id}")
    public DepartmentLocation getDepartmentById(@PathVariable Integer id) throws NotFoundException {
    return departmentLocationService.findDepartmentLocation(id)
            .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    @PutMapping("/update/{id}")
    public DepartmentLocation updateDepartment(@RequestBody DepartmentLocation newDepartmentLocation, @PathVariable Integer id) throws NotFoundException {
        return departmentLocationService.findDepartmentLocation(id)
                .map(departmentLocation -> {
                    departmentLocation.setLocation(newDepartmentLocation.getLocation());
                    departmentLocation.setDepartment(newDepartmentLocation.getDepartment());
                    return departmentLocationService.saveDepartmentLocation(departmentLocation);
                })
                .orElseThrow(() -> new NotFoundException(id));

    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteDepartmentLocation(@PathVariable Integer id) throws NotFoundException {
        for (DepartmentLocation dl : departmentLocationService.getAllDepartmentLocation()) {
            if (dl.getId().compareTo(id) == 0){
                departmentLocationService.deleteDepartmentLocation(id);
                System.out.println("Delete success!");
            }else throw new NotFoundException(id);
        }
    }
}
