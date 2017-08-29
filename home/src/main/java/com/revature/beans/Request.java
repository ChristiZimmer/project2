package com.revature.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Request {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REQUEST_ID")
	private int id;
	@Column(name="TIME_SUBMITTED")
	private Timestamp submitted;
	@Column(name="TIME_RESOLVED")
	private Timestamp resolved;
	@JoinColumn(name="PLAYER_NAME")
	private Player player;
	@JoinColumn(name="COACH_NAME")
	private Coach coach;
	@JoinColumn(name="STATUS")
	private Status status;
	@Column
	private String description;
	
	public Request() {
		super();
	}

	public Request(int id, Timestamp submitted, Timestamp resolved, Player player, Coach coach, Status status,
			String description) {
		super();
		this.id = id;
		this.submitted = submitted;
		this.resolved = resolved;
		this.player = player;
		this.coach = coach;
		this.status = status;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
