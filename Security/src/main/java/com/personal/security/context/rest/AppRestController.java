package com.personal.security.context.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController 
{
 
	
	@GetMapping("/test")
	public String test()
	{
		return "rest controller spring servlet name is: ";
	}
	
	@GetMapping("/adm/restrict")
	public String restrict()
	{
		return "esta é uma area restrita ";
	}
	
	@GetMapping("/adm/path1")
	public String restrict1()
	{
		return "esta é uma area restrita 1";
	}

	
	@GetMapping("/user/all")
	public String all()
	{
		return "esta é uma area para todos ";
	}
	
	@GetMapping("/dash/manager")
	public String dash()
	{
		return "esta é uma area para managers ";
	}
	
	@GetMapping("/loggouts/success")
	public String logouts()
	{
		return "logout success";
	}
	
	@GetMapping("/logIn")
	public String login()
	{
		return "login page";
	}
	
}
