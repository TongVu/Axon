package com.axonactive.homeSpringBoot.service;

import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.service.dto.EmployeeNotPilotDTO;
import com.axonactive.homeSpringBoot.service.dto.EmployeeWithHighestSalaryDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(Integer id);
    Employee save(Employee  employee);
    void deleteById(Integer id);

    List<Employee> findBySalaryLessThan(Integer salary);
    Integer calculateTotalSalaryForAllEmployees();

    List<String> findAllNamesOfPilotCanFlyBoeingAircraft();
//    List<EmployeeNotPilotDTO> findEmployeeWhoNotPilot();
    List<EmployeeNotPilotDTO> findEmployeeWhoIsNotPilot();
    List<EmployeeWithHighestSalaryDTO> findEmployeeWithHighestSalary();
}
