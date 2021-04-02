package com.itlize.res.service;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProjectService {

    public List<Project> getAllProject ();
    void deleteAllProjectbyID(Integer pID);

    void getProjectName(Integer pID);
    Project addProjectResource(Project project);
}
