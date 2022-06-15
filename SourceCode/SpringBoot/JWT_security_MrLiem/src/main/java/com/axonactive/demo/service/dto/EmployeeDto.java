package com.axonactive.demo.service.dto;

import com.axonactive.demo.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String firstName;
    private String departmentName;
    private Gender gender;
}
