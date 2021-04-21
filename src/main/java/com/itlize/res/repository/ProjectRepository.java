package com.itlize.res.repository;

import com.itlize.res.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    //void deleteProjectRepositoryById(Integer id);

    Boolean existsByProjectId(Long id);
    String deleteByProjectId(Long id);
    Project findByProjectId(Long id);
}
