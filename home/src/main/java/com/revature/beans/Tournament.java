package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tournament {

	@Min(value=0)
	@Id
	@Column(name="TOURNAMENT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tourn")
	@SequenceGenerator(name="tourn", sequenceName="TOURNAMENT_ID_SEQ")
	private int id;
	@NotBlank
	@Column
	private String name;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COACH_ID", nullable=false)
	private Coach coach;
	@JsonIgnore
	@ManyToMany(mappedBy="tournaments", fetch=FetchType.EAGER)
	private Set<Player> participants;
	
	public Tournament() {
		super();
	}

	public Tournament(int id, String name, Coach coach, Set<Player> participants) {
		super();
		this.id = id;
		this.name = name;
		this.coach = coach;
		this.participants = participants;
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

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Set<Player> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Player> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "Tournament [id=" + id + ", name=" + name + ", coach=" + coach + "]";
	}
	
	
}
