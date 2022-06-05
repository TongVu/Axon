package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.repository.CertificateRepository;
import com.axonactive.homeSpringBoot.service.CertificateService;
import com.axonactive.homeSpringBoot.service.dto.CertificateOfEmployeeCanFlyMoreThan3AircraftsAndMaxRangeOfThoseAircraftsDTO;
import com.axonactive.homeSpringBoot.service.dto.CertificateOfPilotCanOnlyFly3AircraftsDTO;
import com.axonactive.homeSpringBoot.service.dto.CertificateOfTotalAircraftsAPilotCanFlyDTO;
import com.axonactive.homeSpringBoot.service.dto.CertificateShowTotalPilotsOfEachAircraftDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    CertificateRepository certificateRepository;

    @Override
    public List<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    @Override
    public Optional<Certificate> findById(Integer id) {
        return certificateRepository.findById(id);
    }

    @Override
    public Certificate save(Certificate aircraft) {
        return certificateRepository.save(aircraft);
    }

    @Override
    public void deleteById(Integer id) {
        certificateRepository.deleteById(id);
    }

    @Override
    public List<Certificate> findEmployeeIdByAircraftId(Integer id) {
        return certificateRepository.findByAircraftId(id);
    }

    @Override
    public List<Certificate> findByEmployeeNameStartingWith(String lookedPattern) {
        return certificateRepository.findByEmployeeNameStartingWith(lookedPattern);
    }

    @Override
    public Set<Integer> findAircraftIdsThatEmployeesHaveLastNameIsNguyenCanFly() {
        Set<Integer> aircraftsThatEmployeesHaveLastNameIsNguyenCanFly = new HashSet<>();
        List<Certificate> certificatesOfEmployeesHaveLastNameIsNguyen =
                findByEmployeeNameStartingWith("Nguyen");

        for (Certificate cer : certificatesOfEmployeesHaveLastNameIsNguyen)
            aircraftsThatEmployeesHaveLastNameIsNguyenCanFly.add(cer.getAircraft().getId());
        return aircraftsThatEmployeesHaveLastNameIsNguyenCanFly;
    }

    @Override
    public List<Certificate> findByAircraftTypeLike(String aircraftType) {
        return certificateRepository.findByAircraftTypeLike(aircraftType);
    }

    @Override
    public Set<CertificateShowTotalPilotsOfEachAircraftDTO> findTotalPilotsOfEachAircraft() {
        List<Certificate> certificates = certificateRepository.findAll();
        Set<CertificateShowTotalPilotsOfEachAircraftDTO> totalPilotsCertificate = new HashSet<>();

        for (Certificate certificate : certificates) {
            totalPilotsCertificate.add(new CertificateShowTotalPilotsOfEachAircraftDTO(certificate.getAircraft().getType(), 0));
        }

        for (CertificateShowTotalPilotsOfEachAircraftDTO certificate : totalPilotsCertificate)
            for (Certificate cer : certificates)
                if (certificate.getAircraftType().equals(cer.getAircraft().getType()))
                    certificate.increasePilot();

        return totalPilotsCertificate;
    }

    @Override
    public List<CertificateOfPilotCanOnlyFly3AircraftsDTO> findPilotCanOnlyFly3Aircrafts(){
        return certificateRepository.findPilotCanOnlyFly3Aircrafts();
    }

    @Override
    public List<CertificateOfTotalAircraftsAPilotCanFlyDTO> findTotalAircraftsAPilotCanFly() {
        return certificateRepository.findTotalAircraftsAPilotCanFly();
    }

    @Override
    public List<CertificateOfEmployeeCanFlyMoreThan3AircraftsAndMaxRangeOfThoseAircraftsDTO> getEmployeeCanFlyMoreThan3AircraftsAndMaxRange() {
        return certificateRepository.findEmployeeCanFlyMoreThan3AicraftsAndMaxRangeOfThoseAircrafts();
    }
    @Override
    public int totalSalaryOfAllPilots(){
        List<Certificate> certificates = certificateRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        for (Certificate cer : certificates)
            employeeList.add(cer.getEmployee());

        Set<Employee> allPilots = new HashSet<>();
        allPilots.addAll(employeeList);

        int totalSalary = 0;
        for (Employee pilot : allPilots) totalSalary += pilot.getSalary();

        return totalSalary;
    }
}
