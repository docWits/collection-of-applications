package com.autogroup.AutoService.service;

import com.autogroup.AutoService.model.Auto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AutoService {

    List<Auto> getAllAuto();
    Auto addAuto(Auto auto);
    Auto getById(Long id);
    void deleteAuto(Long id);

}
