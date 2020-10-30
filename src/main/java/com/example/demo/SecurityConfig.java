package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/login", "/images/**", "/images/icons/**", "/images/slider/**", "/fonts/**", "/scripts/**", "/styles/**", "/styles/custom/**", "/styles/custom/**", "/styles/css/**", "/styles/less/**", "/fragments/**").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
            .usernameParameter("username")
            .passwordParameter("password");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {

		web
				.ignoring()
				.antMatchers(
					"/api/version", "/api/logs",
					"/resources/templates/*", "/static/*", "/styles/*", "/fonts/*", "/images/*", "/scripts/**", "/styles/custom/**",
					"/images/icons/**", "/rest/**");

	}
	

}