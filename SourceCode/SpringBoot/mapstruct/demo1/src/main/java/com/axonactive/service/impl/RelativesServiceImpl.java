package com.axonactive.service.impl;

import com.axonactive.demo.entity.Relatives;
import com.axonactive.repository.RelativesRepository;
import com.axonactive.service.RelativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativesServiceImpl implements RelativeService {
private final RelativesRepository relativesRepository;
    @Override
    public List<Relatives> getAll() {
        List<Relatives> allRelatives=relativesRepository.findAll();
        return allRelatives;
    }

    @Override
    public Optional<Relatives> getRelativeById(Integer id) {
        return relativesRepository.findById(id);
    }

    @Override
    public void saveRelative(Relatives relatives) {
    relativesRepository.save(relatives);
    }

    @Override
    public void deleteRelative(Integer id) {
    relativesRepository.deleteById(id);
    }
}

