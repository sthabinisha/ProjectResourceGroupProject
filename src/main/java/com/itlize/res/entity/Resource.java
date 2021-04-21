package com.itlize.res.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, name="resource_id")
    private Long resourceId;

    @Column(name = "time_created")
    private Date timeCreated;

    @Column(name = "last_updated")
    private Date lastUpdated;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="resourceId",
            cascade= CascadeType.ALL, orphanRemoval = true)
    private List<ResourceDetails> resourceDetailsList;
    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="resourceId",
            cascade= CascadeType.ALL, orphanRemoval = true)
    private Set<ProjectResource> projectResourceList;



    public Resource() {
    }

    public Resource(Long resourceID, Date timeCreated, Date lastUpdated) {
        this.resourceId = resourceID;
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
    }

    public Long getResourceID() {
        return resourceId;
    }

    public void setResourceID(Long resourceID) {
        this.resourceId = resourceID;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public List<ResourceDetails> getResourceDetailsList() {
        return resourceDetailsList;
    }

    public void setResourceDetailsList(List<ResourceDetails> resourceDetailsList) {
        this.resourceDetailsList = resourceDetailsList;
    }

    public Set<ProjectResource> getProjectResourceList() {
        return projectResourceList;
    }

    public void setProjectResourceList(Set<ProjectResource> projectResourceList) {
        this.projectResourceList = projectResourceList;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
