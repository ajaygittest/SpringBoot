package com.kafkaMicroService.project.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafkaMicroService.project.Dto.OrderEvent;

@Service
public class OrderProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
	
	@Autowired
	private NewTopic topic;
	
	@Autowired
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;
	
	public void sendMessage(OrderEvent order) {
		LOGGER.info(String.format("Order Event %s", order.toString()));
		Message<OrderEvent> message = MessageBuilder.withPayload(order).setHeader(KafkaHeaders.TOPIC, topic.name()).build();
		
		kafkaTemplate.send(message);
		
	}

}
