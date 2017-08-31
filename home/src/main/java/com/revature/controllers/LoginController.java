package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	/*
	@RequestMapping(value="login", method=RequestMethod.POST)
	//@ResponseStatus(value=HttpStatus.OK)
	public String getHomePageAfterLogin(@RequestParam("username")  String username, @RequestParam("password")  String password){
		System.out.println(username + " " + password);
		return "redirect:/pages/home.html";
	}*/
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String testLogin(){
		return "redirect:/pages/home.html";
	}

}
