package com.itlize.res.service;

import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.ResourceDetails;

import java.util.Date;
import java.util.List;

public interface ProjectColumnsService {
    public List<ProjectColumns> getAllProjectColumns ();

    ProjectColumns addResourceDetails(ProjectColumns projectColumns);
    ProjectColumns updateResourceDetail(ProjectColumns projectColumns);
}
