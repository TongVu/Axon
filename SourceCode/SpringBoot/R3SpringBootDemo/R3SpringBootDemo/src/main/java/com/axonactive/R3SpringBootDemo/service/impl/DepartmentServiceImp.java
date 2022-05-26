package com.axonactive.R3SpringBootDemo.service.impl;

import com.axonactive.R3SpringBootDemo.dtoData.DepartmentDTO;
import com.axonactive.R3SpringBootDemo.entity.Department;
import com.axonactive.R3SpringBootDemo.repository.DepartmentRepository;
import com.axonactive.R3SpringBootDemo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        departmentRepository.save(department);
        return department;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Optional<Department> findDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department toDepartmentEntity(DepartmentDTO departmentDTO) {
        return new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getStartDate()

        );
    }

    @Override
    public List<Department> toDepartmentEntity(List<DepartmentDTO> departmentDTOs) {
        List<Department> departmentList = new ArrayList<>();
        for (DepartmentDTO departmentDTO : departmentDTOs) {
            departmentList.add(this.toDepartmentEntity(departmentDTO));
        }

        return departmentList;
    }

    @Override
    public DepartmentDTO toDepartmentDTO(Department department) {
        return new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getStartDate()
                );
    }

    @Override
    public List<DepartmentDTO> toDepartmentDTO(List<Department> departmentList){
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        for (Department department : departmentList) {
            departmentDTOList.add(this.toDepartmentDTO(department));
        }

        return departmentDTOList;
    }
}
