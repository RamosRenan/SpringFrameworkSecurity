package com.personal.security.context.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.security.entity.RolesPaths;

@Repository
public interface RolesPathsRepository extends CrudRepository<RolesPaths, Long>
{
	public List<RolesPaths> findAll();
}
