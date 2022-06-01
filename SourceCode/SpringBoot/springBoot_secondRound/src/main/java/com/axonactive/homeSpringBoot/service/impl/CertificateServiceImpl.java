package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.repository.CertificateRepository;
import com.axonactive.homeSpringBoot.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    CertificateRepository certificateRepository;


    @Override
    public List<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    @Override
    public Optional<Certificate> findById(Integer id) {
        return certificateRepository.findById(id);
    }

    @Override
    public Certificate save(Certificate aircraft) {
        return certificateRepository.save(aircraft);
    }

    @Override
    public void deleteById(Integer id) {
        certificateRepository.deleteById(id);
    }
}
