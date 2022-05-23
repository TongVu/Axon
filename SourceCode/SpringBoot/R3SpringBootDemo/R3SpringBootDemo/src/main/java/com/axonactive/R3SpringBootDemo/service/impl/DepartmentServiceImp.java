package com.axonactive.R3SpringBootDemo.service.impl;

import com.axonactive.R3SpringBootDemo.entity.Department;
import com.axonactive.R3SpringBootDemo.repository.DepartmentRepository;
import com.axonactive.R3SpringBootDemo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department){
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(Long id){
        departmentRepository.deleteById(id);
    }

    @Override
    public Optional<Department> findDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }
}
