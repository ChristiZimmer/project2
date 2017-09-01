package com.revature.controllers;

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
	public ResponseEntity<Void> create(@Valid @RequestBody Tournament Tournament){ // look in the request body and find Tournament
		dao.createTournament(Tournament);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/tournament/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> update(@RequestBody Tournament Tournament){
		dao.updateTournament(Tournament);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/tournament/delete/{tournamentId}", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable Integer tournamentId){
		Tournament tournament = dao.findOneTournament(tournamentId.intValue());
		if(tournament != null){
			dao.deleteTournament(tournament);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/tournament/all", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Tournament>> findAll(){
		return new ResponseEntity<List<Tournament>>(dao.findAllTournaments(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/tournament/join/{tournamentId}/{playerId}", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Void> addPlayerTournament(@PathVariable Integer tournamentId, @PathVariable Integer playerId){
		Tournament tournament = dao.findOneTournament(tournamentId.intValue());
		Player player = dao.findOnePlayer(playerId.intValue());
		if(tournament != null && player != null){
			dao.addPlayersTournament(tournament, player);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
}
