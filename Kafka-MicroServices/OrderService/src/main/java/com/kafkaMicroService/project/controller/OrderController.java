package com.kafkaMicroService.project.controller;

import org.apache.kafka.common.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaMicroService.project.Dto.Order;
import com.kafkaMicroService.project.Dto.OrderEvent;
import com.kafkaMicroService.project.kafka.OrderProducer;

@RestController
@RequestMapping("api")
public class OrderController {
	
	
	@Autowired
	private OrderProducer producer;
	
	@PostMapping("/order")
	public String placeOrder(@RequestBody Order order) {
		
		order.setOrderId(Uuid.randomUuid().toString());
		OrderEvent event = new OrderEvent();
		event.setStatus("Pending");
		event.setMessage("order status is pending");
		event.setOrder(order);
		producer.sendMessage(event);
		return "Order placed SuccessFully";
	}

}
