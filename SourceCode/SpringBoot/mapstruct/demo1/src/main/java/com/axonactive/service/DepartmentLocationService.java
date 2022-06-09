package com.axonactive.service;

import com.axonactive.demo.entity.DepartmentLocation;

import java.util.List;
import java.util.Optional;

public interface DepartmentLocationService {
   List<DepartmentLocation> getAll();
   Optional<DepartmentLocation> getDepartmentLocationById(Integer id);
   void saveDepartmentLocation(DepartmentLocation departmentLocation);
   void deleteDepartmentLocation(Integer id);


}
