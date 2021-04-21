package com.itlize.res.controller;

import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.payloads.ApiResponse;
import com.itlize.res.repository.ProjectColumnsRepository;
import com.itlize.res.service.ProjectColumnsService;
import com.itlize.res.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/column")
public class ProjectColumnController {
    private final ProjectColumnsService projectColumnsService;

    @Autowired
    public ProjectColumnController(ProjectColumnsService projectColumnsService) {
        this.projectColumnsService = projectColumnsService;
    }


    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectColumnsRepository projectColumnsRepository;

    @GetMapping("viewall")
    public ResponseEntity<List<ProjectColumns>> getAllProject(){
        List<ProjectColumns> allProject =  projectColumnsService.getAllProjectColumns();
        return new ResponseEntity<>(allProject, HttpStatus.OK);
    }

    @GetMapping("/find/{column_id}")
    public ResponseEntity<ProjectColumns> getProjectById(@PathVariable("column_id") Long id){
        ProjectColumns project = projectColumnsService.getProjectColumnById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
    @PutMapping("/update/{column_id}")
    public ResponseEntity<?> updateUser(@PathVariable("column_id") Long id, @RequestBody ProjectColumns projectColumns){
        if(projectColumnsRepository.existsByColumnId(id)){
            projectColumnsService.updateProjectColumn(id, projectColumns);

            return ResponseEntity.ok(new ApiResponse(true, "Successfully updated the userID: " + id));
        }else{
            return ResponseEntity.ok(new ApiResponse(false, "Project Column does not exist. The ID is  " + id));
        }



    }



    @PostMapping("/add")
    public ResponseEntity<ProjectColumns> addProject(@RequestBody ProjectColumns projectColumns){
        System.out.println(projectColumns);



        ProjectColumns newProject = projectColumnsService.addProjectColumn(projectColumns);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{column_id}")
    public ResponseEntity<String> deleteById(@PathVariable("column_id") Long cId){
        String deleteProject=  "Project column removed !! " + cId;
        projectColumnsService.deleteProjectColumnbyID(cId);
        return new ResponseEntity<>( deleteProject, HttpStatus.OK);

    }

}
