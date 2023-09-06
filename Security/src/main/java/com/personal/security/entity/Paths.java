package com.personal.security.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "paths")
@Table(name = "paths", schema = "public")
public class Paths 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column
	private String path;
	
	@Column
	private boolean isenabled;
	
	@Column
	private Date created_at;
	
	@Column
	private Date updated_at;
	
	

	public boolean isIsenabled() {
		return isenabled;
	}

	public void setIsenabled(boolean isenabled) {
		this.isenabled = isenabled;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isEnabled() {
		return isenabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isenabled = isEnabled;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdate_at() {
		return updated_at;
	}

	public void setUpdate_at(Date update_at) {
		this.updated_at = update_at;
	}
	
	
}
