package com.itlize.res.service;

import com.itlize.res.entity.Project;

import java.util.List;

public interface ProjectService {

    public List<Project> getAllProject ();
    void deleteAllProjectbyID(Integer cID);

    void getProjectName(Integer pID);
    Project addProject(Project project);
    Project getProjectById(Integer pId);
}
