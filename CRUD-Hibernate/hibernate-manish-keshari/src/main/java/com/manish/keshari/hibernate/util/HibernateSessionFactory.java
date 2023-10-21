package com.manish.keshari.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manish.keshari.hibernate.model.Movie;

public class HibernateSessionFactory {
	
	public static SessionFactory getSessionFactory() {
		// create configuration
		Configuration configuration = new Configuration();

		// we just tell the hibernate this is entity class with annotation
		configuration.addAnnotatedClass(Movie.class);
		configuration.configure("hibernate.cfg.xml");

		// create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}

}
