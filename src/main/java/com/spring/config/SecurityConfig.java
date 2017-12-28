package com.spring.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private Environment environment;
	public static final String[] PUBLIC_URL= {
			"/webjars/**",
			"/images/**",
			"/css/**",
			"/js/**",
			"/",
			"/about",
			"/contact/**",
			"/error/**/*",
			"/console/**"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		List<String> activeProfiles=Arrays.asList(environment.getActiveProfiles());
		if(activeProfiles.contains("dev")) {
			http.csrf().disable();
			http.headers().frameOptions().disable();
		}
		
		http.authorizeRequests()
		.antMatchers(PUBLIC_URL).permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/payload")
		.failureUrl("/login?error").permitAll()
		.and().logout().permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("user")
		.password("password").roles("USER");
	}
}
