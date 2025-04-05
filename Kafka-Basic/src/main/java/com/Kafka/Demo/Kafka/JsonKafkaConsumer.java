package com.Kafka.Demo.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.Kafka.Demo.Mode.User;

@Service
public class JsonKafkaConsumer {
	
private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "demoKafkaJson", groupId = "myGroup")
	public void consume(User data) {
		LOGGER.info(String.format("Json Message Received %s", data));
		
	}

}
