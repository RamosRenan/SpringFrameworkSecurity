package com.personal.security.context.service;

 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.security.context.repository.PathRepository;
import com.personal.security.entity.Paths;

@Service
public class PathService 
{
	@Autowired
	PathRepository pathRepository;
	
	public Iterable<Paths> findAll()
	{
		return  this.pathRepository.findAll();
	}
}
