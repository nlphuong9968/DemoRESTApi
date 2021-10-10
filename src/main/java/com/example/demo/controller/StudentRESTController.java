package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Name;
import com.example.demo.entities.StudentV1;
import com.example.demo.entities.StudentV2;

@RestController
@RequestMapping("/version")
public class StudentRESTController {
	
	@GetMapping({"v1/students/greeting", "v2/students/greeting"})
	public String greeting() {
		return "greeting using all Rest versions";
	}
	
	@GetMapping("v1/students")
	public StudentV1 studentV1() {
		return new StudentV1("Sammon Nguyen");
	}
	
	@GetMapping("v2/students")
	public StudentV2 studentV2() {
		return new StudentV2(new Name("Sammon", "Nguyen"));
	}

}
