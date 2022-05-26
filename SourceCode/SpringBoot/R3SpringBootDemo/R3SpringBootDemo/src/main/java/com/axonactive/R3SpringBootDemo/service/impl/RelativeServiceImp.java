package com.axonactive.R3SpringBootDemo.service.impl;

import com.axonactive.R3SpringBootDemo.dtoData.RelativeDTO;
import com.axonactive.R3SpringBootDemo.entity.Relative;
import com.axonactive.R3SpringBootDemo.repository.RelativeRepository;
import com.axonactive.R3SpringBootDemo.service.RelativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativeServiceImp implements RelativeService {

    @Autowired
    private final RelativeRepository relativeRepository;

    @Override
    public List<Relative> getAllRelative() {
        return relativeRepository.findAll();
    }

    @Override
    public Relative saveRelative(Relative relative) {
        return relativeRepository.save(relative);
    }

    @Override
    public void deleteRelativeById(Long id) {
        relativeRepository.deleteById(id);
    }

    @Override
    public Optional<Relative> findRelativeById(Long id) {
        return relativeRepository.findById(id);
    }

    @Override
    public Optional<Relative> findRelativeByEmployeeId(Long empId) {
        return relativeRepository.findRelativeByEmployeeId(empId);
    }

    public Optional<Relative> findRelativeByFullName(String name) {
        return  relativeRepository.findRelativeByFullName(name);
    }

    @Override
    public Relative toRelativeEntity(RelativeDTO relativeDTO) {
        return new Relative(
                relativeDTO.getId(),
                relativeDTO.getFullName(),
                relativeDTO.getGender(),
                relativeDTO.getPhoneNumber(),
                relativeDTO.getRelationship(),
                relativeDTO.getEmployee());
    }

    @Override
    public List<Relative> toRelativeEntity(List<RelativeDTO> relativeDTOs) {
        List<Relative> relativeList = new ArrayList<>();

        for (RelativeDTO relativeDTO : relativeDTOs) {
            relativeList.add(this.toRelativeEntity(relativeDTO));
        }
        return relativeList;
    }

    @Override
    public RelativeDTO toRelativeDTO(Relative relative) {
        return new RelativeDTO(
                relative.getId(),
                relative.getFullName(),
                relative.getGender(),
                relative.getPhoneNumber(),
                relative.getRelationship(),
                relative.getEmployee());
    }

    @Override
    public List<RelativeDTO> toRelativeDTO(List<Relative> relativeList) {
        List<RelativeDTO> relativeDTOList = new ArrayList<>();
        for (Relative relative : relativeList)
            relativeDTOList.add(this.toRelativeDTO(relative));

        return relativeDTOList;
    }
}
