package com.axonactive.demo.repositories;

import com.axonactive.demo.entities.Relative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelativeRepository
        extends JpaRepository<Relative, Long> {
}
