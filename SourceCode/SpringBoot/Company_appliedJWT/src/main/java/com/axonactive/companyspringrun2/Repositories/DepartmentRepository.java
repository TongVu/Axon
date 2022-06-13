package com.axonactive.companyspringrun2.Repositories;

import com.axonactive.companyspringrun2.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
