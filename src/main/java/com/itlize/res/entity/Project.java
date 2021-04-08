package com.itlize.res.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(nullable = false, updatable = false, name="project_id")
    private Integer projectId;


    @Column(name="time_created")
    private Date timeCreated;

    @ManyToOne(cascade= CascadeType.DETACH)
    @JoinColumn(name="user_id")
    private User userId;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="projectId",
            cascade= CascadeType.ALL)
    private List<ProjectColumns> projectColumns;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="projectId",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<ProjectResource> projectResources;

    public List<ProjectResource> getProjectResources() {
        return projectResources;
    }

    public void setProjectResources(List<ProjectResource> projectResources) {
        this.projectResources = projectResources;
    }


    public Project() {
    }

    public Project(Integer projectId, Date timeCreated, User userId, List<ProjectColumns> projectColumns, List<ProjectResource> projectResources) {
        this.projectId = projectId;
        this.timeCreated = timeCreated;
        this.userId = userId;
        this.projectColumns = projectColumns;
        this.projectResources = projectResources;
    }

    public List<ProjectColumns> getProjectColumns() {
        return projectColumns;
    }

    public void setProjectColumns(List<ProjectColumns> projectColumns) {
        this.projectColumns = projectColumns;
    }


    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", timeCreated=" + timeCreated +
                ", userId=" + userId +
                ", projectColumns=" + projectColumns +
                ", projectResources=" + projectResources +
                '}';
    }
}
