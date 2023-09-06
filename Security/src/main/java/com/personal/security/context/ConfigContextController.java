package com.personal.security.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.personal.security.context.service.UserService;
import com.personal.security.entity.User;

@Configuration
@EnableWebMvc
public class ConfigContextController 
{
	@Autowired
	UserService userService;
	
	@SuppressWarnings("unused")
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext = null;
	
	public static void main(String args[])
	{
		ConfigContextController.annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigContextController.class);
		
//		ConfigContextController.annotationConfigApplicationContext.refresh();
	}// main
	
	
	
	// bean test
	@Bean
	public boolean test()
	{
		System.out.println("Test bean ... ok");
		return true;
	}
	
	
	@Bean("/test")
	public String findUser()
	{
		User user = userService.findUserByUsername("renan");
		return "rest controller spring servlet name is: "+user.getUsername()+" "+user.getRolesPaths().size();
	}
}// ConfigContextController
