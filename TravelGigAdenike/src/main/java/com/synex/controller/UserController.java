package com.synex.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

	//CIARA'S COMMENT
	
	
	@RequestMapping(value="/login")
	public String login(@RequestParam(required=false) String logout, @RequestParam(required=false) String error, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Model model) {
		
		String message = "";
		if (error!=null) {
			message="Invalid Credentials";
		}
		if (logout!=null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if(auth!=null) {
				new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
			}
			message="Logout";
			return "login";
		}
		model.addAttribute("Message", message);
		return "login";
		
	}
	
	@RequestMapping(value="/accessDeniedPage")
	public String accessDenied(Principal principal, Model model) {
		String message = principal.getName()+", Unauthorised access";

		model.addAttribute("Message", message);
		return "accessDenied";
		
	}
	
	@RequestMapping(value= {"/home","/"})
	public String home() {
		return "home";
	}
	
	
}
