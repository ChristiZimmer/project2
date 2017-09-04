package com.revature.data;

import java.util.Set;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Tournament;
import com.revature.beans.Coach;
import com.revature.beans.Player;
import com.revature.beans.Request;

public class TennisDAO {
	
	@Autowired
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
	 * Finds a tournament based on its id
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Tournament findOneTournament(int id) {
		List<Tournament> list = sessionFactory.getCurrentSession().createCriteria(Tournament.class).list();
		for(Tournament t : list){
			if(t.getId() == id){
				return t;
			}
		}
		return null;
	}
	
	/**
	 * Get coach based on name
	 * @param name
	 * @return
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public Coach findCoachByName(String name) {
			List<Coach> list = sessionFactory.getCurrentSession().createCriteria(Coach.class).list();
			for (Coach c : list) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
			return null;
	}
	
	/**
	 * Finds a Player by the id
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Player findOnePlayer(int id) {
		List<Player> list = sessionFactory.getCurrentSession().createCriteria(Player.class).list();
		for(Player p : list){
			if(p.getId() == id){
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Find player by name
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Player findPlayerByName(String name) {
		List<Player> list = sessionFactory.getCurrentSession().createCriteria(Player.class).list();
		for (Player p : list) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	/**
	 * Adds the Player to the list of participants in the Tournament and saves the Tournament
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void addPlayersTournament(Tournament tournament, Player player) {
		Set<Tournament> tournaments = player.getTournaments();
		tournaments.add(tournament);
		player.setTournaments(tournaments);
		sessionFactory.getCurrentSession().saveOrUpdate(player);
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
	public void requestCoach(Request request) {
		//Calendar now = Calendar.getInstance();
		//request.setSubmitted(Timestamp.valueOf(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.nn").format(new Date())));
		Calendar now = Calendar.getInstance();
		request.setSubmitted(new Timestamp(now.getTime().getTime()));
		sessionFactory.getCurrentSession().save(request);
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
	public void validateCoachingRequest(Request request) {
		Calendar now = Calendar.getInstance();
		request.setResolved(new Timestamp(now.getTime().getTime()));
		//request.setStatus("PENDING");
		sessionFactory.getCurrentSession().saveOrUpdate(request);
	}
	
	/**
	 * Save player information
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void updatePlayerInstructor(Player player, Coach coach) {
		player.setCoach(coach);
		sessionFactory.getCurrentSession().saveOrUpdate(player);
	}
	
	/**
	 * Coach takes a look at all the players they train
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Request> listAllRequests() {
		//System.out.println(sessionFactory.getCurrentSession().createCriteria(Request.class).list());
		return sessionFactory.getCurrentSession()
				.createCriteria(Request.class).list();
	}
	
	/**
	 * Tennis Player can drop a coach without coach's approval
	 * @param coach
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED,
				propagation=Propagation.REQUIRED,
				rollbackFor=Exception.class)
	public void deleteRequest(Request request) {
		sessionFactory.getCurrentSession().delete(request);
	}
	
	/**
	 * Finds a request based on its id
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Request findRequest(int id) {
		List<Request> list = sessionFactory.getCurrentSession().createCriteria(Request.class).list();
		for (Request r : list) {
			if (r.getId() == id) {
				return r;
			}
		}
		return null;
	}

}
