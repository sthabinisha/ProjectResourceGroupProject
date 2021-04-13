package com.itlize.res.controller;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.Resource;
import com.itlize.res.entity.ResourceDetails;
import com.itlize.res.entity.User;
import com.itlize.res.payloads.ApiResponse;
import com.itlize.res.repository.ResourcesRepository;
import com.itlize.res.service.ProjectService;
import com.itlize.res.service.ResourceDetailsService;
import com.itlize.res.service.ResourceService;
import com.itlize.res.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.init.ResourceReader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ResourcesRepository resourcesRepository;

    @GetMapping("viewall")
    public ResponseEntity<List<Resource>> getAllResources(){
        List<Resource> allResources =  resourceService.getAllResources();
        return new ResponseEntity<>(allResources, HttpStatus.OK);
    }

    @GetMapping("/find/{resource_id}")
    public ResponseEntity<Optional<Resource> > getResources(@PathVariable("resource_id") Integer id){
        Optional<Resource> resource = resourceService.getResourcesById(id);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Resource> addResource(@RequestBody Resource resource){


        Resource newResource = resourceService.addResource(resource);
        return new ResponseEntity<>(newResource, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{resource_id}")
    public ResponseEntity<String> deleteById(@PathVariable("resource_id") Integer resourceId){
        String deleteProject=  "Resource " + resourceId+ " removed !!";

        if(resourcesRepository.existsById(resourceId)) {


            resourceService.deleteAllResourcebyID(resourceId);
            return new ResponseEntity(new ApiResponse(true, deleteProject), HttpStatus.OK);
        }else{
            return new ResponseEntity(new ApiResponse(false, "Resource Id "+ resourceId+" doesn't exist"), HttpStatus.BAD_REQUEST);

        }

    }


}
