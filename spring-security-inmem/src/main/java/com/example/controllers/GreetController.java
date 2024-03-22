package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetController {
	//http://localhost:8081/
	@GetMapping("/greet")
	public String greet() {
		return "Have a Good Day";
	}

	@GetMapping("/user/books/show")
	public List<String> showBooks() {
		return Arrays.asList("Java","jsp");
	}
	@GetMapping("/admin/books/in")
	public String addBooks() {
		return "added";
	}

}
