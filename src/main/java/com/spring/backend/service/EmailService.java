package com.spring.backend.service;

import org.springframework.mail.SimpleMailMessage;

import com.spring.web.domain.frontend.FeedbackPojo;

public interface EmailService {
	
	public void sendFeedbackEmail(FeedbackPojo feedbackPojo);
	
	public void sendGenericEmail(SimpleMailMessage message);
}
