package com.axonactive.demo.repository;

import com.axonactive.demo.entity.Project;
import com.axonactive.demo.entity.Relative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelativeRepository extends JpaRepository<Relative, Integer> {
}
