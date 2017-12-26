package com.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PayloadController {
	
	@RequestMapping("/payload")
	public String returnPayload() {
		return "payload/payload";
	}
}
