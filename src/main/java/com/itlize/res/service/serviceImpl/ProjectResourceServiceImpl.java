package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.ProjectResource;
import com.itlize.res.repository.ProjectResourceRepository;
import com.itlize.res.service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectResourceServiceImpl implements ProjectResourceService {

    @Autowired
    private ProjectResourceRepository projectResourceRepository;

    @Override
    public List<ProjectResource> getAllProjectResources() {
        return projectResourceRepository.findAll();
    }



    @Override
    public String deleteProjectDetails(Integer recordid) {
         projectResourceRepository.deleteById(recordid);
         return "Delete project details By ID: "+ recordid;
    }
}
