package com.itlize.res.controller;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.Resource;
import com.itlize.res.entity.ResourceDetails;
import com.itlize.res.payloads.ApiResponse;
import com.itlize.res.repository.ResourceDetailsRepository;
import com.itlize.res.service.ProjectColumnsService;
import com.itlize.res.service.ProjectService;
import com.itlize.res.service.ResourceDetailsService;
import com.itlize.res.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
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

    @Autowired
    private ResourceDetailsRepository resourceDetailsRepository;
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
        @PutMapping("/update/{record_id}")
        public ResponseEntity<?> updateUser(@PathVariable("record_id") Long id, @RequestBody ResourceDetails resourceDetails){
            if(resourceDetailsRepository.existsByRecordId(id)){
                resourceDetailsService.updateResourceDetail(id, resourceDetails);

                return ResponseEntity.ok(new ApiResponse(true, "Successfully updated the Resource Details: " + id));
            }else{
                return ResponseEntity.ok(new ApiResponse(false, "Project Column does not exist. The ID is  " + id));
            }



}

    @PostMapping("/add")
    public ResponseEntity<ResourceDetails> addProject(@RequestBody ResourceDetails resourceDetails){
        Resource resource = resourceService.getResourcesById(resourceDetails.getResourceId().getResourceID()).orElse(null);
        resourceDetails.setResourceId(resource);
        ProjectColumns columns = projectColumns.getProjectColumnById(resourceDetails.getColumnId().getColumnId());
        resourceDetails.setColumnId(columns);
        resourceDetails.setLastUpdated(Calendar.getInstance().getTime());
        resourceDetails.setTimeCreated(Calendar.getInstance().getTime());
        ResourceDetails newResource = resourceDetailsService.addResourceDetails(resourceDetails);
        return new ResponseEntity<>(newResource, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{record_id}")
    public ResponseEntity<String> deleteById(@PathVariable("record_id") Long cId){
        String deleteProject=  "Project column removed !! " + cId;
        resourceDetailsService.deleteAllResourceDetailsByID(cId);
        return new ResponseEntity<>( deleteProject, HttpStatus.OK);

    }
}
