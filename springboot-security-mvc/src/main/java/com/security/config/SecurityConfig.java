package com.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth.inMemoryAuthentication().withUser("sam").password("{noop}sam").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("Ajitesh").password("{noop}123456").authorities("EMP");
		auth.inMemoryAuthentication().withUser("syed").password("{noop}syed").authorities("STUDENT");
	}
	protected void configure(HttpSecurity http)throws Exception {
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/common").hasAnyAuthority("ADMIN", "EMP")
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/student").hasAuthority("STUDENT")
		.antMatchers("/emp").hasAuthority("EMP")
		
		//Login form
		.and().formLogin().defaultSuccessUrl("/welcome", true)
		//logout details
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		//Exception handling details
		.and().exceptionHandling().accessDeniedPage("/denied");
		;
	}
	
	
}
