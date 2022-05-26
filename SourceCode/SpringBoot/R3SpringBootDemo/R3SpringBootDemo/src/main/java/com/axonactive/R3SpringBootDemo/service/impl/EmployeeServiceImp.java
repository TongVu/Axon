package com.axonactive.R3SpringBootDemo.service.impl;

import com.axonactive.R3SpringBootDemo.dtoData.EmployeeDTO;
import com.axonactive.R3SpringBootDemo.dtoData.ProjectDTO;
import com.axonactive.R3SpringBootDemo.entity.Employee;
import com.axonactive.R3SpringBootDemo.entity.Project;
import com.axonactive.R3SpringBootDemo.repository.EmployeeRepository;
import com.axonactive.R3SpringBootDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
// no need RequireArgumentConstructor
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    // delete private final
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // ===================================
    @Override
    public List<Employee> findEmployeeByFirstNameLike(String name){
        return employeeRepository.findEmployeeByFirstNameLike(name);
    }

    @Override
    public List<Employee> findEmployeeByFirstNameLikeAndLastNameLike(String firstName, String lastName){
        return employeeRepository.findEmployeeByFirstNameLikeAndLastNameLike(firstName, lastName);
    }

    @Override
    public List<Employee> findEmployeeByFirstNameIgnoreCaseLike(String firstName){
        return employeeRepository.findEmployeeByFirstNameIgnoreCaseLike("%g%");
    }

    @Override
    public List<Employee> findEmployeeByDateOfBirthBefore(int year, int month, int day){
        LocalDate date = LocalDate.of(year,month,day);
        return employeeRepository.findEmployeeByDateOfBirthBefore(date);
    }

    @Override
    public List<Employee> findEmployeeByAgeLessThan(Integer age){
        List<Employee> satisfiedEmployeesHaveAgeLessThan = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> {
           if(employee.getAge() < age) satisfiedEmployeesHaveAgeLessThan.add(employee);
        });

        return satisfiedEmployeesHaveAgeLessThan;
    }

    @Override
    public List<Employee> findEmployeeByDateOfBirthBetween(LocalDate dateStart, LocalDate dateEnd){
        return employeeRepository.findEmployeeByDateOfBirthBetween(dateStart, dateEnd);
    }

    @Override
    public List<Employee> findEmployeeByDepartmentId(Long id){
        return employeeRepository.findEmployeeByDepartmentId(id);
    }
    @Override
    public List<Employee> findEmployeeByFirstNameContaining(String pattern){
        return employeeRepository.findEmployeeByFirstNameContaining(pattern);
    }


    @Override
    public Employee toEmployeeEntity(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getEmployeeid(),
                employeeDTO.getDateOfBirth(),
                employeeDTO.getFirstName(),
                employeeDTO.getGender(),
                employeeDTO.getLastName(),
                employeeDTO.getMiddleName(),
                employeeDTO.getSalary(),
                employeeDTO.getDepartment(),
                employeeDTO.getAge()
        );
    }

    @Override
    public List<Employee> toEmployeeEntity(List<EmployeeDTO> employeeDTOs) {
        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeDTO emp : employeeDTOs) {
            employeeList.add(this.toEmployeeEntity(emp));
        }
        
        return employeeList;
    }

    @Override
    public EmployeeDTO toEmployeeDTO(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getEmployeeid(),
                employee.getDateOfBirth(),
                employee.getFirstName(),
                employee.getGender(),
                employee.getLastName(),
                employee.getMiddleName(),
                employee.getSalary(),
                employee.getDepartment(),
                employee.getAge()
        );
    }

    @Override
    public List<EmployeeDTO> toEmployeeDTO(List<Employee> employees){
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        for (Employee emp : employees) {
            employeeDTOS.add(this.toEmployeeDTO(emp));
        }

        return employeeDTOS;
    }

}
