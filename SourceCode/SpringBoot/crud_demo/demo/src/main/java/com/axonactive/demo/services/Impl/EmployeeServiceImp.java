package com.axonactive.demo.services.Impl;

import com.axonactive.demo.entities.Department;
import com.axonactive.demo.entities.Employee;
import com.axonactive.demo.repositories.DepartmentRepository;
import com.axonactive.demo.repositories.EmployeeRepository;
import com.axonactive.demo.services.DepartmentService;
import com.axonactive.demo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
}
