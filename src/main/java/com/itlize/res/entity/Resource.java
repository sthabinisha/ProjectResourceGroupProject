package com.itlize.res.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

public class Resource {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="resourceId")
    private Integer resourceID;

    @Column(name = "resource")
    private String Resource;

    @Column(name = "resourceCode")
    private Integer resourceCode;

    public Resource(int resourceID, String resource, int resourceCode) {
        this.resourceID = resourceID;
        Resource = resource;
        this.resourceCode = resourceCode;
    }

    public Resource(String resource, int resourceCode) {
        Resource = resource;
        this.resourceCode = resourceCode;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getResource() {
        return Resource;
    }

    public void setResource(String resource) {
        Resource = resource;
    }

    public int getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(int resourceCode) {
        this.resourceCode = resourceCode;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceID=" + resourceID +
                ", Resource='" + Resource + '\'' +
                ", resourceCode=" + resourceCode +
                '}';
    }
}
