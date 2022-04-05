package com.synex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping(value="/home")
	public String home() {
		return "hotel";
	}
	
	@GetMapping(value="/hotel")
	public String hotel() {
		return "hotel";
	}
	//Cody adding a comment
}
