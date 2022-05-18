package com.axonactive.demo.services.Impl;

import com.axonactive.demo.entities.Assignment;
import com.axonactive.demo.entities.DepartmentLocation;
import com.axonactive.demo.repositories.AssignmentRepository;
import com.axonactive.demo.repositories.DepartmentLocationRepository;
import com.axonactive.demo.services.AssignmentService;
import com.axonactive.demo.services.DepartmentLocationService;
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
    public void saveDepartmentLocation(DepartmentLocation departmentLocation){
        departmentLocationRepository.save(departmentLocation);
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
