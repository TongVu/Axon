package com.axonactive.companyspringrun2.Repositories;

import com.axonactive.companyspringrun2.Entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {
}
