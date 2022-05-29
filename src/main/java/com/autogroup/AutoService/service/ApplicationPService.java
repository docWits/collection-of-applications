package com.autogroup.AutoService.service;

import com.autogroup.AutoService.model.ApplicationP;
import com.autogroup.AutoService.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicationPService {

    List<ApplicationP> getAllApplicationP();
    ApplicationP addApplicationP(ApplicationP applicationP);
    void deleteApplicationP(Long id);
    ApplicationP getById(Long id);
}
