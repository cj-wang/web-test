package org.walle.webtest.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class TestQueueListener implements MessageListener {
	
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			final TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println(textMessage.getText());
			} catch (final JMSException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(message.getClass() + " not supported");
		}
	}
	
}