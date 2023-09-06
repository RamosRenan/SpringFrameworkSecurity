package com.personal.security.context.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.security.context.repository.RolesPathsRepository;
import com.personal.security.entity.RolesPaths;

@Service
public class RolesPathsService 
{
	@Autowired
	RolesPathsRepository rolesPathsRepository;
	
	public List<RolesPaths> findAll()
	{
		return rolesPathsRepository.findAll();
	}// findAll
}// class
