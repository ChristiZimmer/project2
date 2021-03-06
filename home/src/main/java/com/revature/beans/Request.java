package com.revature.beans;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="request")
	@SequenceGenerator(name="request", sequenceName="REQUEST_ID_SEQ")
	@Column(name="REQUEST_ID")
	private int id;
	@Column(name="TIME_SUBMITTED")
	private Timestamp submitted;
	@Column(name="TIME_RESOLVED")
	private Timestamp resolved;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PLAYER_ID", nullable=false)
	private Player player;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COACH_ID", nullable=false)
	private Coach coach;
	@Column(nullable=false)
	private String status;
	@Column
	private String description;
	
	public Request() {
		super();
	}

	public Request(int id, Timestamp submitted, Timestamp resolved, Player player, Coach coach, String status,
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", submitted=" + submitted + ", resolved=" + resolved + ", player=" + player.getName()
				+ ", coach=" + coach.getName() + ", status=" + status + ", description=" + description + "]";
	}
	
	
}
