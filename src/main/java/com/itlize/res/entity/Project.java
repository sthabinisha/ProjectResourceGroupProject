package com.itlize.res.entity;


import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(nullable = false, updatable = false, name="projectId")
    private Integer projectId;


    @Column(name="timeCreated")
    private Date timeCreated;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="userId")
    private User userId;

    @OneToOne(fetch=FetchType.LAZY,
            mappedBy="projectId",
            cascade= CascadeType.ALL)
    private ProjectColumns projectColumns;


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

    public ProjectColumns getProjectColumns() {
        return projectColumns;
    }

    public void setProjectColumns(ProjectColumns projectColumns) {
        this.projectColumns = projectColumns;
    }

    public Project() {
    }



    public Integer getProjectID() {
        return projectId;
    }

    public void setProjectID(Integer projectID) {
        this.projectId = projectID;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public User getOwner() {
        return userId;
    }

    public void setOwner(User owner) {
        this.userId = owner;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectID=" + projectId +
                ", timeCreated=" + timeCreated +
                ", owner=" + userId +
                '}';
    }
}
