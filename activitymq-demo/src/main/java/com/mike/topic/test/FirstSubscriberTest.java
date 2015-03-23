package com.mike.topic.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mike.topic.service.SubscriberService;

public class FirstSubscriberTest {

	private static ApplicationContext appContext = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	private static void receive() {
		SubscriberService firstSubscriberService = (SubscriberService) appContext
				.getBean("firstSubscriberService");
		firstSubscriberService.receive();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		receive();
	}
}