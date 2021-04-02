package com.itlize.res.repository;

import com.itlize.res.entity.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectResourceRepository extends JpaRepository<ProjectResource, Integer> {
}
