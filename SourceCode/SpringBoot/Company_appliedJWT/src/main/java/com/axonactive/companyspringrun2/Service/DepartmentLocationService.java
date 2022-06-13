package com.axonactive.companyspringrun2.Service;

import com.axonactive.companyspringrun2.Entities.DepartmentLocation;

import java.util.List;
import java.util.Optional;

public interface DepartmentLocationService {
    List<DepartmentLocation> getAllDepartmentLocation();

    DepartmentLocation saveDepartmentLocation(DepartmentLocation departmentLocation);

    void deleteDepartmentLocation(Integer id);

    Optional<DepartmentLocation> findDepartmentLocation(Integer id);
}
