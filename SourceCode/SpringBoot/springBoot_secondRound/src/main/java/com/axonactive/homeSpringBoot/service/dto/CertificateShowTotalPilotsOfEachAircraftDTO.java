package com.axonactive.homeSpringBoot.service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CertificateShowTotalPilotsOfEachAircraftDTO {
    private String aircraftType;
    private int totalPilots = 0;

    public int increasePilot(){
        return totalPilots++;
    }
}
