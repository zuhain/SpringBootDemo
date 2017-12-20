package com.spring.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.spring.web.domain.frontend.FeedbackPojo;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.to.address}")
	private String address;
	
	protected SimpleMailMessage createSimpleMailMessageFromFeedbackPojo(FeedbackPojo feedbackPojo) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(address);
		mailMessage.setFrom(feedbackPojo.getEmail());
		mailMessage.setSubject("[SpringBootDemo] Feedback recieved from "+feedbackPojo.getFirstName()+
				" "+feedbackPojo.getLastName());
		mailMessage.setText(feedbackPojo.getFeedback());
		return mailMessage;
	}
	
	@Override
	public void sendFeedbackEmail(FeedbackPojo feedbackPojo) {
		sendGenericEmail(createSimpleMailMessageFromFeedbackPojo(feedbackPojo));
	}
}
