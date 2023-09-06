package com.personal.security.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.personal.security.entity.User;

public class UserDto implements UserDetails
{
	private User user = null;
	
	private List<SimpleGrantedAuthority> authorities;
	
	public UserDto(User user) 
	{
		// TODO Auto-generated constructor stub
		this.user = user;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		// TODO Auto-generated method stub
		authorities = new ArrayList<>();
		
		this.user.getRolesPaths().forEach((i)->{
			authorities.add(new SimpleGrantedAuthority(i.getRoles().getAuthority()));
		});
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
