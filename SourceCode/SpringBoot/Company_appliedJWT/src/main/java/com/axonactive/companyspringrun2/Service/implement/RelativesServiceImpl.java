package com.axonactive.companyspringrun2.Service.implement;

import com.axonactive.companyspringrun2.Entities.Relatives;
import com.axonactive.companyspringrun2.Repositories.RelativesRepository;
import com.axonactive.companyspringrun2.Service.RelativesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativesServiceImpl implements RelativesService {

    private final RelativesRepository relativesRepository;

    @Override
    public List<Relatives> getAllRelatives() {
    return relativesRepository.findAll();
    }

    @Override
    public Relatives saveRelative(Relatives relatives) {
        relativesRepository.save(relatives);
        return relatives;
    }

    @Override
    public void deleteRelative(Integer id) {
        relativesRepository.deleteById(id);
    }

    @Override
    public Optional<Relatives> findRelative(Integer id) {
        return relativesRepository.findById(id);
    }

    @Override
    public List<Relatives> findByFullName(String fullName) {
       return relativesRepository.findByFullName(fullName);
    }

    @Override
    public List<Relatives> findByGender(Integer gender) {
        return findByGender(gender);
    }

    @Override
    public Relatives findByPhoneNumber(String phoneNumber) {
        return findByPhoneNumber(phoneNumber);
    }

    @Override
    public Relatives findByRelationship(String relationShip) {
        return findByRelationship(relationShip);
    }

    @Override
    public Relatives findByEmployeeId(String id) {
        return findByEmployeeId(id);
    }

    @Override
    public Relatives findByEmployeeLastName(String lastName) {
        return findByEmployeeLastName(lastName);
    }

    @Override
    public Relatives findByEmployeeDepartmentId(Integer id) {
        return findByEmployeeDepartmentId(id);
    }

    @Override
    public List<Relatives> findByEmployeeDepartmentDepartmentName(String departmentName) {
        return findByEmployeeDepartmentDepartmentName(departmentName);
    }

    @Override
    public Relatives findByFullNameStartingWith(String character) {
        return findByFullNameStartingWith(character);
    }

    @Override
    public List<Relatives> findByEmployeeDepartmentDepartmentNameStartingWith(String character) {
        return findByEmployeeDepartmentDepartmentNameStartingWith(character);
    }

//    @Override
//    public List<Relatives> findByEmployeeDateOfBirth(int year,int month,int day) {
//        return findByEmployeeDateOfBirth(LocalDate.of(year,month,day));
//    }
}
