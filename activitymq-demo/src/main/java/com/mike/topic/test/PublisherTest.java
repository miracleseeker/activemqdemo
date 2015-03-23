package com.mike.topic.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mike.topic.service.PublisherService;

public class PublisherTest {
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	private static void send() {
		PublisherService publisherService = (PublisherService) appContext
				.getBean("publisherService");
		publisherService.send();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		send();
	}
}
