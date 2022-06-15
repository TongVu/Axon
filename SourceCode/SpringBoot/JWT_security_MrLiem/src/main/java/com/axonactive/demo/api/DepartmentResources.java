package com.axonactive.demo.api;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.service.DepartmentService;
import com.axonactive.demo.service.dto.DepartmentDto;
import com.axonactive.demo.service.dto.DepartmentStatisticsDto;
import com.axonactive.demo.service.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequiredArgsConstructor
public class DepartmentResources {
    private final DepartmentService departmentService;

    @GetMapping("/departments")
    public List<DepartmentDto> getAllDepartment(){
        List<Department> aLlDepartment = departmentService.getALl();
        return DepartmentMapper.INSTANCE.toDtos(aLlDepartment);
    }
    @GetMapping("/departments/statistics")
    public List<DepartmentStatisticsDto> getDepartmentStatistics(){
       //return  departmentService.getDepartmentStatisticsByJPAQL();

       // the following function using Native query ==> shouldn't use it
        return  departmentService.getDepartmentStatistics();
    }
}
