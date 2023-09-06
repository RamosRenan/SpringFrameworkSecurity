package com.personal.security.context.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.personal.security.context.service.RolesPathsService;
import com.personal.security.entity.RolesPaths;

@Configuration
public class RolesAndPathsUtil 
{
	@Autowired
	RolesPathsService rolesPathsService;
	
	private static Map<String, List<String>> mapPathRoles = new HashMap<String, List<String>>();
	
	private static List<RolesPaths> rolesPaths = null;
	
	RolesAndPathsUtil()
	{
		
	}
	
	@Bean
	public boolean mapRoles()
	{
		Map<String, List<String>> supportMapPathRoles = new HashMap<String, List<String>>();
		
		RolesAndPathsUtil.rolesPaths = this.rolesPathsService.findAll();
		
		 
		return true;
	}
	
	public static Set<String> getAllPaths()
	{
		return RolesAndPathsUtil.mapPathRoles.keySet();
	}
	
	public static Iterable<List<String>> getAllRoles()
	{
		return RolesAndPathsUtil.mapPathRoles.values();
	}
	
	public static List<String> getRolesByKeyUrlPath(String key)
	{
		List<String> allRoles = new ArrayList<>();
		
		Iterator<RolesPaths> iterator = RolesAndPathsUtil.rolesPaths.iterator();
		
		String gg = "";
		
		while(iterator.hasNext())
		{
			RolesPaths rolesPaths = iterator.next();
			
			gg = key;
			
			gg = gg.substring(13, 18);
			
			System.out.println("key: "+key);
			System.out.println("key sub : "+gg);
			System.out.println("path: "+rolesPaths.getPaths().getPath());
			
			if(gg.equals(rolesPaths.getPaths().getPath()))
			{
				allRoles.add(rolesPaths.getRoles().getAuthority());
			}
		}
		
		
		return allRoles;
	}
}// RolesAndPaths
