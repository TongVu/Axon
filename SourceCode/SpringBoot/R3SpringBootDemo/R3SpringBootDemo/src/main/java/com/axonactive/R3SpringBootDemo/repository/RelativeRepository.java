package com.axonactive.R3SpringBootDemo.repository;

import com.axonactive.R3SpringBootDemo.entity.Relative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelativeRepository
        extends JpaRepository<Relative, Long> {
}
