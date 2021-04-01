package com.itlize.res.service;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectResource;

import java.util.ArrayList;
import java.util.List;

public interface ProjectService {

    List<Project> getAllProject = new ArrayList<>();
    void deleteAllProjectbyID(Integer pID);

    void getProjectName(Integer pID);
    ProjectResource addProjectResource(Integer pID, String projectName);
}
