package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.Project;
import com.itlize.res.repository.ProjectRepository;
import com.itlize.res.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public String deleteAllProjectbyID(Integer pID) {
        return projectRepository.deleteByProjectId(pID);

    }

        @Override
    public void getProjectName(Integer pID) {
        projectRepository.findById(pID);

    }

    @Override
    public Project addProject(Project project) {
        return  projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Integer pId) {
        return projectRepository.findByProjectId(pId);
    }

}
