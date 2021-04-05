package com.itlize.res.service;

import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.ResourceDetails;

import java.util.Date;
import java.util.List;

public interface ProjectColumnsService {
    public List<ProjectColumns> getAllProjectColumns ();
    String deleteAllprojectColByID(Integer columnId);
    String getformulaTextbyId(Integer columnId);

    String getColumnNameByColumnId(Integer columnId);
    ProjectColumns addResourceDetails(ProjectColumns projectColumns);
    ProjectColumns updateResourceDetail(Integer columnId);
}
