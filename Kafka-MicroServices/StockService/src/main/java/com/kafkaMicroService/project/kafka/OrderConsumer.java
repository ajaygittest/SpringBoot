package com.kafkaMicroService.project.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafkaMicroService.project.Dto.OrderEvent;

@Service
public class OrderConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
	
	@KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent order) {
		LOGGER.info(String.format("Order event received in stock service => %s", order.toString()));
		
		
		
	}

}
