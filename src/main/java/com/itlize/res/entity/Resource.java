package com.itlize.res.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, name="resourceId")
    private Integer resourceID;



    @Column(name = "timeCreated")
    private Date timeCreated;

    @Column(name = "lastUpdated")
    private Date lastUpdated;

    @OneToOne(fetch=FetchType.LAZY,
            mappedBy="Resource",
            cascade= CascadeType.ALL)
    @JoinColumn(name="resourceDetail")
    private ResourceDetails resourceDetails;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="resources",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<ProjectResource> project;

    public Resource() {
    }

    public Resource(Integer resourceID, Date timeCreated, Date lastUpdated) {
        this.resourceID = resourceID;
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
    }

    public Integer getResourceID() {
        return resourceID;
    }

    public void setResourceID(Integer resourceID) {
        this.resourceID = resourceID;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public ResourceDetails getResourceDetails() {
        return resourceDetails;
    }

    public void setResourceDetails(ResourceDetails resourceDetails) {
        this.resourceDetails = resourceDetails;
    }

    public List<ProjectResource> getProject() {
        return project;
    }

    public void setProject(List<ProjectResource> project) {
        this.project = project;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
