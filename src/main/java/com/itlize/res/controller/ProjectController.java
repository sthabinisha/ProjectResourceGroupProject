package com.itlize.res.controller;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.Resource;
import com.itlize.res.entity.User;
import com.itlize.res.payloads.ApiResponse;
import com.itlize.res.repository.ProjectRepository;
import com.itlize.res.repository.ResourcesRepository;
import com.itlize.res.repository.RoleRepository;
import com.itlize.res.repository.UserRepository;
import com.itlize.res.service.ProjectService;
import com.itlize.res.service.ResourceService;
import com.itlize.res.service.UserService;
import com.itlize.res.service.serviceImpl.ProjectServiceImpl;
import com.itlize.res.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ProjectRepository projectRepository;



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
        project.setTimeCreated(Calendar.getInstance().getTime());

        Project newProject = projectService.addProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }



    @DeleteMapping("/delete/{project_id}")
    public ResponseEntity<?> deleteById(@PathVariable("project_id") Integer projectId){

        if(projectRepository.existsById(projectId)) {


            String deleteProject = "Project removed !! " + projectId;
            projectService.deleteAllProjectbyID(projectId);
            return new ResponseEntity(new ApiResponse(true, deleteProject), HttpStatus.OK);
        }else{
            return new ResponseEntity(new ApiResponse(false, "Project Id doesn't exist"), HttpStatus.BAD_REQUEST);

        }

    }






}
