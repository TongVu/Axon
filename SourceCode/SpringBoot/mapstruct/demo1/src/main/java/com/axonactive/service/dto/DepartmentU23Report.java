package com.axonactive.service.dto;

import com.sun.xml.bind.v2.runtime.property.StructureLoaderBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentU23Report {
    private String departmentName;
    private LocalDate startDate;
    private int numberOfEmployeeInDept;
    private int numberOfFemale;
    private int numberOfMale;
    private int numberOfU23;
}
