package com.revature.data;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Player;
import com.revature.beans.Tournament;

public class TennisDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void createTournament(Tournament tournament) {
		sessionFactory.getCurrentSession().save(tournament);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deleteTournament(Tournament tournament) {
		sessionFactory.getCurrentSession().delete(tournament);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void addPlayersTournament(Tournament tournament, Player player) {
		Set<Player> players = tournament.getParticipants();
		players.add(player);
		tournament.setParticipants(players);
		sessionFactory.getCurrentSession().saveOrUpdate(tournament);
	}

}
