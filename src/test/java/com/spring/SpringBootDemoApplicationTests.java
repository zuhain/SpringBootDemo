package com.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.web.i18n.I18NService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	@Autowired
	I18NService i18nService;
	
	@Test
	public void testMessageByLocaleService() throws Exception{
		String expectedResult="Bootstrap starter template";
		String messageId="index.title";
		String actual=i18nService.getMessage(messageId);
		Assert.assertEquals("actual and expected Strings dont match", expectedResult, actual);
	}

}
