package com.Kafka.Demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Kafka.Demo.Kafka.JsonKafkaProducer;
import com.Kafka.Demo.Mode.User;

@RestController
@RequestMapping("api")
public class JsonMessageController {
	
	
	@Autowired
	private JsonKafkaProducer kafkaProducer;
	
	@PostMapping("publish")
	public ResponseEntity<String> publish(@RequestBody User user){
		kafkaProducer.sentJson(user);
		return ResponseEntity.ok("Json Message sent to kafka topic");
	}

}
