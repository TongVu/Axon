package com.axonactive.demo.service.impl;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.repository.DepartmentRepository;
import com.axonactive.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getALl() {
        return departmentRepository.findAll();
    }
}
