package com.autogroup.AutoService.service;

import com.autogroup.AutoService.model.ApplicationT;
import com.autogroup.AutoService.repository.ApplicationTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationTServiceImpl implements ApplicationTService{

    private final ApplicationTRepository applicationTRepository;

    @Autowired
    public ApplicationTServiceImpl(ApplicationTRepository applicationTRepository) {
        this.applicationTRepository = applicationTRepository;
    }

    @Override
    public List<ApplicationT> getAllApplicationT() {
        return applicationTRepository.findAll();
    }

    @Override
    public ApplicationT addApplicationT(ApplicationT applicationT) {
        return applicationTRepository.save(applicationT);
    }

    @Override
    public ApplicationT getById(Long id) {
        return applicationTRepository.getById(id);
    }

    @Override
    public void deleteApplicationT(Long id) {

        applicationTRepository.deleteById(id);
    }
}
