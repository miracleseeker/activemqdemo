package com.mike.activitymq_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSender {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		Sender sender = (Sender) context.getBean("sender");

		int i = 0;
		while (i < 1000) {
			i++;
			sender.sendInfo(i);
		}
	}
}
