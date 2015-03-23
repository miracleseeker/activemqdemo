package com.mike.activitymq_demo;

import javax.jms.JMSException;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;

public class Receiver {
   private JmsTemplate jmsTemplate;
   public Receiver() {}
   public String receiveMessage()
	{   String my="";
		MapMessage message=(MapMessage)jmsTemplate.receive();
		  try{
			  if(null != message){
				  my= message.getString("firstName");
				  my+=" "+message.getString("lastName");
			  }
		  }
		  catch(JMSException e)
		  {  throw JmsUtils.convertJmsAccessException(e); }
		return my;
	}
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
