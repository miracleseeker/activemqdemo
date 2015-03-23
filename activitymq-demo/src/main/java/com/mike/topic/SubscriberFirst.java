/**
 * 
 */
package com.mike.topic;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * topic:消息订阅者一
 * @author Mike
 *
 */
public class SubscriberFirst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String user = ActiveMQConnection.DEFAULT_USER;
		String password = ActiveMQConnection.DEFAULT_PASSWORD;
		String url = "tcp://localhost:61616";
		String subject = "日出江花红胜火";
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(user, password, url);
		Connection connection;
		
		try{
			connection = factory.createConnection();
			connection.start();
			final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic(subject);
			MessageConsumer consumer = session.createConsumer(topic);
			consumer.setMessageListener(new MessageListener(){
				public void onMessage(Message msg) {
					MapMessage message = (MapMessage) msg;
					try {
						while(true){
							System.out.println("--订阅者一收到消息："+new Date(message.getLong("count")));
							session.commit();
						}
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
				
			});
		}catch(JMSException e){
			e.printStackTrace();
		}
		
	}

}
