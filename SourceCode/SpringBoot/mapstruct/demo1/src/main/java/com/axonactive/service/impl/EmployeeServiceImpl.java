package com.axonactive.service.impl;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.entity.Project;
import com.axonactive.demo.entity.Relatives;
import com.axonactive.repository.EmployeeRepository;
import com.axonactive.service.AssignmentService;
import com.axonactive.service.EmployeeService;
import com.axonactive.service.ProjectService;
import com.axonactive.service.RelativeService;
import com.axonactive.service.dto.EmployeeAndTheirKinDto;
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

    private final RelativeService relativesService;
    private final AssignmentService assignmentService;
    private final ProjectService projectService;

    @Override
    public List<Employee> getAll() {
        List<Employee> allEmployee = employeeRepository.findAll();
        return allEmployee;
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    @Override
    public List<Employee> findByLastNameOrByFirstName(String lastName, String firstName) {
        return employeeRepository.findEmployeeByLastNameOrFirstName(lastName, firstName);
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    @Override
    public List<Employee> findByMiddleName(String middleName) {
        return employeeRepository.findEmployeeByMiddleName(middleName);
    }

    @Override
    public List<Employee> findBySalaryLessThan(Integer salary) {
        return employeeRepository.findBySalaryLessThan(salary);
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(Integer salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    @Override
    public List<Employee> findBySalary(Integer salary) {
        return employeeRepository.findBySalary(salary);
    }

    @Override
    public List<Employee> findByDepartmentDepartmentName(String departmentName) {
        return employeeRepository.findByDepartmentDepartmentName(departmentName);
    }

    @Override
    public List<Employee> findByDepartmentDepartmentNameLike(String departmentName) {
        return employeeRepository.findByDepartmentDepartmentNameLike(departmentName);
    }

    @Override
    public List<Employee> findByEmployeeLastNameLike(String lastName) {
        return employeeRepository.findByLastNameLike(lastName);
    }


    @Override
    public List<Employee> findByLastNameIgnoreCase(String lastname) {
        return employeeRepository.findByLastNameIgnoreCase(lastname);
    }

    @Override
    public List<Employee> findAllEmployeeInADepartment(Department department) {

        return employeeRepository.findAll()
                .stream()
                .filter(n -> n.getDepartment().getDepartmentId() == department.getDepartmentId())
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findBySalaryBetween(Integer min, Integer max) {
        return employeeRepository.findBySalaryBetween(min, max);
    }

    @Override
    public List<Employee> findAllOrderByIdAsc() {
        return employeeRepository.findAllByOrderById();
    }

    @Override
    public List<Employee> findAllOrderByDepartment() {
        return employeeRepository.findAllByOrderByDepartment();
    }

    @Override
    public List<Employee> findAllOrderByLastName() {
        return employeeRepository.findAllByOrderByLastName();
    }

    @Override
    public List<Employee> employeeWithSameBirthMonth(int month) {
        return employeeRepository.findAll()
                .stream()
                .filter(e -> e.getDateOfBirth().getMonth() == LocalDate.of(0, month, 0).getMonth())
                .toList();

    }

    @Override
    public List<EmployeeAndTheirKinDto> findEmployeeAndTheirRelative() {
        return employeeRepository.findAll()
                .stream()
                .map(
                        e -> new EmployeeAndTheirKinDto(
                                e.getFirstName(),
                                e.getId(),
                                relativesService.getAll()
                                        .stream()
                                        .filter(k -> k.getEmployee().getId() == e.getId())
                                        .toList()
                        )
                ).toList();
    }

    public Relatives findFatherFirstMotherSecondThanAny(Employee employee) {
        return relativesService.getAll()
                .stream()
                .filter(k -> (k.getEmployee().getId() == employee.getId()))
                .filter(k ->
                        k.getRelationship().equalsIgnoreCase("father") ||
                                k.getRelationship().equalsIgnoreCase("mother") ||
                                k.getRelationship().equalsIgnoreCase("any")
                ).toList().get(0);

    }

    public List<Employee> findAllEmployeeNotInAnyProject() {
        List<Integer> employeeInProjects = assignmentService.getAll()
                .stream()
                .map(a -> a.getEmployee().getId())
                .toList();

        return employeeRepository.findAll()
                .stream()
                .filter(e -> !employeeInProjects.contains(e.getId()))
                .toList();
    }

    public List<Employee> findEmployeeWorkInProjectThatManagedByAnotherDepartment() {
        List<Integer> departmentOfEmployeesAssignedProject = assignmentService.getAll()
                .stream()
                .map(a -> a.getEmployee().getDepartment().getDepartmentId())
                .toList();

        List<Integer> departmentManageProject = assignmentService.getAll()
                .stream()
                .map(a -> a.getProject().getDepartment().getDepartmentId())
                .toList();

        List<Integer> departmentManageProjectHasEmployeeDoesntBelongToIt =
                departmentOfEmployeesAssignedProject
                .stream()
                .filter(d -> !departmentManageProject.contains(d))
                .toList();

        return employeeRepository.findAll()
                        .stream()
                        .filter(e ->
                                departmentManageProjectHasEmployeeDoesntBelongToIt.contains(e.getDepartment().getDepartmentId()))
                        .toList();
    }

}
