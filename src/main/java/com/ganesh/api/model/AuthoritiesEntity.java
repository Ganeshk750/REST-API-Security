package com.ganesh.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Ptoject: books-ws
 * @Author: Ganesh
 * @Date: May 25, 2021
 */

@Entity
@Table(name = "AUTHORITIES")
public class AuthoritiesEntity {

	@Column(name = "Authority_Id")
    @Id
    private Integer authorityId;

    @Column(name = "Authority")
    private String authority;
    
    @Column(name = "Role")
    private String role;
    
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "Username", nullable = false)
//    private UserEntity userEntity;
    
    public AuthoritiesEntity() {}

	
	public AuthoritiesEntity(Integer authorityId, String authority, String role) {
		super();
		this.authorityId = authorityId;
		this.authority = authority;
		this.role = role;
	}

	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
    
    
}