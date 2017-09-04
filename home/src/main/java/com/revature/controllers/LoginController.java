package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Person;
import com.revature.data.UserDAO;

@Controller
public class LoginController {
	
	@Autowired
	private UserDAO dao;

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String getHomePageAfterLogin(@RequestParam("username")  String username, @RequestParam("password")  String password){
		boolean verified = authenticate(username, password);
		if(verified){
			return "redirect:/pages/home.html";
		}
		return "redirect:/index.html";
	}
	
	@RequestMapping(value="/user/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> createUser(@Valid @RequestBody Person user){
		List<Person> list = dao.findAllUsers();
		for(Person u : list){
			if(u.getUsername().equals(user.getUsername())){
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
		}
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		dao.createUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	private boolean authenticate(String username, String password) {
		List<Person> list = dao.findAllUsers();
		for(Person u : list){
			if(u.getUsername().equals(username)){
				if(BCrypt.checkpw(username, u.getPassword())){
					return true;
				}
			}
		}
		return false;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(){
		return "redirect:/index.html";
	}

}
