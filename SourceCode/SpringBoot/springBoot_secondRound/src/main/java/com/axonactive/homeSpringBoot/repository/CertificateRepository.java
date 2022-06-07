package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.service.dto.CertificateOfEmployeeCanFlyMoreThan3AircraftsAndMaxRangeOfThoseAircraftsDTO;
import com.axonactive.homeSpringBoot.service.dto.CertificateOfPilotCanOnlyFly3AircraftsDTO;
import com.axonactive.homeSpringBoot.service.dto.CertificateOfTotalAircraftsAPilotCanFlyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    List<Certificate> findByAircraftId(Integer id);
    List<Certificate> findByEmployeeNameStartingWith(String lookedPattern);
    List<Certificate> findByAircraftTypeLike(String aircraftType);


    @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.CertificateOfPilotCanOnlyFly3AircraftsDTO(e.id, COUNT(c.id)) "+
            "FROM Certificate c, Employee e WHERE c.employee.id = e.id GROUP BY e.id HAVING COUNT(c.id) = 3")
    List<CertificateOfPilotCanOnlyFly3AircraftsDTO> findPilotCanOnlyFly3Aircrafts();

    @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.CertificateOfTotalAircraftsAPilotCanFlyDTO(e.id, COUNT(c.id)) " +
    "FROM Employee e JOIN Certificate c ON c.employee.id = e.id GROUP BY e.id") // modified
    List<CertificateOfTotalAircraftsAPilotCanFlyDTO> findTotalAircraftsAPilotCanFly();

    @Query(nativeQuery = true)
    List<CertificateOfEmployeeCanFlyMoreThan3AircraftsAndMaxRangeOfThoseAircraftsDTO> findEmployeeCanFlyMoreThan3AicraftsAndMaxRangeOfThoseAircrafts();

    @Query(nativeQuery = true)
    List<Certificate> findEmployeeCanFlyBoeingAndAirbus();
}
