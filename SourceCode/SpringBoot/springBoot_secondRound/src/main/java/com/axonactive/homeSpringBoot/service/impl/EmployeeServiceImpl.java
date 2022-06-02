package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.repository.EmployeeRepository;
import com.axonactive.homeSpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


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
    public List<Employee> findEmployeeByNameLike(String name){
        return employeeRepository.findEmployeeByNameLike("Nguyen%");
    }

}
