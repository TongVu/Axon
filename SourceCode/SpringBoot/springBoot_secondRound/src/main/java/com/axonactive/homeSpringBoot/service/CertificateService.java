package com.axonactive.homeSpringBoot.service;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Certificate;
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
}
