package com.spring.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.backend.service.EmailService;
import com.spring.web.domain.frontend.FeedbackPojo;

@Controller
public class ContactController {
	
	private static final Logger logger=LoggerFactory.getLogger(ContactController.class);
	@Autowired
	private EmailService emailService;
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public String getFeedback(ModelMap model) {
		FeedbackPojo pojo=new FeedbackPojo();
		model.addAttribute("feedback", pojo);
		return "contact/contact";
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.POST)
	public String postFeedback(@ModelAttribute("feedback") FeedbackPojo feedbackPojo) {
		logger.debug("Feedback pojo content {}",feedbackPojo);
		emailService.sendFeedbackEmail(feedbackPojo);
		return "contact/contact";
	}
}
