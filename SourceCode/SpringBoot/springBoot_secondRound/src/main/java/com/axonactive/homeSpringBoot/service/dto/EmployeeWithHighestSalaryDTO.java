package com.axonactive.homeSpringBoot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWithHighestSalaryDTO {
    private String id;

    private String name;

    private Integer salary;
}
