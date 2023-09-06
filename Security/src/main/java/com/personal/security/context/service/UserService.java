package com.personal.security.context.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.personal.security.context.repository.UserRepository;
import com.personal.security.dto.UserDto;
import com.personal.security.entity.User;

@Service
public class UserService implements UserDetailsService
{
	@Autowired
	UserRepository userRepository;
	
	public User findUserByUsername(String name)
	{
		User user = userRepository.findByUsername(name);
		
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		// TODO Auto-generated method stub
		UserDto udto = new UserDto(userRepository.findByUsername(username));
		
		System.out.println(">>>: "+udto.getUsername());
		System.out.println(">>>: "+udto.getPassword());
		
		System.out.println("listando roles de user");
		
		udto.getAuthorities().forEach((q)->{
			System.out.println(">>> A: "+q.getAuthority());
		});
		
		return udto;
	}
}
