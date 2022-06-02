package com.axonactive.homeSpringBoot.service;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Certificate;

import java.util.List;
import java.util.Optional;

public interface CertificateService {
    List<Certificate> findAll();
    Optional<Certificate> findById(Integer id);
    Certificate save(Certificate aircraft);
    void deleteById(Integer id);
    List<Certificate> findEmployeeIdByAircraftId(Integer id);
    List<Certificate> findAircraftIdThatEmployeesHaveLastNameIsNguyenCanFly();
}
