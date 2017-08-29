package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String getHomePageAfterLogin(@RequestParam("username")  String username, @RequestParam("password")  String password){
		System.out.println(username + " " + password);
		return "redirect:/pages/home.html";
	}
	
}
