package com.axonactive.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAtVietnamStaticHasTotalSalaryDto {
    private Integer projectId;

    private String projectName;

    private Integer totalSalary;

    private Integer numberOfHours;
}
