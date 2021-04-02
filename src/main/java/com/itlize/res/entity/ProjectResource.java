package com.itlize.res.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
public class ProjectResource {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(nullable = false, updatable = false, name="prID")

    private Integer prID;
    @Column(name="pID")
    private Integer pID;
    @Column(name="rID")
    private Integer rID;

    public ProjectResource(Integer pID, Integer rID) {
        this.pID = pID;
        this.rID = rID;
    }

    public ProjectResource(Integer prID, Integer pID, Integer rID) {
        this.prID = prID;
        this.pID = pID;
        this.rID = rID;
    }

    public Integer getPrID() {
        return prID;
    }

    public void setPrID(Integer prID) {
        this.prID = prID;
    }

    public Integer getpID() {
        return pID;
    }

    public void setpID(Integer pID) {
        this.pID = pID;
    }

    public Integer getrID() {
        return rID;
    }

    public void setrID(Integer rID) {
        this.rID = rID;
    }
}
