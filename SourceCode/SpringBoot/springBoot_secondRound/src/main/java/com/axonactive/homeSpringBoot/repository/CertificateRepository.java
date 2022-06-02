package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    List<Certificate> findByAircraftId(Integer id);
}
