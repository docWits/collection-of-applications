package com.autogroup.AutoService.service;

import com.autogroup.AutoService.model.Auto;
import com.autogroup.AutoService.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService{

    private final AutoRepository autoRepository;

    @Autowired
    public AutoServiceImpl(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public List<Auto> getAllAuto() {
        return autoRepository.findAll();
    }

    @Override
    public Auto addAuto(Auto auto) {
        return autoRepository.save(auto);
    }

    @Override
    public Auto getById(Long id) {
        return autoRepository.getById(id);
    }

    @Override
    public void deleteAuto(Long id) {
        autoRepository.deleteById(id);
    }
}
