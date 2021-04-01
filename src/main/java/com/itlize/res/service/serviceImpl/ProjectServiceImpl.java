package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.ProjectResource;
import com.itlize.res.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectServiceImpl implements ProjectService {


    @Autowired
    ProjectService projectService;

    @Override
    public void deleteAllProjectbyID(Integer pID) {

    }

    @Override
    public void getProjectName(Integer pID) {

    }

    @Override
    public ProjectResource addProjectResource(Integer pID, String projectName) {
        return null;
    }
}
