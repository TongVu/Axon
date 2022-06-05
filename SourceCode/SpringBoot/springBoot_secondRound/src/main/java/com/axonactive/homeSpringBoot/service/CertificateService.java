package com.axonactive.homeSpringBoot.service;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.service.dto.CertificateOfEmployeeCanFlyMoreThan3AircraftsAndMaxRangeOfThoseAircraftsDTO;
import com.axonactive.homeSpringBoot.service.dto.CertificateOfPilotCanOnlyFly3AircraftsDTO;
import com.axonactive.homeSpringBoot.service.dto.CertificateOfTotalAircraftsAPilotCanFlyDTO;
import com.axonactive.homeSpringBoot.service.dto.CertificateShowTotalPilotsOfEachAircraftDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CertificateService {
    List<Certificate> findAll();
    Optional<Certificate> findById(Integer id);
    Certificate save(Certificate aircraft);
    void deleteById(Integer id);
    List<Certificate> findEmployeeIdByAircraftId(Integer id);
    List<Certificate> findByEmployeeNameStartingWith(String lookedPattern);
    Set<Integer> findAircraftIdsThatEmployeesHaveLastNameIsNguyenCanFly();
    List<Certificate> findByAircraftTypeLike(String aircraftType);

    Set<CertificateShowTotalPilotsOfEachAircraftDTO> findTotalPilotsOfEachAircraft();
    List<CertificateOfPilotCanOnlyFly3AircraftsDTO> findPilotCanOnlyFly3Aircrafts();
    List<CertificateOfTotalAircraftsAPilotCanFlyDTO> findTotalAircraftsAPilotCanFly();
    List<CertificateOfEmployeeCanFlyMoreThan3AircraftsAndMaxRangeOfThoseAircraftsDTO> getEmployeeCanFlyMoreThan3AircraftsAndMaxRange();
    int totalSalaryOfAllPilots();

}
