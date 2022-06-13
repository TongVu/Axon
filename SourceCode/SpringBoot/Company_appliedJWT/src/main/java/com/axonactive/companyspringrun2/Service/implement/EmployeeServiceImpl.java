package com.axonactive.companyspringrun2.Service.implement;

import com.axonactive.companyspringrun2.Entities.Employee;
import com.axonactive.companyspringrun2.Entities.Relatives;
import com.axonactive.companyspringrun2.Repositories.EmployeeRepository;
import com.axonactive.companyspringrun2.Service.EmployeeAndRelativeDto;
import com.axonactive.companyspringrun2.Service.EmployeeService;
import com.axonactive.companyspringrun2.Service.RelativesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final RelativesService relativesService;


    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findEmployee(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee findByLastname(String lastname) {
        return employeeRepository.findByLastName(lastname);
    }

    @Override
    public Employee findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    @Override
    public Employee findByLastNameOrFirstName(String lastName, String firstName) {
        return employeeRepository.findByLastNameOrFirstName(lastName, firstName);
    }

    @Override
    public List<Employee> findByDateOfBirthBetween(LocalDate date1, LocalDate date2) {
        return employeeRepository.findByDateOfBirthBetween(date1, date2);
    }

//    @Override
//    public List<Employee> findByAgeLessThan(int age) {
//        return employeeRepository.findByAgeLessThan(age);
//    }

    @Override
    public List<Employee> findByLastNameIsNotNull() {
        return employeeRepository.findByLastNameIsNotNull();
    }

    @Override
    public List<Employee> findByMiddleNameIsNull() {
        return employeeRepository.findByMiddleNameIsNull();
    }

    @Override
    public Employee findByLastNameIgnoreCase(String lastName) {
        return employeeRepository.findByLastNameIgnoreCase(lastName);
    }

    @Override
    public Employee findByFirstNameStaringWith(String letter) {
        return employeeRepository.findByFirstNameStartingWith(letter);
    }

    @Override
    public List<Employee> findByDepartmentId(Integer id) {
        return employeeRepository.findByDepartmentId(id);
    }

    @Override
    public List<Employee> findByDepartmentDepartmentName(String name) {
        return employeeRepository.findByDepartmentDepartmentName(name);
    }

    @Override
    public List<Employee> findByDepartmentStartDate(int year, int month, int day) {
        return employeeRepository.findByDepartmentStartDate(LocalDate.of(year, month, day));
    }

    @Override
    public List<Employee> findByDepartmentDepartmentNameIgnoreCase(String name) {
        return employeeRepository.findByDepartmentDepartmentNameIgnoreCase(name);
    }

    @Override
    public List<Employee> findByDepartmentDepartmentNameStartingWith(String letter) {
        return employeeRepository.findByDepartmentDepartmentNameStartingWith(letter);
    }

    @Override
    public List<Employee> findByDepartmentDepartmentNameIsNotNull() {
        return employeeRepository.findByDepartmentDepartmentNameIsNotNull();
    }

    @Override
    public List<Employee> findEmployeeByBirthMonth(int month) {
        return employeeRepository.findAll()
                .stream()
                .filter(e -> e.getDateOfBirth().getMonthValue() == month)
                .collect(Collectors.toList());

    }

    @Override
    public List<EmployeeAndRelativeDto> findAllEmployeeAndTheirRelative() {
        return employeeRepository.findAll()
                .stream()
                .map(temp -> {
                    EmployeeAndRelativeDto dto = new EmployeeAndRelativeDto();
                    dto.setEmployeeName(temp.getLastName() + " " + temp.getFirstName());
                    dto.setRelativeName(relativesService.getAllRelatives()
                            .stream()
                            .filter(r -> r.getEmployee().getId().equals(temp.getId()))
                            .map(Relatives::getFullName)
                            .collect(Collectors.toList()));
                    return dto;
                }).collect(Collectors.toList());
    }
}


