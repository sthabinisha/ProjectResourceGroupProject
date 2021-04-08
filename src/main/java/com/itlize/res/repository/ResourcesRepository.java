package com.itlize.res.repository;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourcesRepository extends JpaRepository<Resource, Integer> {

    Resource findResourcesByResourceId(Integer id);

    //Resource findResourcesByResourceI
}
