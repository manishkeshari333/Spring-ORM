package com.manish.keshari.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.manish.keshari.hibernate.model.Movie;
import com.manish.keshari.hibernate.util.HibernateSessionFactory;

public class UpdateMovie {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		Movie mov = new Movie();
		mov.setId(3);
		mov.setMovieName("Math");
		session.beginTransaction();
		session.update(mov);
		session.getTransaction().commit();
		System.out.println("Data is update");

		// close session
		session.close();

	}

}
