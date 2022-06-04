package com.axonactive.homeSpringBoot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateOfPilotCanOnlyFly3AircraftsDTO {
    private String employeeId;

    private int totalAircraftsCanFly;
}
