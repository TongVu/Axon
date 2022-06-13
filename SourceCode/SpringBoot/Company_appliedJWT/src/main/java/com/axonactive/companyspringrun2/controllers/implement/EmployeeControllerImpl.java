package com.axonactive.companyspringrun2.controllers.implement;

import com.axonactive.companyspringrun2.Entities.Employee;
import com.axonactive.companyspringrun2.Service.EmployeeService;
import com.axonactive.companyspringrun2.controllers.EmployeeController;
import com.axonactive.companyspringrun2.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeControllerImpl implements EmployeeController {

    private final EmployeeService employeeService;

    @Override
    @GetMapping("/list")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @Override
    @PostMapping("/create")
    public Employee newEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @Override
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) throws NotFoundException {
        return employeeService.findEmployee(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee,@PathVariable String id) throws NotFoundException {
        return employeeService.findEmployee(id)
                .map(employee -> {
                    employee.setDateOfBirth(newEmployee.getDateOfBirth());
                    employee.setFirstName(newEmployee.getFirstName());
                    employee.setMiddleName(newEmployee.getMiddleName());
                    employee.setLastName(newEmployee.getLastName());
                    employee.setGender(newEmployee.getGender());
                    employee.setSalary(newEmployee.getSalary());
                    employee.setDepartment(newEmployee.getDepartment());
                    return employeeService.saveEmployee(employee);
                }).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable String id) throws NotFoundException {
        for (Employee em:employeeService.getAllEmployee()
             ) {
            if (em.getId().equalsIgnoreCase(id)){
                employeeService.deleteEmployee(id);
                System.out.println("Delete success!");
            }else throw new NotFoundException(id);
        }
    }
}
