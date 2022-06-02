package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.repository.CertificateRepository;
import com.axonactive.homeSpringBoot.repository.EmployeeRepository;
import com.axonactive.homeSpringBoot.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    CertificateRepository certificateRepository;

    @Autowired
    EmployeeRepository employeeRepository;


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

    @Override // 11
    public List<Certificate> findAircraftIdThatEmployeesHaveLastNameIsNguyenCanFly() {
        List<Employee> employeesHaveLastNameIsNguyen = employeeRepository.findEmployeeByNameLike("Nguyen");
        List<Certificate> aircraftIdsThatEmployeesHaveLastNameIsNguyenCanFly =
                new ArrayList<>();
        for (Certificate certificate : certificateRepository.findAll())
            for (Employee emp : employeesHaveLastNameIsNguyen)
                if (certificate.getEmployee().getId().equals(emp.getId()))
                    aircraftIdsThatEmployeesHaveLastNameIsNguyenCanFly.add(certificate);

        return aircraftIdsThatEmployeesHaveLastNameIsNguyenCanFly;
    }
}
