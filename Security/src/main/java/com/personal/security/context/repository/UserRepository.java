package com.personal.security.context.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.security.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
	public User findByUsername(String name);
}
