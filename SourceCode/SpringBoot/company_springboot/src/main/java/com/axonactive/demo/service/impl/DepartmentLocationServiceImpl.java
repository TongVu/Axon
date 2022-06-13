package com.axonactive.demo.service.impl;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.demo.repository.DepartmentLocationRepository;
import com.axonactive.demo.repository.DepartmentRepository;
import com.axonactive.demo.service.DepartmentLocationService;
import com.axonactive.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentLocationServiceImpl implements DepartmentLocationService {
    private final DepartmentLocationRepository departmentLocationRepository;

    @Override
    public List<DepartmentLocation> getAll(){
        return departmentLocationRepository.findAll();
    }
}


