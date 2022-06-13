package com.axonactive.companyspringrun2.Service.implement;

import com.axonactive.companyspringrun2.Entities.Department;
import com.axonactive.companyspringrun2.Repositories.DepartmentRepository;
import com.axonactive.companyspringrun2.Service.DepartmentService;
import com.axonactive.companyspringrun2.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeService employeeService;

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        departmentRepository.save(department);
        return department;
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Optional<Department> findDepartment(Integer id) {
        return departmentRepository.findById(id);
    }

//    public Page<Department> findPaginated(int pageNo, int pageSize) {
//        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
//        return this.departmentRepository.findAll(pageable);
//    }

    @Override
    public List<DepartmentNameAndNumberOfEmployeesDto> departmentNameAndNumberOfEmployees() {
        return departmentRepository.findAll().stream()
                .map(temp -> {
                    DepartmentNameAndNumberOfEmployeesDto dto = new DepartmentNameAndNumberOfEmployeesDto();
                    dto.setDepartmentName(temp.getDepartmentName());
                    dto.setStartDate(temp.getStartDate());
                    dto.setNumberOfEmployees(employeeService.getAllEmployee().stream()
                            .filter(e -> Objects.equals(e.getDepartment().getId(), temp.getId()))
                            .count());
                    dto.setNumberOfFemales(employeeService.getAllEmployee().stream()
                            .filter(f -> (
                                    f.getDepartment().getId().equals(temp.getId()) &&
                                            f.getGender().equalsIgnoreCase("Female")
                            ))
                            .count());
                    dto.setNumberOfMales(employeeService.getAllEmployee().stream()
                            .filter(m -> (
                                    m.getDepartment().getId().equals(temp.getId()) &&
                                            m.getGender().equalsIgnoreCase("Male")
                            ))
                            .count());
                    dto.setNumberOfU23(employeeService.getAllEmployee().stream()
                            .filter(u -> (
                                            u.getDepartment().getId().equals(temp.getId()) &&
                                                    ( LocalDate.now().getYear() - u.getDateOfBirth().getYear() < 23 )
                                    )
                            ).count());
                    return dto;
                }).collect(Collectors.toList());
    }

}
