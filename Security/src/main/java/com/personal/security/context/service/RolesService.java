package com.personal.security.context.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.security.context.repository.RolesRepository;
import com.personal.security.entity.Roles;

@Service
public class RolesService 
{
	@Autowired
	RolesRepository rolesRepository;
	
	public List<Roles> findAll()
	{
		return (List<Roles>) rolesRepository.findAll();
	}
}
