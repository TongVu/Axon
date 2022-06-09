package com.axonactive.repository;

import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.demo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DepartmentLocationRepository extends JpaRepository<DepartmentLocation,Integer> {

    List<DepartmentLocation> findByLocationLike(Location location);

    List<DepartmentLocation> findByDeptIdDepartmentNameLike (String name);

    List<DepartmentLocation> findByIdBetween(Integer min,Integer max);

    List<DepartmentLocation> findAllByOrderById();

    List<DepartmentLocation> findAllByOrderByLocation();

    List<DepartmentLocation> findByDeptIdDepartmentIdLike(Integer departmentId);

    List<DepartmentLocation> findByDeptIdStartDateIsAfter(LocalDate date);

    List<DepartmentLocation> findByDeptIdDepartmentIdBetween(Integer min,Integer max);
}