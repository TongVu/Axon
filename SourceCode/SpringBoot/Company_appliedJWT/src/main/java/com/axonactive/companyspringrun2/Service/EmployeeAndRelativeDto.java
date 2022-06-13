package com.axonactive.companyspringrun2.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeAndRelativeDto {
    private String employeeName;
    private List<String> relativeName;
}
