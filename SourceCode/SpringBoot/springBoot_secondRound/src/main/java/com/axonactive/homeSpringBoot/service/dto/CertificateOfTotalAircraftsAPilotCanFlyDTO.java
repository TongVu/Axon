package com.axonactive.homeSpringBoot.service.dto;

import com.axonactive.homeSpringBoot.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CertificateOfTotalAircraftsAPilotCanFlyDTO {
    private String employeeId;

    private Long totalAircraftsCanFly;
}
