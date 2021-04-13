package com.itlize.res.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class ResourceDetails {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(nullable = false, updatable = false, name="record_id")
    private Integer recordId;

    @Column(name="time_created")
    private Date timeCreated;

    @Column(name="last_updated")
    private Date lastUpdated;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "resource_id")
    private Resource resourceId;

    @Column(name="column_value")
    private String columnValue;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="column_id")
    private ProjectColumns columnId;


    public ResourceDetails() {
    }

    public ResourceDetails(Integer recordId, Date timeCreated, Date lastUpdated, Resource resourceId, String columnValue, ProjectColumns columnId) {
        this.recordId = recordId;
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
        this.resourceId = resourceId;
        this.columnValue = columnValue;
        this.columnId = columnId;
    }

    public ResourceDetails(Integer recordId, Resource resourceId, String columnValue) {
        this.recordId = recordId;

        this.resourceId = resourceId;
        this.columnValue = columnValue;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Resource getResource() {
        return resourceId;
    }

    public void setResource(Resource resource) {
        this.resourceId = resource;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    public Resource getResourceId() {
        return resourceId;
    }

    public void setResourceId(Resource resourceId) {
        this.resourceId = resourceId;
    }

    public ProjectColumns getColumnId() {
        return columnId;
    }

    public void setColumnId(ProjectColumns columnId) {
        this.columnId = columnId;
    }

    @Override
    public String toString() {
        return "ResourceDetails{" +
                "recordId=" + recordId +
                ", timeCreated=" + timeCreated +
                ", lastUpdated=" + lastUpdated +
                ", resourceId=" + resourceId +
                ", columnValue='" + columnValue + '\'' +
                ", columnId=" + columnId +
                '}';
    }
}
