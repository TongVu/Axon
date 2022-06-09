package com.axonactive.service.impl;

import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.repository.DepartmentLocationRepository;
import com.axonactive.service.DepartmentLocationService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DepartmentLocationServiceImpl implements DepartmentLocationService {
    private final DepartmentLocationRepository departmentLocationRepository;
    @Override
    public List<DepartmentLocation> getAll() {
        List<DepartmentLocation> allDepartmentLocation=
                departmentLocationRepository.findAll();
        return allDepartmentLocation;
    }

    @Override
    public Optional<DepartmentLocation> getDepartmentLocationById(Integer id) {
        return departmentLocationRepository.findById(id);
    }

    @Override
    public void saveDepartmentLocation(DepartmentLocation departmentLocation) {
    departmentLocationRepository.save(departmentLocation);
    }

    @Override
    public void deleteDepartmentLocation(Integer id) {
    departmentLocationRepository.deleteById(id);
    }
}
