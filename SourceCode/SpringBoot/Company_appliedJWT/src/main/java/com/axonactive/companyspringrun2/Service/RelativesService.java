package com.axonactive.companyspringrun2.Service;

import com.axonactive.companyspringrun2.Entities.Relatives;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RelativesService {
    List<Relatives> getAllRelatives();

    Relatives saveRelative(Relatives relatives);

    void deleteRelative(Integer id);

    Optional<Relatives> findRelative(Integer id);

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

//    List<Relatives> findByEmployeeDateOfBirth (int year,int month,int day);
}
