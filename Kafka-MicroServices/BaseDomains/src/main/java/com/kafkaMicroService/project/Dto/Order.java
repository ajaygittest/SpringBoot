package com.kafkaMicroService.project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	private String orderId;
	private String orderName;
	private int qty;
	private double price;

}
