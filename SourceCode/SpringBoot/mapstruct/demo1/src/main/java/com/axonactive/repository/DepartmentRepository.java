package com.axonactive.repository;

import com.axonactive.demo.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.*;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    List<Department> findByDepartmentName(String departmentName);

    List<Department> findByDepartmentNameIgnoreCase(String name);

    Department findByDepartmentNameLike(String name);

    List<Department> findByDepartmentIdBetween(Integer min, Integer max);

    List<Department> findAllByOrderByDepartmentName();

    List<Department> findAllByOrderByStartDate();

    List<Department>findAllByOrderByDepartmentId();

    List<Department> findByStartDateAfter(LocalDate date);

    List<Department> findByDepartmentLocationLike(String name);


    //findByStartDate
}
