package com.personal.security.context.websecurity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

import com.personal.security.context.filter.VerifyUrlToSetRoleFilter;
import com.personal.security.context.service.PathService;
import com.personal.security.context.service.RolesPathsService;
import com.personal.security.context.service.RolesService;
import com.personal.security.context.service.UserService;
import com.personal.security.context.utils.RoleToCurrentRequestUtil;
import com.personal.security.entity.Roles;
import com.personal.security.entity.RolesPaths;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfigurerAdapater 
{
	@Autowired
	UserService userService;
	
	@Autowired
	PathService pathService;
	
	@Autowired
	VerifyUrlToSetRoleFilter verifyUrlToSetRoleFilter;
	
	@Autowired
	RolesService rolesService;
	
	@Autowired
	RolesPathsService rolesPathsService;
	
	private List<String> arr = new ArrayList<>();
	
	private int idex = 0;
	
	SecurityConfigurerAdapater()
	{
		
	}// constructor
	
//	public void configure(AuthenticationManagerBuilder authz) throws Exception
//	{
//		authz.userDetailsService(userService).passwordEncoder(passwordEncoder());
////		authz.inMemoryAuthentication().passwordEncoder(encods()).withUser("renan").password(encBCrypt()).roles("USER");
//	}
	
	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{		
		System.out.println(">>>> Iniciando configuração de segurança ...");
		try 
		{
			httpSecurity
			.csrf()
			.disable()
			.authorizeHttpRequests((authorizeHttpRequests)->{
//				.antMatchers("/app/adm/restrict/**").hasRole("ADMIN");
				String[] ff = {"/app"+"/dash/manager/**", "/app"+"/adm/path1/**", "/app"+"/adm/restrict/**"};
				for (int i = 0; i <= 2; i++) {
					authorizeHttpRequests.antMatchers(ff[i]).hasRole("ADMIN");
					System.out.println(">>>> val I: "+i);
				}
			}).authenticationProvider(authenticationProvider())	
			.httpBasic()
			.and()
			.formLogin()
			.loginPage("/app/logIn")
			.loginProcessingUrl("/app/login")
			.and()
			.logout()
			.permitAll()
			.logoutSuccessUrl("/test")
			;
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return httpSecurity.build();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
//		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	 @Bean
     public UserDetailsService userDetailsService() {
             UserDetails user = User.withDefaultPasswordEncoder()
                     .username("user")
                     .password("password")
                     .roles("USER")
                     .build();
             UserDetails admin = User.withDefaultPasswordEncoder()
                     .username("admin")
                     .password("password")
                     .roles("ADMIN", "USER")
                     .build();
             return new InMemoryUserDetailsManager(user, admin);
     }
	
//	
//    @Bean
//    public SecurityContextRepository securityContextRepository() 
//    {
//        HttpSessionSecurityContextRepository repository = new HttpSessionSecurityContextRepository();
//        repository.setAllowSessionCreation(true);
//        return repository;
//    }

//	@Bean
//	public PasswordEncoder  passwordEncoder()
//	{
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public String encBCrypt()
//	{
//		System.out.println("password user: "+new BCryptPasswordEncoder().encode("user"));
//		System.out.println("password renan: "+new BCryptPasswordEncoder().encode("renan"));
//		return "";
//	}

	public String[] getRole()
	{
		System.out.println("chamando get roles ... "+RoleToCurrentRequestUtil.listRolesForIncomingRequest.size());
		
		List<Roles> l = rolesService.findAll();
		
		String[] d = new String[l.size()];
		
		Iterator<Roles> h = l.iterator();
		
		int o = 0;
		while(h.hasNext())
		{
			d[o] = h.next().getAuthority();
			o++;
		}
		
		System.out.println("tamanho de roles: "+d.length);
		
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
		
		return d;
	}
	
	synchronized private String[] paths(String authorities)
	{
		List<RolesPaths> list = (List<RolesPaths>) this.rolesPathsService.findAll();
		
		Stream<RolesPaths> streamRoles =  list.stream().filter(obj -> obj.getRoles().getAuthority().equals(authorities));
		
		
//		arr = new String[Long.valueOf(streamRoles.count()).intValue()];
		
		streamRoles.forEach((e)->{
			arr.add(e.getPaths().getPath());
		});
		
		idex = 0;
		
//		System.out.println(">>>> list: "+list.size());
//		
//		String[] paths = new String[list.size()];
//		
//		Iterator<RolesPaths> iterator = list.iterator();
//		
//		int index = 0;
//		while(iterator.hasNext())
//		{
//			 
//		}
		
		
		String[] ll = new String[arr.size()];
		
		Iterator<String> i = arr.iterator();
		
		int in = 0;
		
		while(i.hasNext())
		{
			ll[in++] = i.next();
		}
		
		for (int j = 0; j < ll.length; j++) {
			System.out.println(">>>: paths"+ll[j]);
		}
		arr = new ArrayList<String>();
		return ll;
	}
}// SecurityConfigurerAdapater


