package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Player {

	@Min(value=0)
	@Id
	@Column(name="PLAYER_ID")
	private int id;
	@NotBlank
	@Column
	private String name;
	@NotBlank
	@Column
	private String country;
	@NotBlank
	@Min(value=1)
	@Column
	private int rank;
	@NotBlank
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COACH_ID")
	private Coach coach;
	@ManyToMany
	@JoinTable(name="TOURNAMENT_ENROLLMENT")
	private Set<Tournament> tournaments;
	
	public Player() {
		super();
	}

	public Player(int id, String name, String country, int rank, Coach coach, Set<Tournament> tournaments) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.rank = rank;
		this.coach = coach;
		this.tournaments = tournaments;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Set<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(Set<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", country=" + country + ", rank=" + rank + ", coach=" + coach
				+ ", tournaments=" + tournaments + "]";
	}
	
}
