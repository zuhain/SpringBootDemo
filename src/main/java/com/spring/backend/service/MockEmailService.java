package com.spring.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;


public class MockEmailService extends AbstractEmailService{
	
	private static final Logger logger=LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendGenericEmail(SimpleMailMessage message) {
		logger.info("Simulating an email");
		logger.info(message.toString());
		logger.info("mail sent");
	}

}
