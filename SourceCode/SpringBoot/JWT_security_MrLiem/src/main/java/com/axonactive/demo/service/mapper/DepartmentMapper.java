package com.axonactive.demo.service.mapper;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.service.dto.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);


    DepartmentDto toDto(Department department);

    List<DepartmentDto> toDtos(List<Department> departments);

}
