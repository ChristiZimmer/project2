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
import com.revature.beans.Tournament;
import com.revature.data.TennisDAO;

@Controller
public class TournamentController {
	
	@Autowired
	private TennisDAO dao;

	public void setDao(TennisDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value="/tournament/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE) // Accept=application
	@ResponseBody
	public void create(@Valid @RequestBody Tournament Tournament){ // look in the request body and find Tournament
		dao.createTournament(Tournament);
	}
	
	@RequestMapping(value="/tournament/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void update(@RequestBody Tournament Tournament){
		dao.updateTournament(Tournament);
	}
	
	@RequestMapping(value="/tournament/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void delete(@RequestBody Tournament Tournament){
		dao.deleteTournament(Tournament);
	}
	
	@RequestMapping(value="/tournament/all", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Tournament> findAll(){
		return dao.findAllTournaments();
	}
	
	@RequestMapping(value="/tournament/add", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addPlayerTournament(@RequestBody Tournament tournament, @RequestBody Player player){
		dao.addPlayersTournament(tournament, player);
	}
	
}
