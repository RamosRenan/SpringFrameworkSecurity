package com.personal.security.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "user")
@Table(name = "user", schema = "public")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String password;
	
	@Column
	private String username;
	
	@Column
	private Boolean isaccountnonexpired = false;
	
	@Column
	private Boolean isaccountnonlocked = false;
	
	@Column
	private Boolean iscredentialsnonexpired = false;
	
	@Column
	private Boolean isenabled = false;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "users")
	private List<RolesPaths> rolesPaths;
	
	@Column
	private Date created_at;
	
	@Column
	private Date updated_at;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isIsaccountnonexpired() {
		return isaccountnonexpired;
	}

	public void setIsaccountnonexpired(boolean isaccountnonexpired) {
		this.isaccountnonexpired = isaccountnonexpired;
	}

	public boolean isIsaccountnonlocked() {
		return isaccountnonlocked;
	}

	public void setIsaccountnonlocked(boolean isaccountnonlocked) {
		this.isaccountnonlocked = isaccountnonlocked;
	}

	public boolean isIscredentialsnonexpired() {
		return iscredentialsnonexpired;
	}

	public void setIscredentialsnonexpired(boolean iscredentialsnonexpired) {
		this.iscredentialsnonexpired = iscredentialsnonexpired;
	}

	public boolean isIsenabled() {
		return isenabled;
	}

	public void setIsenabled(boolean isenabled) {
		this.isenabled = isenabled;
	}

	public List<RolesPaths> getRolesPaths() {
		return rolesPaths;
	}

	public void setRolesPaths(List<RolesPaths> rolesPaths) {
		this.rolesPaths = rolesPaths;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
}// User
