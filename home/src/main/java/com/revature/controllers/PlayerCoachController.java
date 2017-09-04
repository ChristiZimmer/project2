package com.revature.controllers;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Coach;
import com.revature.beans.Player;
import com.revature.beans.Request;
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
		request.setStatus("PENDING");
		dao.requestCoach(request);
	}
	
	@RequestMapping(value="/request/update/{requestId}/{status}", method=RequestMethod.PUT/*, consumes=MediaType.APPLICATION_JSON_VALUE*/)
	@ResponseBody
	public ResponseEntity<Void> update(/*@RequestBody Request request*/@PathVariable Integer requestId, @PathVariable Integer status){
		//System.out.println(requestId);
		//System.out.println(status);
		Request request = dao.findRequest(requestId.intValue());
		if (request != null && status == 1) {
			request.setStatus("ACCEPTED");
			//System.out.println(request.getCoach().getName());
			//System.out.println(request.getPlayer().getName());
			Coach coach = dao.findCoachByName(request.getCoach().getName());
			Player player = dao.findPlayerByName(request.getPlayer().getName());
			//System.out.println(coach);
			//System.out.println(player);
			//player.setCoach(coach);
			//player.setCoach(coach);
			dao.updatePlayerInstructor(player, coach);
			dao.validateCoachingRequest(request);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else if (request != null && status == 0) {
			request.setStatus("DENIED");
			dao.validateCoachingRequest(request);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		//dao.validateCoachingRequest(request);
	}
	
	@RequestMapping(value="/request/delete/{requestId}", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable Integer requestId/*@RequestBody*/ /*Request request*/){
		/*Request request = new Request(101, 
				null, 
				null,
				new Player(1, "Roger Federer", "Switzerland"),
				new Coach(2, "Jon McEnroe"),
				"PENDING",
				"You cannot be serious!");
		System.out.println("Delete was called");
		dao.deleteRequest(request);
		*/
		System.out.println(requestId);
		Request request = dao.findRequest(requestId.intValue());
		if (request != null) {
			dao.deleteRequest(request);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/request/all", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Request> findAll(){
		/*
		System.out.println("I was called");
		List<Request> list = dao.listAllRequests();
		for (Request l : list) {
			System.out.println(l);
		}
		*/
		return dao.listAllRequests();
	}

}
