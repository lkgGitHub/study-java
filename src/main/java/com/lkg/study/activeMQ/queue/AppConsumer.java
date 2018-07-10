package com.lkg.study.activeMQ.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by lkg on 2018/6/21
 */
public class AppConsumer {
	private static final String url = "tcp://127.0.0.1:61616";
	private static final String queue = "queue-test";
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

		Connection connection = connectionFactory.createConnection();

		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue(queue);

		MessageConsumer consumer = session.createConsumer(destination);

		consumer.setMessageListener(message -> {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println(textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		});

//		connection.close();
	}
}
