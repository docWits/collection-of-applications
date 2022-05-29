package com.autogroup.AutoService.repository;

import com.autogroup.AutoService.model.ApplicationP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationPRepository extends JpaRepository<ApplicationP,Long> {
}
