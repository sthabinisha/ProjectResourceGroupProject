package com.itlize.res.entity;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class ProjectColumns {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(nullable = false, updatable = false, name="recordId")
    private Integer recordId;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "projectId")
    private Project project;

    @Column(name = "projectName")
    private String projectName;

    @Column(name= "type")
    @Enumerated(EnumType.ORDINAL)
    private TypeEnum typeEnum;

    @Column(name= "formulaText")
    private String formulaText;


    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="projectCol",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<ResourceDetails> resourceDetails;


    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public String getFormulaText() {
        return formulaText;
    }

    public void setFormulaText(String formulaText) {
        this.formulaText = formulaText;
    }

    public List<ResourceDetails> getResourceDetails() {
        return resourceDetails;
    }

    public void setResourceDetails(List<ResourceDetails> resourceDetails) {
        this.resourceDetails = resourceDetails;
    }
}
