package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	public static final String[] PUBLIC_URL= {
			"/webjars/**",
			"/images/**",
			"/css/**",
			"/js/**",
			"/",
			"/about",
			"/contact/**",
			"/error/**/*"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
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
