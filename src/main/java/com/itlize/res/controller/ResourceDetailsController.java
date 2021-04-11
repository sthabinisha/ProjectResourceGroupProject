package com.itlize.res.controller;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.Resource;
import com.itlize.res.entity.ResourceDetails;
import com.itlize.res.service.ProjectColumnsService;
import com.itlize.res.service.ProjectService;
import com.itlize.res.service.ResourceDetailsService;
import com.itlize.res.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/auth/details")
public class ResourceDetailsController {

    private final ResourceDetailsService resourceDetailsService;

    @Autowired
    public ResourceDetailsController(ResourceDetailsService resourceDetailsService) {
        this.resourceDetailsService = resourceDetailsService;
    }


    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ProjectColumnsService projectColumns;

    @GetMapping("viewall")
    public ResponseEntity<List<ResourceDetails>> getAllProject(){
        List<ResourceDetails> allProject =  resourceDetailsService.getAllResourcesDetails();
        return new ResponseEntity<>(allProject, HttpStatus.OK);
    }

//    @GetMapping("/find/{record_id}")
//    public ResponseEntity<ProjectColumns> getProjectById(@PathVariable("record_id") Integer id){
//        ProjectColumns project = resourceDetailsService.(id);
//        return new ResponseEntity<>(project, HttpStatus.OK);
//    }
    @PutMapping("/update")
    public ResponseEntity<ResourceDetails> updateUser(@RequestBody ResourceDetails resourceDetails){
        ResourceDetails updateProjectColumn = resourceDetailsService.updateResourceDetail(resourceDetails.getRecordId());
        return new ResponseEntity<>(updateProjectColumn, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ResourceDetails> addProject(@RequestBody ResourceDetails resourceDetails){
        Resource resource = resourceService.getResourcesById(resourceDetails.getResourceId().getResourceID()).orElse(null);
        resourceDetails.setResourceId(resource);
        ProjectColumns columns = projectColumns.getProjectColumnById(resourceDetails.getColumnId().getColumnId());
        resourceDetails.setResourceId(resource);
        resourceDetails.setColumnId(columns);
        ResourceDetails newResource = resourceDetailsService.addResourceDetails(resourceDetails);
        return new ResponseEntity<>(newResource, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{record_id}")
    public ResponseEntity<String> deleteById(@PathVariable("record_id") Integer cId){
        String deleteProject=  "Project column removed !! " + cId;
        resourceDetailsService.deleteAllResourceDetailsByID(cId);
        return new ResponseEntity<>( deleteProject, HttpStatus.OK);

    }
}
