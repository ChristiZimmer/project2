package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TennisController {
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String getHomePageAfterLogin(){
		return "redirect:/pages/home.html";
	}
	
}
