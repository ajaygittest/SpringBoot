package com.Kafka.Demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Kafka.Demo.Kafka.KafkaProducer;

@RestController
@RequestMapping("api")
public class MessageController {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@GetMapping("publish")
	public ResponseEntity<String> publish(@RequestParam("message")String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message send to the topic");
	}

}
