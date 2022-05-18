package com.axonactive.demo.services;

import com.axonactive.demo.entities.Assignment;
import com.axonactive.demo.entities.DepartmentLocation;

import java.util.List;
import java.util.Optional;

public interface DepartmentLocationService {
    List<DepartmentLocation> getAllDepartmentLocation();

    void saveDepartmentLocation(DepartmentLocation departmentLocation);

    void deleteDepartmentLocation(Long id);

    Optional<DepartmentLocation> findDepartmentLocationById(Long id);

}
