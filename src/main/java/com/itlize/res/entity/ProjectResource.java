package com.itlize.res.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
public class ProjectResource {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(nullable = false, updatable = false, name="record_id")
    private Long recordId;

    @Column(name= "date_created")
    private Date dateCreated;

    @ManyToOne(cascade= CascadeType.DETACH)
    @JoinColumn(name="project_id")
    private Project projectId;

    @ManyToOne(cascade= CascadeType.DETACH)
    @JoinColumn(name="resource_id")
    private Resource resourceId;

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public Resource getResourceId() {
        return resourceId;
    }

    public void setResourceId(Resource resourceId) {
        this.resourceId = resourceId;
    }

    public ProjectResource() {
    }

    public ProjectResource(Date time, Project projectId, Resource resourceID) {
        this.dateCreated = time;
        this.projectId = projectId;
        this.resourceId = resourceID;
    }

    public ProjectResource(Long recordId, Date dateCreated, Project projectID, Resource resourceID) {
        this.recordId = recordId;
        this.dateCreated = dateCreated;
        this.projectId = projectID;
        this.resourceId = resourceID;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Project getProjectID() {
        return projectId;
    }

    public void setProjectID(Project projectID) {
        this.projectId = projectID;
    }

    public Resource getResourceID() {
        return resourceId;
    }

    public void setResourceID(Resource resourceID) {
        this.resourceId = resourceID;
    }

    @Override
    public String toString() {
        return "ProjectResource{" +
                "recordId=" + recordId +
                ", dateCreated=" + dateCreated +
                ", projectID=" + projectId +
                ", resourceID=" + resourceId +
                '}';
    }
}
