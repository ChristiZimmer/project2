package com.revature.data;

import java.util.Set;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Tournament;
import com.revature.beans.Coach;
import com.revature.beans.Player;

public class TennisDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * Saves the tournament object
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void createTournament(Tournament tournament) {
		sessionFactory.getCurrentSession().save(tournament);
	}
	
	/**
	 * Deletes the tournament object
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deleteTournament(Tournament tournament) {
		sessionFactory.getCurrentSession().delete(tournament);
	}
	
	/**
	 * Adds the Player to the list of participants in the Tournament and saves the Tournament
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void addPlayersTournament(Tournament tournament, Player player) {
		Set<Player> players = tournament.getParticipants();
		players.add(player);
		tournament.setParticipants(players);
		sessionFactory.getCurrentSession().save(tournament);
	}

	/**
	 * Updates a tournament
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void updateTournament(Tournament tournament) {
		sessionFactory.getCurrentSession().saveOrUpdate(tournament);
	}

	/**
	 * Get all tournaments
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Tournament> findAllTournaments() {
		return sessionFactory.getCurrentSession().createCriteria(Tournament.class).list();
	}

	/**
	 * Tennis Player can request to add a coach with coach's approval
	 * @param coach
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void requestCoach(Coach coach) {
		sessionFactory.getCurrentSession().save(coach);
	}
	
	/**
	 * Nice to have:
	 * Update player ranking
	 */
	public void changeRanking(Player player) {
		
	}
	
	/**
	 * Accept/Deny player's request
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED,
				propagation=Propagation.REQUIRED,
				rollbackFor=Exception.class)
	public void validateCoachingRequest(Player player) {
		sessionFactory.getCurrentSession().saveOrUpdate(player);
	}
	
	/**
	 * Coach takes a look at all the players they train
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Player> listAllPlayers() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Player.class).list();
	}
	
	/**
	 * Tennis Player can drop a coach without coach's approval
	 * @param coach
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED,
				propagation=Propagation.REQUIRED,
				rollbackFor=Exception.class)
	public void deleteCoach(Coach coach) {
		sessionFactory.getCurrentSession().delete(coach);
	}

}
