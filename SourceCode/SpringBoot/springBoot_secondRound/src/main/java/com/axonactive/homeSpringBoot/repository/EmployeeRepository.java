package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.service.dto.EmployeeNotPilotDTO;
import com.axonactive.homeSpringBoot.service.dto.EmployeeWithHighestSalaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findBySalaryLessThan(Integer salary);

    /*
    SELECT *
FROM employees
WHERE employee_id NOT IN (
	SELECT employee_id
	FROM certificates
)
     */
        @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.EmployeeNotPilotDTO(id, name) " +
                "FROM Employee WHERE id NOT IN (SELECT c.employee.id FROM Certificate c)")
    List<EmployeeNotPilotDTO> findEmployeeWhoNotPilot();
    @Query(nativeQuery = true)
    List<EmployeeNotPilotDTO> findEmployeeWhoIsNotPilot();

    @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.EmployeeWithHighestSalaryDTO(id, name, salary) " +
            "FROM Employee WHERE salary = (SELECT MAX(salary) FROM Employee)")
    List<EmployeeWithHighestSalaryDTO> findEmployeeWithHighestSalary();

}
