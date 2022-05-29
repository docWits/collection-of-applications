package com.autogroup.AutoService.repository;

import com.autogroup.AutoService.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<Auto,Long> {
}
