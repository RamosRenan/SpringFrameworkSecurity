package com.personal.security.context;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class TestRest2
{
	 
	
	@GetMapping("/adm/ola")
	public String noSec4()
	{
		System.out.println(">>>> test de chamada rest sem security");
		return "ok... ";
	}// test
}// Test
