package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Player;
import com.revature.beans.Request;
import com.revature.beans.Tournament;
import com.revature.data.TennisDAO;

@Controller
public class PlayerCoachController {
	
	@Autowired
	private TennisDAO dao;
	
	public void setDao(TennisDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/request/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE) // Accept=application
	@ResponseBody
	public void create(@Valid @RequestBody Request request){ // look in the request body and find Request
		dao.requestCoach(request);;
	}
	
	@RequestMapping(value="/request/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void update(@RequestBody Request request){
		dao.validateCoachingRequest(request);
	}
	
	@RequestMapping(value="/request/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void delete(@RequestBody Request request){
		dao.deleteRequest(request);
	}
	
	@RequestMapping(value="/request/all", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Request> findAll(){
		System.out.println("Reaching PlayerCoachController");
		return dao.listAllRequests();
	}
	
	/*
	@RequestMapping(value="/request/add", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addPlayerTournament(@RequestBody Tournament tournament, @RequestBody Player player){
		dao.addPlayersTournament(tournament, player);
	}
	*/

}
