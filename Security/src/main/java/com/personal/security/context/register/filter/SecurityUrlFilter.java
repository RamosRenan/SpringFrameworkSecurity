package com.personal.security.context.register.filter;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.personal.security.context.filter.VerifyUrlToSetRoleFilter;
import com.personal.security.context.service.PathService;
import com.personal.security.entity.Paths;

@Configuration
public class SecurityUrlFilter 
{
	@Autowired
	PathService pathService;
	
//	@Autowired
//	RolesPathsService rolesPathsService;
//	
//	private static final Map<String, List<String>> mapPathRoles = new HashMap<String, List<String>>();
	
	public SecurityUrlFilter() 
	{
		// TODO Auto-generated constructor stub
		System.out.println(">>> SecurityUrlFilter: SecurityUrlFilter constructor created");
	}
	
//	@Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//	public FilterRegistrationBean<VerifyUrlToSetRoleFilter> securityUrlFilters()
//	{
//		System.out.println("password: "+new BCryptPasswordEncoder().encode("renan"));
//		List<Paths> list = (List<Paths>) pathService.findAll();
//		
//		System.out.println(">>>> list: "+list.size());
//		
//		String[] paths = new String[list.size()];
//		
//		Iterator<Paths> iterator = list.iterator();
//		
//		int index = 0;
//		while(iterator.hasNext())
//		{
//			paths[index++] = iterator.next().getPath();
//		}
//		
//		System.out.println(">>>: "+paths.length);
//		System.out.println(">>>: "+paths.toString());
//		
//		for (int i = 0; i < paths.length; i++) {
//			System.out.println(">>>: "+paths[i]);
//		}
//		
////		System.out.println(">>>> in filter: "+RolesAndPathsUtil.getAllPaths().size());
//		FilterRegistrationBean<VerifyUrlToSetRoleFilter> filterRegistrationBean = new FilterRegistrationBean<>();
//		filterRegistrationBean.addUrlPatterns("/*");
//		filterRegistrationBean.setFilter(new VerifyUrlToSetRoleFilter());
//		filterRegistrationBean.setEnabled(true);
//		
//		return filterRegistrationBean;
//	}
}// SecurityUrlFilter
