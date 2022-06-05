package com.axonactive.homeSpringBoot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateOfEmployeeCanFlyMoreThan3AircraftsAndMaxRangeOfThoseAircraftsDTO {
    private String employee_id;

    private Integer distance;
}
