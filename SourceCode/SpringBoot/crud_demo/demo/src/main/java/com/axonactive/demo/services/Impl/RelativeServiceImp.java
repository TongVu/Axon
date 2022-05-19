package com.axonactive.demo.services.Impl;

import com.axonactive.demo.entities.Project;
import com.axonactive.demo.entities.Relative;
import com.axonactive.demo.repositories.ProjectRepository;
import com.axonactive.demo.repositories.RelativeRepository;
import com.axonactive.demo.services.ProjectService;
import com.axonactive.demo.services.RelativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativeServiceImp implements RelativeService {

    @Autowired
    private final RelativeRepository relativeRepository;

    @Override
    public List<Relative> getAllRelative(){
        return relativeRepository.findAll();
    }

    @Override
    public void saveRelative(Relative relative){
        relativeRepository.save(relative);
    }

    @Override
    public void deleteRelativeById(Long id){
        relativeRepository.deleteById(id);
    }

    @Override
    public Optional<Relative> findRelativeById(Long id) {
        return relativeRepository.findById(id);
    }
}
