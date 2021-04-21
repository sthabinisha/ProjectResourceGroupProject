package com.itlize.res.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class ProjectColumns {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(nullable = false, updatable = false, name="column_id")
    private Long columnId;

    @ManyToOne(cascade= CascadeType.DETACH)
    @JoinColumn(name= "project_id")
    private Project projectId;

    @Column(name = "column_name")
    private String columnName;

    @Column(name= "type")
    @Enumerated(EnumType.ORDINAL)
    private TypeEnum typeEnum;

    @Column(name= "formula_text")
    private String formulaText;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="columnId",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH}, orphanRemoval = true)
    private List<ResourceDetails> resourceDetails;


    public ProjectColumns() {
    }

    public ProjectColumns(String columnName, String formulaText, Project projectId, TypeEnum typeEnum) {
        this.projectId = projectId;
        this.columnName = columnName;
        this.typeEnum = typeEnum;
        this.formulaText = formulaText;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public Project getProject() {
        return projectId;
    }

    public void setProject(Project project) {
        this.projectId = project;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
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

    @Override
    public String toString() {
        return "ProjectColumns{" +
                "columnId=" + columnId +
                ", projectId=" + projectId +
                ", columnName='" + columnName + '\'' +
                ", typeEnum=" + typeEnum +
                ", formulaText='" + formulaText + '\'' +
                ", resourceDetails=" + resourceDetails +
                '}';
    }
}
