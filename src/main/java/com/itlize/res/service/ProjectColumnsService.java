package com.itlize.res.service;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.ResourceDetails;

import java.util.Date;
import java.util.List;

public interface ProjectColumnsService {
    public List<ProjectColumns> getAllProjectColumns ();
    public ProjectColumns getProjectColumnById(Long column_id);
    String deleteProjectColumnbyID(Long pID);


    ProjectColumns addProjectColumn(ProjectColumns projectColumns);
    ProjectColumns updateProjectColumn(Long column_id, ProjectColumns projectColumns);
}
