package com.axonactive.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAtVietNameStatisticDto {
    private Integer projectId;

    private String projectName;

    private Integer numberOfEmployees;

    private Integer numberOfHours;

}
