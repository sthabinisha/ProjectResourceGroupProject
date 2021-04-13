package com.itlize.res.repository;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectColumns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectColumnsRepository extends JpaRepository<ProjectColumns, Integer> {

    ProjectColumns findProjectColumnsByColumnId(Integer columnId);
    String deleteProjectColumnsByColumnId(Integer id);
    ProjectColumns findByColumnId(Integer columnid);
    Boolean existsByColumnId(Integer column_id);
}
