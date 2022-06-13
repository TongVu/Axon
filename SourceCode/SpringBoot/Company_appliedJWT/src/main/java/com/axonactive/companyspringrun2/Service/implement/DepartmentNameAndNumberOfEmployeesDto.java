package com.axonactive.companyspringrun2.Service.implement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentNameAndNumberOfEmployeesDto {

    private String departmentName;
    private LocalDate startDate;
    private Long numberOfEmployees;
    private Long numberOfFemales;
    private Long numberOfMales;
    private Long numberOfU23;
}
