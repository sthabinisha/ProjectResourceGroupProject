package com.itlize.res.controller;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.User;
import com.itlize.res.service.ProjectColumnsService;
import com.itlize.res.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projectColumn")
public class ProjectColumnController {
    private final ProjectColumnsService projectColumnsService;

    @Autowired
    public ProjectColumnController(ProjectColumnsService projectColumnsService) {
        this.projectColumnsService = projectColumnsService;
    }


    @Autowired
    private ProjectService projectService;

    @GetMapping("viewall")
    public ResponseEntity<List<ProjectColumns>> getAllProject(){
        List<ProjectColumns> allProject =  projectColumnsService.getAllProjectColumns();
        return new ResponseEntity<>(allProject, HttpStatus.OK);
    }

    @GetMapping("/find/{column_id}")
    public ResponseEntity<ProjectColumns> getProjectById(@PathVariable("column_id") Integer id){
        ProjectColumns project = projectColumnsService.getProjectColumnById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ProjectColumns> updateUser(@RequestBody ProjectColumns projectColumns){
        ProjectColumns updateProjectColumn = projectColumnsService.updateProjectColumn(projectColumns);
        return new ResponseEntity<>(updateProjectColumn, HttpStatus.OK);
    }
    @PostMapping("/addproject")
    public ResponseEntity<ProjectColumns> addProject(@RequestBody ProjectColumns projectColumns){
        System.out.println(projectColumns);
        Project project = projectService.getProjectById(projectColumns.getProjectId().getProjectId());
        projectColumns.setProjectId(project);

        ProjectColumns newProject = projectColumnsService.addProjectColumn(projectColumns);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{column_id}")
    public ResponseEntity<String> deleteById(@PathVariable("column_id") Integer cId){
        String deleteProject=  "Project column removed !! " + cId;
        projectColumnsService.deleteProjectColumnbyID(cId);
        return new ResponseEntity<>( deleteProject, HttpStatus.OK);

    }

}
