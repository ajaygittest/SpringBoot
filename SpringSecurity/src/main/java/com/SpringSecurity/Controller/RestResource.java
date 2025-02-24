package com.SpringSecurity.Controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class RestResource {
	
	
	@GetMapping("/hello")
	public String getFirst() {
		return "Hello world";
	}

	@GetMapping("csrf")
	public CsrfToken getToken(HttpServletRequest request) {
		return (CsrfToken)request.getAttribute("_csrf");
	}
}
