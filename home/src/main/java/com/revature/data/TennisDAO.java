package com.revature.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Coach;
import com.revature.beans.Player;

public class TennisDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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
