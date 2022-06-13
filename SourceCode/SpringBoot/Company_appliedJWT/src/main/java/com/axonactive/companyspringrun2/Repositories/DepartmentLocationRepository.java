package com.axonactive.companyspringrun2.Repositories;

import com.axonactive.companyspringrun2.Entities.DepartmentLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentLocationRepository extends JpaRepository<DepartmentLocation,Integer> {

}
