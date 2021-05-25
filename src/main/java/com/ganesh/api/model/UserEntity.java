package com.ganesh.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @Ptoject: books-ws
 * @Author: Ganesh
 * @Date: May 25, 2021
 */


@Entity
@Table(name = "USERS")
public class UserEntity {

    @Column(name = "Username")
    @Id
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Enabled")
    private boolean enabled;
    
    @OneToMany(mappedBy="userEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AuthoritiesEntity> authoritiesEntities;

    public UserEntity() {
    }

    public UserEntity(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

	public Set<AuthoritiesEntity> getAuthoritiesEntities() {
		return authoritiesEntities;
	}

	public void setAuthoritiesEntities(Set<AuthoritiesEntity> authoritiesEntities) {
		this.authoritiesEntities = authoritiesEntities;
	}
    
    
}

