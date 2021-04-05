package com.itlize.res.service;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.ProjectResource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ProjectResourceService {
    public List<ProjectResource> getAllProjectResources();
    Integer getResourceId(Integer recordId);
    Integer getProjectId(Integer recordId);
    Date getTimeCreated(Integer recordId);
    ProjectResource deleteProjectDetails(Integer recordid);
}
