package com.axonactive.R3SpringBootDemo.service;


import com.axonactive.R3SpringBootDemo.dtoData.DepartmentDTO;
import com.axonactive.R3SpringBootDemo.dtoData.DepartmentLocationDTO;
import com.axonactive.R3SpringBootDemo.entity.Department;
import com.axonactive.R3SpringBootDemo.entity.DepartmentLocation;

import java.util.List;
import java.util.Optional;

public interface DepartmentLocationService {
    List<DepartmentLocation> getAllDepartmentLocation();

    DepartmentLocation saveDepartmentLocation(DepartmentLocation departmentLocation);

    void deleteDepartmentLocation(Long id);

    Optional<DepartmentLocation> findDepartmentLocationById(Long id);

    DepartmentLocation toDepartmentLocationEntity(DepartmentLocationDTO departmentLocationDTO);
    List<DepartmentLocation> toDepartmentLocationEntity(List<DepartmentLocationDTO> departmentLocationDTOList);

    DepartmentLocationDTO toDepartmentLocationDTO(DepartmentLocation departmentLocation);
    List<DepartmentLocationDTO> toDepartmentLocationDTO(List<DepartmentLocation> departmentLocationList);

}
