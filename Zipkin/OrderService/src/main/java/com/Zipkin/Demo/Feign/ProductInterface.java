package com.Zipkin.Demo.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product-service", url = "http://localhost:8181/api") 
public interface ProductInterface {
	
	
	@GetMapping("product")
	String getProduct();

}
