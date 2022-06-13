package com.axonactive.companyspringrun2.Service.implement;

import com.axonactive.companyspringrun2.Entities.DepartmentLocation;
import com.axonactive.companyspringrun2.Repositories.DepartmentLocationRepository;
import com.axonactive.companyspringrun2.Service.DepartmentLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentLocationImpl implements DepartmentLocationService {

    private final DepartmentLocationRepository departmentLocationRepository;

    @Override
    public List<DepartmentLocation> getAllDepartmentLocation() {
    return departmentLocationRepository.findAll();
    }

    @Override
    public DepartmentLocation saveDepartmentLocation(DepartmentLocation departmentLocation) {
        departmentLocationRepository.save(departmentLocation);
        return departmentLocation;
    }

    @Override
    public void deleteDepartmentLocation(Integer id) {
        departmentLocationRepository.deleteById(id);
    }

    @Override
    public Optional<DepartmentLocation> findDepartmentLocation(Integer id) {
        return departmentLocationRepository.findById(id);
    }
}
