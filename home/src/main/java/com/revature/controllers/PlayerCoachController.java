package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.revature.data.TennisDAO;

@Controller
public class PlayerCoachController {
	
	@Autowired
	private TennisDAO dao;

}
