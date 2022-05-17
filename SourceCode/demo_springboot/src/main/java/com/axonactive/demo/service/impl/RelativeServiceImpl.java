package com.axonactive.demo.service.impl;

import com.axonactive.demo.entity.Project;
import com.axonactive.demo.entity.Relative;
import com.axonactive.demo.repository.RelativeRepository;
import com.axonactive.demo.service.RelativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelativeServiceImpl implements RelativeService {
    private final RelativeRepository relativeRepository;

    @Override
    public List<Relative> getAll(){
        return relativeRepository.findAll();
    }
}
