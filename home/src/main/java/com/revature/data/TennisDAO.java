package com.revature.data;

import org.hibernate.SessionFactory;

public class TennisDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
