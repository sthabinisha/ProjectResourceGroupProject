package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.User;
import com.itlize.res.repository.ProjectColumnsRepository;
import com.itlize.res.repository.ProjectRepository;
import com.itlize.res.service.ProjectColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProjectColumnServiceImpl implements ProjectColumnsService {


    @Autowired
    ProjectColumnsRepository projectColumnsRepository;

    @Override
    public List<ProjectColumns> getAllProjectColumns() {
        return projectColumnsRepository.findAll();
    }


    @Override
    public ProjectColumns getProjectColumnById(Integer id) {
        return projectColumnsRepository.findProjectColumnsByColumnId(id);
    }


    @Override
    public ProjectColumns addProjectColumn(ProjectColumns projectColumns) {

        return projectColumnsRepository.save(projectColumns);
    }

    @Override
    public ProjectColumns updateProjectColumn(Integer id, ProjectColumns projectColumns) {
        ProjectColumns projectColumns1 = projectColumnsRepository.findByColumnId(id);
        projectColumns1.setProjectId(projectColumns.getProjectId());
        projectColumns1.setColumnName(projectColumns.getColumnName());
        System.out.println(projectColumns.getTypeEnum());

        projectColumns1.setTypeEnum(projectColumns.getTypeEnum());
        return projectColumnsRepository.save(projectColumns1);
    }
    @Override
    public String deleteProjectColumnbyID(Integer pID) {
        return projectColumnsRepository.deleteProjectColumnsByColumnId(pID);

    }
}
