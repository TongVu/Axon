package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.repository.EmployeeRepository;
import com.axonactive.homeSpringBoot.service.CertificateService;
import com.axonactive.homeSpringBoot.service.EmployeeService;
import com.axonactive.homeSpringBoot.service.dto.EmployeeNotPilotDTO;
import com.axonactive.homeSpringBoot.service.dto.EmployeeWithHighestSalaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CertificateService certificateService;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findBySalaryLessThan(Integer salary) {
        return employeeRepository.findBySalaryLessThan(salary);
    }

    @Override
    public Integer calculateTotalSalaryForAllEmployees() {
        Integer totalSalary = 0;
        for (Employee emp : employeeRepository.findAll()) {
            totalSalary += emp.getSalary();
        }

        return totalSalary;
    }

    @Override
    public List<String> findAllNamesOfPilotCanFlyBoeingAircraft() {
        List<Certificate> boeingCertificates = certificateService.findByAircraftTypeLike("Boeing%");
        List<Employee> employeeList = employeeRepository.findAll();
        List<String> nameOfPilotsCanFlyBoeingAircraft = new ArrayList<>();
        for (Employee emp : employeeList)
            for (Certificate boeingCertificate : boeingCertificates)
                if (emp.getId().equals(boeingCertificate.getEmployee().getId()))
                    nameOfPilotsCanFlyBoeingAircraft.add(emp.getName());

        return nameOfPilotsCanFlyBoeingAircraft;
    }

    @Override
    public List<EmployeeNotPilotDTO> findEmployeeWhoIsNotPilot() {
        return employeeRepository.findEmployeeWhoIsNotPilot();
    }

    //    @Override
//    public List<EmployeeNotPilotDTO> findEmployeeWhoNotPilot() {
//        return employeeRepository.findEmployeeWhoNotPilot();
//    }
    @Override
    public List<EmployeeWithHighestSalaryDTO> findEmployeeWithHighestSalary(){
        return employeeRepository.findEmployeeWithHighestSalary();
    }


}
