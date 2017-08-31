package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity	// Hibernate marks this POJO as an entity, 
		// Java looks at this POJO and recreates it as a table in our DB
public class Coach {
	
	//@Min(value=0)
	@Id	// Hibernate marks this field as a primary key
	@Column(name="COACH_ID")
	private int id;
	//@NotBlank
	@Column(name="COACH_NAME", nullable=false)
	private String name;
	@OneToMany(mappedBy="coach")
	private Set<Player> pupils;
	@OneToMany(mappedBy="coach")
	private Set<Tournament> tournaments;
	@OneToMany(mappedBy="coach")
	private Set<Request> requests;
	
	public Coach() {
		super();
	}

	public Coach(int id, String name, Set<Player> pupils, Set<Tournament> tournaments, Set<Request> requests) {
		super();
		this.id = id;
		this.name = name;
		this.pupils = pupils;
		this.tournaments = tournaments;
		this.requests = requests;
	}
	
	public Coach(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Player> getPupils() {
		return pupils;
	}

	public void setPupils(Set<Player> pupils) {
		this.pupils = pupils;
	}

	public Set<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(Set<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

	@Override
	public String toString() {
		return "Coach [id=" + id + ", name=" + name + ", pupils=" + pupils + ", tournaments=" + tournaments + "]";
	}

}
