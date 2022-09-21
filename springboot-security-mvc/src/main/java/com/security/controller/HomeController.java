package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	@GetMapping("/student")
	public String student() {
		return "student";
	}
	@GetMapping("/employee")
	public String employee() {
		return "employee";
	}
	@GetMapping("/common")
	public String common() {
		return "common";
	}
	@GetMapping("/welcome")
	public String welcome() {
		return "index";
	}
}
