package com.itlize.res.controller;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.User;
import com.itlize.res.service.ProjectService;
import com.itlize.res.service.UserService;
import com.itlize.res.service.serviceImpl.ProjectServiceImpl;
import com.itlize.res.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("viewall")
    public ResponseEntity<List<Project>> getAllProject(){
        List<Project> allProject =  projectService.getAllProject();
        return new ResponseEntity<>(allProject, HttpStatus.OK);
    }

    @GetMapping("/find/{project_id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("project_id") Integer id){
        Project project = projectService.getProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Project> addProject(@RequestBody Project project){

        User user = userService.getUserByID(project.getUserId().getUserId()).orElse(null);
        project.setUserId(user);
        Project newProject = projectService.addProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }
//
//    @DeleteMapping("/delete/{project_id}")
//    public ResponseEntity<String> deleteById(@PathVariable("project_id") Integer projectId){
//        String deleteProject=  "Project removed !! " + projectId;
//        userService.deleteUserByID(projectId);
//        return new ResponseEntity<>( deleteProject, HttpStatus.OK);
//
//    }






}
