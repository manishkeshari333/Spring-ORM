package com.manish.keshari.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.manish.keshari.hibernate.model.Movie;
import com.manish.keshari.hibernate.util.HibernateSessionFactory;

public class DeleteMovie {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		Movie getdata = session.get(Movie.class, 3);
		session.beginTransaction();
		session.delete(getdata);
		session.getTransaction().commit();
		System.out.println("delete Data by id");

		// close session
		session.close();

	}

}
