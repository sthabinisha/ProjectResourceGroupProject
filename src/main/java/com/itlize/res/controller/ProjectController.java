package com.itlize.res.controller;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.User;
import com.itlize.res.service.ProjectService;
import com.itlize.res.service.serviceImpl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

//    public ProjectController() {
//    }
    @Autowired
    private ProjectService projectService;


    @GetMapping
    public ResponseEntity<List<Project>> getAllProject(){
        List<Project> allProject =  projectService.getAllProject();

        return new ResponseEntity<>(allProject, HttpStatus.OK);

    }

    @PostMapping("/addproject")
    public ResponseEntity<Project> addProject(@RequestBody Project project){

        Project newProject = projectService.addProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

}
