package com.axonactive.companyspringrun2.Repositories;

import com.axonactive.companyspringrun2.Entities.Relatives;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RelativesRepository extends JpaRepository<Relatives,Integer> {

    List<Relatives> findByFullName(String fullName);

    List<Relatives> findByGender(Integer gender);

    Relatives findByPhoneNumber(String phoneNumber);

    Relatives findByRelationship (String relationShip);

    Relatives findByEmployeeId (String id);

    Relatives findByEmployeeLastName (String lastName);

    Relatives findByEmployeeDepartmentId(Integer id);

    List<Relatives> findByEmployeeDepartmentDepartmentName (String departmentName);

    Relatives findByFullNameStartingWith (String character);

    List <Relatives> findByEmployeeDepartmentDepartmentNameStartingWith (String Character);

    List<Relatives> findByEmployeeDateOfBirth (LocalDate dateOfBirth);
}
