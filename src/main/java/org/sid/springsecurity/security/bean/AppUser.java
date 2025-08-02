package org.sid.springsecurity.security.bean;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    @Column(unique = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany(fetch =FetchType.EAGER)
    private Collection<AppRole> appRoles=new ArrayList<>();


    public AppUser() {
    }

    public AppUser(Long id, String username, String password, Collection<AppRole> appRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.appRoles = appRoles;
    }

    public void addRole(AppRole role) {
        appRoles.add(role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Collection<AppRole> getAppRoles() {
        return appRoles;
    }

    public void setAppRoles(Collection<AppRole> appRoles) {
        this.appRoles = appRoles;
    }
}

