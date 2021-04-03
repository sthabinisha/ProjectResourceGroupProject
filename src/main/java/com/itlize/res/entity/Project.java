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
    private Integer projectID;


    @Column(name="timeCreated")
    private Date timeCreated;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="owner")
    private User owner;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="project",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<ProjectResource> projectResources;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="project",
            cascade= CascadeType.ALL)
    private List<ProjectColumns> projectColumns;

    public List<ProjectResource> getProjectResources() {
        return projectResources;
    }

    public void setProjectResources(List<ProjectResource> projectResources) {
        this.projectResources = projectResources;
    }

    public List<ProjectColumns> getProjectColumns() {
        return projectColumns;
    }

    public void setProjectColumns(List<ProjectColumns> projectColumns) {
        this.projectColumns = projectColumns;
    }

    public Project() {
    }



    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectID=" + projectID +
                ", timeCreated=" + timeCreated +
                ", owner=" + owner +
                '}';
    }
}
