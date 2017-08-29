package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class LoginController {
	
	
	/*
	@RequestMapping(value="login", method=RequestMethod.POST)
	//@ResponseStatus(value=HttpStatus.OK)
	public String getHomePageAfterLogin(@RequestParam("username")  String username, @RequestParam("password")  String password){
		System.out.println(username + " " + password);
		return "redirect:/pages/home.html";
	}*/
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public void testLogin(){
		System.out.println("Here");
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String getHomePageAfterLogin(HttpServletRequest request) {
		System.out.println(request.getParameter("username"));
		return "redirect:/pages/home.html";
	}

}
