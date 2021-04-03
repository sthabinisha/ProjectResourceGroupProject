package com.itlize.res.entity;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
public class ProjectResource {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(nullable = false, updatable = false, name="record_Id")
    private Integer recordId;

    @Column(name= "dateCreated")
    private Date dateCreated;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="projectID")
    private Project projectID;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="resourceID")
    private Resource resourceID;

    public ProjectResource() {
    }

    public ProjectResource(Integer recordId, Date dateCreated, Project projectID, Resource resourceID) {
        this.recordId = recordId;
        this.dateCreated = dateCreated;
        this.projectID = projectID;
        this.resourceID = resourceID;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Project getProjectID() {
        return projectID;
    }

    public void setProjectID(Project projectID) {
        this.projectID = projectID;
    }

    public Resource getResourceID() {
        return resourceID;
    }

    public void setResourceID(Resource resourceID) {
        this.resourceID = resourceID;
    }

    @Override
    public String toString() {
        return "ProjectResource{" +
                "recordId=" + recordId +
                ", dateCreated=" + dateCreated +
                ", projectID=" + projectID +
                ", resourceID=" + resourceID +
                '}';
    }
}
