package com.revature.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Person;

public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public UserDAO() {
		super();
	}

	/**
	 * Saves the User object
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void createUser(Person user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	/**
	 * Get all users
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Person> findAllUsers() {
		return sessionFactory.getCurrentSession().createCriteria(Person.class).list();
	}

}
