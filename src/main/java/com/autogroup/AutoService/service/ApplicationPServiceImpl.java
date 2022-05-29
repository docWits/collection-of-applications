package com.autogroup.AutoService.service;

import com.autogroup.AutoService.model.ApplicationP;
import com.autogroup.AutoService.repository.ApplicationPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationPServiceImpl implements ApplicationPService{

    private final ApplicationPRepository applicationPRepository;

    @Autowired
    public ApplicationPServiceImpl(ApplicationPRepository applicationPRepository) {
        this.applicationPRepository = applicationPRepository;
    }

    @Override
    public List<ApplicationP> getAllApplicationP() {
        return applicationPRepository.findAll();
    }

    @Override
    public ApplicationP addApplicationP(ApplicationP applicationP) {
        return applicationPRepository.save(applicationP);
    }

    @Override
    public void deleteApplicationP(Long id) {
        applicationPRepository.deleteById(id);
    }

    @Override
    public ApplicationP getById(Long id) {
        return applicationPRepository.getById(id);
    }
}
