package com.mukewang.spring_security_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringSecurityTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityTestApplication.class, args);
	}


	@GetMapping("/")
	public String hello(){

		return "helle";

	}


	@GetMapping("/login")
	public String home(){

		return "success  login";

	}



}
