package com.axonactive.demo.service;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.service.dto.DepartmentStatisticsDto;

import java.util.List;

public interface DepartmentService {
    List<Department> getALl();
    List<DepartmentStatisticsDto> getDepartmentStatistics();
    List<DepartmentStatisticsDto> getDepartmentStatisticsByJPAQL();
}
