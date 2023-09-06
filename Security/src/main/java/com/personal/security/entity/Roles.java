package com.personal.security.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity(name = "roles")
@Table(name = "roles", schema = "public")
public class Roles implements GrantedAuthority
{
	/**
	 * version id
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String authority;
	
	@Column
	private Date created_at;
	
	@Column
	private Date updated_at;
	
	
	
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

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public void setAuthoity(String authoity) 
	{
		this.authority = authoity;
	}

	public static long getSerialversionuid() 
	{
		return serialVersionUID;
	}

	public String getAuthority() 
	{
		// TODO Auto-generated method stub
		return this.authority;
	}
	
}// UserGrantedAuthority
