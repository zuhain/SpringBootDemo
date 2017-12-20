package com.spring.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SMTPEmailService extends AbstractEmailService{
	
	private static final Logger logger=LoggerFactory.getLogger(SMTPEmailService.class);
	
	@Autowired
	private MailSender mailSender;
	
	@Override
	public void sendGenericEmail(SimpleMailMessage message) {
		logger.info("Sending mail for:"+message);
		mailSender.send(message);
		logger.info("Mail sent");
		
	}

}
