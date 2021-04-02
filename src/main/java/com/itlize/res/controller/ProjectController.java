package com.itlize.res.controller;

import com.itlize.res.entity.Project;
import com.itlize.res.service.ProjectService;
import com.itlize.res.service.serviceImpl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    public ProjectController() {
    }
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProject(){
        return projectService.getAllProject();
    }

}
