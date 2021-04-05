package com.itlize.res.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class ResourceDetails {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(nullable = false, updatable = false, name="recordId")
    private Integer recordId;

    @Column(name="timeCreated")
    private Date timeCreated;

    @Column(name="lastUpdated")
    private Date lastUpdated;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "resourceId")
    private Resource resourceId;

    @Column(name="columnValue")
    private String columnValue;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="column_id")
    private ProjectColumns projectColumns;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="recordId",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<ProjectColumns> projectColumnsList;


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

    public ProjectColumns getProjectColumns() {
        return projectColumns;
    }

    public void setProjectColumns(ProjectColumns projectColumns) {
        this.projectColumns = projectColumns;
    }

    public List<ProjectColumns> getProjectColumnsList() {
        return projectColumnsList;
    }

    public void setProjectColumnsList(List<ProjectColumns> projectColumnsList) {
        this.projectColumnsList = projectColumnsList;
    }
}
