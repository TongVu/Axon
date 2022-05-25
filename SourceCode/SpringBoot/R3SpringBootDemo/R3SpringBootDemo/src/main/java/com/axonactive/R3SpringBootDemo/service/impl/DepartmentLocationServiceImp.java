package com.axonactive.R3SpringBootDemo.service.impl;

import com.axonactive.R3SpringBootDemo.entity.Department;
import com.axonactive.R3SpringBootDemo.entity.DepartmentLocation;
import com.axonactive.R3SpringBootDemo.repository.DepartmentLocationRepository;
import com.axonactive.R3SpringBootDemo.repository.DepartmentRepository;
import com.axonactive.R3SpringBootDemo.service.DepartmentLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentLocationServiceImp implements DepartmentLocationService {

    @Autowired
    private final DepartmentLocationRepository departmentLocationRepository;


    @Override
    public List<DepartmentLocation> getAllDepartmentLocation(){
        return departmentLocationRepository.findAll();
    }

    @Override
    public DepartmentLocation saveDepartmentLocation(DepartmentLocation departmentLocation){
        departmentLocationRepository.save(departmentLocation);
        return departmentLocation;
    }

    @Override
    public void deleteDepartmentLocation(Long id){
        departmentLocationRepository.deleteById(id);
    }

    @Override
    public Optional<DepartmentLocation> findDepartmentLocationById(Long id) {
        return departmentLocationRepository.findById(id);
    }
}
