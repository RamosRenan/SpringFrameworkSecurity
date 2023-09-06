package com.personal.security.context.utils;

import java.util.Iterator;
import java.util.LinkedList;

public class RoleToCurrentRequestUtil 
{
	public static LinkedList<String> listRolesForIncomingRequest = new LinkedList<>();
	
	public RoleToCurrentRequestUtil() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public static void addLast(String... roles)
	{
		System.out.println("add last ...");
		for(int i = 0; i < roles.length; i++)
		{
			RoleToCurrentRequestUtil.listRolesForIncomingRequest.add(roles[i]);			
		}
		RoleToCurrentRequestUtil.listRolesForIncomingRequest.addLast("-");
		
		System.out.println("add roles em liked list: "+ RoleToCurrentRequestUtil.listRolesForIncomingRequest.size());
	}
	
	public static void removeFirst()
	{
		RoleToCurrentRequestUtil.listRolesForIncomingRequest.removeFirst();
	}
	
	public static String getFirsts()
	{
		System.out.println("get roles acionado ...");
		
		Iterator<String> ii = RoleToCurrentRequestUtil.listRolesForIncomingRequest.iterator();
		
		System.out.println("lista de roles: "+ RoleToCurrentRequestUtil.listRolesForIncomingRequest.size());
		
		String expression = "";
		
		int index = 0;
		while(ii.hasNext())
		{
			String e = ii.next();
			
			System.out.println("is e - "+e);
			
			if(e.equals("-"))
				break;
			
			if(index > 0)
				expression += " and";
			
			expression = e;
			
			RoleToCurrentRequestUtil.removeFirst();
			
			index++;
		}
		
		System.out.println(">>> roles: "+expression);
		
		return expression;
	}
}
