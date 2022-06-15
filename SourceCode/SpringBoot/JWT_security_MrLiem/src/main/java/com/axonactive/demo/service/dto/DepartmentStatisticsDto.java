package com.axonactive.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentStatisticsDto {
    private String departmentName;
    private Long numberOfEmployee;
}
