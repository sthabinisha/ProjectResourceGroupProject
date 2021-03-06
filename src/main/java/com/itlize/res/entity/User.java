package com.itlize.res.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

import static javax.persistence.GenerationType.IDENTITY;
@Entity

public class User{


    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(nullable = false, updatable = false, name="user_id")
    private Long userId;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="title")
    private String title;
    @Column(name="email")
    private String email;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @CreatedDate
    @Column(name="created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name="last_updated")
    private Date lastUpdated;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="userId",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH}, orphanRemoval = true)
    @JsonIgnore
    private List<Project> project;


    public User(Long userId, String username, String password, String title, String email, Set<Role> roles, Date createdDate, Date lastUpdated) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.title = title;
        this.email = email;
        this.roles = roles;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
    }

    public User() {

    }

    public User(String title) {
        this.title = title;
    }

    public User(String username, String email, String title) {
        this.username = username;
        this.email = email;

        this.title = title;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }

    public User(String username, String email, String password, Date createdDate, Date lastUpdated, String title){
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
        this.title = title;

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }



    public Long getUserID() {
        return userId;
    }

    public void setUserID(Long userID) {
        this.userId = userID;
    }

    public String getUsername() {
        return username;
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
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", createdDate=" + createdDate +
                ", lastUpdated=" + lastUpdated +
                ", project=" + project +
                '}';
    }
}
