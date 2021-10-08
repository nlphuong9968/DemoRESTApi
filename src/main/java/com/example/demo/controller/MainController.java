package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
	@ResponseBody
	private String welcome() {
		// TODO Auto-generated method stub
		return "Welcome to first Spring Boot Demo";
	}
	
	@RequestMapping("/home")
	private String index() {
		// TODO Auto-generated method stub
		return "index";
	}

}
