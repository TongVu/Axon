package com.axonactive.R3SpringBootDemo.repository;

import com.axonactive.R3SpringBootDemo.entity.Relative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RelativeRepository
        extends JpaRepository<Relative, Long> {
    Optional<Relative> findRelativeByEmployeeId(Long empId);

    Optional<Relative> findRelativeByFullName(String name);

}
