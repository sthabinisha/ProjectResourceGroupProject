package com.itlize.res.controller;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectResource;
import com.itlize.res.entity.Resource;
import com.itlize.res.entity.User;
import com.itlize.res.payloads.ApiResponse;
import com.itlize.res.repository.ProjectRepository;
import com.itlize.res.repository.ProjectResourceRepository;
import com.itlize.res.repository.ResourcesRepository;
import com.itlize.res.service.ProjectResourceService;
import com.itlize.res.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/projectres")
public class ProjectResourceController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ResourcesRepository resourcesRepository;
    @Autowired
    private ProjectResourceService projectResourceService;
    @PostMapping("/add")
    public ResponseEntity<ProjectResource> addResourcetoProject(@RequestBody ProjectResource projectResource){
        if (!projectRepository.existsById(projectResource.getProjectID().getProjectId())) {
            return new ResponseEntity(new ApiResponse(false, "Project ID does not exist"), HttpStatus.BAD_REQUEST);
        }
        if (!resourcesRepository.existsById(projectResource.getResourceID().getResourceID())) {
            return new ResponseEntity(new ApiResponse(false, "Resource ID does not exist"), HttpStatus.BAD_REQUEST);
        }
       ProjectResource projectResource1 = new ProjectResource(Calendar.getInstance().getTime(), projectResource.getProjectID(), projectResource.getResourceID());

        projectResourceService.addProjectResource(projectResource1);
        return new ResponseEntity<>(projectResource1, HttpStatus.CREATED);
    }

    @GetMapping("/find/{record_id}")
    public ResponseEntity<Optional<ProjectResource>> getProjectById(@PathVariable("record_id") Long id){
        Optional<ProjectResource> project = projectResourceService.getProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
