package com.Kafka.Demo.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.Kafka.Demo.Mode.User;

@Service
public class JsonKafkaProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	
	public void sentJson(User data) {
		LOGGER.info(String.format("Message sent %s", data.toString()));
		Message<User> message =MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC,"demoKafkaJson").build();
		kafkaTemplate.send(message);
	}

}
