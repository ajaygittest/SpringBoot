package com.Zipkin.Demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Zipkin.Demo.Feign.ProductInterface;

@RestController
@RequestMapping("api")
public class OrderController {
	
	@Autowired
	private ProductInterface service;
	
	@GetMapping("get")
	public String getProduct() {
		return service.getProduct();
	}

}
