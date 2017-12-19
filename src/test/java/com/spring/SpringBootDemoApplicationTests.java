package com.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.web.i18n.I18NService;

import ch.qos.logback.classic.Logger;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {
	
	private static final Logger log=(Logger) LoggerFactory.getLogger(I18NService.class);
	@Autowired
	I18NService i18nService;
	
	@Test
	public void testMessageByLocaleService() throws Exception{
		String expectedResult="Bootstrap starter template";
		String messageId="index.title";
		String actual=i18nService.getMessage(messageId);
		log.info("Return text from message id using logger{}",messageId);
		Assert.assertEquals("actual and expected Strings dont match", expectedResult, actual);
	}

}
