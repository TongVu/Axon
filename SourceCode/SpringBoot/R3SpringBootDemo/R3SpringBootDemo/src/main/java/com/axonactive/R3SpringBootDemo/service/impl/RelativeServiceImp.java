package com.axonactive.R3SpringBootDemo.service.impl;

import com.axonactive.R3SpringBootDemo.entity.Relative;
import com.axonactive.R3SpringBootDemo.repository.RelativeRepository;
import com.axonactive.R3SpringBootDemo.service.RelativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Relative> saveRelative(Relative relative){
        relativeRepository.save(relative);
        return null;
    }

    @Override
    public void deleteRelativeById(Long id){
        relativeRepository.deleteById(id);
    }

    @Override
    public Optional<Relative> findRelativeById(Long id) {
        return relativeRepository.findById(id);
    }
    @Override
    public Optional<Relative> findRelativeByEmployeeId(Long empId){
        return relativeRepository.findRelativeByEmployeeId(empId);
    }
}
