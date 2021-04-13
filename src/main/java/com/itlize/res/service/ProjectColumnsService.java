package com.itlize.res.service;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.ResourceDetails;

import java.util.Date;
import java.util.List;

public interface ProjectColumnsService {
    public List<ProjectColumns> getAllProjectColumns ();
    public ProjectColumns getProjectColumnById(Integer column_id);
    String deleteProjectColumnbyID(Integer pID);


    ProjectColumns addProjectColumn(ProjectColumns projectColumns);
    ProjectColumns updateProjectColumn(Integer column_id, ProjectColumns projectColumns);
}
