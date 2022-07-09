package com.lkg.demo.activeMQ.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by lkg on 2018/6/21
 */
public class AppProducer {
	private static final String url = "tcp://127.0.0.1:61616";
	private static final String topicName = "topic-test";
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

		Connection connection = connectionFactory.createConnection();

		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createTopic(topicName);

		MessageProducer messageProducer = session.createProducer(destination);

		for (int i=1;i<=100;i++){
			TextMessage testMessage = session.createTextMessage("test-"+i);
			messageProducer.send(testMessage);

			System.out.println("发送消息"+ testMessage.getText());
		}

		connection.close();
	}
}
