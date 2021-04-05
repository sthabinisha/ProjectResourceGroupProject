package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.repository.ProjectColumnsRepository;
import com.itlize.res.repository.ProjectRepository;
import com.itlize.res.service.ProjectColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProjectColumnServiceImpl implements ProjectColumnsService {


    @Autowired
    ProjectColumnsRepository projectColumnsRepository;

    @Override
    public List<ProjectColumns> getAllProjectColumns() {
        return projectColumnsRepository.findAll();
    }



    @Override
    public ProjectColumns addResourceDetails(ProjectColumns projectColumns) {
        return projectColumnsRepository.save(projectColumns);
    }

    @Override
    public ProjectColumns updateResourceDetail(ProjectColumns projectColumns) {
        return projectColumnsRepository.save(projectColumns);
    }
}
