package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.ProjectResource;
import com.itlize.res.repository.ProjectResourceRepository;
import com.itlize.res.service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectResourceServiceImpl implements ProjectResourceService {

    @Autowired
    private ProjectResourceRepository projectResourceRepository;

    @Override
    public List<ProjectResource> getAllProjectResources() {
        return projectResourceRepository.findAll();
    }



    @Override
    public String deleteProjectDetails(Long recordid) {
         projectResourceRepository.deleteById(recordid);
         return "Delete project details By ID: "+ recordid;
    }

    @Override
    public void addProjectResource(ProjectResource projectResource1) {
        projectResourceRepository.save(projectResource1);

    }

    @Override
    public Optional<ProjectResource> getProjectById(Long record_id) {
        return projectResourceRepository.findById(record_id);
    }
}
