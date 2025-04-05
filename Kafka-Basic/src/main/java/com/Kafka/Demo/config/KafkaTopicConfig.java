package com.Kafka.Demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	@Bean
	NewTopic demoKafka() {
		return TopicBuilder.name("demoKafka").build();
	}
	
	@Bean
	NewTopic demoKafkaJson() {
		return TopicBuilder.name("demoKafkaJson").build();
	}

}
