package com.itlize.res.repository;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ResourceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceDetailsRepository extends JpaRepository<ResourceDetails, Long> {
    Boolean existsByRecordId(Long id);
    ResourceDetails findByRecordId(Long id);
}
