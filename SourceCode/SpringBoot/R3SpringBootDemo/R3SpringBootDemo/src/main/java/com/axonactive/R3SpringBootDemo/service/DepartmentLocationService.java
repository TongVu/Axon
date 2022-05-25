package com.axonactive.R3SpringBootDemo.service;


import com.axonactive.R3SpringBootDemo.entity.DepartmentLocation;

import java.util.List;
import java.util.Optional;

public interface DepartmentLocationService {
    List<DepartmentLocation> getAllDepartmentLocation();

    DepartmentLocation saveDepartmentLocation(DepartmentLocation departmentLocation);

    void deleteDepartmentLocation(Long id);

    Optional<DepartmentLocation> findDepartmentLocationById(Long id);

}
