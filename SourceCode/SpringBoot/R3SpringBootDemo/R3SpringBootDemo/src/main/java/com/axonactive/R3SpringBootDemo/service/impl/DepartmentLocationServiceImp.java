package com.axonactive.R3SpringBootDemo.service.impl;

import com.axonactive.R3SpringBootDemo.dtoData.DepartmentDTO;
import com.axonactive.R3SpringBootDemo.dtoData.DepartmentLocationDTO;
import com.axonactive.R3SpringBootDemo.entity.DepartmentLocation;
import com.axonactive.R3SpringBootDemo.repository.DepartmentLocationRepository;
import com.axonactive.R3SpringBootDemo.service.DepartmentLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentLocationServiceImp implements DepartmentLocationService {

    @Autowired
    private final DepartmentLocationRepository departmentLocationRepository;


    @Override
    public List<DepartmentLocation> getAllDepartmentLocation() {
        return departmentLocationRepository.findAll();
    }

    @Override
    public DepartmentLocation saveDepartmentLocation(DepartmentLocation departmentLocation) {
        departmentLocationRepository.save(departmentLocation);
        return departmentLocation;
    }

    @Override
    public void deleteDepartmentLocation(Long id) {
        departmentLocationRepository.deleteById(id);
    }

    @Override
    public Optional<DepartmentLocation> findDepartmentLocationById(Long id) {
        return departmentLocationRepository.findById(id);
    }

    @Override
    public DepartmentLocation toDepartmentLocationEntity(DepartmentLocationDTO departmentLocationDTO) {
        return new DepartmentLocation(
                departmentLocationDTO.getId(),
                departmentLocationDTO.getLocation(),
                departmentLocationDTO.getDepartment()
        );
    }

    @Override
    public List<DepartmentLocation> toDepartmentLocationEntity(List<DepartmentLocationDTO> departmentLocationDTOList) {
        List<DepartmentLocation> departmentLocationList = new ArrayList<>();
        for (DepartmentLocationDTO departmentLocationDTO : departmentLocationDTOList) {
            departmentLocationList.add(this.toDepartmentLocationEntity(departmentLocationDTO));
        }

        return  departmentLocationList;
    }

    @Override
    public DepartmentLocationDTO toDepartmentLocationDTO(DepartmentLocation departmentLocation) {
        return new DepartmentLocationDTO(
                departmentLocation.getId(),
                departmentLocation.getLocation(),
                departmentLocation.getDepartment()
        );
    }

    @Override
    public List<DepartmentLocationDTO> toDepartmentLocationDTO(List<DepartmentLocation> departmentLocationList) {
        List<DepartmentLocationDTO> departmentLocationDTOS = new ArrayList<>();
        for (DepartmentLocation departmentLocation : departmentLocationList) {
            departmentLocationDTOS.add(this.toDepartmentLocationDTO(departmentLocation));
        }

        return departmentLocationDTOS;
    }


}
