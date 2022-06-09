package com.axonactive.repository;

import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.entity.Relatives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelativesRepository extends JpaRepository<Relatives, Integer> {
    List<Relatives> findByFullNameLike(String name);

    List<Relatives> findByPhoneNumberLike(String phoneNumber);

    List<Relatives> findByGender(Integer gender);

    List<Relatives> findByRelationshipLike(String relationship);

    List<Relatives> findByIdBetween(Integer min,Integer max);

    List<Relatives> findByEmployeeFirstNameOrEmployeeLastNameLike(String firstName,String lastName);

    Relatives findByEmployeeId(Integer id);

    List<Relatives> findByEmployeeIdBetween(Integer min,Integer max);

    List<Relatives> findByEmployeeDepartmentDepartmentNameLike(String name);

    List<Relatives> findAllByOrderByEmployeeId();

    List<Relatives> findAllByOrderByFullName();
}
