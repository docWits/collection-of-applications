package com.autogroup.AutoService.repository;

import com.autogroup.AutoService.model.ApplicationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationInfoRepository extends JpaRepository<ApplicationInfo,Long> {
}
