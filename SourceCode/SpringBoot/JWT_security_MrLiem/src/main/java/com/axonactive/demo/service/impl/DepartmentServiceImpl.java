package com.axonactive.demo.service.impl;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.repository.DepartmentRepository;
import com.axonactive.demo.service.DepartmentService;
import com.axonactive.demo.service.dto.DepartmentStatisticsDto;
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

    @Override
    public List<DepartmentStatisticsDto> getDepartmentStatistics() {
        return departmentRepository.countEmployeesInDepartments();
    }

    @Override
    public List<DepartmentStatisticsDto> getDepartmentStatisticsByJPAQL() {
        return departmentRepository.countEmployeesInDepartmentsJPAQL();
    }
}
