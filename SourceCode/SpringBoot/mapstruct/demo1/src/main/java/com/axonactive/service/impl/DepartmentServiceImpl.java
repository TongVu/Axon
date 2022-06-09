package com.axonactive.service.impl;

import com.axonactive.demo.entity.Department;

import com.axonactive.repository.DepartmentRepository;
import com.axonactive.service.DepartmentService;
import com.axonactive.service.EmployeeService;
import com.axonactive.service.ProjectService;
import com.axonactive.service.dto.DepartmentAndTheirPro;
import com.axonactive.service.dto.DepartmentU23Report;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeService employeeService;
    private final ProjectService projectService;

    @Override
    public List<Department> getAll() {
        List<Department> allDepartment = departmentRepository.findAll();
        return allDepartment;
    }

    @Override
    public Optional<Department> getDepartmentById(Integer id) {
        return departmentRepository.findById(id);
    }


    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<DepartmentU23Report> departmentU23Report() {

//        return departmentRepository.findAll()
//                .stream()
//                .map(d->new DepartmentU23Report(d.getDepartmentName(),
//                        d.getStartDate(),
//                        employeeService.findAllEmployeeInADepartment(d).size(),
//
//                        employeeService.findAllEmployeeInADepartment(d)
//                                        .stream()
//                                .filter(e->e.getGender().equalsIgnoreCase("male")).count(),
//
//                        employeeService.findAllEmployeeInADepartment(d)
//                                .stream()
//                                .filter(e->e.getGender().equalsIgnoreCase("female")).count(),
//
//                        employeeService.findAllEmployeeInADepartment(d)
//                                .stream()
//                                .filter(e->
//                                    (LocalDate.now().getYear() - e.getDateOfBirth().getYear())<23).count()))
        return departmentRepository.findAll()
                .stream()
                .map(d -> new DepartmentU23Report(
                                d.getDepartmentName(),
                                d.getStartDate(),
                                employeeService.findAllEmployeeInADepartment(d).size(),

                                employeeService.findAllEmployeeInADepartment(d).stream().filter(e -> e.getGender().equalsIgnoreCase("male")).toList().size(),

                                employeeService.findAllEmployeeInADepartment(d).stream().filter(e -> e.getGender().equalsIgnoreCase("female")).toList().size(),

                                employeeService.findAllEmployeeInADepartment(d).stream().filter(e ->
                                        (LocalDate.now().getYear() - e.getDateOfBirth().getYear()) < 23
                                ).toList().size()
                        )
                ).toList();


    }

    @Override
    public List<DepartmentAndTheirPro> departmentAndTheirPro() {
        return departmentRepository.findAll()
                .stream()
                .map(d -> new DepartmentAndTheirPro(d.getDepartmentId(),
                        projectService.getAll()
                                .stream()
                                .filter(p -> p.getDepartment().getDepartmentId() == d.getDepartmentId())
                                .toList()

                )).toList();

    }

    @Override
    public List<DepartmentAndTheirPro> departmentNameAndTheirPro() {
        return departmentRepository.findAll()
                .stream()
                .map(d -> new DepartmentAndTheirPro(
                        projectService.getAll()
                                .stream()
                                .filter(p -> p.getDepartment().getDepartmentId() == d.getDepartmentId())
                                .toList(),d.getDepartmentName()

                )).toList();
    }

    @Override
    public List<DepartmentAndTheirPro> departmentObjectAndTheirPro() {
        return departmentRepository.findAll()
                .stream()
                .map(d -> new DepartmentAndTheirPro(d,
                        projectService.getAll()
                                .stream()
                                .filter(p -> p.getDepartment().getDepartmentId() == d.getDepartmentId())
                                .toList()

                )).toList();
    }
}
