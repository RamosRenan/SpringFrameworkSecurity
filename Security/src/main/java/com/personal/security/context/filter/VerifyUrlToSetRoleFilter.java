package com.personal.security.context.filter;

import com.personal.security.context.utils.RoleToCurrentRequestUtil;
import com.personal.security.context.utils.RolesAndPathsUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.Filter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Component
public class VerifyUrlToSetRoleFilter extends OncePerRequestFilter  
{
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException 
//	{
//		// TODO Auto-generated method stub
//		Filter.super.init(filterConfig);
//	}
//	
//	@Override
//	public void doFilter(
//						 ServletRequest request, 
//						 ServletResponse response, 
//						 FilterChain chain
//						)
//			throws IOException, ServletException 
//	{
//		// TODO Auto-generated method stub
//		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
//		String httpUri = httpServletRequest.getRequestURI();
//		
//		System.out.println(">> url by filter: "+httpUri);
//		
//		List<String> lis = RolesAndPathsUtil.getRolesByKeyUrlPath(httpUri);
//		
//		RoleToCurrentRequestUtil.addLast((String[]) lis.toArray());
//	}

	@Override
	protected void doFilterInternal(
									HttpServletRequest request, 
									HttpServletResponse response, 
									FilterChain filterChain
									)throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
//		System.out.println(">>> passando pelo filter ... urls: ");
//		System.out.println(request.getRequestURI().toString());
//		List<String> lis = RolesAndPathsUtil.getRolesByKeyUrlPath(request.getRequestURI().toString());
//		
//		System.out.println("list de roles ok size: ");
//		System.out.println(lis.size());
//		
//		Iterator<String> roles = lis.iterator();
//		
//		String[] rolesArrays = new String[lis.size()];
//		
//		int ii = 0;
//		while(roles.hasNext())
//		{
//			System.out.println("passou ..."+ ii);
//			rolesArrays[ii] = roles.next();
//			ii++;
//		}
//
//		RoleToCurrentRequestUtil.addLast(rolesArrays);
//		
//		System.out.println("cast ok: ");
//		
//		filterChain.doFilter(request, response);

	}
	
}
