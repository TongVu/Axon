package com.axonactive.demo.repository;

import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.service.dto.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT new com.axonactive.demo.service.dto.EmployeeDto(e.firstName, d.name, e.gender) " +
            "FROM Employee e, Department d WHERE e.department.id = d.id and d.id = :deptid ")
    List<EmployeeDto> getEmployeeInADepartment(@Param("deptid") Integer deptid);

    @Query(value="SELECT e.* FROM Employee e WHERE e.first_name like CONCAT('%',:firstName,'%')", nativeQuery = true)
    List<Employee> getEmployeebyFirstname(@Param("firstName") String firstname);



}
