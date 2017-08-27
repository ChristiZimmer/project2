package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.revature.data.TennisDAO;

@Controller
public class TournamentController {
	
	@Autowired
	private TennisDAO dao;

	public void setDao(TennisDAO dao) {
		this.dao = dao;
	}

}
