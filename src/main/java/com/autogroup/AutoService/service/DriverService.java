package com.autogroup.AutoService.service;

import com.autogroup.AutoService.model.Auto;
import com.autogroup.AutoService.model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DriverService {
    List<Driver> getAllDriver();
    Driver addDriver(Driver driver);
    Driver getById(Long id);
    void deleteDriver(Long id);
}
