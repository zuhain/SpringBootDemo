package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.spring.backend.service.EmailService;
import com.spring.backend.service.SMTPEmailService;

@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/properties/application-prod.properties")
public class ProductionConfig {
	
	@Bean
	public EmailService emailService() {
		return new SMTPEmailService();
	}

}
