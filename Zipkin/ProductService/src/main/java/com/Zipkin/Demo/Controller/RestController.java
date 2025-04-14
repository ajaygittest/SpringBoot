package com.Zipkin.Demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api")
@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	
	@GetMapping("product")
	public String getProduct() {
		
		return "SampleProduct";
	}

}
