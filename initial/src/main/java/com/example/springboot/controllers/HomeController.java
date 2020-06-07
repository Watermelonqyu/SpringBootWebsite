package com.example.springboot.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * HomeController
 */
@RestController
public class HomeController {

	/*
	 * default
	 */
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
