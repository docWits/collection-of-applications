package com.autogroup.AutoService.service;

import com.autogroup.AutoService.model.ApplicationP;
import com.autogroup.AutoService.model.ApplicationT;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicationTService {
    List<ApplicationT> getAllApplicationT();
    ApplicationT addApplicationT(ApplicationT applicationT);
    ApplicationT getById(Long id);
    void deleteApplicationT(Long id);
}
