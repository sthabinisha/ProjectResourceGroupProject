package com.itlize.res.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, name="resource_id")
    private Integer resourceId;

    @Column(name = "time_created")
    private Date timeCreated;

    @Column(name = "last_updated")
    private Date lastUpdated;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="resourceId",
            cascade= CascadeType.ALL)
    private List<ResourceDetails> resourceDetailsList;
    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="resourceId",
            cascade= CascadeType.ALL)
    private List<ProjectResource> projectResourceList;



    public Resource() {
    }

    public Resource(Integer resourceID, Date timeCreated, Date lastUpdated) {
        this.resourceId = resourceID;
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
    }

    public Integer getResourceID() {
        return resourceId;
    }

    public void setResourceID(Integer resourceID) {
        this.resourceId = resourceID;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public List<ResourceDetails> getResourceDetailsList() {
        return resourceDetailsList;
    }

    public void setResourceDetailsList(List<ResourceDetails> resourceDetailsList) {
        this.resourceDetailsList = resourceDetailsList;
    }

    public List<ProjectResource> getProjectResourceList() {
        return projectResourceList;
    }

    public void setProjectResourceList(List<ProjectResource> projectResourceList) {
        this.projectResourceList = projectResourceList;
    }


    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
