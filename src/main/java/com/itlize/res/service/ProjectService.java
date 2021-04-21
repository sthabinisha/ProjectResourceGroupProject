package com.itlize.res.service;

import com.itlize.res.entity.Project;

import java.util.List;

public interface ProjectService {

    public List<Project> getAllProject ();
    void deleteAllProjectbyID(Long cID);

    void getProjectName(Long pID);
    Project addProject(Project project);
    Project getProjectById(Long pId);
}
