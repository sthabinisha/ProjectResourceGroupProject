package com.itlize.res.repository;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectColumns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectColumnsRepository extends JpaRepository<ProjectColumns, Long> {

    ProjectColumns findProjectColumnsByColumnId(Long columnId);
    String deleteProjectColumnsByColumnId(Long id);
    ProjectColumns findByColumnId(Long columnid);
    Boolean existsByColumnId(Long column_id);
}
