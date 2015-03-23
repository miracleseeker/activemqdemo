package com.mike.activitymq_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestReceiver {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Receiver receiver = (Receiver) context.getBean("receiver");
		while (true) {
			System.out.println(receiver.receiveMessage());
		}
	}
}
