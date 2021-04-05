package com.itlize.res.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
public class User {


    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(nullable = false, updatable = false, name="userId")
    private Integer userId;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="title")
    private String title;
    @Column(name="email")
    private String email;
    @Column(name="role")
    private String role;
    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="lastUpdated")
    private Date lastUpdated;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="userId",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Project> project;

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }

    public User(){

    }

    public User(Integer userID, String username, String password, String title, String email, String role, Date createdDate, Date lastUpdated) {
        this.userId = userID;
        this.username = username;
        this.password = password;
        this.title = title;
        this.email = email;
        this.role = role;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
    }

    public User(Integer userID, String username, String password, String title, String email, String role, Date createdDate, Date lastUpdated, List<Project> project) {
        this.userId = userID;
        this.username = username;
        this.password = password;
        this.title = title;
        this.email = email;
        this.role = role;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
        this.project = project;
    }

    public Integer getUserID() {
        return userId;
    }

    public void setUserID(Integer userID) {
        this.userId = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", createdDate=" + createdDate +
                ", lastUpdated=" + lastUpdated +
                ", project=" + project +
                '}';
    }
}
