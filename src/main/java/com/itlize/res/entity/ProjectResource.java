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

//    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="projectId")
    private Integer projectId;

//    @ManyToOne(cascade= CascadeType.ALL)
//    @JoinColumn(name="resourceId", foreignKey = @ForeignKey)
    @JoinColumn(name = "resourceId",foreignKey = @ForeignKey(name ="resourceId",
                                            value = ConstraintMode.NO_CONSTRAINT))
    private Resource resource;

    public ProjectResource() {
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
