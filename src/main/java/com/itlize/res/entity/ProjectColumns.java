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
    private Integer columnId;

    @ManyToOne(cascade= CascadeType.ALL)
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
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<ResourceDetails> resourceDetails;



    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
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
}
