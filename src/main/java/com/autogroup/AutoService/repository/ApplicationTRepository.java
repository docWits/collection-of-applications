package com.autogroup.AutoService.repository;

import com.autogroup.AutoService.model.ApplicationT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationTRepository extends JpaRepository<ApplicationT,Long> {
}
